-- drop database if exists fruit_man;

/*==============================================================*/
/* Database: fruit_man                                          */
/*==============================================================*/
-- create database fruit_man;

use fruit_man;

/*==============================================================*/
/* Table: t_goods                                            */
/*==============================================================*/
create table t_goods
(
   id                   varchar(36) not null comment '主键id',
   user_id              varchar(36) comment '用户id',
   goods_name           varchar(200) comment '名称',
   goods_type           tinyint(2) comment '商品分类 0-水果，1-农产品',
   price                decimal(10,2) comment '商品价格',
   unit                 varchar(50) comment '商品单位 0-元/件，1-元/斤，2-元/吨，3-元/千克，4-元/车',
   goods_status         tinyint(2) comment '商品状态 0-审核中，1-待上架，2-上架，3-下架',
   googs_desc           varchar(2000) comment '商品简介',
   default_pic_url      varchar(200) comment '默认图片地址',
   position_name        varchar(500) comment '位置名称',
   position             varchar(100) comment '位置信息',
   open_date            DATETIME comment '上线时间',
   close_date           DATETIME comment '下线时间',
   close_reason         varchar(100) comment '下线原因',
   create_date          DATETIME not null comment '创建时间',
   update_date          DATETIME comment '修改时间',
   is_delete            tinyint(1) not null default 0 comment '删除标志 0-未删除，1-删除',
   data_from            tinyint(2) comment '数据来源 0 app android,1 app ios,2 web ',
   primary key (id)
)
ENGINE= InnoDB;

alter table t_goods comment '商品信息表';

/*==============================================================*/
/* Table: t_goods_inventory                                     */
/*==============================================================*/
create table t_goods_inventory
(
   id                   varchar(36) not null comment '主键id',
   goods_id             varchar(36) not null comment '商品id',
   amount               decimal(10,2) not null comment '商品库存',
   occupy_amount        decimal(10,2) not null default 0 comment '库存占用',
   create_date          DATETIME not null comment '创建时间',
   update_date          DATETIME comment '修改时间',
   is_delete            tinyint(1) not null default 0 comment '删除标志 0-未删除，1-删除',
   primary key (id)
)
ENGINE= InnoDB;

alter table t_goods_inventory comment '商品库存信息表t_goods_inventory';

/*==============================================================*/
/* Table: t_goods_location                                      */
/*==============================================================*/
create table t_goods_location
(
   id                   varchar(36) not null comment '主键id',
   goods_id             varchar(36) not null comment '商品id',
   goods_name           varchar(200) comment '商品名称',
   location             point comment '经度纬度',
   longitude            decimal(10,7)  comment '经度',
   latitude             decimal(10,7)  comment '纬度',
   position_name        varchar(500) comment '位置名称',
   create_date          DATETIME not null comment '创建时间',
   update_date          DATETIME comment '修改时间',
   primary key (id)
)
ENGINE= MyISAM;

alter table t_goods_location comment '商品位置信息表t_goods_location';

/*==============================================================*/
/* Table: t_goods_pic                                           */
/*==============================================================*/
create table t_goods_pic
(
   id                   varchar(36) not null comment '主键id',
   goods_id             varchar(36) not null comment '商品id',
   pic_url              varchar(200) comment '图片地址',
   show_order           tinyint(5) comment '展示顺序',
   create_date          DATETIME not null comment '创建时间',
   update_date          DATETIME comment '修改时间',
   is_delete            tinyint(1) not null default 0 comment '删除标志 0-未删除，1-删除',
   data_from            tinyint(2) comment '数据来源 0 app android,1 app ios,2 web ',
   primary key (id)
)
ENGINE= InnoDB;

alter table t_goods_pic comment '商品图片信息表t_goods_pic';

/*==============================================================*/
/* Table: t_goods_score                                         */
/*==============================================================*/
create table t_goods_score
(
   id                   varchar(36) not null comment '主键id',
   goods_id             varchar(36) not null comment '商品id',
   goods_name           varchar(200) comment '商品名称',
   user_id              varchar(36) not null comment '用户id',
   nick_name            varchar(50) comment '用户名',
   score_type           tinyint(1) comment '评价方式 0 非匿名，1 匿名',
   score                tinyint(100) comment '评分',
   comment              MEDIUMTEXT not null comment '评价信息',
   create_date          DATETIME not null comment '创建时间',
   update_date          DATETIME comment '修改时间',
   is_delete            tinyint(1) not null default 0 comment '删除标志 0-未删除，1-删除',
   data_from            tinyint(2) comment '数据来源 0 app android,1 app ios,2 web ',
   primary key (id)
)
ENGINE= InnoDB;

