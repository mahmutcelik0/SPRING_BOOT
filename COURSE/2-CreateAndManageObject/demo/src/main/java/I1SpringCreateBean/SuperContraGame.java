package I1SpringCreateBean;

import org.springframework.stereotype.Component;

@Component //We don't want to use @Bean because if we use that -> bean will create manually
//We make this class component after that in the config class we will add @ComponentScan
public class SuperContraGame implements GamingConsole {
    @Override
    public void up() {
        System.out.println("SUPER CONTRA GAME UP");

    }

    @Override
    public void down() {
        System.out.println("SUPER CONTRA GAME DOWN");

    }

    @Override
    public void left() {
        System.out.println("SUPER CONTRA GAME LEFT");

    }

    @Override
    public void right() {
        System.out.println("SUPER CONTRA GAME RIGHT");

    }
}
