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
 * 转换类converter2   