# Article-management-system
文章管理平台使用spring boot spring mvc mybaits mysql 前端vue

# 文章管理系统

需求分析:

主要的功能:

​	1.前台部分: 

​						用户注册，用户登录，管理员登录

​						游客查看文章、游客评论文章

​	2.后台部分:

​						用户发表文章、用户查询文章(通过关键字查询) 、用户删除文章、

​						管理员审核文章、管理员删除文章、管理员查看文章、管理员删除恶意评论、管理员注销用户

Mysql：



​	文章      ===>    article 表

​	字段  id	title	contents	likenum	cratetime

​    

​	用户      ===>    user 表

​    字段   id	username	password	createtime	lock（是否锁定）



​	评论表   ===> comment 表

​	字段  id	username	contents 	likenum	createtime

​	

​	管理员表 ===>	administrator

​	字段  id  username	operation	createtime	state

**表创建**	

CREATE TABLE `administrator` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(30) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`operation` VARCHAR(50) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`createtime` DATE NOT NULL DEFAULT '0000-00-00',
	`state` VARCHAR(10) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `username` (`username`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=2;

CREATE TABLE `article` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`title` VARCHAR(30) NOT NULL COLLATE 'utf8_general_ci',
	`type` VARCHAR(30) NOT NULL COLLATE 'utf8_general_ci',
	`content` TEXT NOT NULL COLLATE 'utf8_general_ci',
	`auth` VARCHAR(20) NOT NULL COLLATE 'utf8_general_ci',
	`createtime` DATE NOT NULL,
	PRIMARY KEY (`id`) USING BTREE,
	UNIQUE INDEX `title` (`title`) USING BTREE
)
COLLATE='utf8_general_ci'
ENGINE=InnoDB
AUTO_INCREMENT=12;

CREATE TABLE `comment` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(30) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`contents` TEXT NOT NULL COLLATE 'utf8mb4_0900_ai_ci',
	`likenum` INT NOT NULL DEFAULT '0',
	`createtime` DATE NOT NULL DEFAULT '0000-00-00',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB;

CREATE TABLE `user` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`username` VARCHAR(30) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`password` VARCHAR(30) NOT NULL DEFAULT '' COLLATE 'utf8mb4_0900_ai_ci',
	`createtime` DATE NOT NULL DEFAULT '0000-00-00',
	`lock` TINYINT(1) NOT NULL DEFAULT '0',
	PRIMARY KEY (`id`) USING BTREE
)
COLLATE='utf8mb4_0900_ai_ci'
ENGINE=InnoDB
AUTO_INCREMENT=7;



测试工具 : Postman

测试数据:

​	http://localhost:8090/login  ==>    登录

​	http://localhost:8090/publish ==> 发表    Json post请求

 	{

  	"title":"sss",

​	  "type":"技术",

  	"auth":"zwzs",

​	  "content":"sadadsadasdadadadwdscsa"

​	}

​	http://localhost:8090/selectall ==> 查询 

​	http://localhost:8090/search?title=aac ==> 条件查询

​	http://localhost:8090/update ==> 文章更新(修改) post请求 json

​	{

  	"title":"ss",

  	"type":"hhs"

​	}

​	http://localhost:8090/delete?title='xxx' ==> 文章删除 get请求





### 环境与工具

​	**1.jdk8**  

​	**2.Idea** 

​	**3.heidsql(mysql)**

​    **4.mysql8**

​	**5.vscode（前端vue）**



​				

