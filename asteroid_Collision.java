package StackByStriver.interviewQuestions;

import java.util.Arrays;
import java.util.Stack;

public class Q12 {

    static int[] asteroidCollision(int[] asteroids){

        //Time Complexity (TC): O(N)
        //Space Complexity (SC): O(N)


        if (asteroids == null || asteroids.length == 0) return new int[0];

        Stack<Integer> st=new Stack<>();

        for(int ele : asteroids){



            boolean destroyed=false;


            while (!st.isEmpty() && ele<0 && st.peek()>0){

                if(Math.abs(ele)>st.peek()){
                    st.pop();
                    continue;
                }

                else if(Math.abs(ele)<st.peek()){
                    destroyed=true;
                    break;
                }

                else {
                    st.pop();
                    destroyed=true;
                    break;
                }


            }

            if(!destroyed){

                st.push(ele);
            }
        }

        int n=st.size();
        int[] result =new int[n];
        for(int i=n-1;i>=0;i--){
            result[i]=st.pop();
        }

        return result;
    }

    public static void main(String[] args) {

        int[] arr={4,7,1,1,2,-3,-7,17,15,-16};
        int[] ans=asteroidCollision(arr);
        System.out.println(Arrays.toString(ans));
    }
}
