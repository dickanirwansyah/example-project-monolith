create table in_users(
 id int auto_increment,
 name varchar(45) not null,
 username varchar(45) not null unique,
 password varchar(45) not null,
 picture varchar(255) null,
 status boolean not null,
 created_at date not null,
 updated_at date not null,
 constraint pk_in_users_id primary key(id)
);

create table in_role(
 id varchar(45) unique primary key,
 name varchar(45)
);

create table in_users_role(
 id int auto_increment primary key,
 id_users int,
 id_role varchar(45),
 created_at date not null,
 updated_at date not null,
 constraint fk_in_users_id foreign key(id_users) references in_users(id),
 constraint fk_in_role_id foreign key(id_role) references in_role(id)
);

create table in_transaction(
    id int auto_increment,
    created_at date not null,
    updated_at date not null,
    total_price double not null,
    users_id int not null,
);

create table in_category(
    id int auto_increment,
    name varchar(45) not null,
    created_at date not null,
    updated_at date not null,
    constraint pk_in_category primary key (id)
);

insert into in_category(name, created_at, updated_at) values
('batu bara', curdate(), curdate()),
('emas', curdate(), curdate()),
('berlian', curdate(), curdate()),
('intan', curdate(), curdate());

create table in_product(
    id varchar(45) not null unique,
    name varchar(45) not null,
    stock int,
    price Double,
    available boolean not null,
    image longblob null,
    category_id int not null,
    seen_product int,
    constraint pk_in_product_id primary key (id),
    constraint fk_in_category_id foreign key (category_id) references in_category(id)
);

