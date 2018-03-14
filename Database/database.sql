CREATE DATABASE management_project;
USE management_Project;



CREATE TABLE Area (
	ID			INT AUTO_INCREMENT	,
	short_name 	VARCHAR(10)			,
	name_area	VARCHAR (30)		,

	PRIMARY KEY ( ID )
);

INSERT INTO Area ( short_name, name_area )
VALUES 	('KV1','Hai Chau')		,
		('KV2','Son Tra')		,
        ('KV3','Lien Chieu')	,
        ('KV4','Ngu Hanh Son');

SELECT * FROM Area;

CREATE TABLE Customer(	
	ID					INT 					AUTO_INCREMENT	,
	cus_name			VARCHAR (50)			NOT NULL		,
	gender				ENUM ('Male','Female')	NOT NULL		,
	date_of_birth		DATE					NOT NULL		,
	ID_card				VARCHAR (11)			NOT NULL		,
	address				VARCHAR (50)			NOT NULL		,
	phone_number		VARCHAR (15)			NOT NULL		,
	email_address		VARCHAR (50)			NOT NULL		,
	area				INT						NOT NULL		,

	PRIMARY KEY ( ID ),
	FOREIGN KEY ( area ) REFERENCES Area ( ID )
);

SELECT * FROM Customer;
SELECT * FROM Customer;

CREATE TABLE PriceRange (
	ID				INT					AUTO_INCREMENT	,		
	start_number	INT 				NOT NULL		,
	end_number		INT					NOT NULL		,
	price			INT					NOT NULL		,

	PRIMARY KEY ( ID)
);

SELECT * FROM PriceRange;

INSERT INTO PriceRange (start_number,end_number,price)
VALUES 	(  0 , 50   ,1484 ),
		( 51 , 100  ,1533 ),
        ( 101, 200  ,1786 ),
        ( 201, 300  ,2242 ),
        ( 301, 400  ,2503 ),
        ( 401, 9999 ,2587 );

SELECT * FROM PriceRange;

CREATE TABLE Indexs (
ID				INT 		 		AUTO_INCREMENT	,
index_of_month 	INT					NOT NULL		,
cus_ID			INT 				NOT NULL		,
old_number		INT 				NOT NULL		,
new_number		INT 				NOT NULL		,
indexs			INT					NOT NULL		,
into_money		INT					NOT NULL		,
vat_tax			DECIMAL(11,0)		NOT NULL		,
total			DECIMAL(11,0)		NOT NULL		,
payment			ENUM ('Submit','Unsubmit') NOT NULL	, 

PRIMARY KEY ( ID),
FOREIGN KEY ( cus_ID ) REFERENCES  Customer ( ID )
);

SELECT * FROM Indexs;



CREATE TABLE Users (
	ID				INT 					AUTO_INCREMENT	,
	user_name		VARCHAR (50)			NOT NULL		,
	user_password	VARCHAR (50)			NOT NULL		,
	role			VARCHAR (20)			NOT NULL		,
	date_login		DATETIME								,
    
	PRIMARY KEY ( ID )
);

INSERT INTO Users ( user_name, user_password, role)
VALUES 	('administrator','200ceb26807d6bf99fd6f4f0d1ca54d4','Administrator'	);

SELECT * FROM Users;

CREATE TABLE History (	
	ID 				INT 					AUTO_INCREMENT	,
    user_ID 		INT 					NOT NULL		,
    time_of_use 	DATETIME 				NOT NULL		,
	history 		VARCHAR(50) 			NOT NULL		,
    
    PRIMARY KEY ( id )										,    
	FOREIGN KEY (user_ID) REFERENCES Users (ID)
);

SELECT * FROM History;

CREATE TABLE Feedback (
	ID 				INT 							AUTO_INCREMENT	,
	full_name 		VARCHAR(20) 					NOT NULL		,
	rate_app 		ENUM('Very Good','Good','Fail')	NOT NULL		,	
	feedback 		VARCHAR(255)    				NOT NULL		,

	PRIMARY KEY ( ID )
);

INSERT INTO Feedback ( full_name, rate_app, feedback)
VALUES('Portgas Roo','Good','Good Job');

SELECT * FROM Feedback;

CREATE TABLE Notification (
ID 						INT 	AUTO_INCREMENT	,
user_ID 				INT 	NOT NULL		,
notification_uploaded 	VARCHAR(200)			,

PRIMARY KEY ( ID )								,    
FOREIGN KEY (user_ID) REFERENCES Users (ID)
);

INSERT INTO Notification (user_ID, notification_uploaded)
VALUES (1,'Notification from Administator: + Good App for good customer');

SELECT * FROM Notification;

SELECT Customer.cus_name,Area.name_area, Indexs.indexs, Indexs.Total, Indexs.payment FROM Customer, Area, Indexs WHERE Customer.ID_card = 1;       

CREATE TABLE Settingapp (
	Id 					INT 			AUTO_INCREMENT 	,
	email_program 		VARCHAR (30) 	NOT NULL		,
	password_program 	VARCHAR (30) 	NOT NULL		,
	name_company 		VARCHAR (40) 	NOT NULL		,
	numberphone_company VARCHAR (15) 	NOT NULL		,
	address_company 	VARCHAR (50) 	NOT NULL		,

PRIMARY KEY ( Id)
);

INSERT INTO Settingapp (email_program, password_program, name_company, numberphone_company, address_company)
VALUES ('ariesspeedkun@gmail.com','anhbahiepleqn2s','Project Management','840553113','80B - Le Duan Street, Da Nang City');
