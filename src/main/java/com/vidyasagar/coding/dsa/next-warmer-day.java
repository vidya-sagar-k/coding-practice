package com.example.sagar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// https://leetcode.com/problems/daily-temperatures/
@SpringBootApplication
public class SagarApplication {

    private static List<Integer> getWarmerDay(List<Integer> temp) {
        int n = temp.size();

        List<Integer> result = new ArrayList<>();

        for ( int  i = 0; i<n; i++) result.add(0);

        if (n == 0) return result;
        if (n == 1) return Arrays.asList(0);

        Stack<Integer> st = new Stack<>();

        st.push(0); // index

        for (int i = 1; i<temp.size(); i++) {
            if (st.isEmpty() || temp.get(i) <= temp.get(st.peek())) {
                // push
                st.push(i);
                continue;
            }

            // warmer

            while(!st.isEmpty() && temp.get(i) > temp.get(st.peek())) {
                // keep popping and setting the result
                int poppedIndex = st.pop();
                result.set(poppedIndex, i - poppedIndex);
            }

            st.push(i);
        }

//      while(!st.isEmpty()) {
//          // keep popping and setting the result as 0 for them
//          int poppedIndex = st.pop();
//          result.set(poppedIndex, 0);
//      }

        return result;

    }

    public static void main(String[] args) {
        SpringApplication.run(SagarApplication.class, args);



        System.out.println(getWarmerDay(Arrays.asList(75, 73,78,75,71,69,72,76,73)));

    }

}
