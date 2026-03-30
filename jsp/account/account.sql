  create table login_test(
     l_id varchar2(30 char) primary key ,
     l_pw varchar2(30 char) not null ,
     l_name varchar2(30 char) not null
);

  insert into login_test values ('kdh1004','kdh1004', 'kdh');
  insert into login_test values ('aa','aa', 'AAA');

  select * from login_test;