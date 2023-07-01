package I1SpringCreateBean;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


public class GameRunner {

    private final GamingConsole game;

    public GameRunner(GamingConsole game){
        this.game = game;
    }

    public void run(){
        game.up();
        game.down();
        game.left();
        game.right();
    }

}
