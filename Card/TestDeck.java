public class TestDeck {
    private static void dealCards(Deck deck) {
        for (int i = 0; i < 13; i++) {
            System.out.print(deck.dealTopCard());
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Deck deck = new Deck();

        System.out.println("create a deck object using the default constructor and print it");
        System.out.println(deck);

        deck.shuffle();
        System.out.println("shuffle the deck and print the deck object");
        System.out.println(deck);

        System.out.println("deal a card and printing it (13 times)");
        dealCards(deck);

        System.out.println("39 cards remaining. Printing deck object.");
        System.out.println(deck);

        System.out.println("deal a card and printing it (13 times)");
        dealCards(deck);

        System.out.println("26 cards remaining. Printing deck object.");
        System.out.println(deck);

        System.out.println("deal a card and printing it (13 times)");
        dealCards(deck);

        System.out.println("13 cards remaining. Printing deck object.");
        System.out.println(deck);

        System.out.println("deal a card and printing it (13 times)");
        dealCards(deck);

        System.out.println("0 cards remaining. Printing deck object.");
        System.out.println(deck);

        Deck newDeck = new Deck();
        int randomIndex = (int) (Math.random() * 52);
        Card card = newDeck.getCard(randomIndex);
        System.out.println("\nRandom card from new deck " + card);
        int count = 0;
        for (int i = 0; i < 52000; i++) {
            if (newDeck.getCard(27).equals(card)) {
                count++;
            }
            newDeck.shuffle();
        }
        System.out.println("Found " + card + " at location 27 in the deck " + count + " times out of 52000 shuffles.");

    }
}
