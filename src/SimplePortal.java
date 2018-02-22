
public class SimplePortal {

    int[] fieldPosition;
    int hitCount = 0;

    public String check(String strField){
        int shoot = Integer.parseInt(strField);

        String result = "miss...";

        for(int field : fieldPosition){
            if (shoot == field){
                result = "hit!";
                hitCount++;
                break;
            }
        }
        if(hitCount == fieldPosition.length){
            result = "you kill this portal!";
        }
        System.out.println(result);
        return result;
    }

    public void setFieldPosition(int[] fieldPosition) {
        this.fieldPosition = fieldPosition;
    }
}
