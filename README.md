﻿# 一个ssm的小小后台管理系统

<hr/>

### 以ssm+vuejs+element-ui为基础的前后台分离的小demo

#### 实现的功能：

#### 1：通过搜索框对用户进行详细查询（如客户姓名、客户来源、客户级别等筛选条件）

#### 2：删除用户

#### 3：更新用户信息

<hr/>

#### 几个坑：

* **后端的springmvc 的@CrossOrign跨域注解一直无法使用不知道是什么原因；
因此最后的解决方案的用**

```
response.setHeader("Access-Control-Allow-Headers", "X-Requested-With, accept,content-type, exception");
response.setHeader("Access-Control-Allow-Methods", "GET, POST");
response.setHeader("Access-Control-Allow-Credentials", "true");
response.setHeader("Access-Control-Allow-Origin", "http://127.0.0.1:5500");
```

*  **spring的版本必须一致，不然无法启动tomcat（jar包冲突)**

*  **在用customerSeerviceImpl类的时候，因为通过customerMapper查询出来的客户来源，客户所属行业，客户级别等信息是数字（即005,22,1等这些数字），不符合最终我们在页面中显示的信息，因此必须在service层中，对查询出来后的信息进去修改；然后再返回给controller层完整的customerList信息**

### 项目结构

### *java代码在ssm文件夹下，其他的为vue-vli生成的常用模式*


## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).


### 登录页面

![image](https://github.com/daimanumber1/pictures/blob/master/ssmAdmin/login.png)


### home页面


![image](https://github.com/daimanumber1/pictures/blob/master/ssmAdmin/img1.png)