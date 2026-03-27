package electronique;

public class Resistance extends Composant{
    double Ohm;
    public Resistance(double ohm){
        this.Ohm=ohm;
    }

    public double calculerResistance() {
        return this.Ohm;
    }
}
