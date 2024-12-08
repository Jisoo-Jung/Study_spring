
create table tbl_member(
    id bigint unsigned auto_increment primary key,
    member_name varchar(255) not null,
    member_email varchar(255) not null,
    profile_img_url varchar(255),
    created_date datetime default current_timestamp,
    updated_date datetime default current_timestamp
);

create table tbl_member_profile (
    id bigint unsigned auto_increment primary key,
    profile_name varchar(255) not null,
    profile_gender varchar(255) default 0,
    profile_age varchar(255) default 0,
    profile_email varchar(255) not null,
    profile_phone varchar(255) not null,
    profile_etc varchar(255),
    member_id bigint unsigned not null,
    updated_date datetime default current_timestamp,
    constraint fk_member_profile_member foreign key (member_id)
        references tbl_member(id)
);

# 여쭤본 후 바꾸기
create table tbl_file (
    id bigint unsigned auto_increment primary key,
    file_size varchar(255) not null,
    file_type varchar(255) not null, -- 영상, 사진, 썸네일 등
    file_path varchar(255) not null,
    file_content varchar(255),
    created_date datetime default current_timestamp,
    updated_date datetime default current_timestamp
);

create table tbl_post (
    id bigint unsigned auto_increment primary key,
    post_title varchar(255) not null,
    post_content varchar(255) not null,
    post_type varchar(255) not null, -- 영상, 글, 문의사항, 공지사항인지 순서대로 0,1,2,3
    member_id bigint unsigned not null,
    created_date datetime default current_timestamp,
    updated_date datetime default current_timestamp,
    constraint fk_post_member foreign key (member_id)
    references tbl_member(id)
);

create table tbl_post_file (
    id bigint unsigned auto_increment primary key,
    post_id bigint unsigned not null,
    constraint fk_post_file_file foreign key (id)
        references tbl_file(id),
    constraint fk_post_file_post foreign key (post_id)
        references tbl_post(id)
);

create table tbl_admin (
    id bigint unsigned auto_increment primary key,
    admin_verify_code int not null
);

create table tbl_notice (
    id bigint unsigned auto_increment primary key,
    constraint fk_notice_post foreign key (id)
    references tbl_post(id)
);

create table tbl_inquiry (
    id bigint unsigned auto_increment primary key,
    constraint fk_inquiry_post foreign key (id)
    references tbl_post(id)
);

create table tbl_admin_answer (
    id bigint unsigned auto_increment primary key,
    admin_answer_content varchar(255) not null,
    inquiry_id bigint unsigned not null,
    created_date datetime default current_timestamp,
    constraint fk_admin_answer_inquiry foreign key (inquiry_id)
    references tbl_inquiry(id)
);

create table tbl_genre (
    id bigint unsigned auto_increment primary key,
    genre_type varchar(255) not null
);

create table tbl_work (
    id bigint unsigned auto_increment primary key,
    work_price varchar(255) not null,
    genre_id bigint unsigned not null,
    read_count int default 0,
    constraint fk_work_post foreign key (id)
    references tbl_post(id),
    constraint fk_work_genre foreign key (genre_id)
    references tbl_genre(id)
);

create table tbl_work_report (
    id bigint unsigned auto_increment primary key,
    report_contents varchar(255) not null,
    work_id bigint unsigned not null,
    created_date datetime default current_timestamp,
    constraint fk_work_report_funding foreign key (work_id)
    references tbl_work(id)
);

create table tbl_reply (
    id bigint unsigned auto_increment primary key,
    reply_content varchar(255) not null,
    member_id bigint unsigned not null,
    work_id bigint unsigned not null,
    created_date datetime default current_timestamp,
    star int not null,
    constraint fk_reply_member foreign key (member_id)
    references tbl_member(id),
    constraint fk_reply_work foreign key (work_id)
    references tbl_work(id)
);

create table tbl_reply_report (
    id bigint unsigned auto_increment primary key,
    report_contents varchar(255) not null,
    reply_id bigint unsigned not null,
    created_date datetime default current_timestamp,
    constraint fk_reply_report_reply foreign key (reply_id)
    references tbl_reply(id)
);

