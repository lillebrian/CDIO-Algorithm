import java.lang.reflect.Array;
import java.util.*;

public class Logic {
    public Logic() {
        initialisereKort();
        splitDeck();
        simulateGame();
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
    boolean validMove = true;
    ArrayList<Kort> legalMoves = new ArrayList<>();

    Stack<String> test = new Stack<>();

    public void algo() {
        //Iterate through all indexes in buildStuff
        for (int i = 0; i < 7; i++) {
            //Iterate to compare all other values with the value at i
            for (int j = 0; j < buildStuff.size(); j++) {
                //Cards we use to compare with each other
                Kort comparisonWith = buildStuff.get(i).get(0);
                Kort compareTo = buildStuff.get(j).get(0);


                //First subtract the 2 values from each other to check if the value is 1 since then it's a legal move
                int compareValues = Integer.parseInt(comparisonWith.getNumber()) - Integer.parseInt(compareTo.getNumber());
                //We gotta make sure that the colors aren't the same so that we have Heart 
                if(!containsName(splitInRed, comparisonWith.getType()) && containsName(splitInRed, compareTo.getType()) && compareValues == 1) {
                    System.out.println("Hej jan " + comparisonWith.getType() + comparisonWith.getNumber() + " og den anden " + compareTo.getType() + compareTo.getNumber());
                }
                if(containsName(splitInRed, comparisonWith.getType()) && !containsName(splitInRed, compareTo.getType()) && compareValues == 1) {
                    System.out.println("Hej jan2 " + comparisonWith.getType() + comparisonWith.getNumber() + " og den anden " + compareTo.getType() + compareTo.getNumber());
                }
            }
        }

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

        for (LinkedList<Kort> k : buildStuff) {
            System.out.println("Alt i buildStuff " + k.get(0).getType() + "" + k.get(0).getNumber());

        }

    }




    public boolean containsName(final List<Kort> list, final String name){
        return list.stream().anyMatch(o -> o.getType().equals(name));
    }

}
