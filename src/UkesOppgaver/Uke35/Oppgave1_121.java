package UkesOppgaver.Uke35;

public class Oppgave1_121 {

    private static int min(int [] a, int begin, int end) {
        if (begin < 0 || end > a.length || begin >= end)
        {
            throw new IllegalArgumentException("Illegalt intervall!");
        }

        int m = begin;
        int minVerdi = a[begin];

        for (int i = begin + 1; i < end; i++) {
            if (a[i] < minVerdi) {
                m = i;
                minVerdi = a[i];
            }
        }
        return m;
    }

    public static void main(String[] args) {

        int [] a = {3,2,1,4,5};

        System.out.println(min(a,1,4));

    }
}
