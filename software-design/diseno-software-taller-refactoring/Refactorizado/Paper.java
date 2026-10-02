package Refactorizado;

public class Paper implements Choice {
    @Override
    public boolean beats(Choice otherChoice) {
        return otherChoice.getName().equals("rock");
    }

    @Override
    public String getName() {
        return "paper";
    }
}