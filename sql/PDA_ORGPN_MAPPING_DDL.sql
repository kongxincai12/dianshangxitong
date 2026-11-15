create table PDA_ORGPN_MAPPING (
    MAPID varchar2(32) not null,
    VENDORNAME varchar2(100) default 'TAIYO YUDEN' not null,
    OLD_MODEL varchar2(100) not null,
    NEW_MODEL varchar2(100) not null,
    SOURCE_SHEET varchar2(100),
    ENABLEDFLAG varchar2(1) default 'Y' not null,
    CREATEUSER varchar2(50) default 'SYSTEM',
    CREATETIME date default sysdate not null,
    UPDATEUSER varchar2(50),
    UPDATETIME date,
    constraint PK_PDA_ORGPN_MAPPING primary key (MAPID),
    constraint CK_PDA_ORGPN_MAPPING_ENABLED check (ENABLEDFLAG in ('Y', 'N'))
);

create unique index UK_PDA_ORGPN_MAPPING_MODEL on PDA_ORGPN_MAPPING (OLD_MODEL, NEW_MODEL);
create index IX_PDA_ORGPN_MAPPING_OLD on PDA_ORGPN_MAPPING (OLD_MODEL, ENABLEDFLAG);
create index IX_PDA_ORGPN_MAPPING_NEW on PDA_ORGPN_MAPPING (NEW_MODEL, ENABLEDFLAG);

comment on table PDA_ORGPN_MAPPING is 'PDA原厂型号新旧映射表';
comment on column PDA_ORGPN_MAPPING.OLD_MODEL is '旧原厂型号，已归一化为去前后空格大写';
comment on column PDA_ORGPN_MAPPING.NEW_MODEL is '新原厂型号，已归一化为去前后空格大写';
comment on column PDA_ORGPN_MAPPING.SOURCE_SHEET is '来源Excel工作表';
comment on column PDA_ORGPN_MAPPING.ENABLEDFLAG is 'Y启用，N停用';
