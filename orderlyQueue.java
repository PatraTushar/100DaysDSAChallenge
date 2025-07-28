package strings.InterviewQuestions;

import OopsByKK.AccessModifier.Public.A;

import java.util.Arrays;

public class Q6 {

    static String orderlyQueue(String s,int k){

        //Time Complexity: O(n²) for k == 1, O(n log n) for k > 1
        //Space Complexity: O(n)

        if(k==1){

            String result=s;

            for(int i=1;i<s.length();i++){

                String rotated=s.substring(i)+s.substring(0,i);

                if(rotated.compareTo(result)<0){
                    result=rotated;
                }
            }

            return result;
        }

        else {

            char[] chars=s.toCharArray();
            Arrays.sort(chars);
            return new String(chars);

        }
    }

    public static void main(String[] args) {

        // leeTCode->899

        String s1="cba";
        int k1=1;

        String s2="baaca";
        int k2=3;

        String Ans=orderlyQueue(s1,k1);
        System.out.println(Ans);


    }
}
