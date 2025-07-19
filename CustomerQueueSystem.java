import java.util.Scanner;

public class CustomerQueueSystem {

    // Node class for each customer
    static class CustomerNode {
        String name;
        CustomerNode next;

        public CustomerNode(String name) {
            this.name = name;
            this.next = null;
        }
    }

    // Queue class using Linked List
    static class CustomerQueue {
        private CustomerNode front, rear;

        public CustomerQueue() {
            front = rear = null;
        }

        // Add customer 
        public void enqueue(String name) {
            CustomerNode newNode = new CustomerNode(name);

            if (rear == null) {
                front = rear = newNode;
            } else {
                rear.next = newNode;
                rear = newNode;
            }

            System.out.println(name + " has been added to the queue.");
        }

        // Serve the front customer
        public void dequeue() {
            if (front == null) {
                System.out.println("The queue is empty. No customer to serve.");
                return;
            }

            System.out.println("Serving customer: " + front.name);
            front = front.next;

            if (front == null) {
                rear = null;
            }
        }

        // Display all customers
        public void displayQueue() {
            if (front == null) {
                System.out.println("The queue is currently empty.");
                return;
            }

            System.out.println("Customers in the queue:");
            CustomerNode current = front;
            int number = 1;
            while (current != null) {
                System.out.println(number + ". " + current.name);
                current = current.next;
                number++;
            }
        }
    }

    // Main method 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerQueue queue = new CustomerQueue();
        int choice;

        do {
            System.out.println("\n===== CUSTOMER SERVICE QUEUE =====");
            System.out.println("1. Add customer to the queue");
            System.out.println("2. Serve customer");
            System.out.println("3. Show all customers in queue");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = scanner.nextLine();
                    queue.enqueue(name);
                    break;
                case 2:
                    queue.dequeue();
                    break;
                case 3:
                    queue.displayQueue();
                    break;
                case 4:
                    System.out.println("Exiting the system. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }
}
