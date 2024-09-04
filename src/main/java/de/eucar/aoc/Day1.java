package src.main.java.de.eucar.aoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day1 {

    static String getFirstNum(String input, Pattern pattern) {
        String firstNum = null;

        Matcher matcher = pattern.matcher(input);

        if (matcher.find() == true) {
            firstNum = matcher.group();
        }
        return firstNum;
    }

    static String getLastNum(String input, Pattern pattern) {
        String lastNum = null;

        Matcher matcher = pattern.matcher(input);

        while (matcher.find() == true) {

            lastNum = matcher.group();

        }
        return lastNum;
    }

    private static List<String> readFile() {

        List<String> lines = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/inputDay1.txt"));

            String line = "";
            do {
                line = reader.readLine();
                lines.add(line);
            } while (line != null);

            reader.close();

        } catch (IOException e1) {
            System.err.println("Error: " + e1.getMessage());
        }

        return lines;
    }

    private static int calculateSum(List<String> lines) {

        int sum = 0;

        Pattern pattern = Pattern.compile("\\d");

        for (int i = 0; i < lines.size(); i++) {

            try {

                int firstNum = Integer.parseInt(getFirstNum(lines.get(i), pattern));
                int lastNum = Integer.parseInt(getLastNum(lines.get(i), pattern));

                int num = 10 * firstNum + lastNum;
                System.out.println(i + ". " + num);

                sum = sum + num;

            } catch (NullPointerException e1) {
                break;
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        List<String> lines = readFile();

        int sum = calculateSum(lines);

        System.out.println(sum);

    }

}