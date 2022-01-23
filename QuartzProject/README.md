Quartz  ：定时异步任务  
任务：做什么事情....  MeetingService(放入job中)  
触发器：定义时间  
调度器：将任务与触发器 一一对应(任务什么时间形式被执行)  
实现步骤：（独立使用）  
1.jar  
2.  
任务（Serivce..）  :Job  

3.测试方法：Job 、 触发器  、调度器  

scheduler.shutdown()：立刻关闭  
scheduler.shutdown(false)：shutdown()立刻关闭  
scheduler.shutdown(true)：将当前任务执行完毕后 再关闭  

异步任务  


触发器：CronScheduleBuilder  

Cron表达式：  
6-7个个参数，以空格隔开  
秒	分	时	天(月)	月	天（周）	 (年)  
2,10     3-6    12/3       L                        2019-2022  




--Spring整合Quartz  

1.jar  
spring基础包(spring-context-support.jar/spring-tx.jar)+quartz  


2.  
a.将Job信息封装到一个 实体类中  
b.spring配置文件  


调度器  ->触发器（Job、执行时间）  









