package Hashmap.InterviewQuestion;

import java.util.HashMap;
import java.util.Map;

public class Q2 {

    static boolean isIsomorphic(String s1,String s2){

        Map<Character,Character> mp=new HashMap<>();

        for(int i=0;i<s1.length();i++){

            char s1Ch=s1.charAt(i);
            char s2Ch=s2.charAt(i);

            if(mp.containsKey(s1Ch)){

                if(mp.get(s1Ch)!=s2Ch) return false;
            }

            else {

                if(mp.containsValue(s2Ch)) return false;

                mp.put(s1Ch,s2Ch);


            }



        }

        return true;
    }

    public static void main(String[] args) {

        // Isomorphic String leeTCode-->205)

        String s1="aab";
        String s2="xxy";
        System.out.println(isIsomorphic(s1,s2));
    }
}
