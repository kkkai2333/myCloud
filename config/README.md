`Spirng cloud config 默认提供了几个REST ful API，可以用来访问git中的配置文件`
 - `/{application}/{profile}[/{label}]`
 - `/{application}-{profile}.yml`
 - `/{label}/{application}-{profile}.yml`
 - `/{application}-{profile}.properties`
 - `/{label}/{application}-{profile}.properties`

`其中，application、profile、label都是占位符`
 - `application：需要从git中获取配置文件的微应用名称`
 - `profile：需要启动的profile`
 - `label：git中的分支名称`

`另外，还有以下读取规则`
 - `application.yml为默认加载到所有应用中的配置`
 - `application-{profile}.yml为默认加载到所有启用profile类型配置的应用中的配置`
 
`相同的配置，{application}-{profile}.properties或{application}-{profile}.yml的优先级
 要高于application-{profile}.properties和application-{profile}.yml`

`config server为配置内容的加解密提供了支持`
 - `可采用对称加密或非对称加密`
 
`在需要获取配置的应用中，通过暴露refresh方法，在获取参数的类上配置@RefreshScope注解`
 - `在配置更新后，调用对应服务的/actuator/refresh方法来刷新配置`
 - `但测试中发现，该配置在切换profile时，无法及时刷新？（还需调查原因）`