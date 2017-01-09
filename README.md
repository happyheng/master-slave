# master-slave
测试数据库people表的sql语句为
```
CREATE TABLE people (
	id BIGINT(20) UNSIGNED NOT NULL  AUTO_INCREMENT,
    name VARCHAR(20) ,
    age INT(3),
    create_time DATETIME,
    PRIMARY KEY (id)
)ENGINE=InnoDB DEFAULT CHARSET=UTF8 ;
```
