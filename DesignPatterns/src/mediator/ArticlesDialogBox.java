package mediator;


public class ArticlesDialogBox {
    private ListBox listBox = new ListBox();
    private TextBox textBox = new TextBox();
    private Button button = new Button();

    public ArticlesDialogBox() {
        listBox.addEventHandler(this::articleSelected);
        textBox.addEventHandler(this::titleChanged);
    }

    private void titleChanged() {
        boolean isEmpty = textBox.getContent().isEmpty() || textBox.getContent() == null;
        button.setEnabled(!isEmpty);
    }

    private void articleSelected() {
        textBox.setContent(listBox.getSelection());
        button.setEnabled(true);
    }
}
