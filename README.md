#NightRun-NTR
-------------
##Server
	Using Nginx1.11 + Tomcat 8/7 + Redis3
	Spring4 + Spring MVC4 + Mybatis3 + shrio
	
###package core
#####interface ObjectsTranscoder
    	transcode list<T> to byte[] so that list<T> can store in redis
        transcode byte[] to list<T> so that can get from redis
#####class RedisCache
    	get from redis & set to redis
#####class TestSupport
    	used as follows: 
        public class TestClass extends TestSupport{
        	@Test
            public void testMethod(){
            	// do something
            }
        }
#####package generic
		There are some generic classes, used as follows:
        public class ModelService extends GenericService<Model, PK>{}
#####class ReadExcel & WriteExcel
		https://github.com/zxyAnkh/ReadExcel
###package web
#####package security
		shiro & permissions & roles

        @RequestMapping()
        @RequiresRoles()
        @RequiresPermissions()
        public Object method(){ 
            return new Object();
        }

###package src/resources
		all the profiles
###package test/resouces
		mybatis-generator configuration

------------
##Database
#####MySQL
    no foreign key, using triggers to process data

#Reference
    https://github.com/starzou/quick4j