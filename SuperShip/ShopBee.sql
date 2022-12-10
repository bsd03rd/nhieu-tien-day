use master
go
Create database ShopeBee
go
use ShopeBee
go
Create table Account(
gmail_Account nvarchar(100) PRIMARY KEY,
type_account nvarchar(max),
password_account nvarchar(max),
)
select * from Account
go
create table Account_info(
gmail_Account nvarchar(100) primary key, --foreign key
Fname nvarchar(max),
Lname nvarchar(max),
gender nvarchar(max),
balance  money,
PhoneNumber nvarchar(max),
img image,           --img type
create_date_account nvarchar(max),
CONSTRAINT Account_info_forgein FOREIGN KEY (gmail_Account) REFERENCES Account (gmail_Account)
)
go
create table City_Address(
ID_City_Address  nvarchar(100) PRIMARY KEY,
Name_City_Address  nvarchar(max)
)
go
create table District_Address(
ID_City_Address nvarchar(100), --foreign key
ID_District_Address  nvarchar(100), -- not a key
Name_District_Address  nvarchar(max),
CONSTRAINT District_Address_FOREIGN FOREIGN KEY (ID_City_Address) REFERENCES City_Address (ID_City_Address)
)
go
create table Address_Account(
gmail_Account nvarchar(100), --foreign key
ID_City_Address nvarchar(100), --foreign key
ID_District_Address  nvarchar(100), -- not a key
Street_Address nvarchar(max),
id_Address_Account int NOT NULL IDENTITY(1,1) PRIMARY KEY,
CONSTRAINT Address_Seller_FOREIGN FOREIGN KEY (gmail_Account) REFERENCES Account (gmail_Account),
CONSTRAINT City_Address_Seller__FOREIGN FOREIGN KEY (ID_City_Address) REFERENCES City_Address (ID_City_Address)
)
go
Create table categories_product(
id_categories int NOT NULL IDENTITY(1,1) PRIMARY KEY, --primary key
CategoryName nvarchar(max),
Description nvarchar(max) null,
)
select * from categories_product
go
Create table product(
id_product int NOT NULL IDENTITY(1,1) PRIMARY KEY, --primary key
id_categories int , --foreign key
gmail_Account nvarchar(100), --foreign key
name_product nvarchar(max),
value_product_unit nvarchar(max),
value_product_perunit money,
amount_product nvarchar(max),
create_date_product nvarchar(max),
img image,
description  nvarchar(max),
CONSTRAINT gmail_Account_FOREIGN FOREIGN KEY (gmail_Account) REFERENCES Account (gmail_Account),
CONSTRAINT product_seller_FOREIGN FOREIGN KEY (id_categories) REFERENCES categories_product (id_categories)
)
select * from product
go
Create table Order_product(
Id_order nvarchar(64) NOT NULL PRIMARY KEY, --primary key
gmail_Account_sell nvarchar(100),--foreign key
gmail_Account_buy nvarchar(100),--foreign key
orderdate_order_product nvarchar(max),
CONSTRAINT gmail_Account_sell_FOREIGN FOREIGN KEY (gmail_Account_sell) REFERENCES Account (gmail_Account),
CONSTRAINT gmail_Account_buy_FOREIGN FOREIGN KEY (gmail_Account_buy) REFERENCES Account (gmail_Account),
)
create table Order_product_details(
Id_order nvarchar(64), --foreign key
id_product int , --foreign key
CONSTRAINT OrderDetails_id_Order_PrimaryKey FOREIGN KEY (id_Order)  REFERENCES Order_product (id_Order),
CONSTRAINT OrderDetails_id_product_PrimaryKey FOREIGN KEY (id_product)  REFERENCES product (id_product)
)
Create table Ship_info(
id_Ship_info int NOT NULL IDENTITY(1,1) PRIMARY KEY, --primary key
Id_order nvarchar(64),--foreign key
RequiredDate_Ship_info nvarchar(max),
ShippedDate_Ship_info nvarchar(max),
Shipfee_Ship_info nvarchar(max),
ShipAddress_Ship_info nvarchar(max),
ShipCity_Ship_info nvarchar(max),
ShipRegion_Ship_info nvarchar(max),
ShipPostalCode_Ship_info nvarchar(max),
Shipped_Ship_info nvarchar(max),
CONSTRAINT Ship_info_FOREIGN FOREIGN KEY (id_Order) REFERENCES Order_product (id_Order)
)
create table historysearch(
gmail_Account nvarchar(100),--foreign key
content nvarchar(max),
date nvarchar(max)
CONSTRAINT gmail_Account_historysearch_FOREIGN FOREIGN KEY (gmail_Account) REFERENCES Account (gmail_Account),
)
create table commentItems(
id_product int , --foreign key
gmail_Account nvarchar(100),--foreign key
comment nvarchar(max),
date nvarchar(max),
grade int
CONSTRAINT gmail_Account_commentItems_FOREIGN FOREIGN KEY (gmail_Account) REFERENCES Account (gmail_Account),
CONSTRAINT commentItems_id_product FOREIGN KEY (id_product)  REFERENCES product (id_product)
)
create table Cart(
id_product int , --foreign key
amount int,
gmail_Account nvarchar(100),--foreign key
CONSTRAINT gmail_Account_Cart FOREIGN KEY (gmail_Account) REFERENCES Account (gmail_Account)
)
--insert data --------------------------------------------------------------------------------------------------------------------------------------------------------
--insert data City_Address------------
insert into City_Address(ID_City_Address,Name_City_Address) values(N'HN',N'Hà Nội')
insert into City_Address(ID_City_Address,Name_City_Address) values(N'DN',N'Đà Nẵng')
insert into City_Address(ID_City_Address,Name_City_Address) values(N'HCM',N'Hồ Chí Minh')
/*
select * from City_Address
delete from City_Address
*/
--------------------------------------
--insert data District_Address------------
insert into District_Address(ID_City_Address,ID_District_Address,Name_District_Address) values(N'HN',N'TX',N'Thanh Xuân')
insert into District_Address(ID_City_Address,ID_District_Address,Name_District_Address) values(N'HN',N'TX',N'Đống Đa')
insert into District_Address(ID_City_Address,ID_District_Address,Name_District_Address) values(N'HCM',N'Q1',N'Quận 1')
insert into District_Address(ID_City_Address,ID_District_Address,Name_District_Address) values(N'HCM',N'Q2',N'Quận 2')
insert into District_Address(ID_City_Address,ID_District_Address,Name_District_Address) values(N'DN',N'CL',N'Cẩm Lệ')
insert into District_Address(ID_City_Address,ID_District_Address,Name_District_Address) values(N'DN',N'QT',N'Quốc Toản')
/*
select * from District_Address
delete from District_Address
*/
-------------------------------------
--------------------------------------
--insert data categories_product------------
insert into categories_product(CategoryName,Description) values(N'Quần Áo',N'Quần Áo các kiểu')
insert into categories_product(CategoryName,Description) values(N'Đồ Điện Tử',N'Đồ Điện Tử các kiểu')
insert into categories_product(CategoryName,Description) values(N'Xe Cộ',N'Xe Cộ các kiểu')
insert into categories_product(CategoryName,Description) values(N'Động Vật',N'Động Vật các kiểu')
insert into categories_product(CategoryName,Description) values(N'Người Yêu',N'Người Yêu các kiểu')
insert into categories_product(CategoryName,Description) values(N'Đồ Chơi',N'Đồ Chơi các kiểu')
insert into categories_product(CategoryName,Description) values(N'Dụng Cụ',N'Dụng Cụ các kiểu')
insert into categories_product(CategoryName,Description) values(N'Học Tập',N'Dụng Cụ các kiểu')
insert into categories_product(CategoryName,Description) values(N'Thẻ',N'Thẻ các kiểu')
insert into categories_product(CategoryName,Description) values(N'Nông Sản',N'Nông Sản các kiểu')
/*
select * from categories_product
delete from categories_product
*/
-------------------------------------

