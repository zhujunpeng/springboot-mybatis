DROP TABLE IF EXISTS t_user;
create table t_user (id int AUTO_INCREMENT primary key, username varchar(40), name varchar(20), age int(3), balance decimal(10,2),version int(3))
ENGINE=InnoDB DEFAULT CHARSET=utf8;