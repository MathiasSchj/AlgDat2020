package UkesOppgaver.Uke34;


import java.sql.SQLOutput;

class MinMaks {

    public int maks(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi (m for maks)

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] > a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    } // maks

    public int minimum(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig minste verdi (m for min)

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] < a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til minste verdi

    } // minimum

    public int[] minmaks(int [] a){

        int [] b = {};

        if (minimum(a) == 0) {
            b = new int[]{a[0], a[1]};
            return b;
        }
        return b;
    }

}

public class Oppgave5_113 {

    public static void main(String[] args) {
        int[] a = {1,5,4,7,2,6};

        int[] b = {3,7};

        MinMaks minMaks = new MinMaks();

        //System.out.println("Maksimum: " + minMaks.maks(a));
        //System.out.println("Minimum: " + minMaks.minimum(a));

        int [] c = minMaks.minmaks(b);

        for (int i = 0; i < c.length; i++) {
            System.out.println(c[i]);
        }

    }
}
