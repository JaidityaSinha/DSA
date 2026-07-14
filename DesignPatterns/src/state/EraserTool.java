package state;

public class EraserTool implements Tool{
    @Override
    public void mouseUp() {
        System.out.println("Eraser Icon");
    }

    @Override
    public void mouseDown() {
        System.out.println("Erase stuff");
    }
}
