package anaydis.compression;

import anaydis.sort.sorters.InsertionSorter;
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

        System.out.println(result);
//
//        Assert.assertEquals("OBRSDDB\n", result);

    }

    @Test
    public void testDecode() throws IOException {

//        String str = "DRDOBBS";
        String str = "97, 115, 97, 97, 97, 97, 97, 97, 97, 97, 97, 97, 32, 97, 109, 97, 115, 97, 32, 97, 109, 97, 115, 97, 32, 97, 109, 10";
        InputStream inputStream = new ByteArrayInputStream(str.getBytes());
        OutputStream outputStream = new ByteArrayOutputStream();


        burrowsWheeler.encode(inputStream, outputStream);
        InputStream newInputStream = new ByteArrayInputStream(outputStream.toString().getBytes());
        OutputStream newoutputStream = new ByteArrayOutputStream();


        burrowsWheeler.decode(newInputStream, newoutputStream);

        String result = newoutputStream.toString();

        System.out.println(result);

//        Assert.assertEquals("DRDOBBS\n",result);

    }
}
