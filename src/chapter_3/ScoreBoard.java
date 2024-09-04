package chapter_3;

public class ScoreBoard {
    private int numberOfEntries;
    private GameEntry[] board;
    public ScoreBoard(int capacity) {
        board = new GameEntry[capacity];
        numberOfEntries = 0;
    }

    public void add(GameEntry entry) {
        int newscore = entry.getScore();

        if (numberOfEntries < board.length || newscore > board[numberOfEntries -1].getScore()) {
            if (numberOfEntries < board.length) {
                numberOfEntries++;
            }

            int j = numberOfEntries-1;
            while(j > 0 && newscore > board[j-1].getScore()) {
                board[j] = board[j-1];
                j--;
            }
            board[j] = entry;
        }
    }
}
