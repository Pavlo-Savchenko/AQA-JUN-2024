CREATE TABLE IPhoneTable (
                         PhoneID int UNIQUE AUTO_INCREMENT NOT NULL,
                         NamePhone varchar(255) NOT NULL,
                         PrisePhone varchar(255) NOT NULL
);
SELECT * FROM IPhoneTable it ;
INSERT INTO IPhoneTable (PhoneID,NamePhone,PrisePhone) VALUES ('1', 'IPhone15pro', '50000');
DELETE from  IPhoneTable;