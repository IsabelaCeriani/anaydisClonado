package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RunLengthEncoding implements anaydis.compression.Compressor{


    @Override
    public void encode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        int data = input.read();
        int count = 0 ;
        while(data!= -1){
            int i = data;
            while(data == i){
                count++;
                i = input.read();
            }
            if(count != 1) output.write(data);
            output.write(count);
            output.write(data);
            count = 0;
            data = input.read();
        }





    }



    @Override
    public void decode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        while (input.available() > 0){
            int counter = input.read();
            char data = (char) input.read();
            for (int i = 0; i < counter; i++) {
                output.write(data);
            }
        }

    }
}
