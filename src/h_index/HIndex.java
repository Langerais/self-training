package h_index;
//Todo: Revisit, optimize

import java.util.Arrays;

public class HIndex {

    public static int hIndex(int[] citations) {
        Arrays.sort(citations);
        int h = 0;
        for(int i = citations.length-1; i >= 0; i--){
            if(citations[i] >= citations.length - i ){
                h++;
            } else return h;
        }
        return h;
    }
}
