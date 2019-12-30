#dubbo-nacos-demo 
> 简介
 * 是简略的使用 nacos 作为 dubbo的注册中心进行简单的RPC调用示例
##遇到的坑
> [官方文档](http://dubbo.apache.org/zh-cn/docs/user/references/registry/nacos.html)存在的坑爹问题
1. 文档中Maven引入包的问题 [nacos-client] 1.0.4 存在注册不了的问题
2. alibaba 已经将dubbo交由apache 基金会但是 文档中很多包都是com.alibaba 的jar 导致一个版本对不上或者说新旧不一。
3. 序列化问题
  当 将文档中的[nacos-client]改为 1.0.0 版本则 注册成功，但是会因为alibaba 的序列化工具导致 rpc失败

最后采用了 全套apache 的jar。则可以避免以上问题，因为时间关系没有去深究原因