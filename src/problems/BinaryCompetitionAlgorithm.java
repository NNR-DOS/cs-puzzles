package problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryCompetitionAlgorithm {

    public List<Integer> cellCompete(int[] states, int days) {
        int[] temp = new int[states.length];
        System.arraycopy(states, 0, temp, 0, states.length);

        System.out.println(Arrays.toString(states));
        System.out.print(Arrays.toString(temp));

        while (days-- > 0) {
            temp[0] = states[1];
            temp[states.length - 1] = states[states.length - 2];
            for (int i = 1; (i <= states.length - 2); i++) {
                temp[i] = states[i - 1] ^ states[i + 1];
            }
            System.arraycopy(temp, 0, states, 0, states.length);
        }
        List<Integer> intList = new ArrayList<Integer>(states.length);
        for (int i : states) {
            intList.add(i);
        }
        return intList;
    }

    public static void main(String[] args) {
        BinaryCompetitionAlgorithm s = new BinaryCompetitionAlgorithm();
        int[] cells = new int[]{1, 0, 0, 0, 0, 1, 0, 0};
        System.out.println(Arrays.toString(s.cellCompete(cells, 1).toArray()));
    }
}
