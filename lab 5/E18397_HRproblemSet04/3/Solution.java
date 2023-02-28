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
     * Complete the 'shortPalindrome' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts STRING s as parameter.
     */

  
    
    public static int shortPalindrome(String s) {

        int length = s.length();
        int count = 0;
        char array[] = s.toCharArray();
        if (length < 4){
            System.out.println("0");
            return 0;
        }
        for (int i = 0; i < length-3; i++){
            for (int j = length-1; j > i+2; j--){
                if (array[i] == array[j]){
                    //count+=findPairs(i, j, array, length);
                    for (int k = i + 1; k < j ; k++ ){
                        for (int m = j - 1; m > k; m--){
                            if (array[k] == array[m]){
                                count++;
                            }
                        }
                    }
                }
            }

        }
        return count%(1000000000 + 7);

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        String s = bufferedReader.readLine();

        int result = Result.shortPalindrome(s);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}