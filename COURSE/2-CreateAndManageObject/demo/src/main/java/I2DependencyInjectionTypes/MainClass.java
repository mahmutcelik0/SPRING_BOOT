package I2DependencyInjectionTypes;

import I1SpringCreateBean.AppConfig;
import I1SpringCreateBean.GameRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;


//THERE WILL BE 2 DIFFERENT CLASSES THAT WILL INJECT INTO OTHER CLASSES TO LEARN DIFFERENT TYPES OF INJECTIONS

@ComponentScan("I2DependencyInjectionTypes")
@Configuration
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainClass.class);

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println(context.getBean("businessClass"));
    }
}
