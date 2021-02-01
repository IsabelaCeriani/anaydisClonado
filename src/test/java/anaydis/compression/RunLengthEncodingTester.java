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

                String str = "AAABBC";
                InputStream inputStream = new ByteArrayInputStream(str.getBytes());
                OutputStream outputStream = new ByteArrayOutputStream();

//
                RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
                runLengthEncoding.encode(inputStream, outputStream);

                String result = outputStream.toString();


                Assert.assertEquals("3A2B1C\n", result);


        }

        @Test
        public void testDecode() throws IOException {


                String str = "3A2B1C";
                InputStream inputStream = new ByteArrayInputStream(str.getBytes());
                OutputStream outputStream = new ByteArrayOutputStream();

//
                RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
                runLengthEncoding.decode(inputStream, outputStream);

                String result = outputStream.toString();

                Assert.assertEquals("AAABBC", result);



        }



    }











