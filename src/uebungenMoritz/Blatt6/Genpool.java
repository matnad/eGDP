package uebungenMoritz.Blatt6;
import java.util.Random;
import java.util.Arrays;

public class Genpool {

    public Genom[] genpool;
    public int len;
    public int n;

    Genpool( int n, int len ) {
        this.genpool = new Genom[n];
        this.len = len;
        this.n = n;
        randomize(len);
    }
    public Genom[] getGenPool() {
        return genpool;
    }
    private void randomize(int len) {
        for(int i = 0; i<n;i++) {
            Random rn = new Random();
            int range = len - 1 + 1;
            int randomNum =  rn.nextInt(range) + 1;
            Genom g = new Genom(randomNum);
            genpool[i] = g;
        }
    }
    public boolean contains(Genom species) {
        boolean cont=false;
        for(int i=0; i<n; i++)	{
            if(genpool[i].isEqual(species)==true)	{
                cont=true;
            }
        }
        return cont;
    }
    public void mutate() {
        for(int i=0; i<genpool.length; i++)	{
            Random rn = new Random();
            int range = 3;
            int randomNum =  rn.nextInt(range) + 1;
            if(randomNum==1)	{
                genpool[i].pointMutation();
            }
            if(randomNum==2)	{
                genpool[i].insertion();
            }
            if(randomNum==3)	{
                genpool[i].deletion();
            }
        }
    }
    public String toString() {
        return Arrays.toString(genpool);
    }

}


