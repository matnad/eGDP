package uebungenMoritz.Blatt3;




public class Bin2Dec {
    public static void main(String[] args){
        int dec = 0;
        int a = 1;
        int c = args.length;

        for ( int i = c-1; i >= 0; i--) {

            int b = Integer.parseInt(args[i]);
            dec = dec + b * a;
            a *= 2;


        }
        System.out.print(dec);
    }
}