--Procstore database-------------------------------------------------------------------------------------------------------------------------------------------------------------
--Proc Register---------------------------------
go
create proc Register_Account
@gmail_Account nvarchar(100),
@password_account nvarchar(max),
@type_account nvarchar(max)
as
insert into Account(gmail_Account,password_account,type_account) values(@gmail_Account,@password_account,@type_account)
go
/*
select * from Account
delete from Account
drop proc Register_Account
exec Register_Account 'admin@gmail.com','admin123','admin' 
exec Register_Account 'user@gmail.com','user123','user' 
exec Register_Account 'user1@gmail.com','user234','user' 
*/
-------------------------------------------------------
--Proc Add_info_Account---------------------------------
go
create proc Add_info_Account
@gmail_Account nvarchar(100),
@Fname nvarchar(max),
@Lname nvarchar(max),
@gender nvarchar(max),
@PhoneNumber nvarchar(max),
@balance money,
@img image,
@create_date_account nvarchar(max)
as
insert into Account_info(gmail_Account,Fname,Lname,gender,PhoneNumber,balance,img,create_date_account)
				values(@gmail_Account,@Fname,@Lname,@gender,@PhoneNumber,@balance,@img,@create_date_account) 
go
/*
select * from Account_info
exec Add_info_Account 'admin@gmail.com','admin','strator','male','09067834','999','1','23/6/2022'
exec Add_info_Account 'user@gmail.com','user','name','male','090654634','123','1','21/6/2022' 
exec Add_info_Account 'user1@gmail.com','user1','name1','male','09034524','234','1','20/6/2022' 
delete from Account_info
drop proc Add_info_Account
*/
-------------------------------------------------------
--Proc Add_Address_Account---------------------------------
go
create proc Add_Adress_Account
@gmail_Account nvarchar(100),
@ID_City_Address nvarchar(100),
@ID_District_Address nvarchar(100),
@Street_Address nvarchar(max)
as
insert into Address_Account(gmail_Account,ID_City_Address,ID_District_Address,Street_Address) values(@gmail_Account,@ID_City_Address,@ID_District_Address,@Street_Address)
go
/*
select * from Address_Account
exec Add_Adress_Account 'admin@gmail.com','HN','TX','12 Ha Noi Thanh Xuan' 
exec Add_Adress_Account 'user@gmail.com','HCM','Q1','12 Q1 ' 
exec Add_Adress_Account 'user1@gmail.com','DN','CL','12 Cl ' 
delete from Address_Account
drop proc Add_Adress_Account
*/
-------------------------------------------------------
--Proc Delete_Address_Account---------------------------------
go
create proc Delete_Adress_Account
@gmail_Account nvarchar(100),
@ID_City_Address nvarchar(100),
@ID_District_Address nvarchar(100),
@Street_Address nvarchar(max)
as
delete  Address_Account  where gmail_Account = @gmail_Account 
and ID_City_Address=@ID_City_Address and ID_District_Address=@ID_District_Address 
and Street_Address=@Street_Address
go
/*
select * from Address_Account
exec Delete_Adress_Account 'user@gmail.com','DN','CL','Nha Bo may ok' 
exec Add_Adress_Account 'user@gmail.com','HCM','Q1','12 Q1 ' 
exec Add_Adress_Account 'user1@gmail.com','DN','CL','12 Cl ' 
delete from Address_Account
drop proc Add_Adress_Account
*/
-------------------------------------------------------
--Proc Update_info_Account---------------------------------
go
create proc Update_info_Account
@gmail_Account nvarchar(100),
@Fname nvarchar(max),
@Lname nvarchar(max),
@gender nvarchar(max),
@PhoneNumber nvarchar(max),
@img image
as
UPDATE Account_info SET Fname=@Fname,Lname=@Lname,gender=@gender,
PhoneNumber=@PhoneNumber,img=@img
where gmail_Account=@gmail_Account
go
/*
select * from Account_info
exec Update_info_Account 'admin@gmail.com','strator','strator','female','09067834','1'
delete from Account_info
drop proc Update_info_Account
*/
-------------------------------------------------------
-------------------------------------------------------
--Proc insert_Product---------------------------------
go
create proc insert_Product
@gmail_Account nvarchar(100),
@id_categories nvarchar(100),
@name_product nvarchar(max),
@value_product_unit nvarchar(max),
@value_product_perunit money,
@amount_product nvarchar(max),
@create_date_product nvarchar(max),
@img image,
@description nvarchar(max)
as
insert into product(gmail_Account,id_categories,name_product,
value_product_unit,value_product_perunit,amount_product,create_date_product,img,[description])
values(@gmail_Account,@id_categories,@name_product,
@value_product_unit,@value_product_perunit,@amount_product,@create_date_product,@img,@description)
go
/*
delete from product
select * from product
select * from categories_product
select * from product
exec insert_Product 'admin@gmail.com','1','clownz','chiec','100000','25','23/6/2022','image','description'
update product set img ='123' where gmail_account like'admin@gmail.com' and id_product like '3'
delete from product
drop proc insert_Product
*/
-------------------------------------------------------
-------------------------------------------------------
--Proc update_Product---------------------------------
go
create proc update_Product
@gmail_Account nvarchar(100),
@id_product nvarchar(100),
@id_categories nvarchar(100),
@name_product nvarchar(max),
@value_product_unit nvarchar(max),
@value_product_perunit money,
@amount_product nvarchar(max),
@img image,
@description nvarchar(max)
as
UPDATE product 
SET 
id_categories=@id_categories,
name_product=@name_product,
value_product_perunit=@value_product_perunit,
value_product_unit=@value_product_unit,
amount_product=@amount_product,
img=@img,
[description] = @description
where gmail_Account=@gmail_Account and  id_product=@id_product
go
/*
select * from product 
select * from categories_product
select * from product
exec update_Product 'admin@gmail.com','4','3','Xe Xe','cai','19000','2','img'
delete from Account_info
drop proc update_Product
*/
-------------------------------------------------------
--Proc insert_Order_product---------------------------------
go
create proc insert_Order_product
@gmail_Account_sell nvarchar(100),
@gmail_Account_buy nvarchar(100),
@orderdate_order_product nvarchar(max)
as
insert into Order_product(gmail_Account_sell,gmail_Account_buy,orderdate_order_product)
values(@gmail_Account_sell,@gmail_Account_buy,@orderdate_order_product)
go
/*
delete Order_product
select * from Order_product
select * from categories_product
select * from product
select * from account
exec insert_Order_product 'admin@gmail.com', 'user@gmail.com','21/6/2022'
delete from Account_info
drop proc insert_Order_product
*/
-------------------------------------------------------
--Proc insert_Order_details---------------------------------
go
create proc insert_Order_details
@Id_order nvarchar(100),
@id_product nvarchar(100)
as
insert into Order_product_details(Id_order,id_product) values(@Id_order,@id_product)
go
/*
delete Order_product_details
select * from Order_product_details
select * from Order_product
select * from product
select * from account
exec insert_Order_details '1', '1'
delete from Order_product_details
drop proc insert_Order_details
*/
-------------------------------------------------------
--Proc insert_Ship_info---------------------------------
go
create proc insert_Ship_info
@Id_order nvarchar(100),
@RequiredDate_Ship_info nvarchar(max),
@ShipAddress_Ship_info nvarchar(max),
@ShipCity_Ship_info nvarchar(max),
@ShipRegion_Ship_info nvarchar(max),
@Shipfee_Ship_info nvarchar(max),
@Shipped_Ship_info nvarchar(max),
@ShippedDate_Ship_info nvarchar(max),
@ShipPostalCode_Ship_info nvarchar(max)
as
insert into Ship_info(Id_order,RequiredDate_Ship_info,
ShipAddress_Ship_info,ShipCity_Ship_info,ShipRegion_Ship_info,Shipfee_Ship_info,
Shipped_Ship_info,ShippedDate_Ship_info,ShipPostalCode_Ship_info)
values(@Id_order,@RequiredDate_Ship_info,@ShipAddress_Ship_info,
@ShipCity_Ship_info,@ShipRegion_Ship_info,@Shipfee_Ship_info,@Shipped_Ship_info,@ShippedDate_Ship_info,@ShipPostalCode_Ship_info)
go
/*
delete Ship_info
select * from Ship_info
select * from Order_product
select * from product
select * from account
exec insert_Ship_info 'Id_order', 'RequiredDate' ,'ShipAddress', 'ShipCity','ShipRegion', 'Shipfee', 'Shipped',
 'ShippedDate', 'ShipPostalCode'
delete from Account_info

drop proc insert_Ship_info
*/
-------------------------------------------------------
--Proc Pay_Order---------------------------------
go
create proc Pay_Order
@Id_order nvarchar(100)
as

