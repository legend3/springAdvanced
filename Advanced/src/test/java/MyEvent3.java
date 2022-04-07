import org.springframework.context.ApplicationEvent;

/**
 * P8 自定义监听器事件
 */
public class MyEvent3 extends ApplicationEvent {//继承ApplicationEvent
    public MyEvent3(Object source) {//source事件
        super(source);
        System.out.println(source);
    }
}
