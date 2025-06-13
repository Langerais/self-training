package gas_station;

import java.util.ArrayList;
import java.util.Arrays;

public class GasStation {


    public static void main(String[] args) {

        int[] gas = {1,2,3,4,5};
        int[] cost = {3,4,5,1,2};

        System.out.println(canCompleteCircuit(gas, cost));


        int[] gas2 = {2,3,4};
        int[] cost2 = {3,4,3};

        System.out.println(canCompleteCircuit(gas2, cost2));


    }

    public static int canCompleteCircuit(int[] gas, int[] cost) {
        int totalTank = 0;
        int currTank = 0;
        int startIndex = 0;

        for (int i = 0; i < gas.length; i++) {
            int net = gas[i] - cost[i];
            totalTank += net;
            currTank += net;

            if (currTank < 0) {
                startIndex = i + 1;
                currTank = 0;
            }
        }

        return totalTank >= 0 ? startIndex : -1;
    }




}
