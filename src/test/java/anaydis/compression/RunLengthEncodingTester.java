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

//                String str = "97, 97, 97, 97, 97, 97, 97, 97, 97, 32, 97, 109, 97, 115, 97, 32, 97, 109, 97, 115, 97, 32, 97, 109, 97, 115, 97";
            String str = "Call me Ishmael.  Some years ago--never mind how long\n" +
                    "precisely--having little or no money in my purse, and nothing\n" +
                    "particular to interest me on shore, I thought I would sail about a\n" +
                    "little and see the watery part of the world.  It is a way I have of\n" +
                    "driving off the spleen and regulating the circulation.  Whenever I\n" +
                    "find myself growing grim about the mouth; whenever it is a damp,\n" +
                    "drizzly November in my soul; whenever I find myself involuntarily\n" +
                    "pausing before coffin warehouses, and bringing up the rear of every\n" +
                    "funeral I meet; and especially whenever my hypos get such an upper\n" +
                    "hand of me, that it requires a strong moral principle to prevent me\n" +
                    "from deliberately stepping into the street, and methodically knocking\n" +
                    "people's hats off--then, I account it high time to get to sea as soon\n" +
                    "as I can.  This is my substitute for pistol and ball.  With a\n" +
                    "philosophical flourish Cato throws himself upon his sword; I quietly\n" +
                    "take to the ship.  There is nothing surprising in this.  If they but\n" +
                    "knew it, almost all men in their degree, some time or other, cherish\n" +
                    "very nearly the same feelings towards the ocean with me.";
//                String shortString = "AAABBC";
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


