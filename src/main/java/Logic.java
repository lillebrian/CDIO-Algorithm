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

    LinkedList<String> buildStak = new LinkedList<String>();
    ArrayList<String> bunken = new ArrayList<>();
    ArrayList<String> suitStak = new ArrayList<>();
    ArrayList<LinkedList<Kort>> buildStuff= new ArrayList<LinkedList<Kort>>();

    Stack<String> test = new Stack<>();

    public void algo() {

        Random rn = new Random();

        LinkedList<Kort> tempInsert = new LinkedList<>();
        for (int i = 0; i < 7; i++) {
            tempInsert.add(deck.get(rn.nextInt(52)));
        }
        for (int i = 0; i < tempInsert.size(); i++) {
            System.out.println(tempInsert.get(i).getType() + tempInsert.get(i).getNumber());
        }



        System.out.println(buildStuff.get(0).size());

    }


}
