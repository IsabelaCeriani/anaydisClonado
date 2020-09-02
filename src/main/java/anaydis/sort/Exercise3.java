package anaydis.sort;

import org.jetbrains.annotations.NotNull;
import java.util.Comparator;
import java.util.List;

public class Exercise3 {

    //Elijo el InsertionSorter ya que en el ejercicio 2 fue el que mejor performo para el average cae

    InsertionSorter insertionSorter = new InsertionSorter();

    public void sort(@NotNull List<FullName> list){
        sortByLastName(list);
        sortByName(list);

    }

    public void sortByName(@NotNull List<FullName> list){
        insertionSorter.sort(getNameComparator(), list);
    }

    public void sortByLastName(@NotNull List<FullName> list){
        insertionSorter.sort(getLastNameComparator(), list);
    }

    public Comparator<FullName> getNameComparator() {
        return Comparator.comparing(FullName::getFirstname);
        }


    public Comparator<FullName> getLastNameComparator() {
        return Comparator.comparing(FullName::getLastname);
    }

}
