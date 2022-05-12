import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Practice {
    public static void main (String[] args) {

        ArrayList<ArrayList<Integer>> matrix = new ArrayList<ArrayList<Integer>>(3);

        ArrayList<Integer> row1 = new ArrayList<Integer>(Arrays.asList(1,3));
        ArrayList<Integer> row2 = new ArrayList<Integer>(Arrays.asList(5,6));
        ArrayList<Integer> row3 = new ArrayList<Integer>(Arrays.asList(78,9));
        matrix.add(row1);
        matrix.add(row2);
        matrix.add(row3);
        System.out.println(matrix.toString());

        int downToUp = 0, upToDown = 0;
        int length = matrix.size();
        for (int i = 0; i < length; i++) {
            upToDown += matrix.get(i).get(i);
            downToUp += matrix.get(length - (i + 1)).get(i);
        }
        System.out.println(Math.abs(upToDown - downToUp));
    }
}
