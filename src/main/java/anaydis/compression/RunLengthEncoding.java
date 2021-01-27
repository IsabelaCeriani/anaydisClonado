package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class RunLengthEncoding implements anaydis.compression.Compressor{


    @Override
    public void encode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String str = br.readLine();

            for (int i = 0; i < str.length(); i++) {
                int count = 1;
                while (i + 1< str.length() && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }

//                if (count!= 1)
                    output.write(Character.forDigit(count, 10));
                output.write(str.charAt(i));
//                if(count != 1) output.write(count);
            }


        }




    @Override
    public void decode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String str = br.readLine();
            for (int i = 0; i < str.length(); i+=2) {
                int count = Character.getNumericValue(str.charAt(i));
                int j = 0;
                while (j < count) {
                    output.write(str.charAt(i+1));
                    j++;
                }



            }


        }



}
