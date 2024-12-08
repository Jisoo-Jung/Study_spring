create table tbl_file(
    id bigint unsigned auto_increment primary key,
    file_name varchar(255) not null,
    file_path varchar(255) not null
);

select * from tbl_file;

alter table tbl_file add (post_id bigint unsigned not null);
alter table tbl_file add constraint fk_file_post foreign key(post_id)
    references tbl_post(id);
alter table tbl_file add (created_date datetime default current_timestamp);
alter table tbl_file add (updated_date datetime default current_timestamp);

select * from tbl_post;