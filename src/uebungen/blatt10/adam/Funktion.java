package uebungen.blatt10.adam;

public class Funktion {

    int funktion(int an, int k) {

        if (k==0)
            return an;

        if (an == 1)
            return funktion(1, k-1);
        else if( an % 2 == 0)
            return funktion(an/2, k-1);
        else
            return funktion(3*an + 1, k-1);
    }

    int funktion2 (int an) {

        int k=0;
        while (an != 1) {
            if (an % 2 == 0)
                an /= 2;
            else
                an = 3*an+1;
            k++;
        }
        return k;
    }

}

