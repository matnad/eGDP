package uebungenMoritz.Blatt3;

public class Dec2Hex {
    static public void main(String[] args){
        int dec  = Integer.parseInt(args[0]);
        char[] b = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        System.out.print("0x");
      /*  int a = 0;
            for( int i = 0; dec >= 1; i++){
                dec = dec / 16;
                a = i;
    }
    */
            for( int i = 3; i  >= 0; i--){
                int d = (int)(dec / (Math.pow(16,i)));
                if( d >= 1){
                    dec -= d * (Math.pow(16,i));
                    System.out.print(b[d]);
                }
                else System.out.print("0");





        }
}
}