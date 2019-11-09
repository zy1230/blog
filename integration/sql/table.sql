create table blog_user(
id varchar (32) primary key,
username varchar(32),
password varchar (36),
phone varchar(20),
birthday date,
update_time datetime,
del_flag char(1)
);
create table  blog(
id varchar (32) primary key,
title varchar (32),
author varchar (16),
publish_date date,
content text,
user_id varchar (32),
update_time datetime,
del_flag char(1)
);

create table  images(
id varchar (32) primary key,
url varchar(64),
update_time datetime,
del_flag char(1)
);
create table  blog_comment(
id varchar (32) primary key,
update_time datetime,
del_flag char(1),
content varchar (255),
user_id varchar (32),
blog_id varchar (32),
publish_date datetime
);


alter table `blog` change `id` `id` int (11) UNSIGNED NOT NULL AUTO_INCREMENT;