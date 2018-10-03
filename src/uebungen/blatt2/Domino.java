package uebungen.blatt2;
public class Domino {
    public static void main(String[] args) {
        int min = 0;
        int max = 6;
        String out_msg = "";
        for(int i=min; i <= max; i++){
            for(int j=i; j <= max; j++){
                out_msg += "("+i+"|"+j+"), ";
            }
        }
        out_msg = out_msg.substring(0, out_msg.length() - 2); // remove last ", "
        System.out.println(out_msg);

    }
}