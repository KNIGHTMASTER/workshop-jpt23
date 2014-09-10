alter table account drop foreign key FKB9D38A2D4759D344;
alter table account drop foreign key FKB9D38A2DEE3DDFE4;
alter table cif drop foreign key FK180C0FB0E35CB;
alter table transactions drop foreign key FK74798955D440A385;
alter table transactions drop foreign key FK74798955FE84C55C;
alter table transactions drop foreign key FK74798955A1CE8769;
alter table user_role drop foreign key FK143BF46A7B765365;
alter table user_role drop foreign key FK143BF46A20A11745;
drop table if exists account;
drop table if exists app_user;
drop table if exists cif;
drop table if exists product;
drop table if exists role;
drop table if exists test;
drop table if exists transactions;
drop table if exists user_role;
create table account (id bigint not null auto_increment, number varchar(20) not null unique, balance double precision not null, fk_cif_id bigint, fk_product_id bigint, account_enable bit, primary key (id)) ENGINE=InnoDB;
create table app_user (id bigint not null auto_increment, version integer not null, username varchar(50) not null unique, password varchar(255) not null, first_name varchar(50) not null, last_name varchar(50) not null, address varchar(150), city varchar(50) not null, province varchar(100), country varchar(100), postal_code varchar(15) not null, email varchar(255) not null unique, phone_number varchar(255), website varchar(255), password_hint varchar(255), account_enabled char(1), account_expired char(1) not null, ktpNumber varchar(17) unique, account_locked char(1) not null, credentials_expired char(1) not null, primary key (id)) ENGINE=InnoDB;
create table cif (id bigint not null auto_increment, number varchar(20) not null unique, foundSource varchar(1000) not null, fk_user_id bigint, primary key (id)) ENGINE=InnoDB;
create table product (id bigint not null auto_increment, name varchar(50) not null, price double precision not null, remark varchar(500) not null, productEnable bit, primary key (id)) ENGINE=InnoDB;
create table role (id bigint not null auto_increment, name varchar(20), description varchar(64), primary key (id)) ENGINE=InnoDB;
create table test (id bigint not null auto_increment, name varchar(20) not null unique, primary key (id)) ENGINE=InnoDB;
create table transactions (id bigint not null auto_increment, accountSource bigint, fk_accountdestination_id bigint, date datetime, status bit, amount double precision, transactionType varchar(100), fk_accountsource_id bigint, primary key (id)) ENGINE=InnoDB;
create table user_role (user_id bigint not null, role_id bigint not null, primary key (user_id, role_id)) ENGINE=InnoDB;
alter table account add index FKB9D38A2D4759D344 (fk_cif_id), add constraint FKB9D38A2D4759D344 foreign key (fk_cif_id) references cif (id);
alter table account add index FKB9D38A2DEE3DDFE4 (fk_product_id), add constraint FKB9D38A2DEE3DDFE4 foreign key (fk_product_id) references product (id);
alter table cif add index FK180C0FB0E35CB (fk_user_id), add constraint FK180C0FB0E35CB foreign key (fk_user_id) references app_user (id);
alter table transactions add index FK74798955D440A385 (accountSource), add constraint FK74798955D440A385 foreign key (accountSource) references account (id);
alter table transactions add index FK74798955FE84C55C (fk_accountdestination_id), add constraint FK74798955FE84C55C foreign key (fk_accountdestination_id) references account (id);
alter table transactions add index FK74798955A1CE8769 (fk_accountsource_id), add constraint FK74798955A1CE8769 foreign key (fk_accountsource_id) references account (id);
alter table user_role add index FK143BF46A7B765365 (role_id), add constraint FK143BF46A7B765365 foreign key (role_id) references role (id);
alter table user_role add index FK143BF46A20A11745 (user_id), add constraint FK143BF46A20A11745 foreign key (user_id) references app_user (id);