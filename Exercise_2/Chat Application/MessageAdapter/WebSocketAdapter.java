package MessageAdapter;
public class WebSocketAdapter implements ClientCommunicator {
    private WebSocketService ws;

    public WebSocketAdapter(WebSocketService ws) { this.ws = ws; }

    @Override
    public void sendMessage(String msg) {
        ws.pushMessage(msg);
    }
}