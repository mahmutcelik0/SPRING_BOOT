package I3BEAN;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class HelloWorldMainClass {
    public static void main(String[] args) { // JVM

        //1: LAUNCH a SPRING CONTEXT
        var context = new AnnotationConfigApplicationContext(ConfigurationClass.class); //SPRING CONTEXT

        //2: CONFIGURE THE THINGS THAT WE WANT SPRING TO MANAGE - @Configuration
        //ConfigurationClass - @Configuration
        //getName - @Bean

        //3: Retrieving Beans managed by Spring
        System.out.println(context.getBean("getName"));

        System.out.println(context.getBean("age"));

        System.out.println(context.getBean("person"));

        System.out.println(context.getBean("address"));

        //I CAN ALSO USE THE RETURN TYPE OF THE BEAN
        System.out.println(context.getBean(Address.class));

        System.out.println(context.getBean("personMethodCall"));

        System.out.println("-----------------------------");
        System.out.println(context.getBean("examplePersonWithoutParameter"));

        Arrays.stream(context.getBeanDefinitionNames()).forEach(System.out::println);

        System.out.println("------------------------------");
        System.out.println(context.getBean(Person.class));


    }
}
