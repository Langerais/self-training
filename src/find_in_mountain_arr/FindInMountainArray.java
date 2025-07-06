package find_in_mountain_arr;

public class FindInMountainArray {

    static class MountainArray {
        private int[] arr;
        private int getCount = 0; // Optional: to simulate call limit

        public MountainArray(int[] input) {
            this.arr = input;
        }

        public int get(int index) {
            getCount++;
            if (index < 0 || index >= arr.length) {
                throw new IndexOutOfBoundsException("Index out of range: " + index);
            }
            return arr[index];
        }

        public int length() {
            return arr.length;
        }

        // Optional: to check call limit
        public int getCallCount() {
            return getCount;
        }
    }

    public static void main(String[] args) {
        int[] arr1 = {1,2,3,4,5,3,1};
        MountainArray mArr1 = new MountainArray(arr1);
        System.out.println(findInMountainArray(3, mArr1));
    }


    public static int findPeak(MountainArray mArr){

        int left = 0, right = mArr.length() - 1, mid = 0;
        while (left < right){
            mid = left + (right - left) / 2;
            if(mArr.get(mid) < mArr.get(mid+1)) left = mid + 1;
            else right = mid;
        }
        return left;
    }

    public static int findTarget(int target, MountainArray mArr, int searchDirection, int peak){

        int left, right, mid = 0;

        if(searchDirection == -1){ //search right
            left = peak;
            right = mArr.length() - 1;
        } else {    //search left
            right = peak-1;
            left = 0;
        }
        while (left < right){
            int val = mArr.get(mid);
            if(val == target) return mid;

            mid = left + (right - left) / 2;
            if( val * searchDirection < target * searchDirection ) left = mid + 1;
            else right = mid;

        }

        return -1;
    }

    public static int findInMountainArray(int target, MountainArray mountainArr) {
        int peak = findPeak(mountainArr);
        int result = findTarget(target, mountainArr, 1, peak);
        if(result != -1) return result;
        return findTarget(target, mountainArr, -1, peak);
    }











}
