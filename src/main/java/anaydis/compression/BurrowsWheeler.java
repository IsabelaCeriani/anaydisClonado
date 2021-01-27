package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class BurrowsWheeler implements anaydis.compression.Compressor {
    @Override
    public void encode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str = br.readLine();
        str+="$";
            String[] strs = new String[str.length()];
            for (int i = 0; i < strs.length; ++i) {
                strs[i] = str.substring(i) + str.substring(0, i);
                System.out.println(strs[i]);
            }
            //sorts the array in ascending order
            java.util.Arrays.sort(strs);


            for (int i = 0; i < strs.length; ++i) {
//                System.out.println(strs[i].charAt(strs[i].length() - 1));
                outputStream.write(strs[i].charAt(strs[i].length() - 1));
            }

    }
//ANNB$AA

    @Override
    public void decode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str = br.readLine();

        Integer[] indexes = new Integer[str.length()-1];
        int firstCharPosition = 0;
        for (int i = 0; i < indexes.length; ++i) {
            indexes[i] = i;
            if(str.charAt(i) == '$'){
                firstCharPosition = i-1;
                StringBuilder sb = new StringBuilder(str);
                sb.deleteCharAt(i);
                str = (String)sb.toString();
            }
        }


        char[] sorted = str.toCharArray();
        java.util.Arrays.sort(sorted);

        int firstPositionSorted = 0;
        for (int i = 0; i < sorted.length; i++) {
            if(sorted[i] == str.charAt(firstCharPosition))firstPositionSorted = i;
        }

        for (int i = firstCharPosition; i >0; i--) {
                outputStream.write(str.charAt(i));
//                System.out.println(str.charAt(i));
            for (int j = firstPositionSorted-1; j >0; j--) {
                outputStream.write(sorted[j]);
//                System.out.println(sorted[j]);
                break;
            }
        }



    }


}
