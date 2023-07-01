package I2SingletonVsPrototypeScopes;


import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class MainClass {
    public static void main(String[] args) {
        ApplicationContext  context = new AnnotationConfigApplicationContext(MainClass.class);

        //SAME HASH CODES
        System.out.println(context.getBean(SingletonClass.class));
        System.out.println(context.getBean(SingletonClass.class));
        System.out.println(context.getBean(SingletonClass.class));

        //DIFFERENT HASH CODES
        System.out.println(context.getBean(PrototpyeClass.class));
        System.out.println(context.getBean(PrototpyeClass.class));
        System.out.println(context.getBean(PrototpyeClass.class));

    }
}
