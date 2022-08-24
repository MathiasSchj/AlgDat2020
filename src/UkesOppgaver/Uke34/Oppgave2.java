package UkesOppgaver.Uke34;

class Min {

    public int maks(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;  // indeks til foreløpig største verdi (m for maks)

        for (int i = 1; i < a.length; i++) // obs: starter med i = 1
        {
            if (a[i] < a[m]) m = i;  // indeksen oppdateres
        }

        return m;  // returnerer indeksen/posisjonen til største verdi

    } // maks
}

public class Oppgave2 {
    public static void main(String[] args) {
        int [] array = {8,4,17,10,6,20,1,11,15,3,18,9,2,7,19};

        Min min = new Min();

        System.out.println(min.maks(array));
    }
}
