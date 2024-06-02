import java.util.Iterator;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList linkedList = new CustomLinkedList();
        int number;
        // Read integers from a file and insert them into the linked list
        try (Scanner scanner = new Scanner(new File("integers.txt"))) {
            while (scanner.hasNextInt()) {
                number = scanner.nextInt();
                linkedList.insert(number);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
        System.out.println("Elements inserted.\n");
        // Iterate and display elements
        Iterator<Integer> iterator = linkedList.iterator();
        System.out.println("Iterate linked list before deleting element: ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println("\nIterate linked list after deletion: ");
        // Delete an element
        linkedList.delete(21);

        // Iterate and display elements again
        iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}
