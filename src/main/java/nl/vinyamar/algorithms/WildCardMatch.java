package nl.vinyamar.algorithms;

import java.util.regex.Pattern;

public class WildCardMatch {

    public static void main(String[] args) {
        String input = "aabcd";
        String pattern = "aa*c?";
        System.out.println(isMatchRecursiveIterative(input, pattern, 0));
        System.out.println((isMatch(input, wildcardToRegex(pattern))));
        System.out.println((isMatch(input, "^" + pattern.replace("*", ".*").replace("?", ".") + "$")));
    }

    private static boolean isMatch(String input, String pattern) {
        System.out.println("regex pattern used: " + pattern);
        return Pattern.matches(pattern, input);
    }

    public static String wildcardToRegex(String wildcard) {
        StringBuffer s = new StringBuffer(wildcard.length());
        s.append('^');
        for (int i = 0, is = wildcard.length(); i < is; i++) {
            char c = wildcard.charAt(i);
            switch (c) {
            case '*':
                s.append(".*");
                break;
            case '?':
                s.append(".");
                break;
            // escape special regexp-characters
            case '(':
            case ')':
            case '[':
            case ']':
            case '$':
            case '^':
            case '.':
            case '{':
            case '}':
            case '|':
            case '\\':
                s.append("\\");
                s.append(c);
                break;
            default:
                s.append(c);
                break;
            }
        }
        s.append('$');
        return (s.toString());
    }

    public static boolean isMatchRecursiveIterative(String s, String p, int sOffset) {
        if (s.equals(p)) {
            return true;
        }
        int nextChar = findFirstNotWC(p);
        int newOffset = matchPattern(s, p.substring(0, nextChar + 1));
        if (newOffset == -1) {
            return false;
        }
        if (newOffset == 0) {
            return true;
        }
        return isMatchRecursiveIterative(s.substring(newOffset), p.substring(nextChar + 1), newOffset);
    }

    private static int matchPattern(String s, String p) {
        int posS = 0;
        for (int posP = 0; posP < p.length(); posP++) {
            if (p.substring(posP).equals("")) {
                return 0;
            }
            if (p.substring(posP).equals("?")) {
                if (s.substring(posS).equals("")) {
                    return -1;
                }
            } else if (p.substring(posP).equals("*")) {

            } else if (!p.substring(posP, posP + 1).equals(s.substring(posS, posS + 1))) {
                return -1;
            }
            posS++;
        }
        return posS;
    }

    private static int findFirstNotWC(String p) {
        int nextS = p.indexOf("*");
        int nextQ = p.indexOf("?");
        int min = Math.min(nextS, nextQ);
        return min == 0 ? Math.max(nextS, nextQ) - 1 : min - 1;
    }
}
