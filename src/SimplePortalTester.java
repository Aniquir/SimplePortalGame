
public class SimplePortalTester {

    public static void main(String[] args) {
        SimplePortal simplePortal = new SimplePortal();
        int[] position = {2,3,4};
        simplePortal.setFieldPosition(position);
        String selectedField = "2";
        String result = simplePortal.check(selectedField);
    }
}
