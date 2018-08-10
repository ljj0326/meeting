create user meetingmanager identified by aaaa;

--����Ȩ��
grant connect,resource to meetingmanager;

/*
���������ұ�
        �����ұ��
        ���������ƺ�
        ����������
        �����������������
        ��ǰ״̬
        ��ע

*/
--��������
create sequence seq_meetroom
   increment by 2
   start with 11
   nocycle
   nomaxvalue
  
  select * from meet_room;
  select seq_meetroom.currval from dual;
   
--������
create table meet_room(
  r_id number(20) primary key,
  r_roomid varchar2(30) not null,
  r_name varchar2(30) not null,
  r_maxsize number(10) not null,
  r_nowstatus number(6) default 0,
  r_remark varchar2(80)
);

--��������
insert into meet_room values(seq_meetroom.nextval,'��22��','�������',150,1,'�ɾ�����');
/*
   ����
        ������
        ��������
        ����Ԥ�Ʋμ�����database1.sql

        ����Ԥ�ƿ�ʼʱ��
        ����Ԥ�ƽ���ʱ��
        ����Ԥ����
        ������
        ����˵��
        �λ���Ա--�����������

*/
create sequence seq_meeting
  increment by 2
  start with 11
  nocycle
  nomaxvalue
  --������
  create table meet_meeting(
     m_id number(20) primary key,
     m_name varchar2(30) not null,
     m_precount number(20) default 0,
     m_prestarttime timestamp ,
     m_preendtime timestamp,
     m_prepid number(20) not null,
     m_roomid number(20) not null,
     m_discription varchar2(80),
     constraint meeting_emp foreign key(m_prepid) references meet_emp(u_id),
     constraint meeting_room foreign key(m_roomid) references meet_room(r_id)
  );
  select * from meet_meeting
/*
������������
  ������λ��˹����ı�
      ���
      ������
      �λ���Ա�ı��
*/
--��������
 create sequence seq_meetingandemp
    increment by 2
    start with 11
    nocycle
    nomaxvalue
--������
create table meet_meeting_emp(
   me_id number(20) primary key,
   me_meetingid number(20),
   me_empid number(20),
    constraint me_empid foreign key(me_empid) references meet_emp(u_id),
     constraint me_meetingid foreign key(me_meetingid) references meet_meeting(m_id)
);

commit

select * from meet_meeting_emp;
delete from meet_meeting_emp
delete from meet_meeting