update Account_info
set balance=(select balance from Account_info where gmail_Account like (select gmail_Account_buy from Order_product where Id_order like @Id_order))-(select Ship_info.Shipfee_Ship_info from Ship_info where  Id_order like @Id_order)
where gmail_Account like (select gmail_Account_buy from Order_product where Id_order like @Id_order)

update Account_info
set balance=(select balance from Account_info where gmail_Account like (select gmail_Account_sell from Order_product where Id_order like @Id_order))+(select Ship_info.Shipfee_Ship_info from Ship_info where  Id_order like @Id_order)
where gmail_Account like (select gmail_Account_sell from Order_product where Id_order like @Id_order)
go

--exec Pay_Order '2698e717ba9aa97fb8439f51aac2456fb0bc338795f4991a9e004999d2296ca8'
--drop proc Pay_Order
--2698e717ba9aa97fb8439f51aac2456fb0bc338795f4991a9e004999d2296ca8
-------------------------------------------------------
--create full text index for table product




-----------------------------------------------

select * from Account
select * from Account_info
select * from Address_Account
select * from product

delete  product


--checking full text ----------------------------
SELECT 
	CASE FULLTEXTSERVICEPROPERTY('IsFullTextInstalled')
		WHEN 1 THEN 'Full-Text installed.' 
		ELSE 'Full-Text is NOT installed.' 
	END
