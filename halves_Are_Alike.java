package strings.InterviewQuestions;

public class Q8 {

    static boolean halvesAreAlike(String s) {

        // Time Complexity: O(n)
        //Space Complexity: O(1)

        int n = s.length();
        int vowels1 = 0;
        int vowels2 = 0;
        String vowels = "aeiouAEIOU";

        int length = n / 2;

        for(int i=0;i<length;i++){

            if(vowels.indexOf(s.charAt(i))!=-1) vowels1++;
        }

        for(int i=length;i<n;i++){

            if(vowels.indexOf(s.charAt(i))!=-1) vowels2++;
        }

        return vowels1==vowels2;


    }

    public static void main(String[] args) {

          // leeTCode->1704

        String s = "book";
        System.out.println(halvesAreAlike(s));


    }
}
