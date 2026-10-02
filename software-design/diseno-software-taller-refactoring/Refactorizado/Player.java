package Refactorizado;

public class Player implements IPlayer {
    private int wins;
    private String name;

    public Player(String name) {
        this.name = name;
        this.wins = 0;
    }

    @Override
    public Choice makeChoice() {
        int c = (int) (Math.random() * 3);
        switch (c) {
            case 0:
                return new Rock();
            case 1:
                return new Paper();
            case 2:
                return new Scissors();
            default:
                return new Rock();
        }
    }

    @Override
    public void incrementWins() {
        this.wins++;
    }

    @Override
    public int getWins() {
        return this.wins;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
