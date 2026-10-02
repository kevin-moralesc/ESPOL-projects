package Refactorizado;

public class Scissors implements Choice {
    @Override
    public boolean beats(Choice otherChoice) {
        return otherChoice.getName().equals("paper");
    }

    @Override
    public String getName() {
        return "scissors";
    }
}