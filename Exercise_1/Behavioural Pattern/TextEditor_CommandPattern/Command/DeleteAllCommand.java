package Command;

public class DeleteAllCommand implements Command {
    Editor editor;
    String backup = "";

    public DeleteAllCommand(Editor e) {
        editor = e;
    }

    @Override
    public void execute() {
        backup = editor.getText().equals("File is empty") ? "" : editor.getText();
        editor.text.setLength(0);
    }

    @Override
    public void undo() {
        editor.text.setLength(0);
        editor.text.append(backup);
    }
}
