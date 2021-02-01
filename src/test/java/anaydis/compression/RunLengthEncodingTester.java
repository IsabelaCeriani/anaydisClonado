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

                String str = "Call me Ishmael.  Some years ago--never mind how long\n" +
                        "precisely--having little or no money in my purse, and nothing\n" +
                        "particular to interest me on shore, I thought I would sail about a\n" +
                        "little and see the watery part of the world.  It is a way I have of\n" +
                        "driving off the spleen and regulating the circulation.  Whenever I\n" +
                        "find myself growing grim about the mouth; whenever it is a damp,";
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


                String str = "1C1a2l1 1m1e1 1I1s1h1m1a1e1l1.2 1S1o1m1e1 1y1e1a1r1s1 1a1g1o2-1n1e1v1e1r1 1m1i1n1d1 1h1o1w1 1l1o1n1g\n" +
                        "1p1r1e1c1i1s1e1l1y2-1h1a1v1i1n1g1 1l1i2t1l1e1 1o1r1 1n1o1 1m1o1n1e1y1 1i1n1 1m1y1 1p1u1r1s1e1,1 1a1n1d1 1n1o1t1h1i1n1g\n" +
                        "1p1a1r1t1i1c1u1l1a1r1 1t1o1 1i1n1t1e1r1e1s1t1 1m1e1 1o1n1 1s1h1o1r1e1,1 1I1 1t1h1o1u1g1h1t1 1I1 1w1o1u1l1d1 1s1a1i1l1 1a1b1o1u1t1 1a\n" +
                        "1l1i2t1l1e1 1a1n1d1 1s2e1 1t1h1e1 1w1a1t1e1r1y1 1p1a1r1t1 1o1f1 1t1h1e1 1w1o1r1l1d1.2 1I1t1 1i1s1 1a1 1w1a1y1 1I1 1h1a1v1e1 1o1f\n" +
                        "1d1r1i1v1i1n1g1 1o2f1 1t1h1e1 1s1p1l2e1n1 1a1n1d1 1r1e1g1u1l1a1t1i1n1g1 1t1h1e1 1c1i1r1c1u1l1a1t1i1o1n1.2 1W1h1e1n1e1v1e1r1 1I\n" +
                        "1f1i1n1d1 1m1y1s1e1l1f1 1g1r1o1w1i1n1g1 1g1r1i1m1 1a1b1o1u1t1 1t1h1e1 1m1o1u1t1h1;1 1w1h1e1n1e1v1e1r1 1i1t1 1i1s1 1a1 1d1a1m1p1,";
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











