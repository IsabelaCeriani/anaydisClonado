package anaydis.compression;

import org.junit.Assert;
import org.junit.Test;
import java.io.File;
import java.io.*;
import java.lang.instrument.Instrumentation;


class ObjectSizeFetcher {
    private static Instrumentation instrumentation;

    public static void premain(String args, Instrumentation inst) {
        instrumentation = inst;
    }

    public static long getObjectSize(Object o) {
        return instrumentation.getObjectSize(o);
    }
}


public class RunLengthEncodingTester {

    RunLengthEncoding  runLengthEncoding = new RunLengthEncoding();

    @Test
    public void testEncode() throws IOException {

        File file = new File("file.rtf");
        InputStream inputStream = new FileInputStream(file);
        OutputStream outputStream = new FileOutputStream(file);
        outputStream.write("A".getBytes());
        outputStream.write("A".getBytes());
        outputStream.write("A".getBytes());
        outputStream.write("A".getBytes());
        outputStream.write("B".getBytes());
        outputStream.write("C".getBytes());
        runLengthEncoding.encode(inputStream, outputStream);

//
//        File file = new File("/Users/isabelaceriani/Documents/Projects/Anaydis/RLE.txt");
//        FileInputStream fis = new FileInputStream(file);
//        InputStream is = new BufferedInputStream(fis);
//        FileOutputStream fos = new FileOutputStream(file);
//        OutputStream os = new BufferedOutputStream(fos);
//
//        long initialSize = ObjectSizeFetcher.getObjectSize(is);
//
//        runLengthEncoding.encode(is, os);
//
//       long finalSize =  ObjectSizeFetcher.getObjectSize(is);
//
//       Assert.assertTrue(initialSize > finalSize);


//        File file = new File("Listado de personas usando stream");
//
//
//        FileOutputStream outputStream = new FileOutputStream(file);
//        ObjectOutputStream oos = new ObjectOutputStream(outputStream);
//
//        FileOutputStream empty = new FileOutputStream(file);
//        FileInputStream fileInputStream = new FileInputStream(file);
//
//
//        oos.writeChar('a');
//        oos.writeChar('a');
//        oos.writeChar('b');
//
//        char char1 = (char)fileInputStream.read();
//        char char2 = (char) fileInputStream.read();
//        char char3 = (char) fileInputStream.read();
//
//        System.out.println(char1 + ", " + char2 + ", " + char3);
//
//
//
//
//        //runLengthEncoding.encode(fileInputStream, empty);

    }

}
