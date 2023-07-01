package I3BEAN;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


//CONFIG CLASS
//WE CAN DEFINE BEANS OR METHODS THAT CREATES BEANS
//TO MAKE THAT WE NEED TO ADD @CONFIGURATION ANNOTATION
@Configuration
public class ConfigurationClass {
    @Bean
    @Qualifier("sayName")
    public String getName(){
        return "MAHMUT CELIK";
    }

    @Bean
    @Qualifier("sayAge")
    public int age(){
        return 21;
    }

    @Bean
    public Person person(){
        return new Person("AAA",25);
    }

    @Bean
    public Person personMethodCall(){
        return new Person(getName(),age());
    }


    @Bean(name = "address")
    public Address getAddress(){
        return new Address("CUMHURIYET MAHALLESI","DENIZLI");
    }

    //We can create a bean that already exists as a bean in spring context
    //2 ways -> 1. Call bean with method || 2.Call bean with parameter

    //parameters get beans
    @Bean
    public Person examplePersonWithoutParameter(String getName,int age){
        return new Person(getName,age);
    }

    @Bean
    @Primary //PERSON CLASS PRIMARY
    public Person qualifierExample(@Qualifier("sayName") String getName,@Qualifier("sayAge") int age){
        return new Person(getName,age);
    }



}


//JAVA CLASSES
record Person(String name,int age){};
record Address(String firstLine, String city){};
