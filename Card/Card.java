public class Card implements Comparable<Object> {
    private String name = "name";
    private String suit = "suit";
    private int rank = 0;

    // default 
    public Card() {
        name = "default";
        suit = "default";
        rank = 0;
    }

    // initialization
    public Card(String inName, String inSuit, int inRank) {
        name = inName;
        suit = inSuit;
        rank = inRank;
    }

    //accessor
    public String getName() {
        return name;
    }

    public String getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    // mutator 
    public void setName(String in) {
        name = in;
    }

    public void setSuit(String in) {
        suit = in;
    }

    public void setRank(int in) {
        rank = in;
    }

    // equals
    public boolean equals(Object obj) {
        Card cardj = (Card) (obj);
        if (obj == null) {
            return false;
        }
        if ((cardj.getName().equals(getName())) && (cardj.getSuit().equals(getSuit())) && (cardj.getRank() == getRank())) {
            return true;
        } else {
            return false;
        }
    }

    // compareTo 
    public int compareTo(Object obj) {
        Card cardj = (Card) (obj);

        int objsuitrank = 0;
        if (cardj.getSuit() == "clubs") {
            objsuitrank = 3;
        }
        if (cardj.getSuit() == "spades") {
            objsuitrank = 2;
        }
        if (cardj.getSuit() == "hearts") {
            objsuitrank = 1;
        }
        if (cardj.getSuit() == "diamonds") {
            objsuitrank = 0;
        }

        if (getName() == "T") {
            rank = 10;
        }
        if (getName() == "J") {
            rank = 11;
        }
        if (getName() == "Q") {
            rank = 12;
        }
        if (getName() == "K") {
            rank = 13;
        }
        if (getName() == "A") {
            rank = 14;
        }

        int suitRank = 0;
        if (getSuit() == "diamonds") {
            suitRank = 0;
        }
        if (getSuit() == "hearts") {
            suitRank = 1;
        }
        if (getSuit() == "spades") {
            suitRank = 2;
        }
        if (getSuit() == "clubs") {
            suitRank = 3;
        }


        int objrank = cardj.getRank();
        if (cardj.getName() == "T") {
            objrank = 10;
        }
        if (cardj.getName() == "J") {
            objrank = 11;
        }
        if (cardj.getName() == "Q") {
            objrank = 12;
        }
        if (cardj.getName() == "K") {
            objrank = 13;
        }
        if (cardj.getName() == "A") {
            objrank = 14;
        }


        if (suitRank > objsuitrank) {
            return 1;

        } else if (suitRank < objsuitrank) {
            return -1;

        } else if (suitRank == objsuitrank) {

            if (rank > objrank) {
                return 1;

            } else if (rank < objrank) {
                return -1;

            } else if (rank == objrank) {
                return 0;

            } else {
                return 0;
            }
        } else {
            return 0;
        }

    }

    // toString
    public String toString() {
        return (getSuit().charAt(0) + getName() + "(" + getRank() + ")");
    }
}
    

