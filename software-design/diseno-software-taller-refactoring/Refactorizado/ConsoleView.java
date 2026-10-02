package Refactorizado;

public class ConsoleView {
    
    public void printRoundHeader(int round, int draws) {
        System.out.println("***** Round: " + round + " *********************\n");
        System.out.println("Number of Draws: " + draws + "\n");
    }

    public void printPlayerChoice(String playerName, String choiceName, int totalWins) {
        // Usamos \t para las tabulaciones requeridas en tu salida
        System.out.println(playerName + ": " + choiceName + "\t " + playerName + " Total Wins: " + totalWins);
    }

    public void printRoundWinner(String winnerName) {
        System.out.println(winnerName + " Wins\n");
    }

    public void printDraw() {
        System.out.println("\n\t\t\t Draw \n");
    }

    public void printGameWon() {
        System.out.println("GAME WON");
    }
}