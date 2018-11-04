package uebungen.blatt7;

/* Die Komplexen Zahlen a+b i, mit (a+bi)+(c+di) = (a+c)+(b+d)i und (a+bi)(c+di) = (ac-bd)+(ad+bc)i */
class Complex {
    private double a;
    private double b;

  /* Definieren Sie hier die Daten der Klasse */
	

  /* Der Konstruktor */
  public Complex(double a, double b) { 
    /* Implementieren */
      this.a = a;
      this.b = b;
  }

  /* Zugriff auf den realen Anteil */
  public double real() {
      return a;
  }

  /* Zugriff auf den imaginaeren Anteil */
   public double imag() {
       return b;
   }

  /* Multiplikation ohne Veraenderung der beteiligten Objekte */
  public Complex mult(Complex o) {
      Complex n = this;
      double real = n.a * o.a - n.b * o.b;
      double imag = n.a * o.b + n.b * o.a;

      return new Complex(real, imag);
  }

  /* Multiplikation mit Veraenderung der beteiligten Objekte. Gibt this zurueck */
  public Complex mult_inplace(Complex o) {
      Complex n = mult(o);
      this.a = n.real();
      this.b = n.imag();
      return this;
  }

  /* Das Quadrat (c^2 = c*c) ohne Veraenderung der beteiligten Objekte */
   public Complex sqr() {
       Complex n = this;
       double real = n.a * n.a - n.b * n.b;
       double imag = n.a * n.b + n.b * n.a;

       return new Complex(real, imag);
   }

  /* Das Quadrat (c^2 = c*c) in place. Veraendert das Objekt und gibt this zurueck. */
   public Complex sqr_inplace() {
       Complex n = this.sqr();
       this.a = n.a;
       this.b = n.b;
       return this;
   }

  /* Das Quadrat des Betrags */
  public double abs_sqr() {
      return a*a + b*b;
  }

  /* Addition zweier komplexer Zahlen ohne Veraenderung der beteiligten Objekte */
  public Complex add(Complex d) {
      Complex c = this;
      double real = c.a + d.a;
      double imag = c.b + d.b;
      return new Complex(real, imag);
  }

  /* Addition zweier komplexer Zahlen mit Veraenderung der beteiligten Objekte */
  public Complex add_inplace(Complex d) {
      Complex c = add(d);
      this.a = c.real();
      this.b = c.imag();
      return this;
  }
}
