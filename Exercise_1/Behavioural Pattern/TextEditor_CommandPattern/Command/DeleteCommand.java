package Command;

public class DeleteCommand implements Command {
    Editor editor;
    int pos, len;
    String deleted = "";

    public DeleteCommand(Editor e, int p, int l) {
        editor = e;
        pos = p;
        len = l;
    }

    public void execute() {
        deleted = editor.delete(pos, len);
    }

    public void undo() {
        editor.insert(pos, deleted);
    }
}
