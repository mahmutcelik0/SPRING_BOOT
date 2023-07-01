package I4GameWithBean;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;


//IN BELOW BEANS SPRING CONTAINER MANAGES THEM BUT NOT CREATE THEM. (WE CREATE THEM USING NEW)
@Configuration
public class AppConfig {
    @Bean
    @Primary
    public GamingConsole mario(){
        return new MarioGame();
    }

    @Bean
    public GamingConsole pacman(){
        return new PacmanGame();
    }

    @Bean
    @Qualifier("superContraGame")
    public GamingConsole superContra(){
        return new SuperContraGame();
    }

    @Bean("runner")
    public GameRunner gameRunner(@Qualifier("superContraGame") GamingConsole game){
        return new GameRunner(game);
    }


}
