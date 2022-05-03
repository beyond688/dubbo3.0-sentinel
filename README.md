# dubbo3.0-sentinel
整合dubbo3.0和sentinel，并给出sentinel的限流和熔断例子

<strong>一、linux环境下载sentinel</strong>

wget https://github.com/alibaba/Sentinel/releases/download/1.8.4/sentinel-dashboard-1.8.4.jar

<strong>二、启动sentinel</strong>

java -jar sentinel-dashboard-1.8.4.jar --server.port=8010 --auth.username=sentinel --auth.password=sentinel &

<strong>三、访问sentinel,ip换成实际的</strong>

地址 http://127.0.0.1:8010/#/login

账号/密码   sentinel/sentinel


<strong>四、启动dubbo3.0-sentinel项目</strong>

1、启动DubboProviderApplication

2、启动DubboConsumerApplication

注意：dubbo.registry.address = zookeeper://192.168.240.132:2181

ip换成实际的地址

<strong>五、分别调用限流和熔断接口一次</strong>

调用链接如下：

限流：http://127.0.0.1:9091/useExecutes/beyond

熔断：http://127.0.0.1:9091/useFuse/beyond

注意：只有调用过后服务才能在sentinel页面上看到
![image](https://user-images.githubusercontent.com/39320802/166418045-38d67651-6b6d-4fd5-b8ff-eb33c8ed0927.png)

<strong>六、分别设置限流和熔断规则</strong>
![image](https://user-images.githubusercontent.com/39320802/166418297-cb1b3517-ec67-472d-8842-50f4ccd84850.png)

<strong>七、查看设置好的限流和熔断规则</strong>
![image](https://user-images.githubusercontent.com/39320802/166418366-91fd7162-d21d-48ed-9dd4-a07ba654c70c.png)
![image](https://user-images.githubusercontent.com/39320802/166418373-2489f3ba-8586-423c-852c-7e231a5ef205.png)

<strong>八、疯狂调用限流和熔断服务，查看限流和熔断结果</strong>
调用链接如下：

限流：http://127.0.0.1:9091/useExecutes/beyond

熔断：http://127.0.0.1:9091/useFuse/beyond

![image](https://user-images.githubusercontent.com/39320802/166418454-09bd4e83-45e3-44e1-8ec1-839c2ed8fafb.png)



