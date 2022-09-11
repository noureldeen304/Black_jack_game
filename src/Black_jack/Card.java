package Black_jack;

public class Card {
    //Attributes
    private int suit;
    private int rank;
    private int value;


    Card () {

    }
    Card(int suit, int rank, int value) {
        this.suit = suit;
        this.rank = rank;
        this.value = value;
    }
    Card (Card obj) {
        this.suit = obj.suit;
        this.rank = obj.rank;
        this.value = obj.value;
    }

    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }

    public int getValue() {
        return value;
    }

    public void setSuit(int suit) {
        this.suit = suit;
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
