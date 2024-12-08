use test;

create table tbl_member(
       id bigint unsigned auto_increment primary key,
       member_name varchar(255) not null,
       member_age smallint default 0,
       created_date datetime default current_timestamp,
       updated_date datetime default current_timestamp
);

select * from tbl_member;
insert into tbl_member(member_name)
values ('한동석');

create table tbl_post(
     id bigint unsigned auto_increment primary key,
     post_title varchar(255) not null,
     post_content varchar(255) not null,
     member_id bigint unsigned not null,
     constraint fk_post_member foreign key (member_id)
         references tbl_member(id)
);

alter table tbl_post add (created_date datetime default current_timestamp);
alter table tbl_post add (updated_date datetime default current_timestamp);

select count(*) from tbl_post;
select * from tbl_member;

insert into tbl_post(post_title, post_content, member_id)
values ('테스트 제목1', '테스트 내용1', 1);

insert into tbl_post(post_title, post_content, member_id)
    (select post_title, post_content, member_id from tbl_post);

select * from tbl_post
order by id desc
limit 0, 10;

select concat(member_name, '님의 나이는 ', member_age) from tbl_member;

# where post_title like concat('%', #{keyword}, '%');

select * from tbl_member m join tbl_post p on m.id = p.member_id;

/*
from
join
on
where
group by
having
select
order by
limit
*/









