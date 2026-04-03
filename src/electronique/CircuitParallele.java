package electronique;

import java.util.ArrayList;
import java.util.List;

public class CircuitParallele extends Circuit {
    public CircuitParallele(List<Composant> composants) {
        super(composants);
    }

    public double calculerResistance() {
        double ResisTotal = 0;
        for (int i = 0; i < composants.size(); i++) {
            ResisTotal += 1 / composants.get(i).calculerResistance();
        }
        if (ResisTotal == 0) {
            return 0;
        }
        return 1 / ResisTotal;
    }
}
