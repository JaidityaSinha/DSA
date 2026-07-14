package composite;

import java.util.ArrayList;
import java.util.List;

public class Group implements Component {
    private final List<Component> components = new ArrayList<>();

    public void add(Component shape) {
        components.add(shape);
    }

    @Override
    public void render() {
        for (Component component : components)
            component.render();
    }

}
