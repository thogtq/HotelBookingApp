/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     5/27/2020 11:57:47 PM                        */
/*==============================================================*/


drop table if exists CO_SO_PHONG;

drop table if exists CT_PHONG;

drop table if exists DANH_GIA;

drop table if exists DAT_PHONG;

drop table if exists KHACH_SAN;

drop table if exists NGUOI_DUNG;

drop table if exists PHONG;

drop table if exists THANH_PHO;

/*==============================================================*/
/* Table: CO_SO_PHONG                                           */
/*==============================================================*/
create table CO_SO_PHONG
(
   TEN_CO_SO            varchar(256),
   MA_CO_SO             varchar(12) not null,
   primary key (MA_CO_SO)
);

/*==============================================================*/
/* Table: CT_PHONG                                              */
/*==============================================================*/
create table CT_PHONG
(
   MA_PHONG             varchar(12) not null,
   MA_CO_SO             varchar(12) not null,
   DON_VI               char(12),
   primary key (MA_PHONG, MA_CO_SO)
);

/*==============================================================*/
/* Table: DANH_GIA                                              */
/*==============================================================*/
create table DANH_GIA
(
   MA_NGUOI_DUNG        varchar(12) not null,
   MA_KHACH_SAN         varchar(12) not null,
   SO_DIEM              float(3),
   NOI_DUNG             varchar(128),
   primary key (MA_NGUOI_DUNG, MA_KHACH_SAN)
);

/*==============================================================*/
/* Table: DAT_PHONG                                             */
/*==============================================================*/
create table DAT_PHONG
(
   NGAY_DAT             datetime,
   NGAY_DEN             date,
   NGAY_DI              date,
   TONG_TIEN            int,
   TINH_TRANG           varchar(24),
   IS_REVIEW            int,
   MA_DAT_PHONG         varchar(12) not null,
   MA_NGUOI_DUNG        varchar(12),
   MA_PHONG             varchar(12),
   primary key (MA_DAT_PHONG)
);

/*==============================================================*/
/* Table: KHACH_SAN                                             */
/*==============================================================*/
create table KHACH_SAN
(
   MA_KHACH_SAN         varchar(12) not null,
   MA_THANH_PHO         varchar(12),
   TEN_KS               varchar(64),
   DIA_CHI              varchar(256),
   SDT                  varchar(14),
   MO_TA                text,
   GHI_CHU              text,
   SO_SAO               int,
   DIEM_DANH_GIA        float(3),
   CHINH_SACH           text,
   primary key (MA_KHACH_SAN)
);

/*==============================================================*/
/* Table: NGUOI_DUNG                                            */
/*==============================================================*/
create table NGUOI_DUNG
(
   USERNAME             varchar(24),
   PASSWORD             varchar(256),
   HO_TEN               varchar(64),
   SDT                  varchar(14),
   DIA_CHI              varchar(256),
   NGAY_SINH            date,
   CMND                 varchar(14),
   EMAIL                varchar(256),
   MA_NGUOI_DUNG        varchar(12) not null,
   TOKEN				varchar(128) unique,
   primary key (MA_NGUOI_DUNG)
);

/*==============================================================*/
/* Table: PHONG                                                 */
/*==============================================================*/
create table PHONG
(
   TEN_PHONG            varchar(64),
   GIA_PHONG            int,
   DIEN_TICH            float(3),
   SUC_CHUA             int,
   LOAI_GIUONG          varchar(64),
   MA_PHONG             varchar(12) not null,
   MA_KHACH_SAN         varchar(12),
   primary key (MA_PHONG)
);

/*==============================================================*/
/* Table: THANH_PHO                                             */
/*==============================================================*/
create table THANH_PHO
(
   TEN                  char(64),
   MA_THANH_PHO         varchar(12) not null,
   primary key (MA_THANH_PHO)
);

alter table CT_PHONG add constraint FK_CT_PHONG foreign key (MA_CO_SO)
      references CO_SO_PHONG (MA_CO_SO);

alter table CT_PHONG add constraint FK_CT_PHONG2 foreign key (MA_PHONG)
      references PHONG (MA_PHONG);

alter table DANH_GIA add constraint FK_DANH_GIA foreign key (MA_KHACH_SAN)
      references KHACH_SAN (MA_KHACH_SAN);

alter table DANH_GIA add constraint FK_DANH_GIA2 foreign key (MA_NGUOI_DUNG)
      references NGUOI_DUNG (MA_NGUOI_DUNG);

alter table DAT_PHONG add constraint FK_DAT foreign key (MA_NGUOI_DUNG)
      references NGUOI_DUNG (MA_NGUOI_DUNG);

alter table DAT_PHONG add constraint FK_DUOC_DAT foreign key (MA_PHONG)
      references PHONG (MA_PHONG);

alter table KHACH_SAN add constraint FK_CO foreign key (MA_THANH_PHO)
      references THANH_PHO (MA_THANH_PHO);

alter table PHONG add constraint FK_GOM foreign key (MA_KHACH_SAN)
      references KHACH_SAN (MA_KHACH_SAN);

