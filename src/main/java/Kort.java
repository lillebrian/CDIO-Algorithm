import java.util.ArrayList;
import java.util.Arrays;

class Kort {
    public static final String RESET = "\u001B[0m";
    public static final String BLACK = "\u001B[30m";
    public static final String RED = "\u001B[31m";
    // Doubly linked list to keep track of build stacks
    private Kort next;
    private Kort last;



    private int number;
    private EnumColor color;
    private String type;
    private String typeIcon;
    ArrayList<String> suits = new ArrayList<>(Arrays.asList("\u001B[30m♣️️\u001B[0m", "\u001B[31m♦️\u001B[0m", "\u001B[31m♥️️\u001B[0m", "\u001B[30m♠️️\u001B[0m"));
    ArrayList<String> typer = new ArrayList<>(Arrays.asList("C", "D", "H", "S"));
//    ArrayList<String> numre = new ArrayList<>(Arrays.asList("1","2","3","4","5","6","7","8","9","10","11","12","13"));

    public Kort(int type, int number) {
        this.typeIcon = suits.get(type);
        this.type = typer.get(type);
        this.number = number;

        if (this.type.equals("C") || this.type.equals("S")) {
            color = EnumColor.BLACK;
        } else {
            color = EnumColor.RED;
        }
    }


    public String toString() {
        return typeIcon+number;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public EnumColor getColor() {
        return color;
    }

    public String getType() {
        return type;
    }

    public String getTypeIcon() {
        return typeIcon;
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