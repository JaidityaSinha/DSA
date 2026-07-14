package strategy;

public class ImageStorage {
    private final Compressor compressor;
    private final Filter filter;

    public ImageStorage(Compressor compressor, Filter filter) {
        this.compressor = compressor;
        this.filter = filter;
    }

    public void store(String filename) {
        compressor.compress(filename);
        filter.applyFilter(filename);
    }
}
