import java.util.*;
import java.io.*;

public class testing {
    public static void main(String[] args) throws IOException {

    }

}

class FileReader {
    static List<String[]> Storage = new ArrayList<>();

    public static List<String[]> read(String FileName, int SkipHeader) throws IOException {
        Storage.clear();
        File myFile = new File(FileName);
        Scanner reader = new Scanner(myFile);
        for (int i = 0; i < SkipHeader; i++) {
            reader.nextLine();
        }
        while (reader.hasNextLine()) {
            Storage.add(reader.nextLine().split(","));
        }
        reader.close();
        return Storage;
    }
}