alter table t_goods_score comment '商品评价信息表t_goods_score';

/*==============================================================*/
/* Table: t_goods_watch                                         */
/*==============================================================*/
create table t_goods_watch
(
   id                   varchar(36) not null comment '主键id',
   user_id              varchar(36) not null comment '用户id',
   goods_id             varchar(36) not null comment '商品id',
   goods_name           varchar(200) comment '商品名称',
   create_date          DATETIME not null comment '创建时间',
   update_date          DATETIME comment '修改时间',
   is_delete            tinyint(1) not null default 0 comment '删除标志 0-未删除，1-删除',
   data_from            tinyint(2) comment '数据来源 0 app android,1 app ios,2 web ',
   primary key (id)
)
ENGINE= InnoDB;

alter table t_goods_watch comment '用户关注商品表t_goods_watch';

/*==============================================================*/
/* Table: t_sys_log                                             */
/*==============================================================*/
create table t_sys_log
(
   id                   varchar(36) not null comment '主键id',
   user_id              varchar(36) comment '用户id',
   goods_id             varchar(36) comment '商品id',
   goods_name           varchar(200) comment '商品名称',
   fun_name             varchar(50) comment '方法名',
   logcontent           longtext comment '日志内容',
   log_level            tinyint(2) comment '日志级别 0 低,1 中,2 高',
   log_type             tinyint(2) comment '日志类型 0 访问日志，1 异常日志',
   log_ip               varchar(20) comment '访问id',
   longitude            decimal(10,7)  comment '经度',
   latitude             decimal(10,7)  comment '纬度',
   position_name        varchar(500) comment '位置名称',
   create_date          DATETIME not null comment '创建时间',
   update_date          DATETIME comment '修改时间',
   data_from            tinyint(2) comment '数据来源 0 app android,1 app ios,2 web ',
   primary key (id)
)
ENGINE= InnoDB;

alter table t_sys_log comment '系统日志信息表t_sys_log';

/*==============================================================*/
/* Table: t_user                                                */
/*==============================================================*/
create table t_user
(
   id                   varchar(36) not null comment '主键id',
   mobile_phone         varchar(11) not null comment '手机号(登录帐号)',
   password             varchar(100) comment '登录密码',
   photo_url            varchar(200) comment '头像',
   nick_name            varchar(50) comment '用户昵称',
   sex                  tinyint(1) comment '性别 0-男，1-女',
   birth_day            DATE comment '生日',
   email                varchar(100) comment '邮箱',
   address              varchar(200) comment '联系地址',
   position_name        varchar(500) comment '位置名称',
   position             varchar(100) comment '位置信息',
   user_type            tinyint(2) not null comment '用户类型 0-普通用户，1-商户',
   user_status          tinyint(2) not null comment '用户状态 0-未激活，1-审核中，2-启用，3-禁用，商户需要审核',
   create_date          DATETIME not null comment '创建时间',
   update_date          DATETIME comment '修改时间',
   data_from            tinyint(2) comment '数据来源 0 app android,1 app ios,2 web ',
   primary key (id)
)
ENGINE= InnoDB;

alter table t_user comment '用户信息表t_user';

/*==============================================================*/
/* Table: t_user_location                                       */
/*==============================================================*/
create table t_user_location
(
   id                   varchar(36) not null comment '主键id',
   user_id              varchar(36) not null comment '用户id',
   mobile_phone         varchar(11) comment '手机号(登录帐号)',
   location             point comment '经度纬度',
   longitude            decimal(10,7)  comment '经度',
   latitude             decimal(10,7)  comment '纬度',
   position_name        varchar(500) comment '位置名称',
   create_date          DATETIME not null comment '创建时间',
   update_date          DATETIME comment '修改时间',
   primary key (id)
)
ENGINE= MyISAM;

alter table t_user_location comment '用户位置信息表t_user_location';

