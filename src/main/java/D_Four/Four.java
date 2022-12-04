package D_Four;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Four {

    // https://adventofcode.com/2022/day/4
    public static void main(String[] args) throws FileNotFoundException {
        // nehme linkes Paar, nehme rechtes Paar
        // prüfe bei welchem der anfang größer ist als beim anderen
        // prüfe ob bei kleinerem, die Zahl kleiner ist als beim gegenspieler
        // gegenprüfe ob die größere Zahl größer ist als beim gegenspieler
        // dann ist die range komplett enthalten, setze boolean => true
        // zähle, wenn true +=1

        File file = new File("src\\main\\java\\D_Four\\input.txt");
        Scanner scanner = new Scanner(file);

        int[][][] alleGruppen = new int[1000][2][2];
        int gruppe = 0;
        int elf = 0;

        while (scanner.hasNext()) {
            String[] strings = scanner.nextLine().split(",");

            for (String part : strings) {
                String[] ranges = part.split("-");
                int min = Integer.parseInt(ranges[0]);
                int max = Integer.parseInt(ranges[1]);
                alleGruppen[gruppe][elf][0] = min;
                alleGruppen[gruppe][elf][1] = max;

                elf += 1;
            }
            elf = 0;
            gruppe += 1;
        }

        int count = 0;
        for (int i = 0; i < alleGruppen.length; i++) {
            // gets group from all
//            System.out.println("******************************************************************");
//            System.out.println(
//                    "Bereich: " + alleGruppen[i][0][0] + " - " + alleGruppen[i][0][1]
//                            + " vs "
//                            + "Bereich: " + alleGruppen[i][1][0] + " - " + alleGruppen[i][1][1]
//            );
            if (alleGruppen[i][0][0] <= alleGruppen[i][1][0] && alleGruppen[i][0][1] >= alleGruppen[i][1][1]) {
                // Minimum von Elf 1 ist kleiner als das von Elf 2
                // Maximum von Elf 1 ist größer als das von Elf 2
                // => Elf 2-Bereich komplett in Elf 1-Bereich
//                System.out.println(
//                        "Min Elf 1: " + alleGruppen[i][0][0] +
//                                " ist kleiner als das Min von Elf 2: " + alleGruppen[i][1][0] + "\n"
//                                + "Max Elf 1: " + alleGruppen[i][0][1] +
//                                " ist größer als das Max von Elf 2: " + alleGruppen[i][1][1]
//                );
//                System.out.println("Zähle!");
                count += 1;
            } else if (alleGruppen[i][0][0] >= alleGruppen[i][1][0] && alleGruppen[i][0][1] <= alleGruppen[i][1][1]) {
                // Minimum von Elf 2 ist kleiner als das von Elf 1
                // Maximum von Elf 2 ist größer als das von Elf 1
                // => Elf 1-Bereich komplett in Elf 2-Bereich
//                System.out.println(
//                        "Min Elf 2: " + alleGruppen[i][1][0] +
//                                " ist kleiner als das Min von Elf 1: " + alleGruppen[i][0][0] + "\n"
//                                + "Max Elf 2: " + alleGruppen[i][1][1] +
//                                " ist größer als das Max von Elf 1: " + alleGruppen[i][0][1]
//                );
//                System.out.println("Zähle!");
                count += 1;
            } else {
                //System.out.println("Keine Überschneidung!");
                continue;
            }

        }
        //System.out.println();
        System.out.println("Gruppen mit Überschneidungen: " + count);

        // ---- TEIL 2 ----
        int countSimilar = 0;

        for (int i = 0; i < alleGruppen.length; i++) {
            List<Integer> elf1 = new ArrayList<>();
            List<Integer> elf2 = new ArrayList<>();
            for (int j = alleGruppen[i][0][0]; j <= alleGruppen[i][0][1]; j++) {
                // get numbers in range of elf 1
                elf1.add(j);
            }
            for (int k = alleGruppen[i][1][0]; k <= alleGruppen[i][1][1]; k++) {
                // get numbers in range of elf 2
                elf2.add(k);
            }

            Collection<Integer> similar = new HashSet<>(elf1);
            similar.retainAll(elf2);
//            System.out.println("***************************************************");
//            System.out.println("Liste 1: " + Arrays.asList(elf1));
//            System.out.println("Liste 2: " + Arrays.asList(elf2));
//            System.out.println(Arrays.asList(similar));
            if(similar.size() > 0) {
                countSimilar += 1;
            }
        }

        System.out.println("Gruppen mit gemeinsamen Bereichen: " + countSimilar);
    }
}
