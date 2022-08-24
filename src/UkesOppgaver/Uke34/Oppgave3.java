package UkesOppgaver.Uke34;

class Min3 {

    //For at programmet kun skal printe ut posisjonen til det siste høyeste tallet så må man snu forloopen til å kjøre nedover

    public int maks(int[] a)  // a er en heltallstabell
    {
        if (a.length < 1)
            throw new java.util.NoSuchElementException("Tabellen a er tom!");

        int m = 0;

        for (int i = a.length - 1; i > 1; i--) // obs: starter med i = 1
        {
            if (a[i] > a[m]) m = i;
        }

        return m;

    }
}

public class Oppgave3 {
    public static void main(String[] args) {
        int [] array = {8,4,17,10,6,20,1,11,15,20,18,9,2,7,19};

        Min3 min = new Min3();

        System.out.println(min.maks(array));
    }
}
