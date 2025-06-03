public class CompressString {

    public static String compressString(String s){

        StringBuilder buffer = new StringBuilder();
        int count = 1;
        char[] in = s.toCharArray();

        if(in.length == 0) { return s; }


        for(int i = 1; i < in.length; i++){

            if(in[i] == in[i-1]){
                count++;
            } else {
                buffer.append(in[i - 1]).append(count);
                count = 1;
            }

        }

        buffer.append(in[in.length - 1]).append(count);

        return buffer.toString();
    }

}
