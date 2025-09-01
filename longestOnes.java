package TwoPointer_SlidingWindow;

public class Q6 {


    // BRUTE FORCE APPROACH
    static int longestOnes(int[] arr,int k){

        //  Time Complexity: O(n^2)
        //  Space Complexity: O(1)

        int n=arr.length;
        int maxLength=0;


        for (int i=0;i<n;i++){

            int zeroesFlip=0;

            for(int j=i;j<n;j++){

                if(arr[j]==0){

                    zeroesFlip++;
                }

                if(zeroesFlip<=k){
                    int length=j-i+1;
                    maxLength=Math.max(maxLength,length);
                }

                else break;
            }


        }

        return maxLength;
    }


    static int longestOnesI(int[] arr,int k){

        //  Time Complexity: O(n)
        //  Space Complexity: O(1)

        int n=arr.length;
        int maxLength=0;
        int zeroesFlip=0;
        int left=0;
        int right=0;

        for(int i=0;i<n;i++){

            if(arr[right]==0){

                zeroesFlip++;
            }

           while (zeroesFlip>k){

               if(arr[left]==0){
                   zeroesFlip--;
               }

               left++;
           }
            int length=right-left+1;
            maxLength=Math.max(maxLength,length);
            right++;






        }

        return maxLength;




    }

    public static void main(String[] args) {

       // leeTCode->1004

        int[] arr={1,1,1,0,0,0,1,1,1,1,0};
        int k=2;
        System.out.println(longestOnes(arr,k));
        System.out.println(longestOnesI(arr,k));
    }
}
