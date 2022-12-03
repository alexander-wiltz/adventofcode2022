package C_Three;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Three {

    //https://adventofcode.com/2022/day/3

    // splitte string in 2 gleiche hälften (Stringlänge / 2)
    // iteriere über erste hälfte und suche, character im anderen string
    // unterbreche die iteration, suche priorität (a-z = 1-26; A-Z = 27-52)
    // addiere Prio pro Zeile

    // Part 2:
    // finde gemeinsamen Buchstaben in drei aufeinanderfolgenden Zeilen
    // berechne Priorität

    // https://www.torsten-horn.de/techdocs/ascii.htm
    // A = 65, Z = 90
    // a = 97, z = 122

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("src\\main\\java\\C_Three\\input.txt");
        Scanner scanner = new Scanner(file);

        int sum = 0;
        List<String> elfen = new ArrayList<>();

        while (scanner.hasNext()) {
            String str = scanner.nextLine();

            final int mid = str.length() / 2;
            String[] splitted = {str.substring(0, mid), str.substring(mid)};

            elfen.add(str);

            int ascii = 0;
            for (char s : splitted[0].toCharArray()) {
                if (splitted[1].contains(String.valueOf(s))) {
                    if (Character.isUpperCase(s)) {
                        ascii = 64 - 26;
                    } else if (Character.isLowerCase(s)) {
                        ascii = 96;
                    }
                    sum += (int) (s - ascii);
                    // System.out.println("Gemeinsam: " + s + ", Prio: " + (int) (s - ascii));
                    break;
                }
            }
        }

        final int GROUPSIZE = 3;
        String[][] alleGruppen = new String[elfen.size() / GROUPSIZE][GROUPSIZE];

        for (int i = 1; i <= elfen.size(); i++) {
            int bigindex = Math.round((i - 1) / 3) + 1;
            alleGruppen[bigindex - 1][(i - 1) % 3] = elfen.get(i - 1);
        }

        int groupsum = 0;
        for (String[] strings : alleGruppen) {
            int ascii = 0;
            for (char s : strings[0].toCharArray()) {
                if (strings[1].contains(String.valueOf(s)) && strings[2].contains(String.valueOf(s))) {
                    if (Character.isUpperCase(s)) {
                        ascii = 64 - 26;
                    } else if (Character.isLowerCase(s)) {
                        ascii = 96;
                    }
                    groupsum += (int) (s - ascii);
                    break;
                }
            }
        }

        System.out.println("Teil 1 - Summe der Prioritäten ist: " + sum);
        System.out.println("Teil 2 - Summe der Prioritäten ist: " + groupsum);

    }
}
