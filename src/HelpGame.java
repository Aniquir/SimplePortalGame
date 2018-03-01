import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class HelpGame {

    public String getInputData(String info1) {
         String line = null;

        System.out.println(info1 + " ");

        try {
            BufferedReader sw = new BufferedReader(
                    new InputStreamReader(System.in));
                    line = sw.readLine();
                    if(line.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return line;
    }

}