/*==============================================================*/
/* Table: t_user_order                                          */
/*==============================================================*/
create table t_user_order
(
   id                   varchar(36) not null comment '主键id',
   mobile_phone         varchar(11) not null comment '手机号(登录帐号)',
   user_id              varchar(36) not null comment '用户id',
   order_no             varchar(20) comment '订单编号',
   order_category       tinyint(2) comment '订单分类 0 农场品，1 农家乐服务',
   order_type           tinyint(2) comment '订单类型 0 实物，1 虚拟',
   order_status         tinyint(2) comment '订单状态 0 待付款，1 待收获，2 已完成，3 已取消',
   total_pay            decimal(10,2) not null comment '订单总价',
   is_delete            tinyint(1) not null default 0 comment '删除标志 0-未删除，1-删除',
   create_date          DATETIME not null comment '创建时间',
   expire_date          DATETIME comment '过期时间',
   update_date          DATETIME comment '修改时间',
   data_from            tinyint(2) comment '数据来源 0 app android,1 app ios,2 web ',
   primary key (id)
)
ENGINE= InnoDB;

alter table t_user_order comment '用户订单信息表t_user_order';

/*==============================================================*/
/* Table: t_user_order_detail                                   */
/*==============================================================*/
create table t_user_order_detail
(
   id                   varchar(36) not null comment '主键id',
   t_f_id               varchar(36) comment '主键id',
   order_id             varchar(36) not null comment '订单id',
   order_no             varchar(20) not null comment '订单编号',
   user_id              varchar(36) not null comment '用户id',
   goods_id             varchar(36) not null comment '商品id',
   goods_name           varchar(200) not null comment '商品名称',
   amount               decimal(10,2) not null default 0 comment '购买数量',
   price                decimal(10,2) comment '购买价格',
   total_pay            decimal(10,2) comment '购买总价',
   create_date          DATETIME not null comment '创建时间',
   update_date          DATETIME comment '修改时间',
   is_delete            tinyint(1) not null default 0 comment '删除标志 0-未删除，1-删除',
   primary key (id)
)
ENGINE= InnoDB;

alter table t_user_order_detail comment '用户订单明细表t_user_order_detail';


/*==============================================================*/
/* Table: t_user_viainfo                                        */
/*==============================================================*/
create table t_user_viainfo
(
   id                   varchar(36) not null comment '主键id',
   user_id              varchar(36) comment '关联用户id,通过验证码注册、登录时为空',
   receiver             varchar(100) not null comment '手机号或邮箱',
   via_type             tinyint(2) comment '验证类型 0-注册,1-登录,2-找回密码,3-邮箱找回密码',
   via_text             varchar(100) not null comment '验证信息',
   send_msg             MEDIUMTEXT comment '发送内容',
	 send_error           MEDIUMTEXT comment '异常信息',
   create_date          DATETIME not null comment '创建时间',
   expire_date          DATETIME not null comment '过期时间',
   data_from            tinyint(2) comment '数据来源 0 app android,1 app ios,2 web ',
   success_flag         tinyint(2) comment '成功标志',
   primary key (id)
)
ENGINE= InnoDB;

alter table t_user_viainfo comment '用户验证信息表t_user_viainfo';

alter table t_user_viainfo add constraint FK_USER_VIA foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;


alter table t_goods add constraint FK_USER_GOODS foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_goods_inventory add constraint FK_GOODS_INV foreign key (goods_id)
      references t_goods (id) on delete restrict on update restrict;

alter table t_goods_location add constraint FK_GOODS_LOCATION foreign key (goods_id)
      references t_goods (id) on delete restrict on update restrict;

alter table t_goods_pic add constraint FK_GOODS_PIC foreign key (goods_id)
      references t_goods (id) on delete restrict on update restrict;

alter table t_goods_score add constraint FK_GOODS_SCORE foreign key (goods_id)
      references t_goods (id) on delete restrict on update restrict;

alter table t_goods_watch add constraint FK_GOODS_WATCH foreign key (goods_id)
      references t_goods (id) on delete restrict on update restrict;

alter table t_goods_watch add constraint FK_USER_WATCH foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_user_location add constraint FK_USER_LOCATION foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_user_order add constraint FK_USER_ORDER foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;

alter table t_user_order_detail add constraint FK_GOODS_ORDER_DETAIL foreign key (t_f_id)
      references t_goods (id) on delete restrict on update restrict;

alter table t_user_order_detail add constraint FK_ORDER_DETAIL foreign key (id)
      references t_user_order (id) on delete restrict on update restrict;

alter table t_user_viainfo add constraint FK_USER_VIA foreign key (user_id)
      references t_user (id) on delete restrict on update restrict;