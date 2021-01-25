package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class RunLengthEncoding implements anaydis.compression.Compressor{


    @Override
    public void encode(@NotNull InputStream input, @NotNull OutputStream output) throws IOException {
//        int position = input.read();
//        char data = (char) position;
//        int count = 0;
//        while(position != -1){
//            int i = data;
//            while(data == (char)i){
//                count++;
//                position = input.read();
//                i = position;
//            }
//
//            if(count == 1){
//                output.write(data);
//
//            }
//            if (count >0){
//            output.write(count);
//            output.write(data);
//
//            position = input.read();
//
//
//        }
//
//        }

        int position = input.read();
        while (position != -1) {
            int count = 1;
            int next = input.read();
            while (next == position) {
                count++;
                next = input.read();
            }
            output.write(count);
            output.write(position);


        }

    }

//    @Override
//    public void encode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
//        char read = (char) inputStream.read();
//        int counter = 0;
//        char countingChar = read;
//
//        while(read != (char) -1){
//            if(read == countingChar){
//                counter++;
//
//            } else {
//
//                outputStream.write(counter);
//                outputStream.write(countingChar);
//                counter = 1;
//                countingChar = read;
//            }
//            read = (char) inputStream.read();
//        }
//
//        if (counter >0){
//            outputStream.write(counter);
//            outputStream.write(countingChar);
//        }
//    }



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
