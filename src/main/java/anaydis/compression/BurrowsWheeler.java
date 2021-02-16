package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.util.Arrays;

public class BurrowsWheeler implements anaydis.compression.Compressor {
//

    @Override
    public void encode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        PrintWriter pr = new PrintWriter(outputStream);
        DataOutputStream dos = new DataOutputStream(outputStream);


        int index = 0;
        while ((str = br.readLine()) != null) {
            //genero el array de strings con todas las rotaciones
            String[] strs = new String[str.length()];
            for (int i = 0; i < strs.length; ++i) {
                strs[i] = str.substring(i) + str.substring(0, i);
            }
            //los ordeno de manera que sus iniciales esten en orden alfabetico creciente
            java.util.Arrays.sort(strs);


            //genero el output (String formado por el ultimo char de cada string del arreglo + la posicion del primer char del input original)
            for (int i = 0; i < strs.length; ++i) {
                pr.write(strs[i].charAt(strs[i].length() - 1));
                if (strs[i].charAt(strs[i].length() - 1) == str.charAt(0)) index = i;
            }
            pr.println();
        }

        //escribo el indice del primer char original al final del mensaje
        dos.writeInt(index);
        pr.flush();

    }




    @Override
    public void decode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        //leo el mensaje
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str = "";
        PrintWriter pr = new PrintWriter(outputStream);



        //leo los bytes del input setream y busco el indice de la primera posicion (4 bytes)
        byte[] indexBytes = new byte[4];
        inputStream.read(indexBytes);
        int  firstCharPosition = ByteBuffer.wrap(indexBytes).getInt();

        String outputStr = "";

        while ((str = br.readLine()) != null) {


            //ordeno L para obtener F
            char[] sorted = str.toCharArray();
            java.util.Arrays.sort(sorted);

            //creo un array de integer(vector de transformacion)
            Integer[] indexes = new Integer[sorted.length];
//            for (int i = 0; i < indexes.length; i++) {
//                indexes[i] = i;
//            }


            //ordeno el vector de transformacion
            for (int i = 0; i < str.length(); i++) {
                for (int j = 0; j < sorted.length; j++) {
                    if (str.charAt(i) == sorted[j]) {
                        indexes[j] = i;
                        sorted[j] = 'å';
                        break;
                    }
                }
            }

            //empzando desde el primer indice y usando el vector para saber donde posicionarme en el str, decodifico el input y lo escribo en el output

            int index = firstCharPosition;
            for (int i = 0; i < indexes.length; i++) {
                pr.write(str.charAt(index));
                index = indexes[index];
            }
            pr.println();

        }

        pr.flush();


    }
//
//    @Override
//    public void decode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
//        //leo el mensaje
//        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//        String str = "";
//        PrintWriter pr = new PrintWriter(outputStream);
//
//        //leo los bytes del inputstream y busco el indice de la primera posicion (4 bytes)
//        byte[] indexBytes = new byte[4];
//        inputStream.read(indexBytes);
////        inputStream.
//        int  firstCharPosition = ByteBuffer.wrap(indexBytes).getInt();
//
//
//
//        while ((str = br.readLine()) != null) {
//            //ordeno L para obtener F
//            byte[] sortedBytes = Arrays.copyOf(str.getBytes(), str.length()-4);
//            char[] sorted = ByteBuffer.wrap(sortedBytes).asCharBuffer().array();
//            java.util.Arrays.sort(sorted);
//
////            byte[] sorted = Arrays.copyOf(str.getBytes(), str.length()-4);
////            Arrays.sort(sorted);
////            char[] sortedChars = ByteBuffer.wrap(sorted).asCharBuffer().array();
//


}
