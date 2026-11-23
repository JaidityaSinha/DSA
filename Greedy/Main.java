package Greedy;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EvaluateTheBracketPairsOfAString
                evaluateTheBracketPairsOfAString = new EvaluateTheBracketPairsOfAString();

        String s = "(name)is(age)yearsold";
        List<List<String>> knowledge = new ArrayList<>();

        List<String> list = new ArrayList<>();

        list.add("name");
        list.add("bob");

        knowledge.add(list);

        List<String> list2 = new ArrayList<>();

        list2.add("age");
        list2.add("two");

        knowledge.add(list2);

        System.out.println(evaluateTheBracketPairsOfAString.evaluate(s, knowledge));


    }
}
