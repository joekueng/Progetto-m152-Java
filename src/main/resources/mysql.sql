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
    admin    int(1)       not null default 0,
    primary key (id)
);

create table if not exists Waypoints_visited
(
    user_id     int not null,
    waypoint_id int not null,
    foreign key (user_id) references User (id),
    foreign key (waypoint_id) references Waypoints (id)
);

INSERT INTO location (location, region, lat, lon)
VALUES ('Meride', 'TI', 45.9247, 8.9175),
       ('Bellinzona', 'TI', 46.1972, 9.0173),
       ('Locarno', 'TI', 46.0572, 8.7536),
       ('Rivera', 'TI', 46.0283, 8.8739),
       ('Mendrisio', 'TI', 45.9069, 9.0131),
       ('Lugano', 'TI', 46.0031, 8.9536),
       ('Lavertezzo', 'TI', 46.2764, 8.7753),
       ('Orselina', 'TI', 46.1761, 8.8036),
       ('Airolo', 'TI', 46.5106, 8.5167),
       ('Carona', 'TI', 46.0117, 8.9106),
       ('Ligornetto', 'TI', 45.8458, 8.9528);

INSERT INTO Waypoints (name, description, lat, lon, location_name, img)
VALUES ('Monte San Giorgio',
        'Monte conosciuto per i fossili di pesci e rettili marini risalenti a 240-235 milioni di anni fa.', 45.91389,
        8.949722, 'Meride', '/assets/waypointImages/MonteSanGiorgio.jpeg'),
       ('Castelli di Bellinzona',
        'Uno dei principali siti turistici in Ticino, i castelli di Bellinzona sono un patrimonio dell''umanità UNESCO.',
        46.19325192304354, 9.022618372917261, 'Bellinzona', '/assets/waypointImages/CastelliDiBellinzona.jpeg'),
       ('Lago Maggiore',
        'Il lago più grande della Svizzera è situato sia in Svizzera che in Italia ed è una popolare meta turistica.',
        46.170572452411974, 8.801099549541984, 'Locarno', '/assets/waypointImages/LagoMaggiore.jpeg'),
       ('Monte Tamaro',
        'Offre una vista panoramica sul Lago Maggiore e sulle Alpi. È possibile raggiungere la cima con la funivia.',
        46.103889, 8.866111, 'Rivera', '/assets/waypointImages/MonteTamaro.jpeg'),
       ('Monte Generoso',
        'Una montagna con una vista panoramica sulla Svizzera e l''Italia. È possibile raggiungere la cima con un treno a cremagliera.',
        45.9069, 9.0131, 'Mendrisio', '/assets/waypointImages/MonteGeneroso.jpeg'),
       ('Parco Ciani', 'Un parco sul lungolago di Lugano con giardini, fontane e statue.', 46.00491237473893,
        8.958478618474716, 'Lugano', '/assets/waypointImages/ParcoCiani.jpeg'),
       ('Chiesa di Santa Maria degli Angeli',
        'Una chiesa situata a Lugano, nota per gli affreschi di Bernardino Luini.', 46.00009599026546,
        8.949277398721993, 'Lugano', '/assets/waypointImages/ChiesaDiSantaMariaDegliAngeli.jpeg'),
       ('Valle Verzasca',
        'Una valle con un fiume dall''acqua cristallina e un ponte di pietra famoso per i suoi tuffi.', 46.258889,
        8.838056, 'Lavertezzo', '/assets/waypointImages/ValleVerzasca.jpeg'),
       ('Monte Brè', 'Una montagna sopra Lugano con una vista panoramica sulla città e il lago.', 46.009639, 8.986333,
        'Lugano', '/assets/waypointImages/MonteBre.jpeg'),
       ('Santuario della Madonna del Sasso',
        'Un santuario situato sopra Locarno con una vista panoramica sul Lago Maggiore.', 46.175205973123575,
        8.793768400791254, 'Orselina', '/assets/waypointImages/SantuarioDellaMadonnaDelSasso.jpeg'),
       ('Sasso San Gottardo', 'Una fortezza costruita nel 1882 e situata sotto la cima del Passo San Gottardo.',
        46.55878007551914, 8.566391541845356, 'Airolo', '/assets/waypointImages/SassoSanGottardo.jpeg'),
       ('Museo d''arte della Svizzera italiana', 'Un museo d''arte moderna e contemporanea situato a Lugano.',
        45.999271440407014, 8.948773891467306, 'Lugano', '/assets/waypointImages/MuseoDarteDellaSvizzeraItaliana.jpeg');

insert into User (username, password)
values ('mario.rossi', 'password');
insert into User (username, password)
values ('luca.bianchi', 'password');
insert into User (username, password)
values ('giovanni.verdi', 'password');
insert into User (username, password, admin)
values ('Joe', 'admin', true);
insert into User (username, password, admin)
values ('admin', 'admin', true);