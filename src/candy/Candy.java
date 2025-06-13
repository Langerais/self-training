package candy;

import java.util.ArrayList;
import java.util.Arrays;

public class Candy {


    //TODO TRY FROM SIDES
    //TODO || DOESNT WORK


    public static void main(String[] args) {

        int[] c1 = {1,3,2,2,1};
        int[] c2 = {1,2,87,87,87,2,1};

        System.out.println(candy(c1));
        System.out.println(candy(c2));

    }



    public static int candy(int[] ratings) {


        int[] candies = new int[ratings.length];
        int min = ratings[0];

        for(int i = 0; i < ratings.length; i++){
            candies[i] = 1;
            if (ratings[i] < min) {
                min = ratings[i];
            }
        }


        int i = 1;

        while (ratings[i] == min && i < ratings.length - 1) i++;

        while (i < ratings.length - 1){

            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }

            if (ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }

            if(ratings[i] == ratings[i-1] && ratings[i] == ratings[+1]){
                candies[i] = 1;
            }


            i++;
        }


        i = ratings.length-2;


        while (ratings[i] == min && i > 0) i--;

        while (i > 0){

            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            }

            if (ratings[i] > ratings[i + 1]) {
                candies[i] = candies[i + 1] + 1;
            }

            if(ratings[i] == ratings[i-1] && ratings[i] == ratings[+1]){
                candies[i] = 1;
            }


            i--;
        }

        candies[0] = ratings[0] > ratings[1] ? candies[1] + 1 : 1;
        candies[candies.length-1] = ratings[candies.length-1] > ratings[candies.length-2] ? candies[candies.length-2] + 1 : 1;

        int total = 0;
        for(int candie : candies){
            total += candie;
        }

        System.out.println(Arrays.toString(candies));
        return total;
    }


}

