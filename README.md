# EasyShop

## 概述

此项目会持续更新，目前只是开发了一小部分

### 前端样式图示例：

![管理内容页](https://lustre123-myshop.oss-cn-beijing.aliyuncs.com/1.png)

![](https://lustre123-myshop.oss-cn-beijing.aliyuncs.com/2.png)

![](https://lustre123-myshop.oss-cn-beijing.aliyuncs.com/3.png)

### 后端技术选型

| 技术                          | 说明                                                     | 地址                                                         |
| ----------------------------- | -------------------------------------------------------- | ------------------------------------------------------------ |
| Spring Boot                   | 新一代 JavaEE 开发标准                                   | [GitHub](https://github.com/spring-projects/spring-boot)     |
| Spring Cloud Alibaba          | 阿里巴巴基于 Spring Cloud 编程模型的微服务生态           | [GitHub](https://github.com/alibaba/spring-cloud-alibaba)    |
| Spring Cloud Alibaba Dubbo    | 与 Spring Cloud Alibaba 生态相结合的高性能 Java RPC 框架 | [GitHub](https://github.com/apache/dubbo)                    |
| Spring Cloud Alibaba RocketMQ | 分布式消息系统                                           | [GitHub](https://github.com/alibaba/spring-cloud-alibaba/blob/master/spring-cloud-alibaba-examples/rocketmq-example/readme.md) |
| Spring Security oAuth2        | 安全认证和授权框架                                       | [GitHub](https://github.com/spring-projects/spring-security-oauth) |
| MyBatis                       | 持久化框架                                               | [GitHub](https://github.com/abel533/Mapper)                  |
| MyBatisGenerator              | Maven 插件，用于 MyBatis 相关代码生成                    | [官网](http://www.mybatis.org/generator/)                    |
| MybatisCodeHelper             | Intellij IDEA 插件，用于 MyBatis 相关代码生成            | [官网](https://plugins.jetbrains.com/plugin/9837-mybatiscodehelperpro) |
| PageHelper                    | MyBatis 分页插件                                         | [GitHub](https://github.com/pagehelper/Mybatis-PageHelper)   |
| HikariCP                      | 数据库连接池                                             | [GitHub](https://github.com/brettwooldridge/HikariCP)        |
| Docker                        | 容器化引擎                                               | [官网](https://www.docker.com/)                              |
| Docker Compose                | 容器编排工具                                             | [官网](https://docs.docker.com/compose/)                     |
| Seata                         | 分布式事务框架                                           | [官方](<https://seata.io/zh-cn/index.html>)                  |
| OpenFeign                     | 声明式 HTTP 客户端                                       | [GitHub](https://github.com/OpenFeign/feign)                 |
| Nacos                         | 服务注册中心、服务配置中心                               | [官网](http://dubbo.apache.org/zh-cn/docs/user/references/registry/nacos.html) |
| Alicloud sdk oos              | 阿里巴巴对象存储进行图片上传等操作                       | [阿里云](https://www.aliyun.com/)                            |
| Redis                         | NoSQL数据库                                              | [官网](https://redis.io/)                                    |
| RocketMQ                      | 消息中间件                                               | [官网](http://rocketmq.apache.org/)                          |

框架集成

| 集成                          | 完成 |
| ----------------------------- | ---- |
| Spring Boot                   | ✔    |
| Spring Cloud Alibaba          | ✔    |
| Spring Cloud Alibaba Dubbo    | ✔    |
| Spring Cloud Alibaba Sentinel | ✔    |
| Spring Security oAuth2        | ✔    |
| MyBatis                       | ✔    |
| HikariCP                      | ✔    |
| Feign 传递 Token              | ✔    |

### 前端技术

| 技术              | 说明                               | 地址                                                      |
| ----------------- | ---------------------------------- | --------------------------------------------------------- |
| Vue               | 前端框架，MVVM 模式的实现者        | [GitHub](https://github.com/vuejs/vue)                    |
| Vue CLI           | Vue 脚手架，基于 NodeJS            | [GitHub](https://github.com/vuejs/vue-cli)                |
| Vue Router        | Vue 路由框架                       | [GitHub](https://github.com/vuejs/vue-router)             |
| Vuex              | Vue 全局状态管理框架               | [GitHub](https://github.com/vuejs/vuex)                   |
| Axios             | 前端 HTTP 框架                     | [GitHub](https://github.com/axios/axios)                  |
| Element UI        | 饿了么 UI 框架                     | [官网](https://element.eleme.cn)                          |
| Vue Element Admin | 基于 Element UI 的前端后台解决方案 | [GitHub](https://github.com/PanJiaChen/vue-element-admin) |
| Swiper            | 图片轮播组件                       |                                                           |

### 后台功能清单

#### 后台登录

| 功能       | 完成 |
| ---------- | ---- |
| 用户注册   | ✔    |
| 用户登录   | ✔    |
| 获取 Token | ✔    |
| 用户注销   | ✔    |
| 刷新 Token |      |

#### 个人信息

| 功能     | 完成 |
| -------- | ---- |
| 查看信息 | ✔    |
| 更新信息 |      |
| 更新密码 |      |
| 更新头像 |      |

#### 权限管理

| 角色           | 菜单                         |
| -------------- | ---------------------------- |
| ADMIN_INFO     | 获取用户信息                 |
| CONTENT_INSERT | 对内容页的内容进行添加的权限 |

#### 资源管理

| 资源ID           | 访问资源           |
| ---------------- | ------------------ |
| ADMIN_RESOURCE   | Admin用户资源      |
| CONTENT_RESOURCE | 内容广告资源       |
| ITEM_RESOURCE    | 商品或商品类目资源 |

### 后台服务规划

#### 缓存

| 服务                 | 简述                                    |
| -------------------- | --------------------------------------- |
| mall-item-controller | 使用了redis的锁机制解决了缓存的击穿问题 |

#### 服务

| 服务名       | 端口 | 说明                        |
| ------------ | ---- | --------------------------- |
| mall-admin   | 80   | 管理员的注册与登陆获取信息  |
| mall-oauth2  | 80   | 统一认证中心                |
| mall-item    | 80   | 类目 （注：面前只实现这些） |
| mall-content | 80   | 页面内容，内容类目..        |
| mall-gateway | 80   | 网关                        |

#### 分布式事务

认证中心和后台用户是分离的，所以要使用分布式事务进行OAuth2认证中心端用户的注册和Admin服务端的注册，使用了dubbo远程内部调用了OAuth2的api，这样具有安全性

| 服务                  | 简述                                      |
| --------------------- | ----------------------------------------- |
| mall-admin-controller | 使用了seata的全局分布式事务进行用户的注册 |

#### 消息队列

| 服务                  | 简述                                                    |
| --------------------- | ------------------------------------------------------- |
| mall-admin-controller | 消息提供者 用来记录登陆日志                             |
| mall-admin-service    | 消息消费者 调用tb-admin-login-log的添加操作实现登录日志 |

