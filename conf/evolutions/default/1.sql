# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table event (
  id                            integer auto_increment not null,
  manager_id                    integer,
  event_name                    varchar(255),
  cost                          double,
  donations_total               double,
  event_date_time               datetime(6),
  public_private                tinyint(1) default 0,
  venue                         varchar(255),
  capacity                      integer,
  constraint pk_event primary key (id)
);

create table user (
  id                            integer auto_increment not null,
  email                         varchar(255),
  facebook                      varchar(255),
  name                          varchar(255),
  donations_to_date             double,
  privilege                     integer,
  phone_number                  varchar(255),
  password                      varchar(255),
  dietary_requirements          varchar(255),
  disability_access             tinyint(1) default 0,
  constraint pk_user primary key (id)
);


# --- !Downs

drop table if exists event;

drop table if exists user;

