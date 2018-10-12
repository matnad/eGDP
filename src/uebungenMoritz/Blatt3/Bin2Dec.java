package uebungenMoritz.Blatt3;




public class Bin2Dec {
    public static void main(String[] args){
        int dec = 0;
        int a = 1;
        int c = args.length;

        for ( int i = c; i >= 1; i--) {

            int b = Integer.parseInt(args[i-1]);
            dec = dec + b * a;
            a *= 2;


        }
        System.out.print(dec);
    }
}