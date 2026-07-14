package iterator;

public class Main {
    public static void main(String[] args) {
        BrowseHistory browseHistory = new BrowseHistory();

        browseHistory.push("a");
        browseHistory.push("b");
        browseHistory.push("c");

        Iterator iterator = browseHistory.createIterator();

        while (iterator.hasNext()) {
            String url = iterator.current();
            System.out.println(url);

            iterator.next();
        }

    }

}
