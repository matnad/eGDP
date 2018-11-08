package uebungenMoritz.Blatt6;

 class Artikel {
    private  String name;
    private static  int number;
    private static  double price;
     private final static int BREITE = Kassenbon.getBreite();

    Artikel(String name, int number, double price){
        this.name = name;
        this.number = number;
        this.price = price;


    }
    double getPrice() {return price;}
    int getnumber(){return number;}

    public String toString() {
         String totalStr = String.format("%"+ BREITE +"s%.2f","",number*price);

         StringBuilder out = new StringBuilder();
         out.append(String.format("%s%"+ BREITE /2+"s", name,""), 0, BREITE /2);
         out.append(String.format("%2d x", number));
         out.append(String.format("  %.2f", price));
         out.append("\n").append(totalStr, totalStr.length()- BREITE, totalStr.length());
         return out.toString();
     }
}
