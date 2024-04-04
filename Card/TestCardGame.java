import java.util.ArrayList;

public class TestCardGame {
    public static void printDetails(CardGame game) {
        int[] scores = new int[4];
        int totalPoints = 0;
        for (int i = 0; i < 4; i++) {
            CardPlayer cardPlayer = game.getPlayers().get(i);
            scores[i] = cardPlayer.getScore();
            totalPoints += scores[i];
        }

        System.out.println("\nTotal Number of bad points = " + totalPoints);
        for (Player player : game.getPlayers()) {
            System.out.printf("\t%s %d %.2f%%\n", player.getName(), player.getScore(), (float) player.getScore() * 100 / totalPoints);
        }
    }

    public static void playGameNTimes(int n, CardGame game, boolean eachPlayer, boolean newShuffle) {
        for (int g = 0; g < n; g++) {
            game.getDeckOfCards().initializeDeck();

            if (newShuffle) {
                game.getDeckOfCards().shuffle2();
            } else {
                for (int i = 0; i < 10; i++) {
                    game.getDeckOfCards().shuffle();
                }
            }

            for (int index = 0; index < 4; index++) {
                game.deal(13, index);
            }

            game.playGame();

            if (eachPlayer) {
                for (int k = 0; k < 4; k++) {
                    System.out.printf("%s %2d ", game.getPlayers().get(k).getName(), game.getPlayers().get(k).getScore());
                }
                System.out.println();
            }
        }
    }

    public static void main(String[] args) {
        String[] playerNames = new String[] {"Player0", "Player1", "Player2", "Player3"};
        CardGame game = new CardGame("Hearts", 4, playerNames, 0);
        System.out.println(game);

        System.out.println("\n4 CardPlayer players 4 games and current shuffle()");
        playGameNTimes(4, game, true, false);
        printDetails(game);

        System.out.println("\n4 CardPlayer players 20000 games and current shuffle()");
        game = new CardGame("Hearts", 4, playerNames, 0);
        playGameNTimes(20000, game, false, false);
        printDetails(game);

        System.out.println("\n4 CardPlayer players 20000 games and NEW shuffle().");
        game = new CardGame("Hearts", 4, playerNames, 0);
        playGameNTimes(20000, game, false, true);
        printDetails(game);

        System.out.println("\n4 CardPlayerLevel1 players 20000 games and NEW shuffle().");
        game = new CardGame("Hearts", 4, playerNames, 0);
        for (int i = 0; i < 4; i++) {
            game.getPlayers().set(i, new CardPlayerLevel1(playerNames[i], 0, new ArrayList<>()));
        }
        playGameNTimes(20000, game, false, true);
        printDetails(game);

        System.out.println("\n2 CardPlayer & 2 CardPlayerLevel1 players 20000 games and NEW shuffle()");
        game = new CardGame("Hearts", 4, playerNames, 0);

        game.getPlayers().set(2, new CardPlayerLevel1(playerNames[2], 0, new ArrayList<>()));
        game.getPlayers().set(3, new CardPlayerLevel1(playerNames[3], 0, new ArrayList<>()));

        playGameNTimes(20000, game, false, true);
        printDetails(game);
    }
}
