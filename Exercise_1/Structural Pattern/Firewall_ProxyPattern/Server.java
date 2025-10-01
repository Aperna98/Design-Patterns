public class Server implements ServerAccess {
    private final String name;

    public Server(String name) {
        this.name = name;
    }

    @Override
    public void accessServer(String userName) {
        System.out.println(userName + " is accessing server: " + name);
    }

    public String getName() {
        return name;
    }
}