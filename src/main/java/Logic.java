import java.lang.reflect.Array;
import java.util.*;

public class Logic {
    public Logic() {
        initialisereKort();
        algo();
    }

    ArrayList<Kort> deck = new ArrayList<>(52);

    public void initialisereKort() {
        int i = 0;
        for (int type = 0; type <= 3; type++) {
            for (int nummer = 0; nummer < 13; nummer++) {
                deck.add(i, new Kort(type, nummer));
            }
        }
        printDeck();
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
    ArrayList<Kort> splitInBlack = new ArrayList<>();
    ArrayList<Kort> splitInRed = new ArrayList<>();

    Stack<String> test = new Stack<>();

    public void algo() {

    }

    public void splitDeck(){
        for (int i = 0; i < deck.size(); i++) {
            if(deck.get(i).getType().equals("S") || deck.get(i).getType().equals("C")){
                splitInBlack.add(deck.get(i));
            } else {
                splitInRed.add(deck.get(i));
            }
        }

        for (int i = 0; i < splitInRed.size(); i++) {
            System.out.println(splitInRed.get(i).getType() + splitInRed.get(i).getNumber());
        }
    }

    public void simulateGame() {

        Random rn = new Random();

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

    }

}
