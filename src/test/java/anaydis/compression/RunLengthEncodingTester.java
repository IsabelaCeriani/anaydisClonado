package anaydis.compression;

import org.junit.Test;
import java.io.File;
import java.io.*;

public class RunLengthEncodingTester {

    RunLengthEncoding  runLengthEncoding = new RunLengthEncoding();

    @Test
    public void testEncode() throws IOException {
        //public void encode(@NotNull InputStream input, @NotNull OutputStream output)
        File file = new File("Listado de personas usando stream");


        FileOutputStream outputStream = new FileOutputStream(file);
        ObjectOutputStream oos = new ObjectOutputStream(outputStream);

        FileOutputStream empty = new FileOutputStream(file);
        FileInputStream fileInputStream = new FileInputStream(file);


        oos.writeChar('a');
        oos.writeChar('a');
        oos.writeChar('b');

        char char1 = (char)fileInputStream.read();
        char char2 = (char) fileInputStream.read();
        char char3 = (char) fileInputStream.read();

        System.out.println(char1 + ", " + char2 + ", " + char3);




        //runLengthEncoding.encode(fileInputStream, empty);


    }
}
