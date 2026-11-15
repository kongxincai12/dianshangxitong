-- Mark templates migrated before staged-review configuration as legacy.
-- Legacy templates continue to use whole-record approval until quality saves
-- a new active version with one explicit release stage.

UPDATE QA_FA_TEMPLATE_SECTION S
   SET S.STAGE_ENABLED = 0,
       S.FINAL_REQUIRED = 0,
       S.RELEASE_ON_PASS = 0
 WHERE NOT EXISTS (
         SELECT 1
           FROM QA_FA_TEMPLATE_SECTION X
          WHERE X.TEMPLATE_ID = S.TEMPLATE_ID
            AND NVL(X.STAGE_ENABLED, 0) = 1
            AND NVL(X.RELEASE_ON_PASS, 0) = 1
       )
   AND NOT EXISTS (
         SELECT 1
           FROM QA_FA_RECORD R
           JOIN QA_FA_STAGE_RESULT SR ON SR.RECORD_ID = R.ID
          WHERE R.TEMPLATE_ID = S.TEMPLATE_ID
       );

COMMIT;
