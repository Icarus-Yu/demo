```angular2html
com.example.demo
├── DemoApplication.java       (启动类)
├── controller                 (控制层：处理 HTTP 请求，参数校验)
│   └── UserController.java    (重命名，原 UseController)
├── entity                     (实体层：与数据库表对应的 POJO)
│   └── User.java              
├── mapper                     (数据层：直接操作数据库)
│   └── UserMapper.java        
└── service                    (业务层：处理核心业务逻辑)
    ├── UserService.java       (Service 接口)
    └── impl                   
        └── UserServiceImpl.java (Service 实现类)
```
1.  实体层（Entity / POJO / Domain）的作用
   实体层是 数据库表在 Java 代码中的映射。

核心功能： 它的主要职责是承载数据。比如你的 User 类通过 @TableName("sys_user") 映射到了数据库的 sys_user 表。

ORM 桥梁： 它是对象关系映射（ORM）的基础。当你使用 MyBatis-Plus 的 selectById 时，框架会自动将数据库中的行数据填充到这个 Java 对象中。

纯粹性： 这一层通常只包含字段、Getter/Setter 以及构造函数，不应该包含复杂的业务逻辑。

2. 服务层（Service）的作用
   服务层是 整个应用程序的核心大脑，它负责处理业务逻辑。

解耦： 如果没有这一层，Controller 会直接调用 Mapper。当业务变复杂时（例如：查询用户前先检查权限、查询后发送一条 Kafka 消息、或者同时操作多张表），Controller 的代码会变得极其臃肿且难以复用。

业务编排： Service 就像一个指挥官，它不关心数据库是怎么查的，只关心“要做什么”。它可以调用多个 Mapper 或其他 Service 来完成一个完整的业务动作。

事务控制： 通常 Spring 的 @Transactional 事务注解都会标注在 Service 层的方法上，确保一系列数据库操作要么全部成功，要么全部回滚。

3. impl 文件夹与接口实现分离
   这种“接口（Interface）+ 实现类（Impl）”的模式是 Java 典型的解耦设计：
规范化： UserService 接口定义了“能做什么”（契约），而 UserServiceImpl 定义了“怎么做”。
灵活性： 比如你在本地测试时想用一个模拟的逻辑，在生产环境下想用真正的逻辑，只需要更换 impl 的实现即可。
依赖注入： 在 Controller 中，我们通过 @Autowired 注入的是接口。这样做的好处是 Controller 只需要知道接口有哪些功能，而不需要关心背后的具体实现细节。
