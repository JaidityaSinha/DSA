package Greedy;

public class Main {
    public static void main(String[] args) {
        AssignCookies assignCookies = new AssignCookies();

        int[] g = {10,9,8,7};
        int[] s = {5,6,7,8};

        int ans = assignCookies.findContentChildren(g, s);
        System.out.println(ans);
    }
}
