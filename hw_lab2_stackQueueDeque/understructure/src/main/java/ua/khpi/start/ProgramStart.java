package ua.khpi.start;

import ua.khpi.structure.Stack;

import java.io.*;

public class ProgramStart {
    private static BufferedReader reader = new BufferedReader
            (new InputStreamReader(System.in));

    private static Stack stack;

    public static void greeting() throws IOException {
        System.out.println("Welcome to the lab2!");
        System.out.println("Topic: Stack");
        System.out.print("\nPress Enter to continue...");
        reader.readLine();
    }

    public static void run() throws IOException {
        while (true){
            navigation();
            caseLogic();
        }
    }


    private static void navigation(){
        System.out.println("\n1. Read data from file");
        System.out.println("2. Put one element");
        System.out.println("3. Get one element");
        System.out.println("4. Print");
        System.out.println("5. Swap first and last elements");
        System.out.println("6. Turn upside-down");
        System.out.println("7. Remove each second elements");
        System.out.println("8. Insert * in the middle of the stack");
        System.out.println("9. Insert 0 after max");
        System.out.println("10. Remove min");
        System.out.println("11. Remove all elements except first");
        System.out.println("12. Remove all elements except last");
        System.out.println("13. Save result to file");
        System.out.println("0. Exit\n");
        System.out.print("Your input ==> ");
    }


    private static void caseLogic() throws IOException {
        int choice = -1;
        try {
            choice = Integer.parseInt(reader.readLine());
        }catch (NumberFormatException ex){
            System.out.println("Incorrect input. Value must be a number");
        }
        switch (choice){
            case 1 -> stack = fillStackFromFile();
            case 2 -> push();
            case 3 -> System.out.println(stack.pop());
            case 4 -> System.out.println(stack);
            case 5 -> stack.swap();
            case 6 -> stack = stack.turn();
            case 7 -> stack.removeEachSecondElement();
            case 8 -> stack.printStarInTheMiddleOfTheStack();
            case 9 -> stack.insertZeroAfterMax();
            case 10 -> stack.removeMin();
            case 11 -> stack.removeAllBesidesFirst();
            case 12 -> stack.removeAllBesidesLast();
            case 13 -> saveToFile();
            case 14 -> System.out.println("Amount of elements of the stack ==> " + stack.size());
            case 0 -> System.exit(0);
            default -> System.out.println("Incorrect input. Try again");
        }
    }

    private static void push() throws IOException {
        if (stack == null) {
            stack = new Stack();
        }
        System.out.print("Input element you want to put ==> ");
        double element = Double.parseDouble(reader.readLine());
        stack.push(element);
    }

    private static void saveToFile() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("hw_lab2_stackQueueDeque/understructure/write.txt"))) {
            bw.write("Result stack contains:\n");
            bw.write(stack.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static Stack fillStackFromFile() {
        Stack stack = new Stack();
        String fileName = "hw_lab2_stackQueueDeque/read.txt";
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            bufferedReader.lines().mapToDouble(Double::parseDouble).forEach(stack::push);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stack;
    }
}
