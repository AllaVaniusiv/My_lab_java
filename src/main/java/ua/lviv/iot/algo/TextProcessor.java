package ua.lviv.iot.algo;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextProcessor {

    private String text;
    private int length;

    public TextProcessor(final String text, final int length) {
        this.text = text;
        this.length = length;
    }

    public String removeWordsWithConsonant() {
        if (length <= 0) {
            return text;
        }
        String regex = "(?i)\\b[b-df-hj-np-tv-z]\\w{"
               + (length - 1) + "}\\b\\s*";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(text);
        return matcher.replaceAll("");
    }


    public static void main(final String[] args) {
        if (args.length < 2) {
            System.out.println("Usage: java TextProcessor <text> <length>");
            System.exit(1);
        }

        String text = args[0];
        int length = Integer.parseInt(args[1]);

        TextProcessor processor = new TextProcessor(text, length);
        String result = processor.removeWordsWithConsonant();
        System.out.println(result);
    }
}


