import java.util.ArrayList;

public class TestCardPlayer {
    public static void main(String[] args) {
        CardPlayer cardPlayer = new CardPlayer("Kara Jones", 0, new ArrayList<>());
        System.out.println("New CardPlayer -> " + cardPlayer);

        cardPlayer.addCard(new Card("2", "clubs", 2));
        cardPlayer.addCard(new Card("A", "hearts", 14));
        cardPlayer.addCard(new Card("3", "clubs", 3));
        cardPlayer.addCard(new Card("3", "diamonds", 3));
        cardPlayer.addCard(new Card("7", "spades", 7));
        cardPlayer.addCard(new Card("6", "spades", 6));
        System.out.println("After adding 6 specific cards. Player -> " + cardPlayer);

        System.out.println("Played " + cardPlayer.playCard(5) + " at index 5.");

        cardPlayer.updateScore(27);
        System.out.println("Updated score to " + cardPlayer.getScore() + " points.");

        System.out.println("Player -> " + cardPlayer);

        ArrayList<Card> gameCards = new ArrayList<>();
        ArrayList<Card> roundCards = new ArrayList<>();

        System.out.println("Cards played in round -> " + roundCards);
        System.out.println("Cards played in game -> " + gameCards);

        Card card = cardPlayer.chooseCard(roundCards, gameCards);
        System.out.println("Chose " + card.getName() + " of " + card.getSuit() + " -> " + card);

        System.out.println("Player -> " + cardPlayer);

        roundCards.add(new Card("T", "spades", 10));
        System.out.println("Cards played in round -> " + roundCards);

        Card card2 = cardPlayer.chooseCard(roundCards, gameCards);
        System.out.print("RANDOMLY chosen spade -> " + card2);
        System.out.print(" Player -> " + cardPlayer);

        roundCards.clear();
        roundCards.add(new Card("9", "clubs", 9));
        System.out.println("Cards played in round -> " + roundCards);

        Card card3 = cardPlayer.chooseCard(roundCards, gameCards);
        System.out.print("heart chosen -> " + card3);
        System.out.println(" Player -> " + cardPlayer);

        roundCards.clear();
        System.out.println("Cards played in round -> " + roundCards);

        Card card4 = cardPlayer.chooseCard(roundCards, gameCards);
        System.out.print("RANDOMLY chosen card -> " + card4);
        System.out.print(" Player -> " + cardPlayer);
    }
}
