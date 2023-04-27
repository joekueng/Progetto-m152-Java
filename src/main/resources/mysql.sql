drop database if exists Progetto152;
create database if not exists Progetto152;
use Progetto152;



create table if not exists Location
(
    location varchar(255) not null unique,
    region   varchar(3)   not null,
    lat      double       not null,
    lon      double       not null,
    primary key (location)
);

create table if not exists Waypoints
(
    id           int           not null auto_increment,
    name         varchar(255)  not null,
    lat          double        not null,
    lon          double        not null,
    description  varchar(1000) not null,
    img          varchar(1000) not null,
    locationName varchar(255)  not null,
    primary key (id),
    foreign key (LocationName) references Location (location)
);

create table if not exists User
(
    id       int          not null auto_increment,
    name     varchar(45)  not null,
    username varchar(100) not null,
    password varchar(100) not null,
    primary key (id)
);

create table if not exists WaypointsVisited
(
    userId     int not null,
    waypointId int not null,
    foreign key (userId) references User (id),
    foreign key (waypointId) references Waypoints (id)
);


#popolate table location
insert into Location (location, region, lat, lon)
values ('Biasca', 'TI', 46.361184, 8.970937);
insert into Location (location, region, lat, lon)
values ('Bellinzona', 'TI', 46.194034, 9.023976);
insert into Location (location, region, lat, lon)
values ('Lugano', 'TI', 46.003677, 8.951052);
insert into Location (location, region, lat, lon)
values ('Locarno', 'TI', 46.170794, 8.799534);
insert into Location (location, region, lat, lon)
values ('Ascona', 'TI', 46.157320, 8.773882);

insert into Waypoints (name, lat, lon, description, img, LocationName)
values ('Cascata Santa Petronilla', 46.35328215446709, 8.97758397155138, 'A',
        'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png', 'Biasca');
insert into Waypoints (name, lat, lon, description, img, LocationName)
values ('Casa Küng', 46.363570208549994,  8.963464722308554, 'Descrizione del punto 2',
        'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png',
        'Biasca');
insert into Waypoints (name, lat, lon, description, img, LocationName) values ('Punto 1', 46.123,
                                                                               8.123,
                                                                               'Descrizione del punto 3, un grandissimo',
                                                                               'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png',
                                                                               'Lugano');