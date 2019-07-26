## 第二章：SpringBoot使用Devtools实现热部署
我们每次修改代码之后，都需要手动去重启项目，这样才能看到改动后的效果，耗时且麻烦。
使用spring-boot-devtools组件之后，idea可以检测到代码的改动，然后自动编译（需要开启idea的自动编译）并restart项目。
无需我们手动去重启项目，就可以看到改动后的效果，简单方便。

## 本章目标
使用spring-boot-devtools来实现项目热部署，修改java代码，无需手动重启项目，只需刷新页面，即可看到内容的修改。

## 注意事项
存在配置好了devtools但是失效的问题,原因如下：
idea和eclipse不一样，idea需要手动去开启自动编译功能。
具体步骤参考如下：[idea手动开启自动编译功能](https://blog.csdn.net/minebk/article/details/78200507 "SpringBoot热部署")

