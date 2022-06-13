package ua.khpi.start.queue;

import ua.khpi.structure.Queue;

import java.io.*;

public class ProgramStart {
    private static final Queue queue = new Queue();
    private static final BufferedReader reader = new BufferedReader
            (new InputStreamReader(System.in));

    private ProgramStart() {
    }

    public static void run() throws IOException {
        greeting();
        while (true) {
            navigation();
            caseLogic();
        }
    }


    private static void navigation() {
        System.out.println("1. Read data from file");
        System.out.println("2. Add element");
        System.out.println("3. Get element");
        System.out.println("4. Print");
        System.out.println("5. Get size of queue");
        System.out.println("6. Get average of elements");
        System.out.println("7. Find min and max");
        System.out.println("8. Find elements before min");
        System.out.println("9. Save result to file");
        System.out.println("0. Exit");

        System.out.print("\nYour input ==> ");
    }

    private static void caseLogic() throws IOException {
        int choice = -1;
        try {
            choice = Integer.parseInt(reader.readLine());
        } catch (NumberFormatException ex) {
            System.out.println("Incorrect input. Value must be a number!");
        }
        switch (choice) {
            case 1 -> fillQueueByFile();
            case 2 -> push();
            case 3 -> System.out.println(queue.pop());
            case 4 -> System.out.println(queue);
            case 5 -> System.out.printf("Size of queue is %d%n", queue.size());
            case 6 -> System.out.printf("Average of the elements is %f%n", queue.getAverage());
            case 7 -> queue.findMinMaxElement();
            case 8 -> System.out.println("Element before min ==> " + queue.findElementBeforeMin());
            case 9 -> saveQueueToFile();
            case 0 -> System.exit(0);
            default -> System.out.println("Incorrect input");
        }
    }

    private static void greeting() throws IOException {
        System.out.println("Welcome to the lab2!!!");
        System.out.println("Topic: Queue");
        System.out.print("\nPress Enter to continue...");
        reader.readLine();
    }

    private static void fillQueueByFile() {
        String fileName = "hw_lab2_stackQueueDeque/read.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.lines().mapToDouble(Double::parseDouble).forEach(queue::push);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void push() throws IOException {
        System.out.print("Input element ==> ");
        double element = Double.parseDouble(reader.readLine());
        queue.push(element);
    }

    private static void saveQueueToFile() {
        String fileName = "hw_lab2_stackQueueDeque/queue/write.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Queue contains:\n");
            writer.write(queue.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

}
