
public class TennisGame1 implements TennisGame {

    private int playerOneScore = 0;
    private int playerTwoScore = 0;
    private final String playerOneName;
    private final String playerTwoName;

    public TennisGame1(String playerOneName, String playerTwoName) {
        this.playerOneName = playerOneName;
        this.playerTwoName = playerTwoName;
    }

    public void wonPoint(String playerName) {
        if (playerOneName.equals(playerName)) playerOneScore++;
        else playerTwoScore++;
    }

    public String getScore() {
        if (isDeuce()) return "Deuce";
        if (advantagePlay()) {
            int scoreDifference = playerOneScore - playerTwoScore;
            if (scoreDifference == 1) return "Advantage player1";
            else if (scoreDifference == -1) return "Advantage player2";
            else if (scoreDifference >= 2) return "Win for player1";
            else return "Win for player2";
        }

        if (isPair()) return translateScoreToString(playerOneScore) + "-All";

        return translateScoreToString(playerOneScore) + "-" + translateScoreToString(playerTwoScore);
    }

    private String translateScoreToString(int score) {
        switch (score) {
            case 0:
                return "Love";
            case 1:
                return "Fifteen";
            case 2:
                return "Thirty";
            case 3:
                return "Forty";
            default:
                return "";
        }
    }

    private boolean isDeuce() {
        return playerOneScore >= 3 && playerOneScore == playerTwoScore;
    }

    private boolean isPair() {
        return playerOneScore == playerTwoScore;
    }

    private boolean advantagePlay() {
        return playerOneScore >= 4 || playerTwoScore >= 4;
    }
}
