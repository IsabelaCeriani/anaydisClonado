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


        File file = new File("/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/Untitled.rtf");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        outputStream.write("AAABBC".getBytes());

        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
        runLengthEncoding.encode(inputStream, outputStream);

        StringBuilder stringBuilder = new StringBuilder();
        String str = br.readLine();
        Assert.assertEquals("3A2B1C", str);


    }

    @Test
    public void testDecode() throws IOException {

//        File file = new File("/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/Untitled.RTF");
//        InputStream inputStream = new FileInputStream(file);
//        OutputStream outputStream = new FileOutputStream(file);
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//        outputStream.write("3A2B1C".getBytes());
//        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
//        runLengthEncoding.decode(inputStream, outputStream);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        String str = br.readLine();
//        Assert.assertEquals("AAABBC", str);



}
//
//public static class Main{
//
//    public static void main(String[] args) throws IOException {
//        File file = new File("/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/Untitled.RTF");
//        InputStream inputStream = new FileInputStream(file);
//        OutputStream outputStream = new FileOutputStream(file);
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
////        outputStream.write("Call me Ishmael.  Some years ago--never mind how long precisely--having little or no money in my purse, and nothing particular to interest me on shore, I thought I would sail about a little and see the watery part of the world".getBytes());
//        outputStream.write("1C1a2l1 1m1e1 1I1s1h1m1a1e1l1.2 1S1o1m1e1 1y1e1a1r1s1 1a1g1o2-1n1e1v1e1r1 1m1i1n1d1 1h1o1w1 1l1o1n1g1 1p1r1e1c1i1s1e1l1y2-1h1a1v1i1n1g1 1l1i2t1l1e1 1o1r1 1n1o1 1m1o1n1e1y1 1i1n1 1m1y1 1p1u1r1s1e1,1 1a1n1d1 1n1o1t1h1i1n1g1 1p1a1r1t1i1c1u1l1a1r1 1t1o1 1i1n1t1e1r1e1s1t1 1m1e1 1o1n1 1s1h1o1r1e1,1 1I1 1t1h1o1u1g1h1t1 1I1 1w1o1u1l1d1 1s1a1i1l1 1a1b1o1u1t1 1a1 1l1i2t1l1e1 1a1n1d1 1s2e1 1t1h1e1 1w1a1t1e1r1y1 1p1a1r1t1 1o1f1 1t1h1e1 1w1o1r1l1d\n".getBytes());
////        outputStream.write("3A2B1C".getBytes());
//        RunLengthEncoding runLengthEncoding = new RunLengthEncoding();
//        runLengthEncoding.decode(inputStream, outputStream);
//
//        StringBuilder stringBuilder = new StringBuilder();
//        String str = br.readLine();
//        System.out.println(str);
//
//
//    }
}










