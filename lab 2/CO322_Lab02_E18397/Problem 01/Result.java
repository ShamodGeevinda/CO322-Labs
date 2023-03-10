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
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
    for (int i = 0; i<grades.size(); i++){
            
            if (grades.get(i)>=38){
                
                if(((grades.get(i)+1) % 5) == 0 ){
                    // for values like 39, 44 , 49
                    grades.set(i,grades.get(i) +1)  ;
                        
                }else if(((grades.get(i)+2) % 5) == 0 ){
                    // for values like 38, 43 , 48
                    grades.set(i,grades.get(i) +2)  ;
                    
                }
                else{
                    //no change in values already divide by 5 and not in above if and else if parts
                    //grades[i] = grades[i];
                }
            }else{
                
                // no change values below 38
                //grades[i] = grades[i];
                
           }
            
            //System.out.println(grades[i]);
             
        }
        return grades;
    // Write your code here

    

    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = IntStream.range(0, gradesCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        List<Integer> result = Result.gradingStudents(grades);

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