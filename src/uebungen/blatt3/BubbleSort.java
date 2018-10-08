package uebungen.blatt3;

class BubbleSort {

	  /**
	   * Vertauscht zwei Werte in einem Array an den gegebenen Positionen.
	   **/
	  public static void swap(int i, int j, char[] characters) {
	    /* DONE: Diese Methode muss implementiert werden */
          char temp = characters[i];
          characters[i] = characters[j];
          characters[j] = temp;
	  }

	  /**
	   * Sortiert das Eingabearray und aendert das Array in place
	   **/
	  public static void sort(char[] characters) {
	    /**
	     * DONE: Diese Methode muss implementiert werden
	     * TODO: Ist "A" oder "a" grösser?
	     */
		  boolean done = false;

		  while(!done){
		      done = true;
			  for(int i=0; i<characters.length-1; i++){
				  int a = Character.getNumericValue(characters[i]);
				  int b = Character.getNumericValue(characters[i+1]);
				  if (b > a) {
                      swap(i, i + 1, characters);
                      done = false;
                  }
			  }
		  }
	  }

	  /**
	   * Schreibt das Array auf die Ausgabekonsole
	   **/
	  public static void displayArray(char[] characters) {
	    /* DONE: Diese Methode muss implementiert werden */
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
