package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class RunLengthEncoding implements anaydis.compression.Compressor{


    @Override
    public void encode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
//        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(output));
        String str = "";
        PrintWriter pr = new PrintWriter(output);

        while ((str = br.readLine()) != null) {
            for (int i = 0; i < str.length(); i++) {
                int count = 1;
                while (i + 1 < str.length() && str.charAt(i) == str.charAt(i + 1)) {
                    count++;
                    i++;
                }

                pr.write(Character.forDigit(count, 10));
                pr.write(str.charAt(i));
            }

//            bw.newLine();
//            String lineSeparator = System.getProperty("line.separator");
//            pr.append(lineSeparator);
//            pr.write("\n\r");
            //pr.write(10);

        }
//        PrintWriter pr = new PrintWriter(bw);

        pr.flush();
//




    }





    @Override
    public void decode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(input));
        String line = br.readLine();
        StringBuilder str = new StringBuilder();

        //paso todo el archivo a un string
        while(line!=null){
            str.append(line);
            line = br.readLine();
        }

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
