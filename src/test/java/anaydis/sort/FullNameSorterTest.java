package anaydis.sort;


import anaydis.sort.fullNameClasses.FullName;
import anaydis.sort.fullNameClasses.FullNameSorter;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class FullNameSorterTest {

    FullNameSorter fullNameSorter = new FullNameSorter();


    FullName alonsoPaula;
    FullName diazDiego;
    FullName alonsoDiego;

    List<FullName> fullNames = new ArrayList<>();

    {
        alonsoDiego = new FullName("Diego", "Alonso");
        diazDiego = new FullName("Diego", "Diaz");
        alonsoPaula = new FullName("Paula", "Alonso");
        fullNames.add(alonsoPaula);
        fullNames.add(diazDiego);
        fullNames.add(alonsoDiego);
//
    }



    @Test
    public void testSortByName(){
        List<String> auxNames = new ArrayList<>();
        fullNameSorter.sortByName(fullNames);
        fullNames.forEach(fullName -> auxNames.add(fullName.getFirstname()));
        assertThat(auxNames).isSorted();
    }

    @Test
    public void testSortByLastName(){
        List<String> auxLastNames = new ArrayList<>();
        fullNameSorter.sortByLastName(fullNames);
        fullNames.forEach(fullName -> auxLastNames.add(fullName.getLastname()));
        assertThat(auxLastNames).isSorted();
    }

    @Test
    public void testSort(){
        fullNameSorter.sort(fullNames);
        assertThat(fullNames).isSortedAccordingTo(fullNameSorter.getNameComparator());

    }

}
