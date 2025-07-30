package DayTen;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class HtmlReader {

    public static void main(String[] args) {
        String filePath = "E:\\input.html";  

        StringBuilder htmlContent = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                htmlContent.append(line.trim());
            }
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        String content = htmlContent.toString();

        String title = extractTagContent(content, "title");
        System.out.println("Title: " + title);

        extractAllTagContent(content, "p");
    }

    private static String extractTagContent(String content, String tagName) {
        String openTag = "<" + tagName + ">";
        String closeTag = "</" + tagName + ">";

        int start = content.indexOf(openTag);
        int end = content.indexOf(closeTag);

        if (start != -1 && end != -1 && end > start) {
            return content.substring(start + openTag.length(), end);
        }
        return "Not Found";
    }

    private static void extractAllTagContent(String content, String tagName) {
        String openTag = "<" + tagName + ">";
        String closeTag = "</" + tagName + ">";
        int start = 0;
        int count = 0;

        while ((start = content.indexOf(openTag, start)) != -1) {
            int end = content.indexOf(closeTag, start);
            if (end != -1) {
                String data = content.substring(start + openTag.length(), end);
                System.out.println(tagName + " tag content " + (++count) + ": " + data);
                start = end + closeTag.length();
            } else {
                break;
            }
        }
    }
}