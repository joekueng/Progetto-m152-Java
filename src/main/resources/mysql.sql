drop database if exists Progetto152;
create database if not exists Progetto152;
use Progetto152;



create table if not exists Location
(
    id       int auto_increment not null,
    location varchar(255)       not null unique,
    region   varchar(3)         not null,
    lat      double             not null,
    lon      double             not null,
    primary key (id)
);

create table if not exists Waypoints
(
    id          int           not null auto_increment,
    name        varchar(10)   not null,
    lat         double        not null,
    lon         double        not null,
    description varchar(1000) not null,
    img         varchar(1000) not null,
    LocationId  int           not null,
    primary key (id),
    foreign key (LocationId) references Location (id)
);

create table if not exists User(
                                   id int not null auto_increment,
                                   name varchar(45) not null,
                                   username varchar(100) not null,
                                   password varchar(100) not null,
                                   primary key (id)
);

create table if not exists LocationVisited(
                                              userId int not null,
                                              locationid int not null,
                                              foreign key (userId) references User(id),
                                              foreign key (locationid) references Location(id)
)