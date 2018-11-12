package uebungenMoritz.Blatt7;

/* Die Komplexen Zahlen a+b i, mit (a+bi)+(c+di) = (a+c)+(b+d)i und (a+bi)(c+di) = (ac-bd)+(ad+bc)i */
class Complex {

    /* Definieren Sie hier die Daten der Klasse */
    double a, b;

    /* Der Konstruktor */
    public Complex(double a, double b) {
        this.a=a; this.b=b;
    }

    /* Zugriff auf den realen Anteil */
    public double real() {
        return this.a;
    }

    /* Zugriff auf den imaginaeren Anteil */
    public double imag() {
        return this.b;
    }

    /* Multiplikation ohne Veraenderung der beteiligten Objekte */
    public Complex mult(Complex o) {
        Complex result = new Complex(o.a, o.b);
        result.a = (this.a*o.a)-(this.b*o.b);
        result.b = (this.a*o.b)+(this.b*o.a);
        return result;
    }

    /* Multiplikation mit Veraenderung der beteiligten Objekte. Gibt this zurueck */
    public Complex mult_inplace(Complex o) {
        Complex result = new Complex(this.a, this.b);
        result.a = (this.a*o.a)-(this.b*o.b);
        result.b = (this.a*o.b)+(this.b*o.a);
        this.a = result.a;
        this.b = result.b;
        return this;
    }

    /* Das Quadrat (c^2 = c*c) ohne Veraenderung der beteiligten Objekte */
    public Complex sqr() {
        Complex result = new Complex(this.a, this.b);
        result.a = (this.a*this.a)-(this.b*this.b);
        result.b = (this.a*this.b)+(this.b*this.a);
        return result;
    }

    /* Das Quadrat (c^2 = c*c) in place. Veraendert das Objekt und gibt this zurueck. */
    public Complex sqr_inplace() {
        Complex result = new Complex(this.a, this.b);
        this.a = (result.a*result.a)-(result.b*result.b);
        this.b = (result.a*result.b)+(result.b*result.a);
        return this;
    }

    /* Das Quadrat des Betrags */
    public double abs_sqr() {
        double result;
        result = ((this.a*this.a)+(this.b*this.b));
        return result;
    }

    /* Addition zweier komplexer Zahlen ohne Veraenderung der beteiligten Objekte */
    public Complex add(Complex c) {
        Complex result = new Complex(c.a, c.b);
        result.a = (this.a+c.a);
        result.b = (this.b+c.b);
        return result;
    }

    /* Addition zweier komplexer Zahlen mit Veraenderung der beteiligten Objekte */
    public Complex add_inplace(Complex c) {
        this.a = (this.a+c.a);
        this.b = (this.b+c.b);
        return this;
    }
}
