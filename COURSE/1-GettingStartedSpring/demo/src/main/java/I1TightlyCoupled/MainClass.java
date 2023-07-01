package I1TightlyCoupled;


//TIGHTLY COUPLED GAME EXAMPLE
public class MainClass {
    public static void main(String[] args) {
        var marioGame = new MarioGame();

        //WHAT IS THE PROBLEM IN TIGHTLY COUPLED
        //IF I WISH TO SEND ANOTHER GAME TO GAMERUNNER CLASS
        //IT RAISES A COMPILATION ERROR BECAUSE GAMERUNNER CLASS
        //IS TIGHTLY COUPLED TO MARIOGAME CLASS. IT REFUSES ANOTHER CLASSES

        //var anotherGame = new CsGoGame();
        //var gameRunner = new GameRunner(anotherGame); //-> RAISES ERROR

        //IF I WANT TO FIX ABOVE PROBLEM I HAVE TO CHANGE GAMERUNNER CLASS'S FIELD AS ANOTHERGAME CLASS
        //OR I CAN MAKE GAMERUNNER CLASS LOOSE COUPLED
        var gameRunner = new GameRunner(marioGame);
        gameRunner.run();

    }
}
