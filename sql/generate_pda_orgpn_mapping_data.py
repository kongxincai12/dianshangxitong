import argparse
from pathlib import Path

try:
    import openpyxl
except ImportError as exc:
    raise SystemExit("Missing dependency: pip install openpyxl") from exc


def normalize_model(value):
    if value is None:
        return ""
    return str(value).strip().upper()


def sql_literal(value):
    return "'" + value.replace("'", "''") + "'"


def find_header_columns(sheet):
    for row_idx in range(1, min(sheet.max_row, 10) + 1):
        headers = [sheet.cell(row_idx, col_idx).value for col_idx in range(1, sheet.max_column + 1)]
        old_col = None
        for idx, header in enumerate(headers, start=1):
            if str(header).strip() == "旧型号":
                old_col = idx
                break
        if old_col is None:
            continue

        new_col = None
        for idx in range(old_col - 1, 0, -1):
            header = headers[idx - 1]
            if str(header).strip() == "型号":
                new_col = idx
                break
        if new_col is None:
            for idx in range(old_col + 1, len(headers) + 1):
                header = headers[idx - 1]
                if str(header).strip() == "型号":
                    new_col = idx
                    break
        if new_col is not None:
            return row_idx, new_col, old_col
    return None, None, None


def iter_mapping_rows(workbook):
    seen = set()
    for sheet in workbook.worksheets:
        header_row, new_col, old_col = find_header_columns(sheet)
        if header_row is None:
            print(f"skip sheet without model headers: {sheet.title}")
            continue

        for row_idx in range(header_row + 1, sheet.max_row + 1):
            new_model = normalize_model(sheet.cell(row_idx, new_col).value)
            old_model = normalize_model(sheet.cell(row_idx, old_col).value)
            if not old_model or not new_model:
                continue
            key = (old_model, new_model)
            if key in seen:
                continue
            seen.add(key)
            yield sheet.title, old_model, new_model


def build_merge_sql(sheet, old_model, new_model, vendor_name):
    return (
        "merge into PDA_ORGPN_MAPPING t\n"
        "using (select "
        f"{sql_literal(vendor_name)} VENDORNAME, "
        f"{sql_literal(old_model)} OLD_MODEL, "
        f"{sql_literal(new_model)} NEW_MODEL, "
        f"{sql_literal(sheet)} SOURCE_SHEET from dual) s\n"
        "on (t.OLD_MODEL = s.OLD_MODEL and t.NEW_MODEL = s.NEW_MODEL)\n"
        "when not matched then insert "
        "(MAPID, VENDORNAME, OLD_MODEL, NEW_MODEL, SOURCE_SHEET, ENABLEDFLAG, CREATEUSER, CREATETIME)\n"
        "values (rawtohex(sys_guid()), s.VENDORNAME, s.OLD_MODEL, s.NEW_MODEL, s.SOURCE_SHEET, 'Y', 'SYSTEM', sysdate);\n"
    )


def append_plsql_block(lines, merge_sql_list):
    if not merge_sql_list:
        return
    lines.append("begin")
    for merge_sql in merge_sql_list:
        lines.extend("    " + line if line else "" for line in merge_sql.rstrip().splitlines())
    lines.append("    commit;")
    lines.append("end;")
    lines.append("/")
    lines.append("")


def main():
    default_excel = Path(__file__).resolve().parents[1].parent / "MES_JCD_PDA" / "doc" / "PDA上料系统扫码优化" / "太诱新旧料号映射规则.xlsx"
    default_output = Path(__file__).resolve().parent / "PDA_ORGPN_MAPPING_TAIYO_YUDEN_DATA.sql"

    parser = argparse.ArgumentParser(description="Generate PDA original-model mapping MERGE SQL from Excel.")
    parser.add_argument("--excel", default=str(default_excel), help="Path to 太诱新旧料号映射规则.xlsx")
    parser.add_argument("--output", default=str(default_output), help="Output SQL file path")
    parser.add_argument("--vendor", default="TAIYO YUDEN", help="Vendor name stored in PDA_ORGPN_MAPPING")
    parser.add_argument("--format", choices=("merge", "plsql"), default="merge", help="Output format")
    parser.add_argument("--block-size", type=int, default=50, help="MERGE statements per PL/SQL block")
    args = parser.parse_args()

    excel_path = Path(args.excel)
    output_path = Path(args.output)
    workbook = openpyxl.load_workbook(excel_path, data_only=True, read_only=False)

    lines = []
    if args.format == "merge":
        lines.extend(["set define off;", "prompt Import PDA_ORGPN_MAPPING data;", ""])

    count = 0
    block_merges = []
    for sheet, old_model, new_model in iter_mapping_rows(workbook):
        merge_sql = build_merge_sql(sheet, old_model, new_model, args.vendor)
        if args.format == "plsql":
            block_merges.append(merge_sql)
            if len(block_merges) >= args.block_size:
                append_plsql_block(lines, block_merges)
                block_merges = []
        else:
            lines.append(merge_sql)
        count += 1

    if args.format == "plsql":
        append_plsql_block(lines, block_merges)
        lines.append(f"-- Imported {count} PDA_ORGPN_MAPPING rows.")
    else:
        lines.extend(["commit;", f"prompt Imported {count} PDA_ORGPN_MAPPING rows;"])

    output_path.parent.mkdir(parents=True, exist_ok=True)
    output_path.write_text("\n".join(lines), encoding="utf-8")
    print(f"Generated {count} rows: {output_path}")


if __name__ == "__main__":
    main()
