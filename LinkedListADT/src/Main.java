import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();

        // Insert some elements
        linkedList.insert(1);
        linkedList.insert(2);
        linkedList.insert(3);

        // Iterate and display elements
        Iterator<Integer> iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
