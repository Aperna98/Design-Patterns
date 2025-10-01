import java.util.*;
import Command.*;

public class Main {
    public static void main(String[] args) {
        Editor editor = new Editor();
        CommandInvoker invoker = new CommandInvoker();

        Scanner sc = new Scanner(System.in);
        System.out.println("Simple Text Editor");

        while (true) {
            System.out.println(
                    "\n1.Insert Text  2.Delete Text  3.Replace Text  4.Undo  5.Redo  6.Show Content  7.Search Text  8.Empty Entire File  9.Exit");
            System.out.print("Choice: ");
            int choice = Integer.parseInt(sc.nextLine().strip());
            if (choice == 9)
                break;

            switch (choice) {
                case 1 -> {
                    System.out.print("pos: ");
                    int p = Integer.parseInt(sc.nextLine());
                    System.out.print("text: ");
                    String t = sc.nextLine();
                    invoker.run(new InsertCommand(editor, p, t), "insert \"" + t + "\"");
                }
                case 2 -> {
                    if (editor.getText().equals("File is empty")) {
                        System.out.println("File is empty, nothing to delete");
                        break;
                    }
                    System.out.print("pos: ");
                    int p = Integer.parseInt(sc.nextLine());
                    System.out.print("len: ");
                    int l = Integer.parseInt(sc.nextLine());
                    invoker.run(new DeleteCommand(editor, p, l), "delete " + l + " chars");
                }
                case 3 -> {
                    if (editor.getText().equals("File is empty")) {
                        System.out.println("File is empty, nothing to replace");
                        break;
                    }
                    System.out.print("pos: ");
                    int p = Integer.parseInt(sc.nextLine());
                    System.out.print("len: ");
                    int l = Integer.parseInt(sc.nextLine());
                    System.out.print("new text: ");
                    String t = sc.nextLine();
                    invoker.run(new ReplaceCommand(editor, p, l, t), "replace with \"" + t + "\"");
                }
                case 4 -> {
                    invoker.undo();
                    System.out.println("Undo action executed");
                }
                case 5 -> {
                    invoker.redo();
                    System.out.println("Redo action executed");
                }
                case 6 -> System.out.println("Content: " + editor.getText());
                case 7 -> {
                    System.out.print("word: ");
                    String w = sc.nextLine();
                    String text = editor.getText();
                    if (text.contains(w))
                        System.out.println("Found at index " + text.indexOf(w));
                    else
                        System.out.println("Not found");
                }
                case 8 -> {
                    if (editor.getText().equals("File is empty")) {
                        System.out.println("File is already empty");
                    } else {
                        invoker.run(new DeleteAllCommand(editor), "Entire file deleted");
                    }
                }
                default -> System.out.println("Unknown command");
            }
        }

        invoker.showHistory();
        String text = editor.getText();
        System.out.println("\n--- Final Document ---");
        System.out.println(text);

        if (text.equals("File is empty")) {
            System.out.println("\nWord count: 0");
            System.out.println("Character count: 0");
        } else {
            int wordCount = text.trim().isEmpty() ? 0 : text.trim().split("\\s+").length;
            int charCount = text.replaceAll("\\s+", "").length();
            System.out.println("\nWord count: " + wordCount);
            System.out.println("Character count: " + charCount);
        }

    }
}
