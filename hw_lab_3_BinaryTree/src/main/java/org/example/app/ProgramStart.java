package org.example.app;

import org.example.BinaryTree;
import org.example.Person;

import java.io.*;
import java.util.Comparator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class ProgramStart {
    private static BinaryTree tree = new BinaryTree(Comparator.comparing(Person::getSurname));
    private static final BufferedReader reader = new BufferedReader
            (new InputStreamReader(System.in));

    private ProgramStart(){

    }

    public static void run() throws IOException {
        greeting();
        while (true){
            navigation();
            caseLogic();
        }
    }

    private static void greeting() throws IOException {
        System.out.println("Welcome to the lab3!!!");
        System.out.println("Topic: Binary tree");
        System.out.print("\nPress Enter to continue...");
        reader.readLine();
    }

    private static void navigation() {
        System.out.println("1. Fill tree by file");
        System.out.println("2. Obtain average of age of people");
        System.out.println("3. Print tree in preorder");
        System.out.println("4. Print tree in postorder");
        System.out.println("5. Print tree in symmetric order");
        System.out.println("6. Print tree in order");
        System.out.println("7. Remove left subtree");
        System.out.println("8. Remove right subtree");
        System.out.println("9. Remove node");
        System.out.println("10. Clear");
        System.out.println("11. Organize tree by age");
        System.out.println("12. Paint into Red-Black tree");
        System.out.println("0. Exit");
        System.out.print("\nYour input ==> ");
    }

    private static void caseLogic() throws IOException {
        int choice = Integer.parseInt(reader.readLine());
        switch (choice){
            case 1 -> fillTreeByFile();
            case 2 -> System.out.println("Average age ==> " + tree.getAverageAge() + " years");
            case 3 -> tree.preOrder();
            case 4 -> tree.postOrder();
            case 5 -> tree.symmetricOrder();
            case 6 -> tree.print();
            case 7 -> tree.removeLeftSubTree();
            case 8 -> tree.removeRightSubTree();
            case 9 -> remove();
            case 10 -> tree.clear();
            case 11 -> tree = new BinaryTree(tree, Comparator.comparing(Person::getAge));
            case 12 -> tree.paintIntoRedBlackTree();
            case 0 -> System.exit(0);
            default -> System.out.println("Incorrect input. Try again");
        }
    }

    private static void remove() throws IOException {
        System.out.print("Input passport of person you want to remove ==> ");
        String passport = reader.readLine();

    }

    private static void fillTreeByFile() throws IOException {
        String fileName = "hw_lab_3_BinaryTree/read.txt";
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName))){
            String fileContent = reader.lines().collect(Collectors.joining());
            Pattern p = Pattern.compile("\\b(?:(?!surname|passport|age)\\w)+");
            Matcher m = p.matcher(fileContent);
            while (m.find()){
                Person person = new Person();
				person.setSurname(m.group());

                if(m.find()){
					person.setPassport(m.group());
				}
				if(m.find()){
					person.setAge(Integer.parseInt(m.group()));
				}
                tree.put(person);
            }
        }
    }
}