----full text catlog--------------------------------------
select * FROM sys.fulltext_catalogs
------------------------------------
insert into product(name_product) values(N'Kẹo Ngọt')
insert into product(name_product) values(N'Kẹo Kéo')
insert into product(name_product) values(N'Siêu Kẹoo')
insert into product(name_product) values(N'Kẹo Ngọt')
insert into product(name_product) values(N'Quần Áo Đôn Chề')
insert into product(name_product) values(N'Quần Jean')
insert into product(name_product) values(N'Quần Dài')
insert into product(name_product) values(N'quần thể')

delete  from historysearch
select * from Address_Account
select * from product where (freetext(product.*,N'Itemcategorynumber0')) and ((select count(*) from Address_Account where Address_Account.gmail_Account like product.gmail_Account  and ID_City_Address like 'HN')  !=0 )
select * from product where (product.value_product_perunit>=0 and product.value_product_perunit<=10)
and (product.id_categories like '')
select * from product where (freetext(product.*,N'Itemcategorynumber0')) or (freetext(product.*,N'Itemcategorynumber1'))
select * from historysearch where gmail_Account like 'user@gmail.com'
order by historysearch.date DESC
select ID_City_Address from Address_Account where gmail_Account like'user@gmail.com'
order by  create_date_product DESC
offset 12 rows
fetch next 12 rows only


