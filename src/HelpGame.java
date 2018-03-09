import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class HelpGame {

    private static final String alphabet = "abcdefg";
    private int boardLength = 7;
    private int boardSize = 49;
    private int[] board = new int[boardSize];
    private int numberOfPortals = 0;

    public String getInputData(String info1) {
         String inputData = null;

        System.out.println(info1 + " ");

        try {
            BufferedReader is = new BufferedReader(
                    new InputStreamReader(System.in));
                    inputData = is.readLine();
                    if(inputData.length() == 0) return null;
        } catch (IOException e) {
            System.out.println("IOException: " + e);
        }
        return inputData.toLowerCase();
    }

    public ArrayList newPositionOfPortal(int portalSize) {
        ArrayList<String> occupiedFields = new ArrayList<String>();
        String[] coordinatesStr = new String[portalSize];
        String help = null;
        int[] coordinates = new int[portalSize];
        int attempt = 0;
        boolean pass = false;
        int position = 0;

        numberOfPortals++;
        int incr = 1;

        if((numberOfPortals % 2) == 1){
            incr = boardLength;
        }

        while (!pass & attempt++ < 200){
            position = (int) (Math.random() * boardSize);
//            System.out.print(" check " + position);
            int x = 0;
            pass = true;
            while (pass && x < portalSize){
                if(board[position] == 0){
                    coordinates[x++] = position;
                    position += incr;
                    if(position >= boardSize){
                        pass = false;
                    }
                    if (x > 0 & (position % boardLength == 0)){
                        pass = false;
                    }
                } else {
//                    System.out.print(" alread occupied" + position);
                    pass = false;
                }
            }
        }

        int x = 0;
        int row = 0;
        int column = 0;
//        System.out.println("\n");
        while (x < portalSize){
            board[coordinates[x]] = 1;
            row = (int) (coordinates[x] / boardLength);
            column = coordinates[x] % boardLength;
            help = String.valueOf(alphabet.charAt(column));
            occupiedFields.add(help.concat(Integer.toString(row)));
            x++;
//            System.out.print("coordinates" + x + " = " + occupiedFields.get(x-1));
        }
//        System.out.println("\n");
        return occupiedFields;
    }
}
