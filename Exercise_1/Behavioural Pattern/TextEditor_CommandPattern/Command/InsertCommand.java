package Command;

public class InsertCommand implements Command {
    Editor editor;
    int pos;
    String str;

    public InsertCommand(Editor e, int p, String s) {
        editor = e;
        pos = p;
        str = s;
    }

    public void execute() {
        editor.insert(pos, str);
    }

    public void undo() {
        editor.delete(pos, str.length());
    }
}
