create table movie_test(
    m_no number(3) primary key ,
    m_title varchar2(30 char) not null ,
    m_actor varchar2(30 char) not null ,
    m_img varchar2(200 char) not null ,
    m_story varchar2(500 char) not null
);

create sequence movie_test_seq;

insert into movie_test values (movie_test_seq.nextval, '매트릭스', '키아누', 'a.jpg', 'SF계 속 현란한 액션!');
insert into movie_test values (movie_test_seq.nextval, '인터스텔라', '매튜 맥커너히', 'b.jpg', '우주를 넘나드는 감동적인 SF');
insert into movie_test values (movie_test_seq.nextval, '인셉션', '레오나르도 디카프리오', 'c.jpg', '꿈 속의 꿈, 복잡한 스토리');
insert into movie_test values (movie_test_seq.nextval, '다크 나이트', '크리스찬 베일', 'd.jpg', '히어로 영화의 명작');
insert into movie_test values (movie_test_seq.nextval, '어벤져스', '로버트 다우니 주니어', 'e.jpg', '마블 히어로 총집합');
insert into movie_test values (movie_test_seq.nextval, '기생충', '송강호', 'f.jpg', '사회적 메시지를 담은 걸작');
insert into movie_test values (movie_test_seq.nextval, '올드보이', '최민식', 'g.jpg', '강렬한 복수극');
insert into movie_test values (movie_test_seq.nextval, '타이타닉', '레오나르도 디카프리오', 'h.jpg', '비극적인 사랑 이야기');
insert into movie_test values (movie_test_seq.nextval, '아바타', '샘 워싱턴', 'i.jpg', '환상적인 그래픽의 세계');
insert into movie_test values (movie_test_seq.nextval, '범죄도시', '마동석', 'j.jpg', '통쾌한 액션 범죄 영화');
insert into movie_test values (movie_test_seq.nextval, '라라랜드', '라이언 고슬링', 'k.jpg', '음악과 사랑의 이야기')

select * from movie_test;