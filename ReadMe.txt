-*- 中文版 -*-
框架 Maven + Spring MVC + Hibernate + Ehcache
Dao：包括BaseDao(保证只有一个SessionFactory), 
	AdminDao(管理员所有数据库操作的集合类), 
	UserDao(用户所有数据库操作的集合类)
	暂时无太大耦合，但是将来可能会存在通用的方法，可以通过反射机制完善

Service：包括AdminService(管理员所有操作的逻辑层), 
	UserService(用户所有操作的逻辑层) 
	同Dao一样，后期需要整理分成几个小的子类

Controller：包括AdminController(管理员页面所有的处理), 
	UserController(用户页面所有的处理)

管理员：
	-包括夜跑记录的查询(包括日期查询和关键字检索)、通知的管理(暂时未做)、用户的管理(添加/删除/‘查询’)
	-目前已经有了通过上传用户数据的Excel文档来快速添加用户，同时由于存在不同分院，所以需要一个类根据当前管理员的所属分院进行当前该管理员所有操作的特定数据的分配
用户：
	通过Html页面显示JSON格式的数据使客户端可以解析数据，通过<c:forEach>完成JSON格式的信息显示在HTML页面上

未完待续...

-*- English -*-
Frame: Maven + Spring MVC + Hibernate + Ehcache
Dao: BaseDao - only has SessionFactory now
	 AdminDao - admin's database operations(all of them)
	 UserDao - user's databse operations(all of them)
	 I'll use reflection to complete it

Service: AdminService - admin's logic operations(all of them)
	UserService - users' logic operations(all of them)
	seem to the dao, I'll improve it later

Controller:AdminController, UserController - just like dao & service

Administrator:
	-run's data can be searched by datetime or keyword(user'no or user' name), user's management(add/delete/'search')
	-administrator can uplopd an excel(only have user'no & user's name) to add users
	-there's 9 branchs so that I need a class to make sure the administrator only can control his branch's users
users(github.com/zxyAnkh/ZUCC_NightRun_Client):
	json in html and client parse the json

to be continue...