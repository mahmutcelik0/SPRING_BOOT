package I1LazyVsEagerInitialization;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(MainClass.class);

        System.out.println("INITIAL INJECTIONS MADE");

        context.getBean(LazyInitialization.class);
    }




}
