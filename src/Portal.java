import java.util.ArrayList;

public class Portal {

    private ArrayList<String> fieldPosition;
    private String name;

    public void setFieldPosition(ArrayList<String> fieldPosition) {
        this.fieldPosition = fieldPosition;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String check(String move){

        String result = "miss...";

        int index = fieldPosition.indexOf(move);

        if (index >= 0){
            fieldPosition.remove(index);

            if(fieldPosition.isEmpty()){
                result = "you kill portal " + name;
            } else {
                result = "hit!";
            }
        }
        return result;
    }


}
