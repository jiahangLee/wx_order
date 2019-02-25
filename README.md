# wx_order
#### 日志
 * logback替代了log4j
 * logback实现了Slf4j Api
 * xml配置日志
    * filter过滤error
    * 可以配置时间滚动策略   
 * 类注释和方法注释
    
        /**
         * @Auther: ${USER}
         * @Date: ${DATE} ${HOUR}:${MINUTE}
         * @Description: //TODO
         * @version: V1.0 
         */
 * @Data是lombok包的注解
 * 断言的简单使用
 * 单元测试Junit4
 * BeanUtils.copyProperties
    * 可以直接copy对象中的内容
    * 过滤采用stream
 * 随机数random
 * 断点调试
    * 读懂报错信息
 * 断言到底是检测什么？
    * 单元测试就一定要断言吗
        * 无用的断言    
 * 关于错误
    * 就是{日志+异常}
    * 里层外层的错误报告
    * 记得判空
        * 基本上每次数据库操作都要判空
 * 转换类converter2  
 * java8新特性
    * Option可以接受null
    * stream流用来过滤筛选数据形成新列表，不能替代for循环？
        * foreach不能返回 
 * 虚拟机时区不对
 * 字段过滤
 * 时间戳修改格式
 * null值不返回
 * gson的简单使用
## 问题 
 * http://192.168.199.105/sell/buyer/product/list为什么能访问？
    * 请求转发可以让192.168.199.105（nginx上的location）主机上访问sell和被转发的主机返回一样的值
 * 改为8080后可以为http://sell22.com/sell/buyer/product/list？
    * 和8080没有关系
 * sell22.com为什么不能访问？
    * 理论上有cookie都能访问，不会跳转
        * 域名和ip都要设置一遍cookie
 * 理论上是正确的就试3遍
    * 因为机器会有延迟或其他缓存等等
 * Sdk使用流程要搞清楚
 * 第八章总结
    * @bean和config，项目启动就执行
    * 微信支付流程
    * 业务流程
 * 关于分页   
 * 枚举类不同于类
    * @Getter没用，需要实现统一接口
    * 好像多余了
 * 模板消息推送
    * 不用抛出异常，打印log即可
 * 其他
    * appid和openid是一对多，openid是appId下唯一标识
        * 同一个用户，appid不同，openid也不同
    * 内网穿透是为了让电脑接口可以外网用
    * 手机抓包是为了让电脑代替手机发送请求，因为电脑上设置了host   
    