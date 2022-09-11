package Black_jack;
import java.util.Random;
import java.util.Scanner;


class BlackJack {

    public static void main(String[] args) {

        Scanner in= new Scanner(System.in);


        Game game=new Game();
        GUI gui = new GUI();
        gui.runGUI(game.getC(), game.player[0].getCard(), game.player[1].getCard(), game.player[2].getCard(), game.player[3].getCard());


        /************* the first three players *************/
        int t;
        for(int i=0;i<3;i++){

            System.out.println("*************************\n"+game.player[i].getName()+"'s turn:");
            System.out.println("your current score: "+game.player[i].getScore());
            System.out.println("make your decision:");
            System.out.println("1)Hit\n2)stand");
            t=in.nextInt();
            if(t==1)
            {
                while(t==1)
                {   System.out.println("Dealer will give you a card");
                    Card hitt=game.hit(game.player[i]);
                    gui.updatePlayerHand(hitt, i);
                    System.out.println("your new score: "+game.player[i].getScore());
                    if(game.player[i].busted)
                    {
                        System.out.println("you are busted");
                        break;
                    }
                    System.out.println("make your decision:");
                    System.out.println("1)Hit\n2)stand");
                    t=in.nextInt();
                }

            }
        }




        /************* the fourth player *************/

        while(true){
            Card hitt = game.hit(game.player[3]);
            gui.updateDealerHand(hitt, game.getC());
            if(game.player[3].getBlack() || game.player[3].getScore()>=game.getMaxScore() || game.player[3].busted)
            {
                break;
            }
        }
        System.out.println("Dealer("+game.player[3].getName()+")'s score: "+game.player[3].getScore());
        System.out.println("\n\nThe game ended:");
        /*********************** The end of the game *****************************/
        game.endGame();

    }

}
