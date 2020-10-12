package anaydis.sort.quijote;


import anaydis.sort.MyMap;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OccurrencesCounter {

    MyMap<String, Integer> occurrences = new MyMap<>();
    File quijote = new File("/Users/isabelaceriani/Documents/Projects/Anaydis/anaydis-iceriani/src/main/java/anaydis/sort/quijote/quijote.txt");
    Scanner scanner = new Scanner(quijote);
    FileReader fileReader;

    {
        try {
            fileReader = new FileReader(quijote);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    BufferedReader bufferedReader = new BufferedReader(fileReader);

    public OccurrencesCounter() throws FileNotFoundException {

    }


    public void count() throws IOException{
      do{
          String word = scanner.next();
          occurrences.put(word, occurrences.containsKey(word) ? new Integer((Integer) occurrences.get(word) +1) : 1);
      }while (scanner.hasNext());

    }

//    public void count() throws IOException{
//    String bufferString = bufferedReader.readLine();
//
//        while(bufferString != null){
//            int index = occurrences.findKey(bufferString);
//            if(index != -1) {
//                Integer newValue = (Integer) occurrences.get(bufferString)+1;
//                occurrences.put(bufferString, newValue);
//                bufferString = bufferedReader.readLine();
//            }
//
//            occurrences.put(bufferString, 1);
//
//        bufferString = bufferedReader.readLine();
//    }
//        bufferedReader.close();
//        fileReader.close();
//
//    }

    public MyMap<String, Integer> getOccurrences() {
        return occurrences;
    }
}
