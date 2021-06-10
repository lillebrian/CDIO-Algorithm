import java.util.ArrayList;
import java.util.LinkedList;

public class Moves {
    int valueOfMoves = 0;
//    ArrayList<Kort> LegalMoves = new ArrayList<>();
    /* USED FOR DEPTH SEARCH AND KEEPING TRACK OF MOVES WITHIN A MOVE*/
    LinkedList<Kort> LegalMoves = new LinkedList<>();


    public Moves () {

    }

    public void addLegalMove (Kort cardToBeMoved, Kort movedTo, Integer Value) {
        this.valueOfMoves += Value;
        LegalMoves.add(cardToBeMoved);
        LegalMoves.add(movedTo);
    }
}
