package uebungen.blatt3;

class BubbleSort {

	  /**
	   * Vertauscht zwei Werte in einem Array an den gegebenen Positionen.
	   **/
	  public static void swap(int i, int j, char[] characters) {
	    /* Diese Methode muss implementiert werden */
	  }

	  /**
	   * Sortiert das Eingabearray und aendert das Array in place
	   **/
	  public static void sort(char[] characters) {
	    /* Diese Methode muss implementiert werden */
	  }

	  /**
	   * Schreibt das Array auf die Ausgabekonsole
	   **/
	  public static void displayArray(char[] characters) {
	    /* Diese Methode muss implementiert werden */
		  System.out.println(characters);
	  }

	  /**
	   * Die Hauptfunktion liest das Character Array und ruft die Sortierfunktion
	   * und die Ausgabefunktion auf
	   **/
	  public static void main(String[] args) {
	    if (args.length != 1) {
	      System.out.println("Bitte rufen Sie das Programm mit einem Eingabewert auf");
	      System.out.println("  java BubbleSort 'dies ist ein text'");
	      System.exit(-1);
	    }
	    char[] characters = args[0].toCharArray();

	    sort(characters);

	    displayArray(characters);
	  }
	}
