import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'climbingLeaderboard' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY ranked
     *  2. INTEGER_ARRAY player
     */

    public static List<Integer> climbingLeaderboard(List<Integer> ranked, List<Integer> player) {
    // Write your code here
       
        List<Integer> out = new ArrayList<>();
        
        //List<Integer> newList = new ArrayList<>(ranked.size() + player.size());
        //newList.addAll(ranked);
        //newList.addAll(player);
        
        
        Set<Integer> targetSet = new HashSet<>(ranked);
        List<Integer> sortedList = new ArrayList<>(targetSet);
        Collections.sort(sortedList);
        int i = 0;
        
        for (Integer play : player){
             while (i<sortedList.size() && sortedList.get(i)<=play){
                 i+=1;
                 // if(player.get(j) > sortedList.get(sortedList.size()-1)){
                 //     out.add(1);
                 //     break;
                 //}
                 // else (player.get(j) < sortedList.get(i)){
                 //     out.add(sortedList.size()-i+1);
                 //     break;
                 // }
             }
            out.add(sortedList.size() - i +1);
            
            //out.add(sortedList.size() - sortedList.indexOf(player.get(i)));
            //System.out.println(sortedList.size() +" " +sortedList.indexOf(player.get(i)));
        }
        
        return out;

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int rankedCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> ranked = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        int playerCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> player = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.climbingLeaderboard(ranked, player);

        bufferedWriter.write(
            result.stream()
                .map(Object::toString)
                .collect(joining("\n"))
            + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}
