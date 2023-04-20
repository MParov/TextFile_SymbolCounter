import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class SymbolCounter {
    public static void main(String[] args) {

        FileInputStream input = null;
        try {
            input = new FileInputStream("text");
        } catch (FileNotFoundException e) {
            System.out.println("The file not found!" + e);
        }
        Map<Character, Integer> map = new TreeMap<>();
        int b = 0;
        while (b != -1) {
            try {
                if (map.containsKey((char) b)) {
                    map.put((char) b, map.get((char) b) + 1);
                } else {
                    map.put((char) b, 1);
                }
                b = input.read();
            } catch (IOException e) {
                System.out.println("Maika ti" + e);
            }
        }
        for (Map.Entry<Character, Integer> m : map.entrySet()) {
            System.out.printf("%c : %d%n", m.getKey(), m.getValue());
        }
    }
}
