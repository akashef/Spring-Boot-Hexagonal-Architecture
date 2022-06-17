DROP TABLE IF EXISTS account;

CREATE TABLE account (
                         Id  bigint NOT NULL,
                         accountNo bigint NOT NULL,
                         accountBalance Numeric NOT NULL
);

Insert into account values (5,5,5000);
