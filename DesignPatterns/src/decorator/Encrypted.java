package decorator;

public class Encrypted implements Stream {
    private Stream stream;

    public Encrypted(Stream stream) {
        this.stream = stream;
    }

    @Override
    public void write(String data) {
        String encrypted = encrypt(data);
        stream.write(encrypted);
    }

    private String encrypt(String data) {
        return "$$@#^!@#^";
    }
}
