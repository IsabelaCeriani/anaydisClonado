package anaydis.compression;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.*;
import java.lang.instrument.Instrumentation;


public class RunLengthEncodingTester {

    RunLengthEncoding runLengthEncoding = new RunLengthEncoding();

    @Test
    public void testEncode() throws IOException {


    }



    public static class MAin {
        public static void main(String[] args) throws IOException {



        File file = new File("/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/Untitled.RTF");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        outputStream.write("A".getBytes());
        outputStream.write("A".getBytes());
        outputStream.write("A".getBytes());
        outputStream.write("B".getBytes());
        outputStream.write("B".getBytes());
        outputStream.write("C".getBytes());

        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        runLengthEncoding.encode(inputStream, outputStream);

//        String str = br.readLine();
//        while (str != null) {
//            System.out.println(str);
//            str = br.readLine();
//
//        }

        runLengthEncoding.decode(inputStream, outputStream);

        String str = br.readLine();
        while (str != null) {
            System.out.println(str);
            str = br.readLine();

        }

            System.out.println("A");



        }





    }
}





