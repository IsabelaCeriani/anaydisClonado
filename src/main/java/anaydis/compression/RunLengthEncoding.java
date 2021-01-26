package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class RunLengthEncoding implements anaydis.compression.Compressor{


    @Override
    public void encode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String str = br.readLine();
        int counter = 0;
        while (str != null) {
            int n = str.length();
            for (int i = 0; i < n; i++) {

                // Count occurrences of current character
                int count = 1;
                while (i < n - 1 &&
                        str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }
                output.write(count);
                output.write(str.charAt(i));
                str = br.readLine();

            }
        }
        }


    @Override
    public void decode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String str = br.readLine();
        while (str != null) {
            for (int i = 0; i < str.length(); i+=2) {
                int count = Character.getNumericValue(str.charAt(i));
                for (int j = 0; j < count; j++) {
                    output.write(i);
                }
                str = br.readLine();
            }
        }

        }



}
