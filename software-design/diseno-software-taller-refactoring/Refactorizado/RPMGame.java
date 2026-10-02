package Refactorizado;

public class RPMGame {
    private IPlayer player1;
    private IPlayer player2;
    private ConsoleView view;
    private int roundsPlayed;
    private int draws;

    public RPMGame() {
        this.player1 = new Player("Player 1");
        this.player2 = new Player("Player 2");
        this.view = new ConsoleView();
        this.roundsPlayed = 0;
        this.draws = 0;
    }

    public static void main(String[] args) {
        RPMGame game = new RPMGame();
        game.playGame();
    }

    public void playGame() {
        boolean gameWon = false;
        
        do {
            playRound();
            if (isGameWon()) {
                gameWon = true;
                view.printGameWon();
            }
        } while (!gameWon);
    }

    private void playRound() {
        view.printRoundHeader(roundsPlayed, draws);

        Choice p1Choice = player1.makeChoice();
        view.printPlayerChoice(player1.getName(), p1Choice.getName(), player1.getWins());

        Choice p2Choice = player2.makeChoice();
        view.printPlayerChoice(player2.getName(), p2Choice.getName(), player2.getWins());

        determineRoundWinner(player1, p1Choice, player2, p2Choice);
        
        roundsPlayed++;
    }

    private void determineRoundWinner(IPlayer p1, Choice c1, IPlayer p2, Choice c2) {
        if (c1.getName().equals(c2.getName())) {
            draws++;
            view.printDraw();
        } else if (c1.beats(c2)) {
            p1.incrementWins();
            view.printRoundWinner(p1.getName());
        } else {
            p2.incrementWins();
            view.printRoundWinner(p2.getName());
        }
    }

    private boolean isGameWon() {
        return player1.getWins() >= 3 || player2.getWins() >= 3;
    }
}