-- 학생 테이블 저장
-- 이름, 나이, 주소
create table student3_db
(
    s_no   number(2) primary key,
    s_name varchar2(10 char) not null,
    s_age  number(3)         not null,
    s_add  varchar(30 char)  not null
);

create sequence student3_db_seq;

--테스트 데이터 1~2개
insert into student3_db
values (student_db_seq.nextval, 'st1', 10, 'daejeon');
insert into student3_db
values (student_db_seq.nextval, 'dh', 29, 'daejeon dong-gu');

--조회

select *from student3_db;

select * from student3_db where s_name like ??? '%s%';
