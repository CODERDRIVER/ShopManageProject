#添加pageHelper插件
第一步，首先添加pageHelper的jar包
第二步，需要在SqlMapConfig.xml中配置插件
```java
<configuration>
    <!--配置pageHelper-->
    <plugins>
        <plugin interceptor="com.github.pagehelper.PageHelper">
            <!--设置数据库类型 Oracle Mysql,MariaDB,SQLite,Hsqldb,PostgreSQL-->
            <property name="dialect" value="mysql"/>
        </plugin>
    </plugins>
</configuration>

```
第三步：在查询的SQL语句之前，添加一行代码
PageHelper.startPage(1,10);
第一个参数是第几页
第二个参数是每页显示的记录数
第四步：去查询结果的总数量
创建一个PageInfo类，从对象中取分页信息
