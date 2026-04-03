package electronique;

import java.util.ArrayList;
import java.util.List;
public class CircuitSerie extends Circuit {
    public CircuitSerie(List<Composant> composants) {
        super(composants);
    }

    public double calculerResistance() {
        double SommeResisTotal = 0;
        for (int i = 0; i < composants.size(); i++) {
            SommeResisTotal += composants.get(i).calculerResistance();
        }
        return SommeResisTotal;
    }
}
