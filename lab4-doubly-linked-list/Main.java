package editor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        TextEditor editor = new TextEditor();
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n1. Add Text");
            System.out.println("2. Undo");
            System.out.println("3. Redo");
            System.out.println("4. Print Current");
            System.out.println("5. Exit");
            System.out.print("Choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter text to add: ");
                    String t = sc.nextLine();
                    editor.add(t);
                    break;

                case 2:
                    editor.undo();
                    break;

                case 3:
                    editor.redo();
                    break;

                case 4:
                    editor.printCurrent();
                    break;

                case 5:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
