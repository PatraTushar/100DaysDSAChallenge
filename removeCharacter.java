package RecursionByStriver.InterviewQuestions;

public class Q1 {

    static void removeCharacter(String str,String ans){

        // Time Complexity: O(n)
        //Space Complexity: O(n)

        if(str.isEmpty()) {
            System.out.println(ans);
            return;
        }

        char ch=str.charAt(0);

        if(ch!='a'){

            removeCharacter(str.substring(1),ans+ch);

        }

        else {

            removeCharacter(str.substring(1),ans);

        }




    }

    static String removeCharacterI(String str,String ans){

        //Time Complexity: O(n)
        //Space Complexity: O(n)

        if(str.isEmpty()) return ans;

        char ch=str.charAt(0);

        if(ch!='a'){

            return removeCharacterI(str.substring(1),ans + ch );
        }

        else {

            return removeCharacterI(str.substring(1),ans);
        }
    }



    public static void main(String[] args) {

        // Remove character from a string

        String str="baccad";
        removeCharacter(str,"");
        String ans=removeCharacterI(str,"");
        System.out.println(ans);





    }
}
