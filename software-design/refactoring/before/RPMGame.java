
/*
 * Simulate a game of Rock, Paper, Scissors
 */
public class RPMGame {
    public static void main(String args[]) {
        Player p1 = new Player();
        Player p2 = new Player();
        boolean gameWon = false;
        int roundsPlayed = 0;    // Number of rounds played
        int p1Wins = p1.wins;
        int p2Wins = p2.wins;
        int draw = 0;
        String p1Choice;
        String p2Choice;
        // Game Loop
        do {
            System.out.println("***** Round: " +
                roundsPlayed + " *********************\n");
            System.out.println("Number of Draws: "+
                draw + "\n");
            p1Choice = p1.playerChoice();
            System.out.println("Player 1: " + p1Choice +
                "\t Player 1 Total Wins: " + p1Wins);
            p2Choice = p2.playerChoice();
            System.out.println("Player 2: " + p2Choice+
                "\t Player 2 Total Wins: " + p2Wins);
            if((p1Choice.equals("rock"))&&(p2Choice.equals("paper"))) {
                System.out.println("Player 2 Wins");
                p2Wins++;   // trying a couple different ways to get count to work
            } else if((p1Choice.equals("paper"))&&(p2Choice.equals("rock"))) {
                p1Wins++;
                System.out.println("Player 1 Wins");
            } else if((p1Choice.equals("rock"))&&(p2Choice.equals("scissors"))) {
                p1Wins = p1.setWins();
                System.out.println("Player 1 Wins");
            } else if((p1Choice.equals("scissors"))&&(p2Choice.equals("rock"))) {
                p2Wins = p2.setWins();
                System.out.println("Player 2 Wins");
            } else if((p1Choice.equals("scissors"))&&(p2Choice.equals("paper"))) {
                p1Wins = p1.setWins();
                System.out.println("Player 1 Wins");
            } else if((p1Choice.equals("paper"))&&(p2Choice.equals("scissors"))) {
                p2Wins = p2.setWins();
                System.out.println("Player 2 Wins");
            }
            if(p1Choice==p2Choice) {
                draw++;
                System.out.println("\n\t\t\t Draw \n");
            }
            roundsPlayed++;
            if((p1.getWins()>=3)||(p2.getWins()>=3)) {
                gameWon = true;
                System.out.println("GAME WON");
            }
            System.out.println();
        } while(gameWon != true);
    }
}

class Player{
    int wins;      // # of wins
    int winTotal;
    /**
     * Randomly choose rock, paper, or scissors
     */
    public String playerChoice(){
        String choice = "";
        int c = (int)(Math.random()*3);
        switch(c) {
            case 0:
                choice = ("rock");
                break;
            case 1:
                choice = ("paper");
                break;
            case 2:
                choice = ("scissors");
                break;
        }
        return choice;
    }
    public int setWins() {
        int winTotal = wins++;
        return winTotal;
    }
    public int getWins() {
        return(wins);
    }
}