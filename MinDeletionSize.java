package strings.InterviewQuestions;

public class Q11 {

    static int minDeletionSize(String[] str){

        // Time Complexity: O(rows*cols)
        //Space Complexity: O(1)

     int rows=str.length;
     int cols=str[0].length();
     int count=0;

     for(int j=0;j<cols;j++){

         for(int i=0;i<rows-1;i++){

             if(str[i].charAt(j)>str[i+1].charAt(j)){
                 count++;
                 break;
             }
         }
     }

     return count;


    }

    public static void main(String[] args) {

        // leeTCode->944

        String[] str={"cba","daf","ghi"};
        System.out.println(minDeletionSize(str));


    }
}
