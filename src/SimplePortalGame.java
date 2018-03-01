
public class SimplePortalGame {

    public static void main(String[] args) {

        int moveCount = 0;
        HelpGame helper = new HelpGame();

        SimplePortal portal = new SimplePortal();

        int randomNumber = (int) (Math.random() * 5);

        int[] position = {randomNumber, randomNumber+1, randomNumber+2};

        portal.setFieldPosition(position);

        boolean isExist = true;

        while (isExist == true){
            String field = helper.getInputData("Give me a number");

            String result = portal.check(field);

            moveCount++;

            if(result.equals("you kill this portal!")){
                isExist = false;
                System.out.println("in " + moveCount + " moves");
            }
        }
    }
}
