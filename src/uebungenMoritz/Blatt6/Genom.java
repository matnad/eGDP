package uebungenMoritz.Blatt6;


import java.util.Arrays;
import java.util.Random;

public class Genom {
    public char[] genom;

    Genom(int len) {
        this.genom = new char[len];
        randomize();
    }

    public char[] getGenom() {
        return genom;
    }

    public String toString() {
        return Arrays.toString(genom);
    }

    public boolean isEqual(Genom species) {
        boolean test=false;
        String a=String.valueOf(species.getGenom());
        String b=String.valueOf(genom);
        if(a.equals(b)) {
            test=true;
            //System.out.println("The Winner is the species " + a + " which equals to " + b);
        }
        return test;
    }

    private void randomize() {
        char[] options = {'A','C','T','G'};
        Random rnd = new Random();
        for (int i = 0; i<genom.length; i++)	{
            genom[i]=options[rnd.nextInt(options.length)];
        }
    }

     /*private char getChar(int c) {
         return '@';
     }*/

    public void pointMutation() {
        Random rn = new Random();
        int range = genom.length;
        int randomNum =  rn.nextInt(range);
        char[] options = {'A','C','T','G'};
        Random rnd = new Random();
        int randomNum2 =  rnd.nextInt(4);
        genom[randomNum]=options[randomNum2];
    }

    public void insertion() {
        Random rn = new Random();
        int range = genom.length;
        int randomNum =  rn.nextInt(range);
        char[] val = new char[genom.length+1];
        char[] options = {'A','C','T','G'};
        Random rnd = new Random();
        for(int i=0; i<genom.length; i++) {
            val[i]=genom[i];
        }
        for(int i=randomNum; i<genom.length; i++) {
            val[i+1]=genom[i];
        }
        int randomNum2 =  rnd.nextInt(4);
        val[randomNum]=options[randomNum2];
        genom=val;
    }

    public void deletion() {
        if(genom.length!=1)	{
            Random rn = new Random();
            int range = genom.length;
            int randomNum =  rn.nextInt(range);
            char[] val = new char[genom.length-1];
            for(int i=randomNum; i<genom.length-1; i++) {
                genom[i]=genom[i+1];
            }
            for(int p=0; p<val.length; p++) {
                val[p]=genom[p];
            }
            genom=val;
        }
    }

}
