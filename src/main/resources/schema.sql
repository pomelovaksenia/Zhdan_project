create table if not exists userAccount(
    id bigint auto_increment primary key,
    name varchar(255) not null,
    shift int not null
);

create table if not exists questionPosts(
    id bigint auto_increment primary key,
    question_text varchar(255) not null,
    date_post date,
    userAccount_id bigint,
    foreign key (userAccount_id) references userAccount(id)
)