package strings.InterviewQuestions;

public class Q1 {

    static int stringCompression(char[] chars) {

        //Time Complexity (TC): O(n)
        //Space Complexity (SC): O(1)



        int n=chars.length;
        int index=0;
        int i=0;

        while (i<n){

            char currChar=chars[i];
            int count=0;

            while (i<n && currChar==chars[i]){
                count++;
                i++;
            }

            chars[index++]=currChar;


            if(count>1){

                String str=String.valueOf(count);
                for(char ch : str.toCharArray()){

                    chars[index++]=ch;

                }


            }
        }

        return index;



    }

    public static void main(String[] args) {

        // leeTCode->443

        char[] ch = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        System.out.println(stringCompression(ch));


    }
}
