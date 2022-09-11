package Black_jack;

public class Players {

    private String name;
    private int score;
    private Card[] card=new Card[10];

    public Card[] getCard() {
        return card;
    }

    private boolean black= false;
    public boolean busted= false;
    private int count=0;


    Players(){
        this.name="";
        this.score=0;
        black= false;
        busted= false;
    }
    Players(String name) {
        this.name = name;
        score=0;
    }
    Players(Players obj){
        this.name=obj.getName();
        this.score=obj.getScore();
        this.black=obj.getBlack();
    }

    public void hitcard(Card hittedcard){

        this.score+=hittedcard.getValue();
        this.card[count]=new Card(hittedcard);
        count++;
        if(this.score==21)
            this.black=true;
        if(this.score>21)
        {
            busted=true;
        }

    }

    public boolean getBlack(){
        return black;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
