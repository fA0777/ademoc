import com.falling.config.SpringConfig;
import com.falling.service.UserService;
import com.falling.web.UserServlet;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {
        //加载配置类
        ApplicationContext ctx=new AnnotationConfigApplicationContext(SpringConfig.class);
        UserServlet userServlet = ctx.getBean(UserServlet.class);
    }
}
