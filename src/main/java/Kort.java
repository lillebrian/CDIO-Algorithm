import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Stack;

class Kort {

    // Doubly linked list to keep track of build stacks
    private Kort next;
    private Kort last;



    String number;
    String type;
    ArrayList<String> typer = new ArrayList<>(Arrays.asList("Klør", "Ruder", "Hjerter", "Spar"));
    ArrayList<String> numre = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","J","D","K"));

    public Kort(int type, int number) {
        this.type = typer.get(type);
        this.number = numre.get(number);
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    public Kort getNext() {
        return next;
    }

    public void setNext(Kort next) {
        this.next = next;
    }

    public Kort getLast() {
        return last;
    }

    public void setLast(Kort last) {
        this.last = last;
    }

}