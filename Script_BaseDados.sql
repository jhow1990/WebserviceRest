create database ProjectCities;

use ProjectCities;

create table city(

	idCity        int not null auto_increment,
    nameCity      char(100),
    latitudeCity  double default 0 ,
    longitudeCity double default 0 ,
	
    primary key(idCity)
);

insert into city (nameCity, latitudeCity, longitudeCity) values('São Paulo',-23.5506507,-46.6333824);
insert into city (nameCity, latitudeCity, longitudeCity) values('Rio de Janeiro',-22.9110137,-43.2093727);
insert into city (nameCity, latitudeCity, longitudeCity) values('Nova York',40.7308619,-73.9871558);

select * from city;

select * from city where idCity <> 2;
select * from city where idCity <> 2;
select * from city where idCity <> 2 order by idCity asc;