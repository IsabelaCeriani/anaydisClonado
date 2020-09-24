package anaydis.sort.benchmarks;

import anaydis.animation.sort.gui.Main;
import anaydis.sort.SorterProviderClass;

public interface AnimatedMain {

     static void main(String[] args) {
        Main.animate(new SorterProviderClass());
    }
}
