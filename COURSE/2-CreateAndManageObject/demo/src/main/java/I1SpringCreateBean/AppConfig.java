package I1SpringCreateBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;


//IN BELOW BEANS SPRING CONTAINER MANAGES THEM BUT NOT CREATE THEM. (WE CREATE THEM USING NEW)

@Configuration
@ComponentScan("I1SpringCreateBean")
public class AppConfig {
//    @Bean
//    @Primary
//    public GamingConsole mario(){
//        return new MarioGame();
//    }
//
//    @Bean
//    public GamingConsole pacman(){
//        return new PacmanGame();
//    }
//
//    @Bean
//    @Qualifier("superContraGame")
//    public GamingConsole superContra(){
//        return new SuperContraGame();
//    }



    @Bean("runner")
    public GameRunner gameRunner(@Qualifier("marioGame") GamingConsole game){
        return new GameRunner(game);
    }
    //ABOVE METHOD WE USED THE AUTOMATICALLY CREATED BEAN

}
