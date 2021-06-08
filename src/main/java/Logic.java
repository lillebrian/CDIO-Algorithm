import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Logic {
    public Logic() {
        initialisereKort();
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
    ArrayList<LinkedList<String>> buildStak = new ArrayList<>();
    ArrayList<String> bunken = new ArrayList<>();
    ArrayList<ArrayList<String>> suitStak = new ArrayList<>();

    Stack<String> test = new Stack<>();

    public void algo() {
        LinkedList<String> temp = new LinkedList<>();
        buildStak.add(temp);

    }
}
