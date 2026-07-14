package strategy;

public class HighContrastFilter implements Filter  {
    @Override
    public void applyFilter(String filename) {
        System.out.println("Applying High-Contrast Filter");
    }
}
