#####aop统一处理返回数据
+  使用方式
  1. 添加依赖
    
    (```
     <dependency> 
        <groupId>com.billions.framework</groupId> 
        <artifactId>wrap</artifactId> 
        <version>${framework.version}</version> 
     </dependency>  
     ```)
 
  2.controller路径满足以下执行条件
     `` com.billions.api.*.*.*(..) ``
     
  3.保证方法返回类型为Object
    
示例:com.billions.api.auth.Ping



###### RestControllerAdvice 统一异常处理

* 己知的异常，如参数校验，权限等先声明，再抛出。不能自己组装json数据返回

        （```
        模块声明: com.billions.framework.common.base.Module
        异常声明: com.billions.framework.common.base.Cause
        异常抛出: com.billions.framework.common.exception.GlobalException
        throw new GlobalException(Module m,Cause c)
        ```)




##### http请求使用com.billions.framework.common.util.HttpUtil
    
    get post方法自己添加，里边有示例。方法尽量抽象，以便于重用
    其它util方法，有开源组件可用，尽量使用知名的开源组件 如commons-langs，
    组件不提供的方法在 `` com.billions.framework.common.util ``声明 如StringUtil


