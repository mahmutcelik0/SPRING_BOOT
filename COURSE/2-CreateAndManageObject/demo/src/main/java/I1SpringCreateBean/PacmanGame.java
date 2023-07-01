package I1SpringCreateBean;

import org.springframework.stereotype.Component;

@Component //We don't want to use @Bean because if we use that -> bean will create manually
//We make this class component after that in the config class we will add @ComponentScan
public class PacmanGame implements GamingConsole {
    @Override
    public void up() {
        System.out.println("PACMAN GAME UP");
    }

    @Override

    public void down() {
        System.out.println("PACMAN GAME DOWN");
    }

    @Override
    public void left() {
        System.out.println("PACMAN GAME LEFT");
    }

    @Override
    public void right() {
        System.out.println("PACMAN GAME RIGHT");

    }
}
