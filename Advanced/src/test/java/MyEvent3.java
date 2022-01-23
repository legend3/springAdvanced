import org.springframework.context.ApplicationEvent;

/**
 * 自定义监听器
 */
public class MyEvent3 extends ApplicationEvent {//实现ApplicationEvent接口
    public MyEvent3(Object source) {//source事件
        super(source);
        System.out.println(source);
    }
}
