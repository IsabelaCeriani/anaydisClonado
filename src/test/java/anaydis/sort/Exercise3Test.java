package anaydis.sort;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;


public class Exercise3Test {

    Exercise3 exercise3 = new Exercise3();

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
        exercise3.sortByName(fullNames);
        fullNames.forEach(fullName -> auxNames.add(fullName.getFirstname()));
        assertThat(auxNames).isSorted();
    }

    @Test
    public void testSortByLastName(){
        List<String> auxLastNames = new ArrayList<>();
        exercise3.sortByLastName(fullNames);
        fullNames.forEach(fullName -> auxLastNames.add(fullName.getLastname()));
        assertThat(auxLastNames).isSorted();
    }

    @Test
    public void testSort(){
        exercise3.sort(fullNames);
        assertThat(fullNames).isSortedAccordingTo(exercise3.getNameComparator());

    }

}
