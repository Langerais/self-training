public class ReverseString {

    public static void main(String[] args) {
        String input = "hello world here";


        char[] inputChars = input.toCharArray();
        reverseWordsInPlace(inputChars);


        System.out.println(new String(inputChars));
        // Expected output: "here world hello"


        char[] arr = "one two three four".toCharArray();
        reverseWordsInPlace(arr);
        System.out.println(new String(arr));
        // Expected: "four three two one"


        char[] arrSingle = "singleword".toCharArray();
        reverseWordsInPlace(arrSingle);
        System.out.println(new String(arrSingle));
        // Expected: "singleword"


        char[] arr2 = "  leading and  multiple   spaces  ".toCharArray();
        reverseWordsInPlace(arr2);
        System.out.println(new String(arr2));
    }


    /**
     * Reverses the words in a char array in-place:
     * first reverses entire array, then reverses each word.
     *
     * @param s character array of the sentence
     */
    public static void reverseWordsInPlace(char[] s) {
        // Reverse the whole array first
        reverse(s, 0, s.length - 1);

        // Then reverse each individual word
        int start = 0;
        for (int end = 0; end <= s.length; end++) {
            if (end == s.length || s[end] == ' ') {
                reverse(s, start, end - 1);
                start = end + 1;
            }
        }
    }

    /**
     * Helper to reverse a subarray in-place
     */
    private static void reverse(char[] arr, int left, int right) {
        while (left < right) {
            char temp = arr[left];
            arr[left++] = arr[right];
            arr[right--] = temp;
        }
    }
}
