package peak_in_mountain_arr;

public class PeakIndexInMountainArray {


    public static void main(String[] args) {


        int[] arr1 = {13, 25, 38, 55, 58, 75, 85, 88, 100, 94, 88, 82, 60, 58, 48, 43, 40, 35, 17, 2};
        int[] arr2 = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        int[] arr3 = {30, 40, 48, 61, 75, 100, 99, 98, 39, 30, 10};

        //System.out.println(peakIndexInMountainArray(arr1));
        System.out.println("_____________________");
        //System.out.println(peakIndexInMountainArray(arr2));
        System.out.println("_____________________");
        System.out.println(peakIndexInMountainArray(arr3));


    }


    public static int peakIndexInMountainArray(int[] arr) {
        int left = 0, right = arr.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] < arr[mid + 1]) left = mid + 1;
            else right = mid;
        }
        return left;
    }
}





