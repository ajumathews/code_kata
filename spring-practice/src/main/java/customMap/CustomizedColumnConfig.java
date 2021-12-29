package customMap;

import helloworld.HelloWorldConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomizedColumnConfig {


@Bean(initMethod = "onLoad")
public CustomizedColumn customizedColumn(){
    return new CustomizedColumn();
}

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(CustomizedColumnConfig.class);
        CustomizedColumn customizedColumn = context.getBean(CustomizedColumn.class);
        System.out.println(customizedColumn.getCustomizedColumn().size());

    }


}
