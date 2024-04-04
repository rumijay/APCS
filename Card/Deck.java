import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> deck;
    public static final String[] NAMES = {"2","3","4","5","6","7","8","9","T","J","Q","K","A"};
    public static final String[] SUITS = {"clubs", "spades", "hearts", "diamonds"};
    public static final int[] RANKS = {2,3,4,5,6,7,8,9,10,11,12,13,14};


    public Deck() {
        initializeDeck();
    }

    public ArrayList<Card> getDeck() {
        return deck;
    }

    public void setDeck(ArrayList<Card> deck) {
        this.deck = deck;
    }

    public void initializeDeck() {
        deck = new ArrayList<>();
        for (String suit : SUITS) {
            for (int index = 0; index < 13; index ++) {
                deck.add(new Card(NAMES[index], suit, RANKS[index]));
            }
        }
    }

    public Card getCard(int idx) {
        return deck.get(idx);
    }

    public Card dealTopCard() {
        return deck.remove(0);
    }

    public void shuffle() {
        if (deck.isEmpty()) {
            return;
        }

        int range = (int) (Math.random() * 9) + 2;
        int index = (int) (Math.random() * (deck.size() - 1)) + 1;

        while (range > index) {
            range = (int) (Math.random() * 9) + 2;
            index = (int) (Math.random() * (deck.size() - 1)) + 1;
        }

        for (int i = 0; i < range; i++) {
            Card card = dealTopCard();
            deck.add(index, card);
        }
    }

    public void shuffle2() {
        Collections.shuffle(deck);
    }

    @Override
    public String toString() {
        if (deck.isEmpty()) {
            return "No cards in the deck!";
        }
        String output = "";
        for (Card card : deck) {
            output += card;
        }
        return output;
    }
}
