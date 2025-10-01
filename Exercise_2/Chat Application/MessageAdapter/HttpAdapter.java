package MessageAdapter;
public class HttpAdapter implements ClientCommunicator {
    private HttpService http;

    public HttpAdapter(HttpService http) { this.http = http; }

    @Override
    public void sendMessage(String msg) {
        http.postRequest(msg);
    }
}