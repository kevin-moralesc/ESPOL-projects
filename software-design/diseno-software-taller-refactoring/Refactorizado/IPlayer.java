package Refactorizado;

public interface IPlayer {
    Choice makeChoice();
    void incrementWins();
    int getWins();
    String getName();
}