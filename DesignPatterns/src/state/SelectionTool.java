package state;

public class SelectionTool implements Tool {
    @Override
    public void mouseUp() {
        System.out.println("Selection Icon");
    }

    @Override
    public void mouseDown() {
        System.out.println("Draw a dashed rectangle");
    }
}