delete from Ship_info
delete from Order_product_details
delete from Order_product 

select * from Ship_info
select * from Order_product_details
select * from Order_product

update Ship_info set ShippedDate_Ship_info=? where Id_order like ?
select * from Order_product as od
join Ship_info as sp on od.Id_order=sp.Id_order
 where gmail_Account_buy like ? and ShippedDate_Ship_info=? order by orderdate_order_product DESC

 select * from Account_info
 update Ship_info set ShippedDate_Ship_info=2 where Id_order like '2698e717ba9aa97fb8439f51aac2456fb0bc338795f4991a9e004999d2296ca8'

select count(*),id_product from Order_product_details 
group by   id_product

select product.id_product,count(product.id_product) from product
 join Order_product_details on Order_product_details.id_product=product.id_product
group by product.id_product
order by count(product.id_product) DESC

select id_product from Order_product
join Order_product_details on Order_product_details.Id_order=Order_product.Id_order
group by id_product

--dang lam day nay
select Order_product_details.id_product,count(Order_product_details.id_product)as totalorder from Order_product_details 
join product on product.id_product=Order_product_details.id_product
where gmail_Account like 'admin@gmail.com'
group by Order_product_details.id_product
order by count(Order_product_details.id_product) DESC
select * from product
delete from product where id_product =6

