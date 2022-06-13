package ua.khpi.start.deque;

import ua.khpi.structure.Deque;

import java.io.*;

public class ProgramStart {
    private static final BufferedReader reader = new BufferedReader
            (new InputStreamReader(System.in));
    private static final Deque deque = new Deque();

    public static void run() throws IOException {
        greeting();
        while (true) {
            navigation();
            caseLogic();
        }
    }


    private static void greeting() throws IOException {
        System.out.println("Welcome to the lab2!!!");
        System.out.println("Topic: Deque\n");
        System.out.print("Press Enter to continue...");
        reader.readLine();
    }

    private static void navigation() {
        System.out.println("1. Fill deque by file");
        System.out.println("2. Print");
        System.out.println("3. Add element to the end");
        System.out.println("4. Add element to the begin");
        System.out.println("5. Check if deque is empty");
        System.out.println("6. Obtain element by index");
        System.out.println("7. Obtain first element");
        System.out.println("8. Obtain last element");
        System.out.println("9. Save result to file");
        System.out.println("0. Exit");

        System.out.print("\nYour input ==> ");
    }

    private static void caseLogic() throws IOException {
        int choice = Integer.parseInt(reader.readLine());
        switch (choice) {
            case 1 -> readFromFile();
            case 2 -> System.out.println(deque);
            case 3 -> add("pushBack");
            case 4 -> add("pushFront");
            case 5 -> {
                if (deque.isEmpty()) {
                    System.out.println("Deque is empty");
                } else {
                    System.out.println("Deque is not empty");
                }
            }
            case 6 -> get();
            case 7 -> System.out.println("First element ==> " + deque.peekFirst());
            case 8 -> System.out.println("Last element ==> " + deque.peekLast());
            case 9 -> saveToFile();
            case 0 -> System.exit(0);
            default -> System.out.println("Incorrect input. Try again");
        }
    }

    private static void readFromFile() {
        String fileName = "hw_lab2_stackQueueDeque/read.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            reader.lines().map(Double::parseDouble).forEach(deque::pushBack);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void saveToFile() {
        String fileName = "hw_lab2_stackQueueDeque/deque/write.txt";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write("Deque contains:\n");
            writer.write(deque.toString());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private static void get() throws IOException {
        System.out.println("Input index ==> ");
        int index = Integer.parseInt(reader.readLine());
        System.out.println("Desired element ==> " + deque.get(index));
    }

    private static void add(String place) throws IOException {
        System.out.print("Input element ==> ");
        double element = Double.parseDouble(reader.readLine());
        if (place.equals("pushBack")) {
            deque.pushBack(element);
        } else {
            deque.pushFront(element);
        }
    }


}
