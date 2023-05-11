use car_store12;
drop table if exists car;
drop table if exists car_seq;
drop table if exists client_order;
drop table if exists client_order_selected_cars;
drop table if exists color;
drop table if exists engine;
drop table if exists model_option;
drop table if exists transmission;
drop table if exists user;
create table car
(
    id              integer not null,
    availability    bit,
    model           varchar(255),
    price           decimal(38, 2),
    color_id        integer not null,
    engine_id       integer not null,
    model_option_id integer not null,
    transmission_id integer not null,
    order_id        integer,
    primary key (id)
) engine = MyISAM;
create table car_seq
(
    next_val bigint
) engine = MyISAM;
insert into car_seq
values (1);
create table client_order
(
    id               integer not null auto_increment,
    status           varchar(255),
    time_of_creation datetime,
    time_of_update   datetime,
    user_id          integer,
    primary key (id)
) engine = MyISAM;
create table client_order_selected_cars
(
    client_order_id  integer not null,
    selected_cars_id integer not null,
    primary key (client_order_id, selected_cars_id)
) engine = MyISAM;
create table color
(
    id         integer not null auto_increment,
    color_name varchar(255),
    primary key (id)
) engine = MyISAM;
create table engine
(
    id     integer not null auto_increment,
    type   varchar(255),
    volume float(53),
    primary key (id)
) engine = MyISAM;
create table model_option
(
    id                     integer not null auto_increment,
    cruise_control         bit,
    fog_light              bit,
    heated_seat            bit,
    option_name            varchar(255),
    salon                  varchar(255),
    steering_wheel_control bit,
    primary key (id)
) engine = MyISAM;
create table transmission
(
    id   integer not null auto_increment,
    type varchar(255),
    primary key (id)
) engine = MyISAM;
create table user
(
    id              integer not null auto_increment,
    cell_phone      varchar(255),
    email           varchar(255),
    login           varchar(255),
    name            varchar(255),
    password        varchar(255),
    role            varchar(255),
    surname         varchar(255),
    client_order_id integer,
    primary key (id)
) engine = MyISAM;
alter table client_order_selected_cars
    add constraint client_order_fk_selected_cars unique (selected_cars_id);
alter table car
    add constraint car_fk_color foreign key (color_id) references color (id);
alter table car
    add constraint car_fk_engine foreign key (engine_id) references engine (id);
alter table car
    add constraint car_fk_model_option foreign key (model_option_id) references model_option (id);
alter table car
    add constraint car_fk_transmission foreign key (transmission_id) references transmission (id);
alter table car
    add constraint car_fk_client_order foreign key (order_id) references client_order (id);
alter table client_order
    add constraint client_order_fk_user foreign key (user_id) references user (id);
alter table client_order_selected_cars
    add constraint client_order_selected_cars_fk_selected_cars foreign key (selected_cars_id) references car (id);
alter table client_order_selected_cars
    add constraint selected_cars_fk_client_order foreign key (client_order_id) references client_order (id);
alter table user
    add constraint user_1fk_client_order foreign key (client_order_id) references client_order (id);