USE family_finance_management;

ALTER TABLE target_spending DROP FOREIGN KEY target_spending_ibfk_1;

ALTER TABLE target_spending
DROP COLUMN period_id;

ALTER TABLE target_spending
DROP COLUMN within_income;

