# 数据库系统介绍Outline

部署方式：

1. 在数据库执行universitycourse.sql
2. 用idea运行项目文件

# 1. 项目主题

项目主题是以学生课程管理为主题的大学教务系统

实现的业务需求大致有：学生选课，学生退课，学生信息查看，教师信息查看，教师开课等。

# 2. 数据表设计

数据表采用ER图->关系表的设计方式。总共7个实体类，10张关系表，3张视图，2个存储过程，2个触发器。

**7个实体类分别是：**

* 用户
* 学生
* 教师
* 管理员
* 学院
* 课程
* 班级

**10张关系表分别是：**

* users
* student
* teacher
* administrator
* department
* course
* classes
* take
* required
* teach

**3张视图分别是：**

* studentView学生视图
* teacherView教师视图
* currentClasses当前可选课程视图

**2个存储过程分别是**：

* chooseClass选课存储过程
* dropOutClass退课存储过程

**2个触发器分别是**：

* 开课触发器（控制课程学分）
* 学生通过课程触发器（自动更新学生学分）

# 3. 框架和技术

整体采用SSM框架搭建。

后端分出四个层次：

* DAO  数据访问对象层（直接于数据库交互）
* POJOs  普通的老式java对象层（主要用来保存内容和传参）
* Service   服务层（对DAO的进一步封装）
* Controller  控制器层（业务逻辑代码）

安全：

* 对输入密码用**正则表达式**进行校验，防止sql注入。
* 代码中适当使用**try，catch**捕获异常，防止应用崩溃。



# 4. 已知问题

本次作业使用后台数据库为MariaDB，存在重复调用存储过程可能会导致整个数据库崩溃的bug，在MariaDB的官方论坛上看到了和我相似的bug反馈。