import java.util.ArrayList;

public class CardGame {
    private Deck deckOfCards;
    private String nameOfGame;
    private ArrayList<CardPlayer> players;
    private int numberOfPlayers;
    private int currentPlayer;

    public CardGame(String nameOfGame, int numberOfPlayers, String[] playerNames, int currentPlayer) {
        this.deckOfCards = new Deck();
        this.nameOfGame = nameOfGame;
        this.numberOfPlayers = numberOfPlayers;
        this.currentPlayer = currentPlayer;
        this.players = new ArrayList<>();

        for (int i = 0; i < getNumberOfPlayers(); i++) {
            players.add(new CardPlayer(playerNames[i], 0, new ArrayList<>()));
        }
    }

    public void deal(int numberOfCards, int playerIndex) {
        CardPlayer player = players.get(playerIndex);
        for (int i = 0; i < numberOfCards; i++) {
            player.addCard(this.deckOfCards.dealTopCard());
        }
    }

    public void playGame() {
        setCurrentPlayerToStartingPlayer();
        ArrayList<Card> gameCards = new ArrayList<>();
        for (int i = 0; i < 13; i++) {
            ArrayList<Card> roundCards = new ArrayList<>();

            int startingPlayer = getCurrentPlayer();
            CardPlayer currentPlayer = players.get(startingPlayer);
            //System.out.println("First Player \n" + currentPlayer);
            Card card = currentPlayer.chooseCard(roundCards, gameCards);
            //System.out.println(card);
            roundCards.add(card);

//            for (int index = 0; index < getNumberOfPlayers(); index++) {
//                if (index != getCurrentPlayer()) {
//                    System.out.println(getPlayers().get(index));
//                    Card choosenCard = getPlayers().get(index).chooseCard(roundCards, gameCards);
//                    System.out.println(choosenCard);
//                    roundCards.add(choosenCard);
//                }
//            }

            for (int index = 1; index < getNumberOfPlayers(); index++) {
                CardPlayer player = players.get((index + startingPlayer) % getNumberOfPlayers());
                //System.out.println(player);
                Card choosenCard = player.chooseCard(roundCards, gameCards);
                //System.out.println(choosenCard);
                roundCards.add(choosenCard);
            }

            int roundWinner = (takesRound(getCurrentPlayer(), roundCards) + startingPlayer) % getNumberOfPlayers();
            //System.out.println("Taken Round Index : " + takesRound(getCurrentPlayer(), roundCards));
            //System.out.println("Round Winner Index : " + roundWinner);

            setCurrentPlayer(roundWinner);
            //System.out.println(roundCards);
            //System.out.println("Winner " + currentPlayer);
            //System.out.println();

            for (Card takenCard : roundCards) {
                getPlayers().get(getCurrentPlayer()).getTakenCards().add(takenCard);
                gameCards.add(takenCard);
            }

            checkRound(roundCards, startingPlayer);
        }

        for (CardPlayer player : players) {
            int score = score4Game(player.getTakenCards());
            player.setScore(player.getScore() + score);

            player.getTakenCards().clear();
        }
    }

    static int errorsInCheckRound;
    public void checkRound(ArrayList<Card> round, int startingPlayer) {
        if (errorsInCheckRound < 5) {
            // System.out.print(startingPlayer + " ");
            String roundSuit = round.get(0).getSuit(); // Suit that was led
            for (int i = 1; i < round.size(); i++) { // for all other cards played in the round
                if (!round.get(i).getSuit().equals(roundSuit)) {
                    CardPlayer player = players.get((i + startingPlayer) % round.size());
                    for (Card c : player.getHand()) { // check each card in that players hand
                        if (c.getSuit().equals(roundSuit)) {
                            System.out.println("*** DID NOT FOLLOW SUIT ***\n round=" + round + "\n played=" + round.get(i) + "\n hand=" + player.getHand());
                                    errorsInCheckRound++;
                            break;
                        }
                    }
                }
            }
        }
    }


    public int takesRound(int playerThatLed, ArrayList<Card> cardsPlayedThisRound) {
//        ArrayList<Integer> indexList = new ArrayList<>();
//        for (int i = 0; i < 4; i++) {
//            indexList.add(i);
//        }
//        indexList.add(0, indexList.remove(playerThatLed));
//        int index = 0;
//        Card suitCard = cardsPlayedThisRound.get(index);
//        for (int i = 1; i < 4; i++) {
//            Card card = cardsPlayedThisRound.get(i);
//            if (card.getSuit().equals(suitCard.getSuit()) && card.getRank() > suitCard.getRank()) {
//                index = i;
//                suitCard = cardsPlayedThisRound.get(index);
//            }
//        }
//        return indexList.get(index);

        int index = 0;
        Card suitCard = cardsPlayedThisRound.get(index);
        for (int i = 0; i < getNumberOfPlayers(); i++) {
            int temp = (i + playerThatLed) % getNumberOfPlayers();
            Card card = cardsPlayedThisRound.get(temp);
            if (card.getSuit().equals(suitCard.getSuit()) && card.getRank() > suitCard.getRank()) {
                index = temp;
                suitCard = cardsPlayedThisRound.get(index);
            }
        }
        return index;
    }

    public int score4Game(ArrayList<Card> cards) {
        int score = 0;
        for (Card card : cards) {
            if (card.getSuit().equals("hearts")) {
                score += 1;
            } else if (card.equals(new Card("Q", "spades", 12))) {
                //System.out.println(card);
                score += 13;
            }
        }
        //score = cards.size() / 2;
        return score;
    }

    public void setCurrentPlayerToStartingPlayer() {
        Card card = new Card("2", "clubs", 2);
        for (int index = 0; index < getNumberOfPlayers(); index++) {
            CardPlayer player = players.get(index);
            if (player.getHand().contains(card)) {
                setCurrentPlayer(index);
                break;
            }
        }
    }


    public Deck getDeckOfCards() {
        return deckOfCards;
    }

    public void setDeckOfCards(Deck deckOfCards) {
        this.deckOfCards = deckOfCards;
    }

    public String getNameOfGame() {
        return nameOfGame;
    }

    public void setNameOfGame(String nameOfGame) {
        this.nameOfGame = nameOfGame;
    }

    public ArrayList<CardPlayer> getPlayers() {
        return players;
    }

    public void setPlayers(ArrayList<CardPlayer> players) {
        this.players = players;
    }

    public int getNumberOfPlayers() {
        return numberOfPlayers;
    }

    public void setNumberOfPlayers(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
    }

    public int getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(int currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public String toString() {
        String output = "***" + nameOfGame + "***" + "\n";
        for (CardPlayer cardPlayer : players) {
            output += cardPlayer + "\n";
        }
        output += "deck -> " + deckOfCards + "\n";
        return output;
    }
}
