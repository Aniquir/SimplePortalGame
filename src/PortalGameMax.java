import java.util.ArrayList;

public class PortalGameMax {

        private HelpGame helpGame = new HelpGame();
        private ArrayList<Portal> listOfPortals = new ArrayList<>();
        private int moveCount = 0;

        private void prepareGame(){
            Portal first = new Portal();
            first.setName("onet.pl");
            Portal second = new Portal();
            second.setName("wp.pl");
            Portal third = new Portal();
            third.setName("interia.pl");
            listOfPortals.add(first);
            listOfPortals.add(second);
            listOfPortals.add(third);

            System.out.println("You need kill three portals!");
            System.out.println("onet.pl, wp.pl, interia.pl");
            System.out.println("try kill them with the smallest count of moves");

            for(Portal portalPositioning : listOfPortals){
                ArrayList<String> newPosition = helpGame.newPositionOfPortal(3);
                portalPositioning.setFieldPosition(newPosition);
            }
        }

        private void startGame(){
            while(!listOfPortals.isEmpty()){
                String playerMove = helpGame.getInputData("enter the field: ");
                checkPlayerMove(playerMove);
            }
            finishGame();
        }

        private void checkPlayerMove(String move){

            moveCount++;
            String result = "miss...";

            for (Portal checkingPortal : listOfPortals){
                result = checkingPortal.check(move);
                if(result.equals("hit!")){
                    break;
                }
                if (result.equals("you kill portal ")){
                    listOfPortals.remove(checkingPortal);
                    break;
                }
            }
            System.out.println(result);
        }

        private void finishGame(){
            System.out.println("All of portals are dead!");
            if(moveCount <= 18){
                System.out.println("Counter of moves indicate: " + moveCount);
                System.out.println("You are good :)");
            } else {
                System.out.println("Counter of moves indicate: " + moveCount);
                System.out.println("You are pretty lazy :D");
            }
        }

        public static void main(String[] args){
            PortalGameMax game = new PortalGameMax();
            game.prepareGame();
            game.startGame();
        }
}
