create database PHONE_DB;
use PHONE_DB;

	create table Phone(
		id Nvarchar(10) primary key,
		name Nvarchar(50),
		screenSize float,
		chipset Nvarchar(50),
		ram int,
		storage int,
		price money,
		manufacture Nvarchar(50),
		warranty int,
		range int,
		country Nvarchar(50),
		status int,
		bodyStatus int,
		priceWarranty money,
	);

truncate table Phone;

select * from Phone where price > 2000000 and price < 3000000;