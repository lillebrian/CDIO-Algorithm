import java.lang.reflect.Array;
import java.sql.SQLOutput;
import java.util.*;

public class Logic {
    public Logic() {
    }

    public void run () {
        initialisereKort();
        splitDeck();
        simulateGame(true);
        algo();
    }

    ArrayList<Kort> deck = new ArrayList<>(52);
    public void initialisereKort() {
        int i = 0;
        for (int type = 0; type <= 3; type++) {
            for (int nummer = 1; nummer <= 13; nummer++) {
                deck.add(i, new Kort(type, nummer));
            }
        }
//        printDeck();
    }

    public void printDeck() {
        for (int i = 0; i < deck.size(); i++) {
            System.out.println("Kortet: " + deck.get(i).getTypeIcon() + " " + deck.get(i).getNumber());
        }
    }




    /*********** ALGORITME ARBEJDE ***********/


    ArrayList<LinkedList<Kort>> suitStak = new ArrayList<>();
    ArrayList<LinkedList<Kort>> buildStuff = new ArrayList<>();
    ArrayList<Kort> talon = new ArrayList<>();
    ArrayList<Kort> splitInBlack = new ArrayList<>();
    ArrayList<Kort> splitInRed = new ArrayList<>();
    boolean validMove = true;
    ArrayList<Moves> legalMoves = new ArrayList<>();



    public void algo() {
        findLegalMoves(buildStuff, talon);


        /* Method for choosing the move with the highest value (points) */
//        int value = 0;
//        Moves correct = null;
//        for (Moves m : legalMoves) {
//            if (correct == null) {
//                correct = m;
//            }
//            if (m.valueOfMoves < value) {
////                value = m.valueOfMoves;
//                correct = m;
//            }
//        }
//        try {
//            System.out.println(nextMove(correct));
//        } catch (Exception e) {
//            System.out.println("error in try catch: " + e);
//        }
        /* TEST PRINT*/
        for (Moves m : legalMoves) {
            System.out.println("\nPRINTING LEGAL MOVES");
            System.out.println(nextMove(m));
        }
    }


    public void findLegalMoves(ArrayList<LinkedList<Kort>> BuildStacks, ArrayList<Kort> Talon) {
        /* TESTING FOR ONE ITERATION ONLY ATM SO CLEARING BEFORE ITERATING */
        legalMoves.clear();

        /*
        *  1 : CAN CARD BE MOVED TO SUIT STACK?
        *  2 : CAN CARD BE MOVED TO BUILD STACK?
        *  3 : CAN TALON CARD BE MOVED TO CARD?
        *
        * RUN FOR DEPTH OF MOVES AFTER
        */


        /* NOT COMPLETE. LOOP USED FOR MOVE DETECTION */
        System.out.println("PRINTING SUIT STACKS\n" + suitStak);
        for (int i = 0; i < 7; i++) {
            Kort single = BuildStacks.get(i).getFirst();
            Kort blok = BuildStacks.get(i).getLast();
            isMovableToSuit(BuildStacks, single);
            searchTalon(Talon, single);
        }







        for (int i = 0; i < 7; i++) {
            //Iterate to compare all other values with the value at i

            for (int j = 0; j < buildStuff.size(); j++) {
                //Cards we use to compare with each other
                Kort comparisonWith = buildStuff.get(i).get(0);
                Kort compareTo = buildStuff.get(j).get(0);

                //First subtract the 2 values from each other to check if the value is 1 since then it's a legal move
                int compareValues = comparisonWith.getNumber() - compareTo.getNumber();

                /* DOING THE SAME FOR THE TALON */




                /* BUILD STACKS */
                //We gotta make sure that the colors aren't the same so that we have Heart
                if (!containsName(splitInRed, comparisonWith.getType()) && containsName(splitInRed, compareTo.getType()) && compareValues == 1) {
                    System.out.println("VALID MOVE IN BUILDSTACK: " + comparisonWith.getTypeIcon() + comparisonWith.getNumber() + " WITH " + compareTo.getTypeIcon() + compareTo.getNumber());

                    /* ADDS THE MOVE FOR LATER CHOOSING */
                    Moves newMove = new Moves();
                    newMove.addLegalMove(comparisonWith, compareTo, 1);
                    legalMoves.add(newMove);

                }

                /* BUILD STACKS */
                if (containsName(splitInRed, comparisonWith.getType()) && !containsName(splitInRed, compareTo.getType()) && compareValues == 1) {
                    System.out.println("VALID MOVE IN BUILDSTACK: " + comparisonWith.getTypeIcon() + comparisonWith.getNumber() + " WITH " + compareTo.getTypeIcon() + compareTo.getNumber());

                    /* ADDS THE MOVE FOR LATER CHOOSING */
                    Moves newMove = new Moves();
                    newMove.addLegalMove(comparisonWith, compareTo, 1);
                    legalMoves.add(newMove);
                }

            }
        }
    }