//                String str= "19171,1 19171,1 19171,1 19171,1 19171,1 19171,1 19171,1 19171,1 19171,1 13121,1 19171,1 1110191,1 19171,1 21151,1 19171,1 13121,1 19171,1 1110191,1 19171,1 21151,1 19171,1 13121,1 19171,1 1110191,1 19171,1 21151,1 1917";
//               String str = "3A2B1C\n";
            String str = "1C1a2l1 1m1e1 1I1s1h1m1a1e1l1.2 1S1o1m1e1 1y1e1a1r1s1 1a1g1o2-1n1e1v1e1r1 1m1i1n1d1 1h1o1w1 1l1o1n1g\n" +
                    "1p1r1e1c1i1s1e1l1y2-1h1a1v1i1n1g1 1l1i2t1l1e1 1o1r1 1n1o1 1m1o1n1e1y1 1i1n1 1m1y1 1p1u1r1s1e1,1 1a1n1d1 1n1o1t1h1i1n1g\n" +
                    "1p1a1r1t1i1c1u1l1a1r1 1t1o1 1i1n1t1e1r1e1s1t1 1m1e1 1o1n1 1s1h1o1r1e1,1 1I1 1t1h1o1u1g1h1t1 1I1 1w1o1u1l1d1 1s1a1i1l1 1a1b1o1u1t1 1a\n" +
                    "1l1i2t1l1e1 1a1n1d1 1s2e1 1t1h1e1 1w1a1t1e1r1y1 1p1a1r1t1 1o1f1 1t1h1e1 1w1o1r1l1d1.2 1I1t1 1i1s1 1a1 1w1a1y1 1I1 1h1a1v1e1 1o1f\n" +
                    "1d1r1i1v1i1n1g1 1o2f1 1t1h1e1 1s1p1l2e1n1 1a1n1d1 1r1e1g1u1l1a1t1i1n1g1 1t1h1e1 1c1i1r1c1u1l1a1t1i1o1n1.2 1W1h1e1n1e1v1e1r1 1I\n" +
                    "1f1i1n1d1 1m1y1s1e1l1f1 1g1r1o1w1i1n1g1 1g1r1i1m1 1a1b1o1u1t1 1t1h1e1 1m1o1u1t1h1;1 1w1h1e1n1e1v1e1r1 1i1t1 1i1s1 1a1 1d1a1m1p1,\n" +
                    "1d1r1i2z1l1y1 1N1o1v1e1m1b1e1r1 1i1n1 1m1y1 1s1o1u1l1;1 1w1h1e1n1e1v1e1r1 1I1 1f1i1n1d1 1m1y1s1e1l1f1 1i1n1v1o1l1u1n1t1a1r1i1l1y\n" +
                    "1p1a1u1s1i1n1g1 1b1e1f1o1r1e1 1c1o2f1i1n1 1w1a1r1e1h1o1u1s1e1s1,1 1a1n1d1 1b1r1i1n1g1i1n1g1 1u1p1 1t1h1e1 1r1e1a1r1 1o1f1 1e1v1e1r1y\n" +
                    "1f1u1n1e1r1a1l1 1I1 1m2e1t1;1 1a1n1d1 1e1s1p1e1c1i1a2l1y1 1w1h1e1n1e1v1e1r1 1m1y1 1h1y1p1o1s1 1g1e1t1 1s1u1c1h1 1a1n1 1u2p1e1r\n" +
                    "1h1a1n1d1 1o1f1 1m1e1,1 1t1h1a1t1 1i1t1 1r1e1q1u1i1r1e1s1 1a1 1s1t1r1o1n1g1 1m1o1r1a1l1 1p1r1i1n1c1i1p1l1e1 1t1o1 1p1r1e1v1e1n1t1 1m1e\n" +
                    "1f1r1o1m1 1d1e1l1i1b1e1r1a1t1e1l1y1 1s1t1e2p1i1n1g1 1i1n1t1o1 1t1h1e1 1s1t1r2e1t1,1 1a1n1d1 1m1e1t1h1o1d1i1c1a2l1y1 1k1n1o1c1k1i1n1g\n" +
                    "1p1e1o1p1l1e1'1s1 1h1a1t1s1 1o2f2-1t1h1e1n1,1 1I1 1a2c1o1u1n1t1 1i1t1 1h1i1g1h1 1t1i1m1e1 1t1o1 1g1e1t1 1t1o1 1s1e1a1 1a1s1 1s2o1n\n" +
                    "1a1s1 1I1 1c1a1n1.2 1T1h1i1s1 1i1s1 1m1y1 1s1u1b1s1t1i1t1u1t1e1 1f1o1r1 1p1i1s1t1o1l1 1a1n1d1 1b1a2l1.2 1W1i1t1h1 1a\n" +
                    "1p1h1i1l1o1s1o1p1h1i1c1a1l1 1f1l1o1u1r1i1s1h1 1C1a1t1o1 1t1h1r1o1w1s1 1h1i1m1s1e1l1f1 1u1p1o1n1 1h1i1s1 1s1w1o1r1d1;1 1I1 1q1u1i1e1t1l1y\n" +
                    "1t1a1k1e1 1t1o1 1t1h1e1 1s1h1i1p1.2 1T1h1e1r1e1 1i1s1 1n1o1t1h1i1n1g1 1s1u1r1p1r1i1s1i1n1g1 1i1n1 1t1h1i1s1.2 1I1f1 1t1h1e1y1 1b1u1t\n" +
                    "1k1n1e1w1 1i1t1,1 1a1l1m1o1s1t1 1a2l1 1m1e1n1 1i1n1 1t1h1e1i1r1 1d1e1g1r2e1,1 1s1o1m1e1 1t1i1m1e1 1o1r1 1o1t1h1e1r1,1 1c1h1e1r1i1s1h\n" +
                    "1v1e1r1y1 1n1e1a1r1l1y1 1t1h1e1 1s1a1m1e1 1f2e1l1i1n1g1s1 1t1o1w1a1r1d1s1 1t1h1e1 1o1c1e1a1n1 1w1i1t1h1 1m1e1.";
                InputStream inputStream = new ByteArrayInputStream(str.getBytes());
                OutputStream outputStream = new ByteArrayOutputStream();

//
                RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
                runLengthEncoding.decode(inputStream, outputStream);

                String result = outputStream.toString();

                System.out.println(result);

//                Assert.assertEquals("AAABBC", result);



        }



    }











