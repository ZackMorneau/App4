package electronique;

import java.util.ArrayList;
import java.util.List;

public class CircuitParallele extends Circuit {
    public CircuitParallele(List<Composant> composants){
        super(composants);
    }

    public double calculerResistance() {
        double ResisTotal=0;
        for (int i = 0; composants.get(i) != null; i++) {
          ResisTotal+= 1/composants.get(i).calculerResistance();
        }
        double x=1/ResisTotal;

        return x;
    }
}
