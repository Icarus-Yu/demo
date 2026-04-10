# Spring Boot 3 & MyBatis-Plus 企业级开发骨架

这是一个基于 Spring Boot 3.3.5 构建的后端开发入门/演示项目。项目采用模块化设计，遵循 RESTful 风格和阿里巴巴 Java 开发规约，适合初学者理解现代企业级架构。

## 🚀 技术栈
- **核心框架**: Spring Boot 3.3.5 (Java 21)
- **数据库**: H2 Database (内存数据库)
- **持久层**: MyBatis-Plus 3.5.9
- **接口文档**: SpringDoc OpenAPI (Swagger 3)
- **工具库**: Lombok, JSqlParser

## 🏗️ 项目架构说明
项目采用经典的四层架构，并引入了数据模型解耦（Entity/DTO/VO）：
- `common`: 存放统一响应对象 `Result` 及全局异常处理。
- `config`: 项目全局配置（如 MyBatis-Plus 拦截器）。
- `controller`: 负责接收请求，采用**构造器注入**方式。
- `service`: 业务逻辑接口及其实现，处理 DTO 与 Entity 的转换。
- `model`: 
    - `entity`: 数据库映射实体类。
    - `dto`: 接收前端请求参数（使用 Java Record）。
    - `vo`: 返回给前端的展示数据（使用 Java Record）。
- `mapper`: 数据库操作接口。

## 🛠️ 快速开始
1. **环境依赖**: JDK 21+, Maven 3.6+
2. **克隆并运行**:
   ```bash
   mvnw clean spring-boot:run
   ```
3. **API 文档**:
   启动后访问：[http://localhost:8080/swagger-ui/index.html](http://localhost:8080/swagger-ui/index.html)
4. **H2 控制台**:
   访问地址：[http://localhost:8080/h2-console](http://localhost:8080/h2-console)
   - JDBC URL: `jdbc:h2:mem:testdb`
   - User Name: `sa` (无密码)

## 📝 开发者笔记
项目代码中保留了初学阶段关于 **IoC (控制反转)**、**接口契约**、**MyBatis-Plus 泛型** 等核心概念的详细注释，旨在帮助初学者快速建立 Spring 生态的宏观思维。
