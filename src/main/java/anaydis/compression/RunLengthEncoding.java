package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RunLengthEncoding implements anaydis.compression.Compressor{

    @Override
    public void encode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        int data = input.read();
        while(data!= -1){
            int count = 1;
            int i = data;
            while(data == i){
                count++;
                data = input.read();
            }
            if(count != 1) output.write(count+data);
            output.write(data);
        }

        input.close();
        output.close();
    }

    @Override
    public void decode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
        int data = input.read();
        while(data!= -1){
           

        }

        input.close();
        output.close();
    }
}
