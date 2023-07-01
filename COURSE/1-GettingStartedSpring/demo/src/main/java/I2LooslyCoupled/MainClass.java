package I2LooslyCoupled;

public class MainClass {
    public static void main(String[] args) {
        GamingConsole game1 = new MarioGame();  //1:OBJECT CREATION
        GamingConsole game2 = new PacmanGame(); //1:OBJECT CREATION
        GamingConsole game3 = new SuperContraGame();    //1:OBJECT CREATION


        var g1 = new GameRunner(game3);
        //2: OBJECT CREATION + WIRING OF DEPENDENCIES
        //GAME IS A DEPENDENCY OF GAMERUNNER

        //IN ENTERPRISE EDITION APPLICATIONS YOU WILL HAVE THOUSANDS OF OBJECT
        //CREATIONS AND THOUSANDS OF DEPENDENCY INJECTIONS

        //WE CAN'T HANDLE WHOLE THESE AND THEREFORE WE LET THE SPRING MANAGE LIFECYCLE OF
        //OBJECTS AND DEPENDENCIES
        g1.run();
    }
}
