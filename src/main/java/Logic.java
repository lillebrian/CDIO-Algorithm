import com.sun.org.glassfish.gmbal.ParameterNames;

import java.util.*;

public class Logic {

    public Logic() {
        initialisereKort();
        simulateGame(true);

    }

    ArrayList<Kort> deck = new ArrayList<>(52);

    public void initialisereKort() {
        int i = 0;
        for (int type = 0; type <= 3; type++) {
            for (int nummer = 0; nummer < 13; nummer++) {
                deck.add(i, new Kort(type, nummer));
            }
        }
//        printDeck();
    }

    public void printDeck() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.println("Kortet: " + deck.get(i).type + " " + deck.get(i).number);
        }
    }


    /*********** ALGORITME ARBEJDE ***********/
    // Build stak a

    ArrayList<Kort> suitStak = new ArrayList<>();
    ArrayList<LinkedList<Kort>> buildStuff= new ArrayList<>();
    ArrayList<Kort> talon = new ArrayList<>();

    Stack<String> test = new Stack<>();


    public void algo() {


    }




    /* SIMULATING RANDOM CARDS FOR TESTING PURPOSES */
    /* @author*/
    public void simulateGame(boolean wantRandom) {
        Random rn = new Random();
        if (wantRandom) {
            rn.setSeed(69420);
        }

        for (int i = 0; i < 7; i++) {
            LinkedList<Kort> tempInsert = new LinkedList<>();
            int tempValue = rn.nextInt(deck.size());
            tempInsert.add(deck.get(tempValue));
            deck.remove(tempValue);
            buildStuff.add(i,tempInsert);
        }

        for(int i = 0; i < 24; i++){
            int tempValue = rn.nextInt(deck.size());
            talon.add(deck.get(tempValue));
            deck.remove(tempValue);
        }

        System.out.println("BUILD STACKS: \n");
        for (LinkedList<Kort> k : buildStuff) {
            System.out.println(k.get(0).getType() + " " + k.get(0).getNumber());

        }
        System.out.println("\n TALON:");
        for (Kort k : talon) {
            System.out.println(k.getType() + " " + k.getNumber());
        }

    }

}
