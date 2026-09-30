package Refactorizado;

public class Rock implements Choice {
    @Override
    public boolean beats(Choice otherChoice) {
        return otherChoice.getName().equals("scissors");
    }

    @Override
    public String getName() {
        return "rock";
    }
}