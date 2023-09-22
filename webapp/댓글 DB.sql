create sequence  seq_project_visit_idx

--���̺� ����
create table project_visit
(
	visit_idx        int,               				--�Ϸù�ȣ
	visit_content    varchar(2000) not null,    	 	--����
	visit_ip         varchar(100) not null,           --�ۼ����� ip
	regdate date   default sysdate,		      		--�ۼ�����  
	mem_idx      int                                	--�ۼ���
)

--�⺻Ű
alter table project_visit
  add constraint pk_project_visit_p_id primary key(visit_idx);
  
--����Ű
alter table project_visit
  add constraint  fk_project_visit_mem_idx  foreign key(mem_idx) references project_member(mem_idx)

insert into project_visit values(seq_project_visit_idx.nextVal,'ù��° ���Դϴ�','192.168.0.25',sysdate,1)
insert into project_visit values(seq_project_visit_idx.nextVal,'����° ���Դϴ�','192.168.0.25',sysdate,5)
insert into project_visit values(seq_project_visit_idx.nextVal,'�� �������','123.456.789.0',sysdate,10)

delete from project_visit where visit_idx = 45

select * from PROJECT_MEMBER

select * from project_visit