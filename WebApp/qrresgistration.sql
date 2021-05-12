create table qrregistration (
qr_id int auto_increment primary key,
full_name varchar(255) not null,
gender enum('Male','Female','other'),
dob date not null,
aadhar_number  char(15),
mobile_number char(10),
email_id varchar(30) not null,
address varchar(255) ,
vehicle_number varchar(10) not null,
vin varchar(18) ,
vehcile_class enum('MC 50CC (Motorcycle 50cc)','MC EX50CC (Motorcycle more than 50cc)',
  'MC Without Gear or M/CYCL.WOG (Motorcycle Without Gear)',
  'MCWG or MC With Gear or M/CYCL.WG (Motorcycle With Gear)',
  'LMV-NT (Light Motor Vehicle—Non Transport) ',
  'LMV-INVCRG-NT (Light Motor Vehicle—Invalid Carrige-Non Transport)',
  'LMV-TR (Light Motor Vehicle—Transport) ',
  'LMV (Light Motor Vehicle)',
  'LDRXCV (Loader, Excavator, Hydraulic Equipment)',
  'HMV (Heavy Motor Vehicle)',
  'HPMV (Heavy Passenger Motor Vehicle)',
  'HTV',
  'TRANS (Heavy Goods Motor Vehicle, Heavy Passenger Motor Vehicle)'),
fuel enum('Petrol','Diesel'),
register_authority enum('RTO,CHENNAI (CENTRAL-TN01)','RTO,CHENNAI(NORT WEST-TN02)' ,
  'RTO,CHENNAI(NORTH EAST-TN03)','RTO,CHENNAI (EAST-TN04)','REGIONAL TRANSPORT OFFICE, CHENNAI (NORTH-	TN05)',
  'RTO CHENNAI(SOUTH-EAST-TN06)', 'RTO CHENNAI(SOUTH-TN07)','RTO CHENNAI (WEST-TN09)','RTO CHENNAI(SOUTH-WEST-TN10)	'),
insurance_upto date ,
fitness_regn_upto date 
)engine= InnoDB Default charset = utf8mb4 collate=utf8mb4_0900_ai_ci;


alter table qrregistration  auto_increment =1011521111;

create table users(
  `id` int NOT NULL AUTO_INCREMENT,
  `first_name` varchar(20) DEFAULT NULL,
  `last_name` varchar(20) DEFAULT NULL,
  `username` varchar(250) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;