package anaydis.compression;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.*;
import java.lang.instrument.Instrumentation;


public class RunLengthEncodingTester {


//        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
//        String encodedInput;

        @Test
        public void testEncode() throws IOException {

                String str = "97, 97, 97, 97, 97, 97, 97, 97, 97, 32, 97, 109, 97, 115, 97, 32, 97, 109, 97, 115, 97, 32, 97, 109, 97, 115, 97";
                InputStream inputStream = new ByteArrayInputStream(str.getBytes());
                OutputStream outputStream = new ByteArrayOutputStream();

//
                RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
                runLengthEncoding.encode(inputStream, outputStream);

                String result = outputStream.toString();

                System.out.println(result);;
//                Assert.assertEquals("3A2B1C\n", result);


        }

        @Test
        public void testDecode() throws IOException {


                String str = "19171,1 19171,1 19171,1 19171,1 19171,1 19171,1 19171,1 19171,1 19171,1 13121,1 19171,1 1110191,1 19171,1 21151,1 19171,1 13121,1 19171,1 1110191,1 19171,1 21151,1 19171,1 13121,1 19171,1 1110191,1 19171,1 21151,1 1917";
                InputStream inputStream = new ByteArrayInputStream(str.getBytes());
                OutputStream outputStream = new ByteArrayOutputStream();

//
                RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
                runLengthEncoding.decode(inputStream, outputStream);

                String result = outputStream.toString();

                System.out.println(result);

//                Assert.assertEquals("AAABBC\n", result);



        }



    }