select * from product where (freetext(product.*,N'Itemcategorynumber0'))

order by id_product
select * from product


--DELETE DATABASE--------------------------------------------------------------------------------------
go
use master
go
drop database ShopeBee
---------------------------------------------------------------------------------------------------------
select * from account

/*

delete from product
go
select * from product
order by  create_date_product
OFFSET 0 ROWS
FETCH NEXT 3 ROWS ONLY

select * from account
select * from seller
select * from Address_Account

delete from account
delete from seller
delete from Address_Account

select ac.id_account,ac.gmail_Account,ac.Fname,ac.Lname,ac.gender,ac.type_account,ac.password_account,ac.create_date_account,sl.id_seller,sl.ShopDomain_seller,sl.PhoneNumber_seller,sl.img_seller,adc.ID_City_Address,adc.ID_District_Address,adc.Street_Address_Seller from Account as ac
join seller as sl on sl.id_account=ac.id_account
join Address_Account as adc on adc.id_account=ac.id_account
where ac.id_account like ''

select cd.Name_City_Address,da.Name_District_Address,aa.Street_Address_Seller,aa.id_account,aa.gmail_Account from Address_Account as aa 
join City_Address as cd on cd.ID_City_Address=aa.ID_City_Address
join District_Address as da on da.ID_District_Address=aa.ID_District_Address
where id_account like 'e9b9b3038b3717f7f4cd6fdd1f0694a5fff5f0244ebe97927276afd4d219eb64'

select * from Account
select * from City_Address
select * from District_Address
insert into Address_Account(ID_City_Address,ID_District_Address,Street_Address_Seller,id_account,gmail_Account) values('HCM','Q1','stree2t','9a9b7b86eb3c53717cc2e27eb4fca82e57bf0ba7581e1b52a03b374db10b61a2','admin')
UPDATE seller SET img_seller='' WHERE id_seller like '';

update Account set Fname='',Lname='',gender='' where id_account=''
update seller set PhoneNumber_seller='',ShopDomain_seller='' where id_account=''

select * from Address_Account

select * from seller
insert into account(id_account,gmail_Account,Fname,Lname,gender,type_account,password_account,create_date_account) values('1','1','1','1','1','1','1','1')
insert into seller(id_account,id_seller,ShopDomain_seller,PhoneNumber_seller,gmail_Account,img_seller)values('e9b9b3038b3717f7f4cd6fdd1f0694a5fff5f0244ebe97927276afd4d219eb64','SELLe9b9b3038b3717f7f4cd6fdd1f0694a5fff5f0244ebe97927276afd4d219eb64','12','123','123','123')

go
use master
go
drop database ShopeBee


insert into Account
                   (id_account,gmail_Account,Fname,Lname,gender,type_account,password_account,create_date_account)
                    values('1','1','1','1','1','1','1','1')
					*/