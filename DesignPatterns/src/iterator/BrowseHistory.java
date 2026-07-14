package iterator;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BrowseHistory {
    private final List<String> urls = new ArrayList<>();

    public void push(String url) {
        urls.add(url);
    }

    public String pop() {
        return urls.removeLast();
    }

    private List<String> getUrls() {
        return urls;
    }

    public Iterator createIterator() {
        return new ListIterator(this);
    }

    public static class ListIterator implements Iterator  {

        private final BrowseHistory history;
        private int index;

        public ListIterator(BrowseHistory history) {
            this.history = history;
        }

        @Override
        public boolean hasNext() {
            return (index < history.urls.size());
        }

        @Override
        public String current() {
            return history.urls.get(index);
        }

        @Override
        public void next() {
            index++;
        }
    }
}
