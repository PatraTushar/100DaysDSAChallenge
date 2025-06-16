package ArraysbyKK.binarySearchPattern;

public class Q26 {

    static int findMax(int[] piles){

        int max=Integer.MIN_VALUE;

        for(int i:piles){
            if (i>max){
                max=i;
            }
        }

        return max;
    }



    static int hrsTakenToCompleteBananas(int[] piles, int mid){

        int  totalHrs=0;

        for(int i=0;i<piles.length;i++){

            totalHrs+=Math.ceil((double) piles[i]/mid);
        }

        return totalHrs;




    }

    static int kokoEatingBananas(int[] piles,int hrs){



        int start=1;
        int end=findMax(piles);

        while (start<=end){
            int mid=start+(end-start)/2;

            int totalHrs= hrsTakenToCompleteBananas(piles,mid);

            if(totalHrs>hrs){
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }

        return start;
    }


    public static void main(String[] args) {

        // koko eating bananas leeTCode-->875

        int[] piles={3,6,7,11};
        int hrs=8;
        System.out.println(kokoEatingBananas(piles,hrs));


    }
}
