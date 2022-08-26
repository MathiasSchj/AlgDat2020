package UkesOppgaver.Uke34;

class fakultet{
    public int fakulteten(int n) {
        int sum = n;
        for (int i = sum - 1; i > 0; i--) {
            sum = sum * i;
        }
        return sum;
    }
}

public class Oppgave5_113 {
    public static void main(String[] args) {
        fakultet f = new fakultet();

        int print = f.fakulteten(4);

        System.out.println(print);
    }
}
