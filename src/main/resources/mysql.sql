drop database if exists Progetto152;
create database if not exists Progetto152;
use Progetto152;



create table if not exists Location
(
    location varchar(255) not null unique default '',
    region   varchar(3)   not null,
    lat      double       not null,
    lon      double       not null,
    primary key (location)
);

create table if not exists Waypoints
(
    id            int           not null auto_increment,
    name          varchar(255)  not null,
    lat           double        not null,
    lon           double        not null,
    description   varchar(1000) not null,
    img           varchar(1000) not null,
    location_name varchar(255)  not null,
    primary key (id),
    foreign key (Location_name) references Location (location)
);

create table if not exists User
(
    id       int          not null auto_increment,
    username varchar(100) not null unique,
    password varchar(100) not null,
    admin    boolean default false,
    primary key (id)
);

create table if not exists Waypoints_visited
(
    user_id     int not null,
    waypoint_id int not null,
    foreign key (user_id) references User (id),
    foreign key (waypoint_id) references Waypoints (id)
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
insert into Location (location, region, lat, lon)
values ('Airolo', 'TI', 46.548, 8.591);

insert into Waypoints (name, lat, lon, description, img, Location_name)
values ('Cascata Santa Petronilla', 46.35328215446709, 8.97758397155138, 'A',
        'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png', 'Biasca');
insert into Waypoints (name, lat, lon, description, img, Location_name)
values ('Casa Küng', 46.363570208549994, 8.963464722308554, 'Descrizione del punto 2',
        'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png',
        'Biasca');
insert into Waypoints (name, lat, lon, description, img, Location_name)
values ('Punto 1', 46.123,
        8.123,
        'Descrizione del punto 3, un grandissimo',
        'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png',
        'Lugano');
insert into Waypoints (id, name, lat, lon, description, img, Location_name)
values (4, 'Punto 2', 46.123, 8.123,
        'Descrizione del punto 4',
        'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png',
        'Locarno');
insert into Waypoints (id, name, lat, lon, description, img, location_name)
values (5, 'Punto 3', 46.123, 8.123,
        'Descrizione del punto 5',
        'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png',
        'Ascona');
insert into Waypoints (id, name, lat, lon, description, img, location_name)
values (6, 'Punto 4', 46.123, 8.123, 'Descrizione del punto 6',
        'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png',
        'Airolo');
insert into Waypoints (id, name, lat, lon, description, img, location_name)
values (7, 'Punto 5', 46.123, 8.123,
        'Descrizione del punto 7',
        'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png',
        'Bellinzona');
insert into Waypoints (id, name, lat, lon, description, img, location_name)
values (8, 'Punto 6', 46.123, 8.123, 'Descrizione del punto 8',
        'https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png',
        'Biasca');

insert into User (username, password)
values ('mario.rossi', 'password');
insert into User (username, password)
values ('luca.bianchi', 'password');
insert into User (username, password)
values ('giovanni.verdi', 'password');
insert into User (username, password, admin) values ('Joe', 'admin', true);

insert into Waypoints_visited (user_id, waypoint_id) values (1,1);
insert into Waypoints_visited (user_id, waypoint_id) values (2,2);