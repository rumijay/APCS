import java.util.ArrayList;
import java.util.Collections;

public class CardPlayer extends Player {
    private ArrayList<Card> hand;
    private ArrayList<Card> takenCards;
    public CardPlayer(String name, int score, ArrayList<Card> hand) {
        super(name, score);
        this.hand = hand;

        // Creating a arraylist object
        ArrayList<Card> cards = new ArrayList<>();
        // Assigning arraylist object to takenCards
        takenCards = cards;
    }

    public ArrayList<Card> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) {   
        this.hand = hand;
    }

    public ArrayList<Card> getTakenCards() {  
        return takenCards;
    }

    public void setTakenCards(ArrayList<Card> takenCards) {
        this.takenCards = takenCards;
    }

    public void addCard(Card card) {
        hand.add(card);
    }

    public Card playCard(int index) {
        return hand.remove(index);
    }

    public Card chooseCard(ArrayList<Card> thisRound, ArrayList<Card> prevRound) {
        Card twoOfClubs = new Card("2", "clubs", 2);

        int index = hand.indexOf(twoOfClubs);

        if (index != -1) {
            return playCard(index);
        }

        if (thisRound.isEmpty()) {
            int randomIndex = (int) (Math.random() * hand.size());
            return playCard(randomIndex);
        }

        String suit = thisRound.get(0).getSuit();
        ArrayList<Card> sameSuit = new ArrayList<>();

        for (Card card : hand) {
            if (card.getSuit().equals(suit)) {
                sameSuit.add(card);
            }
        }

        String heartSuit = "hearts";
        ArrayList<Card> hearts = new ArrayList<>();

        for (Card card : hand) {
            if (card.getSuit().equals(heartSuit)) {
                hearts.add(card);
            }
        }

        if (!sameSuit.isEmpty()) {
            int randomIndex = (int) (Math.random() * sameSuit.size());
            return playCard(hand.indexOf(sameSuit.get(randomIndex)));
        } else if (!hearts.isEmpty()) {
            int randomIndex = (int) (Math.random() * hearts.size());
            return playCard(hand.indexOf(hearts.get(randomIndex)));
        } else {
            int randomIndex = (int) (Math.random() * hand.size());
            return playCard(randomIndex);
        }
    }

    @Override
    public String toString() {
        Collections.sort(hand);
        return super.toString() + " " + hand;
    }
}
