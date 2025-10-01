import java.util.*;
import Command.*;

public class CommandInvoker {
    Stack<Command> undo = new Stack<>();
    Stack<Command> redo = new Stack<>();
    List<String> history = new ArrayList<>();

    public void run(Command c, String name) {
        c.execute();
        undo.push(c);
        redo.clear();
        history.add(name);
    }

    public void undo() {
        if (!undo.isEmpty()) {
            Command c = undo.pop();
            c.undo();
            redo.push(c);
            history.add("undo");
        } else
            System.out.println("Nothing to undo");
    }

    public void redo() {
        if (!redo.isEmpty()) {
            Command c = redo.pop();
            c.execute();
            undo.push(c);
            history.add("redo");
        } else
            System.out.println("Nothing to redo");
    }

    public void showHistory() {
        System.out.println("\n--- Command History ---");
        for (int i = 0; i < history.size(); i++) {
            System.out.println((i + 1) + ". " + history.get(i));
        }
    }
}
