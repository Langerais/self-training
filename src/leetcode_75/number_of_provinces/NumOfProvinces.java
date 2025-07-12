package leetcode_75.number_of_provinces;

import java.util.HashSet;

//TODO REVISIT/FINISH

public class NumOfProvinces {

    public int findCircleNum(int[][] isConnected) {

        int provinces = isConnected.length * 2;
        int connections = 0;
        boolean unvisited = true;


        HashSet<Integer> visited = new HashSet<>();

        for(int i = 0; i < isConnected.length; i++){

            for(int j = 0; j < isConnected[i].length; j++){

                if(isConnected[i][j] == 1){
                    isConnected[i][j] = 0;
                    isConnected[j][i] = 0;
                }

            }

            provinces -= connections;
            connections = 0;

        }

        return provinces <= 0 ? 1 : provinces;
    }


}
