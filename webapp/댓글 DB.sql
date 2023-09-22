create sequence  seq_project_visit_idx

--테이블 생성
create table project_visit
(
	visit_idx        int,               				--일련번호
	visit_content    varchar(2000) not null,    	 	--내용
	visit_ip         varchar(100) not null,           --작성자의 ip
	regdate date   default sysdate,		      		--작성일자  
	mem_idx      int                                	--작성자
)

--기본키
alter table project_visit
  add constraint pk_project_visit_p_id primary key(visit_idx);
  
--참조키
alter table project_visit
  add constraint  fk_project_visit_mem_idx  foreign key(mem_idx) references project_member(mem_idx)

insert into project_visit values(seq_project_visit_idx.nextVal,'첫번째 글입니다','192.168.0.25',sysdate,1)
insert into project_visit values(seq_project_visit_idx.nextVal,'세번째 글입니다','192.168.0.25',sysdate,5)
insert into project_visit values(seq_project_visit_idx.nextVal,'아 배고프다','123.456.789.0',sysdate,10)

delete from project_visit where visit_idx = 45

select * from PROJECT_MEMBER

select * from project_visit