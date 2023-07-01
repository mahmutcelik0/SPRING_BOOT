package I2LooslyCoupled;

public class MarioGame implements GamingConsole{
    @Override
    public void up() {
        System.out.println("MARIO GAME UP");
    }

    @Override
    public void down() {
        System.out.println("MARIO GAME DOWN");

    }

    @Override
    public void left() {
        System.out.println("MARIO GAME LEFT");

    }

    @Override
    public void right() {
        System.out.println("MARIO GAME RIGHT");

    }
}
