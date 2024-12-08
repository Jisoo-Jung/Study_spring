create table tbl_reply(
    id bigint unsigned auto_increment primary key,
    reply_content varchar(255) not null,
    member_id bigint unsigned not null,
    post_id bigint unsigned not null,
    created_date datetime default current_timestamp,
    updated_date datetime default current_timestamp,
    constraint fk_reply_member foreign key(member_id)
        references tbl_member(id),
    constraint fk_reply_post foreign key(post_id)
        references tbl_post(id)
);

select count(*) from tbl_reply;

insert into tbl_reply (reply_content, member_id, post_id)
(select reply_content, member_id, post_id from tbl_reply);

select * from tbl_reply
order by id desc;

delete from tbl_reply
where id > 20;
