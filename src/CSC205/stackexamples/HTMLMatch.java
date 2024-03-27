package stackexamples;

import stack.*;

public class HTMLMatch {
    public static final String validHTML = "<body>\n" +
            "<center>\n" +
            "<h1> The Little Boat </h1>\n" +
            "</center>\n" +
            "<p> The storm tossed the little\n" +
            "boat like a cheap sneaker in an\n" +
            "old washing machine. The three\n" +
            "drunken fishermen were used to\n" +
            "such treatment, of course, but\n" +
            "not the tree salesman, who even as\n" +
            "a stowaway now felt that he\n" +
            "had overpaid for the voyage. </p>\n" +
            "<ol>\n" +
            "<li> Will the salesman die? </li>\n" +
            "<li> What color is the boat? </li>\n" +
            "<li> And what about Naomi? </li>\n" +
            "</ol>\n" +
            "</body>\n";

    public static void main(String[] args) {
        if (isHTMLMatched(validHTML)) {
            System.out.println("HTML is well formed");
        } else {
            System.out.println("HTML is not well formed");
        }
    }

    public static boolean isHTMLMatched(String html) {
        StackInterface<String> buffer = new ArrayStack<>();

        int tagStart = html.indexOf('<');
        while (tagStart != -1) {
            int tagEnd = html.indexOf('>', tagStart + 1);
            if (tagEnd == -1) {
                return false;
            }
            String tag = html.substring(tagStart + 1, tagEnd);
            if (!tag.startsWith("/")) {
                buffer.push(tag);
            } else {
                if (buffer.isEmpty()) {
                    return false;
                }
                if (!tag.substring(1).equals(buffer.pop())) {
                    return false;
                }
            }
            tagStart = html.indexOf('<', tagEnd + 1);
        }
        return buffer.isEmpty();
    }
}
