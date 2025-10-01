package Command;

public class ReplaceCommand implements Command {
    Editor editor;
    int pos, len;
    String newText, oldText;

    public ReplaceCommand(Editor e, int p, int l, String t) {
        editor = e;
        pos = p;
        len = l;
        newText = t;
    }

    public void execute() {
        oldText = editor.delete(pos, len);
        editor.insert(pos, newText);
    }

    public void undo() {
        editor.delete(pos, newText.length());
        editor.insert(pos, oldText);
    }
}
