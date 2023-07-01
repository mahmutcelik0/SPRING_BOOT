package I2LooslyCoupled;

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
