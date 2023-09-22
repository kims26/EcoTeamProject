create sequence seq_project_mem_idx

create table project_member
(
	mem_idx     int,                       	--일련(회원)번호
	mem_name    varchar2(100) not null,    	--이름
	mem_id      varchar2(100),            	--아이디
	mem_pwd     varchar2(100) not null,    	--비밀번호
	mem_ip      varchar2(100) not null,   	--아이피
	mem_regdate date default sysdate    	--가입일자 기본설정은 데이터베이스에 저장된 시간
);

--기본키
alter table project_member
	add constraint pk_project_mem_idx primary key(mem_idx);
	
--unique 제약
alter table project_member
	add constraint unique_project_mem_id unique(mem_id);  
	
select * from project_member where mem_id = 'qwer'

insert into PROJECT values(seq_project_mem_idx.nextVal,'이한빈','qwer','1234','192.168.0.5',sysdate)
insert into PROJECT_member values(seq_project_mem_idx.nextVal,'이름','ooo','1234','192.168.0.5',sysdate)


