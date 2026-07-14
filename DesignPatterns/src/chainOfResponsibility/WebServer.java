package chainOfResponsibility;

public class WebServer {
    private final Handler handler;

    public WebServer(Handler handler) {
        this.handler = handler;
    }

    public void Handle(HttpRequest request) {
        handler.handle(request);
    }
}
