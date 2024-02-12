package com.challenge;


import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

class Result {

    /*
     * Complete the 'cookies' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER k
     *  2. INTEGER_ARRAY A
     */
/*
   Big O -> nlogn (nlogn/2) -> nlogn
 */
    public static int cookies(int k, List<Integer> A) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(A);
        int counter=0;
        if(queue.peek()>k){
            return 0;
        }
        while(queue.size()>=2 && queue.peek()<k){
            queue.add(queue.poll()+queue.poll()*2);
            counter++;
        }
        return queue.peek()<k ? -1 :counter;
    }

}

public class PerfectCookies {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter("cookies.txt"));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int k = Integer.parseInt(firstMultipleInput[1]);

        List<Integer> A = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.cookies(k, A);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}