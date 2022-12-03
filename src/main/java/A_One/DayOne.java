package A_One;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DayOne {
    
    public static void main(String[] args) throws IOException {
        File file = new File("src\\main\\java\\One\\day1_input.txt");
        Scanner scanner = new Scanner(file);
        
        Pattern pattern = Pattern.compile("[0-9]+");
        Matcher matcher;
        
        List<Integer> values = new ArrayList<>();
        int number = 0;
        
        while(scanner.hasNextLine()) {
            matcher = pattern.matcher(scanner.nextLine());
            
            if(matcher.find()) {
                number += Integer.parseInt(matcher.group());
            } else {
                values.add(number);
                number = 0;
            }
        }
        
        values.sort(Collections.reverseOrder());
        int bestOfThree = 0;
    
        for(int i = 0; i < 3; i++) {
            bestOfThree += values.get(i);
            System.out.println(String.format("Elf Nr %s hat %s Kalorien zu tragen:",i + 1,values.get(i)));
        }
    
        System.out.println("Summe der drei Besten: " + bestOfThree);
    }
}
