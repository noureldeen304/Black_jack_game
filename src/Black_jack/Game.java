package Black_jack;

import java.util.Random;
import java.util.Scanner;

class Game {
    Scanner in=new Scanner(System.in);

    Card[] c= new Card[52]; //cards
    Players[] player=new Players[4]; // players
    private Players[] maxscoreplayers = new Players[2];

    private int maxScore =0;

    Game() {
        this.generate();
        maxscoreplayers[0]=new Players();
        maxscoreplayers[1]=new Players();
        String name;int max=0,max2=0;
        for(int i=0;i<4;i++)
        {
            System.out.println("Player "+(i+1)+" enter your name: ");
            name=in.nextLine();
            this.player[i]=new Players(name);
            this.hit(this.player[i]);
            this.hit(this.player[i]);
            if(player[i].getScore()> maxScore && !player[i].busted)
            {
                maxScore =player[i].getScore();
                if(player[i].getScore()>max && player[i].getScore()>max2)
                {
                    max=player[i].getScore();
                    maxscoreplayers[0]=new Players(player[i]);
                }
                else if(player[i].getScore()<=max && player[i].getScore()>max2)
                {
                    max2=player[i].getScore();
                    maxscoreplayers[1]=new Players(player[i]);
                }

            }


        }


    }

    public Card[] getC() {
        return c;
    }



    public void generate(){
        // Generation the deck
        int[] v=new int[13];// values of cards
        for(int i=0;i<13;i++)
        {
            if(i<9)
                v[i]=i+1;
            else
                v[i]=10;
        }
        int s=0;
        int r=0;
        for(int i=0;i<52;i++)
        {

            c[i]= new Card(s,r,v[r]);
            if((i+1)%13==0)
            {
                s++; r=0;
            }
            else
                r++;

        }


    }

    public Card hit(Players player){
        Random random=new Random();
        Card HittedCard=new Card();
        int randomindex;
        do
        {
            randomindex =random.nextInt(52);
            HittedCard=(Card) c[randomindex];

        }while(HittedCard==null);

        player.hitcard(HittedCard);

        if(player.getScore()>= maxScore && player.getScore()<=21)
        {
            maxScore =player.getScore();
        }
        c[randomindex]= null;
        return HittedCard;
    }

    public int getMaxScore(){
        return this.maxScore;
    }

    public int NumberOfBusted(){
        int count=0;
        for(int i=0;i<4;i++)
        {
            if(this.player[i].getScore()>21)
                count++;
        }
        return count;
        //return this.player[0].busted && this.player[1].busted && this.player[2].busted && this.player[3].busted;


    }

    public void endGame(){

        if(this.NumberOfBusted()<=2){
            int max=0;
            int max2=0;
            for(int i=0;i<4;i++)
            {
                if(!this.player[i].busted){
                    if(this.player[i].getScore()>max && this.player[i].getScore()>max2)
                    {
                        max=this.player[i].getScore();
                        maxscoreplayers[0]= new Players(player[i]);
                    }

                    else if (this.player[i].getScore()<= max && this.player[i].getScore()>max2)
                    {
                        max2=this.player[i].getScore();
                        maxscoreplayers[1]=new Players(player[i]);
                    }
                }
            }
            /***********************************************/
            if(this.maxscoreplayers[1].getScore() == this.maxscoreplayers[0].getScore())
            {
                System.out.println("Pushed");
            }

            else if(this.maxscoreplayers[1].getScore() > this.maxscoreplayers[0].getScore())
            {
                if(this.maxscoreplayers[1].getBlack())
                    System.out.println(this.maxscoreplayers[1].getName()+" won and had a BlackJack");
                else
                {
                    System.out.println(this.maxscoreplayers[1].getName()+" won with maximum score");
                }
            }
            else if(this.maxscoreplayers[1].getScore() < this.maxscoreplayers[0].getScore())
            {
                if(this.maxscoreplayers[0].getBlack())
                    System.out.println(this.maxscoreplayers[0].getName()+" won and had a BlackJack");
                else
                {
                    System.out.println(this.maxscoreplayers[0].getName()+" won with maximum score");
                }
            }
        }

        /******************************************************************************************/




        else if(this.NumberOfBusted()==3)
        {
            for(int i=0;i<4;i++)
            {
                if(!this.player[i].busted)
                {
                    this.maxscoreplayers[0]=new Players(player[i]);
                }
            }

            if(maxscoreplayers[0].getBlack())
                System.out.println(maxscoreplayers[0].getName()+" won and had a BlackJack");
            else
                System.out.println(this.maxscoreplayers[0].getName()+" won with maximum score");
        }





        /******************************************************************************************/

        else
            System.out.println("All players are busted,there is now winner");
    }


}
