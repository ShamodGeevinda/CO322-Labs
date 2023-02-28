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
     * Complete the 'caesarCipher' function below.
     *
     * The function is expected to return a STRING.
     * The function accepts following parameters:
     *  1. STRING s
     *  2. INTEGER k
     */

    public static String caesarCipher(String s, int k) {
    // Write your code here
String alphabet = "abcdefghijklmnopqrstuvwxyz";
        String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String output = "";
         for(int i = 0 ; i < s.length(); i ++){
            
            // to store alphabet positions
            int currentPositionSimple;
            int currentPositionCapital;
            
            // getting current position according to in alphabets. (simple and capital)
            currentPositionCapital = ALPHABET.indexOf(s.charAt(i));
            currentPositionSimple = alphabet.indexOf(s.charAt(i));
            
            
            // for capital letters in the string
            if(currentPositionCapital != -1 && currentPositionSimple == -1){
               
                int cypherPlaceCapital = (k + currentPositionCapital) % 26;
                output += ALPHABET.charAt(cypherPlaceCapital);
                //System.out.print(ALPHABET.charAt(cypherPlaceCapital));
           }
           
           // for simpleletters in the string
            else if(currentPositionSimple != -1 && currentPositionCapital == -1){
              
               int cypherPlaceSimple = (k + currentPositionSimple) % 26;
               output += alphabet.charAt(cypherPlaceSimple);
               // System.out.print(alphabet.charAt(cypherPlaceSimple));
           }
           
           
            
            // when not a leter
            else if(currentPositionSimple == -1 && currentPositionCapital == -1){
                output += s.charAt(i);
                //System.out.print(s.charAt(i));
            }
            
        
            
        }
        //System.out.println("");
        
        return output;
    }
    

    }



public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        String s = bufferedReader.readLine();

        int k = Integer.parseInt(bufferedReader.readLine().trim());

        String result = Result.caesarCipher(s, k);

        bufferedWriter.write(result);
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}