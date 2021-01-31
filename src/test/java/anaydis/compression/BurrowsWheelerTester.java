package anaydis.compression;

import org.junit.Assert;
import org.junit.Test;

import java.io.*;

public class BurrowsWheelerTester {

    BurrowsWheeler burrowsWheeler = new BurrowsWheeler();


    @Test
    public void testEncode() throws IOException {


        String str = "DRDOBBS";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();


        burrowsWheeler.encode(inputStream, outputStream);

        String result = outputStream.toString();

        Assert.assertEquals("OBRSDDB5", result);


    }

    @Test
    public void testDecode() throws IOException {
//


        String str = "OBRSDDB5";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();


        burrowsWheeler.decode(inputStream, outputStream);

        String result = outputStream.toString();

        Assert.assertEquals("DRDOBBS", result);



    }
}
