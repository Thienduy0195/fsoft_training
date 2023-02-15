create database PRODUCT_MANAGEMENT;
use PRODUCT_MANAGEMENT;

create table Customer(
customerId int primary key identity(1,1),
customerName varchar(50)
);

create table Employee(
employeeId int primary key identity(1,1),
employeeName varchar(50),
salary money,
supervisor_id int foreign key references Employee(employeeId)
);

create table Product(
productId int primary key identity(1,1),
roductName varchar(50),
price money
);

create table Orders (
orderId int primary key identity(1,1),
orderDate date,
customerId int foreign key references Customer(customerId),
employeeId int foreign key references Employee(employeeId),
total money
);

create table LineItem(
orderId int foreign key references Orders(orderId),
productId int foreign key references Product(productId),
quantity int,
price money
);

select sum(price) as total_price from LineItem where orderId = 1 group by orderId;

insert into Orders(orderDate,customerId,employeeId,total) values('03-02-2023', 1, 2, 5000);

insert into LineItem(orderId,productId,quantity,price) values(1, 3, 2, 5000);

update Orders set total = 2000 where orderId = 1;



	CREATE PROCEDURE addCustomer 
       @customerName     varchar(50)  
AS 
BEGIN 
     SET NOCOUNT ON 

     INSERT INTO Customer
          (                    
            customerName           
          ) 
     VALUES 
          ( 
            @customerName       
          ) 
END 

exec PRODUCT_MANAGEMENT.dbo.addCustomer
    'Huynh Nhat Hoang';


	CREATE PROCEDURE InsertLineItem
       -- Add the parameters for the stored procedure here
       @orderId int,
       @productId int,
       @quantity int,
       @price money
AS
BEGIN
       -- SET NOCOUNT ON added to prevent extra result sets from
       -- interfering with SELECT statements.
       SET NOCOUNT ON;

    -- Insert statements for procedure here
       INSERT INTO dbo.LineItem
              (orderId, productId, quantity, price)
       VALUES
              (@orderId, @productId, @quantity, @price)
END


CREATE PROCEDURE DeleteCustomerAndRelationalObject
       -- Add the parameters for the stored procedure here
       @customerId int
AS
BEGIN
       -- SET NOCOUNT ON added to prevent extra result sets from
       -- interfering with SELECT statements.
       SET NOCOUNT ON;

            DELETE FROM LineItem
            WHERE  orderId in (SELECT orderId from Orders where customerId = @customerId)
			DELETE FROM Orders
            WHERE  customerId = @customerId
			DELETE FROM Customer
            WHERE  customerId = @customerId
END


CREATE PROCEDURE updateCustomer
       -- Add the parameters for the stored procedure here
       @CustomerName varchar(50),
	   @customerId int
AS
BEGIN
       -- SET NOCOUNT ON added to prevent extra result sets from
       -- interfering with SELECT statements.
       SET NOCOUNT ON;

            update Customer set customerName = @CustomerName where customerId = @customerId;
END