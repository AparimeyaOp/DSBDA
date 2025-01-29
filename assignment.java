import java.util.*;
import java.io.*;

class assignment {
    public static void main(String[] args) {
        try {
            HashMap<String, Integer> freq = new HashMap<>();
            String input = "";
            File obj = new File("text_file.txt");
            Scanner Reader = new Scanner(obj);
            System.out.println("Reading text file");
            System.out.println("\t\t\t\t----------Input text:----------\\t\\t\\t\\t\n");
            while (Reader.hasNextLine()) {
                input += Reader.nextLine() + " ";

            }
            input.trim();
            int recent_index = 0;
            for (int i = 0; i < input.length(); i++) {
                char ch = input.charAt(i);
                if (ch == ' ') {
                    String curr = input.substring(recent_index, i).trim();
                    if (!freq.containsKey(curr)) {
                        freq.put(curr, 1);
                    } else {
                        int count = freq.get(curr);
                        freq.put(curr, count + 1);
                    }
                    recent_index = i;
                }
            }
            System.out.println(input);
            int total = 0;
            System.out.println("Word counts:\n");
            for (String s : freq.keySet()) {
                System.out.println(s + ":" + freq.get(s));
                total += freq.get(s);
            }
            System.out.println("Total words: " + total);
            Reader.close();
        }

        catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }
    }
}