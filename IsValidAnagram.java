package Hashmap.InterviewQuestion;

import java.util.HashMap;
import java.util.Map;

public class Q1 {

    static boolean isValidAnagram(String s1,String s2){  // optimal Approach


        if(s1.length()!=s2.length()) return false;

        int[] count=new int[26];

        for(int i=0;i<s1.length();i++){

            count[s1.charAt(i)-'a']++;
            count[s2.charAt(i)-'a']--;
        }

        for(int val:count){
            if(val!=0) return false;
        }

        return true;

    }


    static Map<Character,Integer> makeFreq(String str){

        Map<Character,Integer> mp=new HashMap<>();

       for (int i=0;i<str.length();i++){

           if(!mp.containsKey(str.charAt(i))){
               mp.put(str.charAt(i),1);
           }

           else {
               mp.put(str.charAt(i),mp.get(str.charAt(i))+1);
           }
       }

       return mp;
    }

    static boolean validAnagram(String s1,String s2){    // Approach 2

        if(s1.length()!=s2.length() ) return false;

        Map<Character,Integer> m=makeFreq(s1);

        for (int i=0;i<s2.length();i++){

            Character ch=s2.charAt(i);

            if(!m.containsKey(ch)) return false;

            int currFreq=m.get(ch);
            m.put(ch,currFreq-1);

        }

        // All values in m should be 0 for both s1 nad s2

        for(Integer i:m.values()){

            if(i!=0) return false;



        }

        return true;


    }

    static boolean isAnagram(String s1,String s2){  // Approach 1

        if(s1.length()!=s2.length() ) return false;


        Map<Character,Integer> m1=makeFreq(s1);
        Map<Character,Integer> m2=makeFreq(s2);




        return m1.equals(m2);





    }

    public static void main(String[] args) {

        // valid Anagram (leeTCode-->242)

        String s1="listen";
        String s2="silent";

    //    System.out.println(isAnagram(s1,s2));
        System.out.println(isValidAnagram(s1,s2));


    }
}
