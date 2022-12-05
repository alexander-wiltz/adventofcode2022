package E_Five;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Five {

    // https://adventofcode.com/2022/day/5
    private static final String[] spalte1 = {"G", "F", "V", "H", "P", "S"};
    private static final String[] spalte2 = {"G", "J", "F", "B", "V", "D", "Z", "M"};
    private static final String[] spalte3 = {"G", "M", "L", "J", "N"};
    private static final String[] spalte4 = {"N", "G", "Z", "V", "D", "W", "P"};
    private static final String[] spalte5 = {"V", "R", "C", "B"};
    private static final String[] spalte6 = {"V", "R", "S", "M", "P", "W", "L", "Z"};
    private static final String[] spalte7 = {"T", "H", "P"};
    private static final String[] spalte8 = {"Q", "R", "S", "N", "C", "H", "Z", "V"};
    private static final String[] spalte9 = {"F", "L", "G", "P", "V", "Q", "J"};

    static List<String[]> array = new ArrayList<>();

    public static void main(String[] args) throws FileNotFoundException {
        array.add(spalte1);
        array.add(spalte2);
        array.add(spalte3);
        array.add(spalte4);
        array.add(spalte5);
        array.add(spalte6);
        array.add(spalte7);
        array.add(spalte8);
        array.add(spalte9);

        File file = new File("src\\main\\java\\E_Five\\input.txt");
        Scanner scanner = new Scanner(file);

        int[] MOVE = {6, 2, 1};
        int[] SOURCEARR = {9, 2, 8};
        int[] TARGETARR = {3, 1, 2};

        for (int i = 0; i < 3; i++) {
            moveStrings(MOVE[i], SOURCEARR[i], TARGETARR[i]);
        }
        /*
        move 6 from 9 to 3
        move 2 from 2 to 1
        move 1 from 8 to 2
         */
    }

    public static void moveStrings(int move, int sourcearr, int targetarr) {
        List<String> source = new ArrayList<>(Arrays.stream(array.get(sourcearr - 1)).toList());
        List<String> target = new ArrayList<>(Arrays.stream(array.get(targetarr - 1)).toList());

        List<String> temporary = new ArrayList<>();

        for (int i = 0; i < move; i++) {
            temporary.add(source.get(source.size() - 1 - i));
        }

        target.addAll(temporary);

        for (int i = move; i > 0; i--) {
            source.remove(i);
        }

//        System.out.println("Source: " + source);
//        System.out.println("Target: " + target);
//        System.out.println("++++++++++++++++++++++++++++");
    }

}
