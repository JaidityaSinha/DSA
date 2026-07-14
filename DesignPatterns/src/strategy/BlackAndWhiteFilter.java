package strategy;

public class BlackAndWhiteFilter implements Filter{
    @Override
    public void applyFilter(String filename) {
        System.out.println("Applying B&W filter");
    }
}
