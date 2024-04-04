import java.util.ArrayList;
import java.util.Collections;

public class CardPlayerLevel1 extends CardPlayer {

    public CardPlayerLevel1(String name, int score, ArrayList<Card> hand) {
        super(name, score, hand);
    }

    @Override
    public Card chooseCard(ArrayList<Card> thisRound, ArrayList<Card> prevRound) {
        Collections.sort(super.getHand());

        Card twoOfClubs = new Card("2", "clubs", 2);

        int index = super.getHand().indexOf(twoOfClubs);

        if (index != -1) {
            return playCard(index);
        }

        if (thisRound.isEmpty()) {
            int randomIndex = (int) (Math.random() * super.getHand().size());
            return playCard(randomIndex);
        }

        String suit = thisRound.get(0).getSuit();
        ArrayList<Card> sameSuit = new ArrayList<>();

        for (Card card : super.getHand()) {
            if (card.getSuit().equals(suit)) {
                sameSuit.add(card);
            }
        }
        
        String heartSuit = "hearts";
        ArrayList<Card> hearts = new ArrayList<>();

        for (Card card : super.getHand()) {
            if (card.getSuit().equals(heartSuit)) {
                hearts.add(card);
            }
        }

        Card queen = new Card("Q", "spades", 12);
        boolean hasQueenSpade = super.getHand().contains(queen);

        if (!sameSuit.isEmpty()) {
            int randomIndex = (int) (Math.random() * sameSuit.size());
            return playCard(super.getHand().indexOf(sameSuit.get(randomIndex)));
        } else if (hasQueenSpade || !hearts.isEmpty()) {
            if (hasQueenSpade) {
                return playCard(super.getHand().indexOf(queen));
            } else {
                return playCard(super.getHand().indexOf(hearts.get(hearts.size() - 1)));
            }
        } else {
            int randomIndex = (int) (Math.random() * super.getHand().size());
            return playCard(randomIndex);
        }
    }
}
