
/*==============================================================*/
/* Table: f_album    专辑                                           */
/*==============================================================*/
create table f_album
(
   id                   varchar(40) not null,
   name                 varchar(40),
   author               varchar(40),
   teller               varchar(40),
   num                  varchar(40),
   content              varchar(40),
   createdate           datetime,
   grade                integer,
   primary key (id)
);

/*==============================================================*/
/* Table: f_article         文章                                */
/*==============================================================*/
create table f_article
(
   id                   varchar(40) not null,
   title                varchar(40),
   createdate           datetime,
   type					varchar(10),
   href					varchar(100),
   masterid             varchar(40),
   primary key (id)
);

/*==============================================================*/
/* Table: f_chapter      章节                                       */
/*==============================================================*/
create table f_chapter
(
   id                   varchar(40) not null,
   oldname              varchar(100),
   newname              varchar(100),
   filepath             varchar(100),
   filesize             varchar(20),
   contenttype          varchar(40),
   albumid              varchar(40),
   primary key (id)
);

/*==============================================================*/
/* Table: f_counter     计数器                                        */
/*==============================================================*/
create table f_counter
(
   id                   varchar(40) not null,
   name                 varchar(40),
   num                  integer,
   createdate           datetime,
   lessonid             varchar(40),
   primary key (id)
);

/*==============================================================*/
/* Table: f_feedback             反馈                               */
/*==============================================================*/
create table f_feedback
(
   id                   varchar(40) not null,
   content              varchar(100),
   userid               varchar(40),
   primary key (id)
);

/*==============================================================*/
/* Table: f_lesson               功课                               */
/*==============================================================*/
create table f_lesson
(
   id                   varchar(40) not null,
   name                 varchar(40),
   type                 varchar(10),
   userid               varchar(40),
   primary key (id)
);

/*==============================================================*/
/* Table: f_manager           管理员                                  */
/*==============================================================*/
create table f_manager
(
   id                   varchar(40) not null,
   name                 varchar(40),
   password             varchar(40),
   salt                 varchar(6),
   phone                varchar(11),
   primary key (id)
);

/*==============================================================*/
/* Table: f_master            上师                                  */
/*==============================================================*/
create table f_master
(
   id                   varchar(40) not null,
   realname             varchar(40),
   nickname             varchar(40),
   imgpath              varchar(100),
   primary key (id)
);

/*==============================================================*/
/* Table: f_menu               菜单                                 */
/*==============================================================*/
create table f_menu
(
   id                   varchar(40) not null,
   name                 varchar(40),
   iconCls              varchar(40),
   href                 varchar(40),
   lev                  varchar(40),
   pid                  varchar(40),
   primary key (id)
);

/*==============================================================*/
/* Table: f_rotation          轮播图                                  */
/*==============================================================*/
create table f_rotation
(
   id                   varchar(40) not null,
   description          varchar(40),
   filepath             varchar(100),
   primary key (id)
);

/*==============================================================*/
/* Table: f_user          前台用户                                      */
/*==============================================================*/
create table f_user
(
   id                   varchar(40) not null,
   realname             varchar(40),
   nickname             varchar(40),
   sex                  varchar(2),
   description          varchar(100),
   password             varchar(40),
   salt                 varchar(6),
   phone                varchar(11),
   imgpath              varchar(100),
   masterid             varchar(40),
   provinceid           varchar(40),
   cityid               varchar(40),
   primary key (id)
);