create table tbl_funding (
    id bigint unsigned auto_increment primary key,
    investor_number int not null,
    target_price int not null,
    converge_price int not null,
    genre_id bigint unsigned not null,
    funding_status varchar(255) default 0,
    constraint fk_funding_post foreign key (id)
    references tbl_post(id),
    constraint fk_funding_genre foreign key (genre_id)
    references tbl_genre(id)
);

create table tbl_funding_report (
    id bigint unsigned auto_increment primary key,
    report_contents varchar(255) not null,
    funding_id bigint unsigned not null,
    created_date datetime default current_timestamp,
    constraint fk_funding_report_funding foreign key (funding_id)
    references tbl_funding(id)
);

create table tbl_funding_product (
    id bigint unsigned auto_increment primary key,
    product_name varchar(255) not null,
    product_price varchar(255) not null,
    product_amount varchar(255) not null,
    funding_id bigint unsigned not null,
    constraint fk_funding_product_funding foreign key (funding_id)
    references tbl_funding(id)
);

create table tbl_audition (
    id bigint unsigned auto_increment primary key,
    audition_field int not null,
    audition_career varchar(255),
    expected_amount varchar(255),
    service_start_date varchar(255) not null,
    audition_deadline varchar(255) not null,
    audition_personnel varchar(255) not null,
    audition_location varchar(255) not null,
    audition_background varchar(255),
    audition_category varchar(255),
    audition_status varchar(255) default 0,
    constraint fk_audition_post foreign key (id)
    references tbl_post(id)
);

create table tbl_audition_report (
    id bigint unsigned auto_increment primary key,
    report_contents varchar(255) not null,
    audition_id bigint unsigned not null,
    created_date datetime default current_timestamp,
    constraint fk_audition_report_audition foreign key (audition_id)
    references tbl_audition(id)
);

create table tbl_audition_application (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    apply_etc varchar(255) not null,
    audition_id bigint unsigned not null,
    created_date datetime default current_timestamp,
    confirm_status varchar(255) default 0,
    constraint fk_audition_application_member foreign key (member_id)
    references tbl_member(id),
    constraint fk_audition_application_audition foreign key (audition_id)
    references tbl_audition(id)
);

create table tbl_audition_application_file (
    id bigint unsigned auto_increment primary key,
    audition_application_id bigint unsigned not null,
    constraint fk_audition_application_file_file foreign key (id)
    references tbl_file(id),
    constraint fk_audition_application_file_audition_application foreign key (audition_application_id)
    references tbl_audition_application (id)
);

##추가 테이블
create table tbl_buy_work (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    work_id bigint unsigned not null,
    work_send_status varchar(255) default 0,
    constraint fk_buy_work_member foreign key (member_id)
    references tbl_member (id),
    constraint fk_buy_work_work foreign key (work_id)
    references tbl_work (id)
);
create table tbl_buy_funding_product (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    funding_product_id bigint unsigned not null,
    funding_send_status varchar(255) default 0,
    constraint fk_buy_funding_product_member foreign key (member_id)
    references tbl_member (id),
    constraint fk_buy_funding_product_funding_product foreign key (funding_product_id)
    references tbl_funding_product (id)
);


create table tbl_work_notification (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    work_id bigint unsigned not null,
    constraint fk_buy_work_notification_member foreign key (member_id)
    references tbl_member (id),
    constraint fk_work_notification_buy_work foreign key (work_id)
    references tbl_work (id)
);

create table tbl_reply_notification (
    id bigint unsigned auto_increment primary key,
    reply_id bigint unsigned not null,
    constraint fk_reply_notification_reply foreign key (reply_id)
    references tbl_reply (id)
);
create table tbl_funding_product_notification (
    id bigint unsigned auto_increment primary key,
    member_id bigint unsigned not null,
    funding_product_id bigint unsigned not null,
    constraint fk_buy_funding_product_notification_member foreign key (member_id)
    references tbl_member (id),
    constraint fk_funding_product_notification_funding_product foreign key (funding_product_id)
    references tbl_funding_product (id)
);
create table tbl_apply_audition_notification (
    id bigint unsigned auto_increment primary key,
    audition_application_id bigint unsigned not null,
    constraint fk_apply_audition_notification_audition_application foreign key (audition_application_id)
    references tbl_audition_application (id)
);
