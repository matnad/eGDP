package uebungenMoritz.Blatt6;

public class TestGeneticEvolution {


        public static int mutateTo(Genpool pool, Genom species) {
            int year=0;
            while(pool.contains(species)==false){
                pool.mutate();
                year++;
            }
            //System.out.println("We found it after " + year + " years.");
            return year;
        }

        public static void main( String[] args ) {
            int len = 5;
            int poolSize = 1000;
            int years = 0;
            System.out.println("An examplar human genom in our model is:\n"+new Genom(len));
            System.out.println("An examplar small genpool in our model is:\n"+new Genpool(5,len));
            System.out.println("Starting simulation ...");
            for( int i=0; i<1000; ++i) {
                Genom species = new Genom(len);
                Genpool pool = new Genpool(poolSize,len);
                int year = mutateTo(pool,species);
                years += year;
            }
            System.out.println("Needed "+years/1000.0+" years in average.");
        }
    }

