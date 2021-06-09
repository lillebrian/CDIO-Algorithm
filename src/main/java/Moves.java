import java.util.ArrayList;
import java.util.LinkedList;

public class Moves {
    int valueOfMoves = 0;
//    ArrayList<Kort> LegalMoves = new ArrayList<>();
    LinkedList<Kort> LegalMoves = new LinkedList<>();
    String træk = "H8 -> S9";

    public Moves () {

    }

    public void addLegalMove (Kort cardToBeMoved, Kort movedTo, Integer Value) {
        this.valueOfMoves += Value;
        LegalMoves.add(cardToBeMoved);
        LegalMoves.add(movedTo);
    }
}
