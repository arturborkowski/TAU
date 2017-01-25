insert into person (name,yob) values ("Jan Kowalski", 1963);
insert into person (name,yob) values ("Zbyszek Nowak", 1970);
insert into person (name,yob) values ("Janina Malinowska", 1956);

insert into car (brand, model, production_year, person_id) values ("Opel","Astra",2001,1);
insert into car (brand, model, production_year, person_id) values ("Fiat","Seicento",2002,2);
insert into car (brand, model, production_year, person_id) values ("Mazda","6",2006,2);
insert into car (brand, model, production_year, person_id) values ("VW","Golf",1998,3);

insert into car_repair (name_of_service,price, car_id) values ("Wymiana opon",100.00,1);
insert into car_repair (name_of_service,price, car_id) values ("Powłoka antykorozyjna",450.00,1);
insert into car_repair (name_of_service,price, car_id) values ("Wymiana świec",350.00,2);
insert into car_repair (name_of_service,price, car_id) values ("Wymiana uszczelki p/głowicą",900.00,4);
insert into car_repair (name_of_service,price, car_id) values ("Wymiana fitra oleju",40.00,4);
insert into car_repair (name_of_service,price, car_id) values ("Regeneracja sprzęgła",750.00,3);