IF EXISTS(Select * From Sysobjects Where
Name='putao_character')  --��ѯ�����Ƿ����
alter table putao_character drop constraint if exists FK_StudentNo;
IF EXISTS(Select * From Sysobjects Where Name='putao_character')  --��ѯ�����Ƿ����
alter table  putao_character  drop constraint if exists FK_StudentNo_delete;
IF EXISTS(Select * From Sysobjects Where Name='putao')  --��ѯ�����Ƿ����
alter table putao drop constraint if exists tpid;

drop table if exists putao;
drop table if exists putao_character;
drop table if exists users;
--     ɾ���洢����
DROP PROCEDURE if exists loginUser;
drop procedure  if exists selectByPhone;

drop trigger if exists insert_character;
drop trigger if exists insert_putao;
 create table putao(
                      id int IDENTITY(1,1),
                     pid int not null ,
                       name varchar(20) not null,
                       project varchar(50) not null ,
                       constraint tpid primary key (pid)
 );


 create table putao_character(
                                id int identity(1,1),
                                 pid int not null,
                                 color varchar(20)  null,
                                 froms varchar(20)  null,
                                 status varchar(50)  null
 );
 create table users(
                       id int identity(1,1),
                      username varchar(20) not null,
                      password varchar(20) not null,
                      name varchar(20) not null,
                      phone varchar(20) not null,
                     constraint tpid2 primary key (id)
 );
 insert into putao(pid,name,project) values(1,'������','�ཽˮ');
 insert into putao(pid,name,project) values(2,'������','ע��ɹ̫��');



insert into putao_character(pid,color,froms,status) values(1,'��ɫ','����','������');
insert into putao_character(pid,color,froms,status) values(2,'��ɫ','����','ζ����');

insert into users(username,password,name,phone) values('admin','123','����','15615445633');
insert into users(username,password,name,phone) values('123','123','����','12545874366');

--��������
alter table putao_character add constraint FK_StudentNo foreign key (pid) references putao (pid) ON UPDATE CASCADE;

--����ɾ��
alter table putao_character add constraint FK_StudentNo_delete foreign key (pid) references putao (pid) ON DELETE  CASCADE;


--������¼�Ĵ洢���̣�;
        create procedure loginUser
        @Username varchar(20),
        @Password varchar(20)
        AS
        select * from users where username=@Username and password=@Password;
--����ͨ���ֻ��Ų��ҵĴ洢����
        create procedure selectByPhone
        @phone varchar(20)
        As
            select * from users where phone=@phone;


--����insert������
create trigger insert_character on putao_character
    for insert
    AS
    declare @pid int
select @pid =putao.pid from putao,inserted where putao.pid=inserted.pid
IF @pid<>''
    print('������Ϣ�ɹ�')
ELSE
    BEGIN
        PRINT('��������Ϣ�����ڣ����������Ƿ���ȷ')
        ROLLBACK
END;
--����������ʵ�ּ������
create trigger insert_putao
    on putao
    for insert
    as
begin
    declare @a varchar(20)
    select @a = pid from inserted
    insert into putao_character(pid) values(@a)
end;
