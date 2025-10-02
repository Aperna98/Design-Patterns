package Command;

public class Editor {
    public StringBuilder text = new StringBuilder();

    public void insert(int pos, String s) {
        while (text.length() < pos)
            text.append(' ');
        text.insert(pos, s);
    }

    public String delete(int pos, int len) {
        if (text.length() == 0 || pos < 0 || pos >= text.length())
            return "";
        int end = Math.min(pos + len, text.length());
        String out = text.substring(pos, end);
        text.delete(pos, end);
        return out;
    }

    public void replace(int pos, int len, String s) {
        if (text.length() == 0 || pos < 0 || pos >= text.length())
            return;
        int end = Math.min(pos + len, text.length());
        text.delete(pos, end);
        text.insert(pos, s);
    }

    public String getText() {
        return text.length() == 0 ? "File is empty" : text.toString();
    }
}