    public void isMovableToSuit (ArrayList<LinkedList<Kort>> suits, Kort compare) {
        for (LinkedList<Kort> k : suits) {
            if (compare.getNumber() - k.getLast().getNumber() == 1 && compare.getType().equals(k.getLast().getType())){
                System.out.println(compare + " Is movable to suit");
                /* DO FOR DEPTH LATER */
                Moves newMove = new Moves();
                newMove.addLegalMove(compare, k.getLast(), 10);
                legalMoves.add(newMove);
            }
        }
    }

    /* USED TO DETERMINE IF A CARD IN THE TALON CAN BE MOVED TO A STACK */
    public void searchTalon (ArrayList<Kort> talon, Kort compare) {
        Kort talonPos;
        for (int i = 0; i < talon.size(); i++) {
            talonPos = talon.get(i);
            if(compare.getNumber() - talonPos.getNumber() == 1  &&  compare.getColor() != talonPos.getColor()) {
                System.out.println("test af search talon \n VALID MOVE IN TALON: " + talonPos + " -> " + compare);
                Moves newMove = new Moves();
                newMove.addLegalMove(compare, talonPos, 1);
                legalMoves.add(newMove);
            }
            isMovableToSuit(suitStak, compare);
        }
    }

    public void searchBuildStacks (ArrayList<LinkedList<Kort>> bs, Kort compare) {




    }



    /* RETURN METHOD FOR WHAT THE NEXT MOVE IS IN STRING FORMAT (USED FOR VISUAL REPRESENTATION FOR THE APP) */
    public String nextMove(Moves m) {
        String move = m.LegalMoves.get(1).toString() + " -> " + m.LegalMoves.get(0).toString();
        String intersect = ": ";
        String value = String.valueOf(m.valueOfMoves);
        return value + intersect + move;
    }


    /* USED TO SPLIT THE DECK INTO DARK SUITS AND RED SUITS */
    public void splitDeck(){
        for (int i = 0; i < deck.size(); i++) {
            if(deck.get(i).getType().equals("S") || deck.get(i).getType().equals("C")){
                splitInBlack.add(deck.get(i));
            } else {
                splitInRed.add(deck.get(i));
            }
        }

        for (int i = 0; i < splitInRed.size(); i++) {
            System.out.println(splitInRed.get(i).getTypeIcon() + splitInRed.get(i).getNumber());
            System.out.println(splitInBlack.get(i).getTypeIcon() + splitInBlack.get(i).getNumber());
        }
    }


    /* USED TO SIMULATE SOLITAIRE FOR TESTING PURPOSES */
    public void simulateGame(boolean wantSetValues) {
        Random rn = new Random();
        if(wantSetValues){
            rn.setSeed(69420);
        }

        /* THE SEVEN BUILD STACKS */
        for (int i = 0; i < 7; i++) {
            LinkedList<Kort> tempInsert = new LinkedList<>();
            int tempValue = rn.nextInt(deck.size());
            tempInsert.add(deck.get(tempValue));
            deck.remove(tempValue);
            buildStuff.add(i,tempInsert);
        }

        /* THE TALON */
        for(int i = 0; i < 24; i++){
            int tempValue = rn.nextInt(deck.size());
            talon.add(deck.get(tempValue));
            deck.remove(tempValue);
        }

        for (LinkedList<Kort> k : buildStuff) {
            System.out.println("Alt i buildStuff " + k.get(0).getTypeIcon() + "" + k.get(0).getNumber());

        }
    }



    public void notSameColor(Kort compare, Kort compareTo) {
    }


    public boolean containsName(final List<Kort> list, final String name){
        return list.stream().anyMatch(o -> o.getType().equals(name));
    }

}
