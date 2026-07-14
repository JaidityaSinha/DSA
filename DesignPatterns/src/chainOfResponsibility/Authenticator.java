package chainOfResponsibility;

public class Authenticator extends Handler {
    public Authenticator(Handler next) {
        super(next);
    }

    @Override
    public boolean doHandle(HttpRequest request) {
        boolean isValid = (request.username().equals("admin") &&
                            request.password().equals("1234"));

        System.out.println("Authentication");
        return !isValid;
    }
}
