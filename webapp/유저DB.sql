create sequence seq_project_mem_idx

create table project_member
(
	mem_idx     int,                       	--�Ϸ�(ȸ��)��ȣ
	mem_name    varchar2(100) not null,    	--�̸�
	mem_id      varchar2(100),            	--���̵�
	mem_pwd     varchar2(100) not null,    	--��й�ȣ
	mem_ip      varchar2(100) not null,   	--������
	mem_regdate date default sysdate    	--�������� �⺻������ �����ͺ��̽��� ����� �ð�
);

--�⺻Ű
alter table project_member
	add constraint pk_project_mem_idx primary key(mem_idx);
	
--unique ����
alter table project_member
	add constraint unique_project_mem_id unique(mem_id);  
	
select * from project_member where mem_id = 'qwer'

insert into PROJECT values(seq_project_mem_idx.nextVal,'���Ѻ�','qwer','1234','192.168.0.5',sysdate)
insert into PROJECT_member values(seq_project_mem_idx.nextVal,'�̸�','ooo','1234','192.168.0.5',sysdate)


