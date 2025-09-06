import java.util.LinkedList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int i = 0; // anderer Speicherplatz als in value()
        List<Integer> list = new LinkedList<>();
        list.add(0);
        value(i);
        reference(list);

        System.out.println("Value: " + i);
        System.out.printf("Reference: " + list.get(0));
    }

    public static void value(int i) {
        // "int i" ist ein anderes "i" als oben (unterschiedlicher Speicherplatz)
        i = 2; // pass by value (primitive Datentypen)
    }

    public static void reference(List<Integer> l) {
        l.set(0, 2); // pace by reference (Array, Listen etc)
    }
}