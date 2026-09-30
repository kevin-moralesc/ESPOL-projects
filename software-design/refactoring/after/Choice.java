public interface Choice {
    boolean beats(Choice otherChoice);
    String getName();
}