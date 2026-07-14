public class QOTD {
    public char processStr(String s, long k) {
        StringBuilder sb = new StringBuilder();

        for (var ch : s.toCharArray()) {
            if (ch >= 'a' && ch <= 'z')
                sb.append(ch);

            else if (ch == '*' && !sb.isEmpty())
                sb.deleteCharAt(sb.length() - 1);

            else if (ch == '#')
                sb.append(sb);

            else if (ch == '%')
                sb.reverse();

        }

        if (k >= sb.length())
            return '.';
        else
            return sb.charAt((int) k);
    }
}
