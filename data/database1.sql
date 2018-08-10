create user meetingmanager identified by aaaa;

--赋予权限
grant connect,resource to meetingmanager;

/*
创建会议室表
        会议室编号
        会议室门牌号
        会议室名称
        会议室最多容纳人数
        当前状态
        备注

*/
--创建序列
create sequence seq_meetroom
   increment by 2
   start with 11
   nocycle
   nomaxvalue
  
  select * from meet_room;
  select seq_meetroom.currval from dual;
   
--创建表
create table meet_room(
  r_id number(20) primary key,
  r_roomid varchar2(30) not null,
  r_name varchar2(30) not null,
  r_maxsize number(10) not null,
  r_nowstatus number(6) default 0,
  r_remark varchar2(80)
);

--插入数据
insert into meet_room values(seq_meetroom.nextval,'二22室','大会议室',150,1,'干净明亮');
/*
   会议
        会议编号
        会议名称
        会议预计参加人数database1.sql

        会议预计开始时间
        会议预计结束时间
        会议预定者
        会议室
        会议说明
        参会人员--用三方表关联

*/
create sequence seq_meeting
  increment by 2
  start with 11
  nocycle
  nomaxvalue
  --创建表
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
创建第三方表
  会议与参会人关联的表
      编号
      会议编号
      参会人员的编号
*/
--创建序列
 create sequence seq_meetingandemp
    increment by 2
    start with 11
    nocycle
    nomaxvalue
--创建表
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