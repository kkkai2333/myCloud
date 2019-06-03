1、在.yml文件中，可以使用“---”分割文本，来区别不同的profiles。

2、在idea中，可以配置启动项的命令行参数（Program arguments）或虚拟机参数（VM options）来调用不同的profiles。
    
    VM options：-Dspring.profiles.active=profilesName
    Program arguments：-spring.profiles.active=profilesName
3、使用jar包启动时，可添加输入启动参数来切换不同的profiles
    
    java -jar projectName --spring.profiles.active=profilesName
4、根据上述配置，可启动不同的应用实例进行测试