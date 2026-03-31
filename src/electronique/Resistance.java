package electronique;

public class Resistance extends Composant {
    double Ohm;

    public Resistance(double ohm) {

        setOhm(ohm);
    }

    public double calculerResistance() {
        return this.Ohm;
    }

    public double getOhm() {
        return this.Ohm;
    }

    public void setOhm(double ohm) {
        verifierOhm(ohm);
        Ohm = ohm;
    }

    public void verifierOhm(double ohm) {
        if (ohm < 0) {
            throw new IllegalArgumentException("La valeur d'une résistance ne peut être négative :" + this.getOhm());
        }
    }
}
