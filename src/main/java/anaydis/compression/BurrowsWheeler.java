package anaydis.compression;

import org.jetbrains.annotations.NotNull;

import java.io.*;

public class BurrowsWheeler implements anaydis.compression.Compressor {
    @Override
    public void encode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        //paso el input a string
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str = br.readLine();
//        str+="$";

        //genero el array de strings con todas las rotaciones
            String[] strs = new String[str.length()];
            for (int i = 0; i < strs.length; ++i) {
                strs[i] = str.substring(i) + str.substring(0, i);
            }
            //los ordeno de manera que sus iniciales esten en orden alfabetico creciente
            java.util.Arrays.sort(strs);


            //genero el output (String formado por el ultimo char de cada string del arreglo + la posicion del primer char del input original)
            int index = 0;
            for (int i = 0; i < strs.length; ++i) {
                outputStream.write(strs[i].charAt(strs[i].length() - 1));
                if(strs[i].charAt(strs[i].length() - 1) == str.charAt(0)) index = i;
            }
             outputStream.write(Character.forDigit(index, 10));


    }
//ANNB$AA

    @Override
    public void decode(@NotNull InputStream inputStream, @NotNull OutputStream outputStream) throws IOException {
        //paso el input a string
        BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
        String str = br.readLine();

        //busco la posicion del primer indice y lo borro del input (str es mi L)
        int firstCharPosition = Character.getNumericValue(str.charAt(str.length()-1));
        StringBuilder sb = new StringBuilder(str);
        sb.deleteCharAt(str.length()-1);
        str = (String)sb.toString();


        //ordeno L para obtener F
        char[] sorted = str.toCharArray();
        java.util.Arrays.sort(sorted);

        //creo un array de integer(vector de transformacion)
        Integer[] indexes = new Integer[sorted.length];
        for (int i = 0; i < indexes.length; i++) {
            indexes[i] = i;
        }


        //ordeno el vector de transformacion
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < sorted.length; j++) {
                if(str.charAt(i) == sorted[j]) {
                    indexes[j] = i;
                    sorted[j] = 'å';
                    break;
                }
            }
        }



        for (int i = 0; i < indexes.length; i++) {
            System.out.println(indexes[i]);
        }

//
        int index = firstCharPosition;
        for ( int i = 0 ; i < indexes.length; i++ ) {
            outputStream.write(str.charAt(index));
            index = indexes[index];
        }







//
//        int firstPositionSorted = 0;
//        for (int i = 0; i < sorted.length; i++) {
//            if(sorted[i] == str.charAt(firstCharPosition))firstPositionSorted = i;
//        }
//
//        for (int i = firstCharPosition; i >0; i--) {
//                outputStream.write(str.charAt(i));
////                System.out.println(str.charAt(i));
//            for (int j = firstPositionSorted-1; j >0; j--) {
//                outputStream.write(sorted[j]);
////                System.out.println(sorted[j]);
//                break;
//            }
//        }



    }


}
