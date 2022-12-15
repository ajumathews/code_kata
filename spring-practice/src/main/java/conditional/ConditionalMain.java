package conditional;

import conditional.daps.core.DapsCoreService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ConditionalMain {


    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(ConditionalConfiguration.class);
        DapsCoreService service = (DapsCoreService) context.getBean("dapsCoreService");
        service.print();
    }
}
