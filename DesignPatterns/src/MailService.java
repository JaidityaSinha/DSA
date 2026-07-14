public class MailService {
    public void sendEmail() {
        connect();
        authenticate();
        //Send email
        disconnect();
    }

    private void connect() {
        System.out.println("Connect");
    }

    private void disconnect() {
        System.out.println("Disconnect");
    }

    private void authenticate() {
        System.out.println("Authenticate");
    }


}
