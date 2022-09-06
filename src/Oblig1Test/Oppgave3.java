package Oblig1Test;

public class Oppgave3 {

    public static int antallUlikeUsortert(int[] a) {

        int teller = 1;

        boolean finnes = false;

        for (int i = 1; i < a.length; i++) {
            for (int j = i - 1; j > 0; j--) {

            }
        }
        return teller;
    }

    public static void main(String[] args) {
        int [] a = {2,4,2,5,4};
        int [] b = {3,5,2,6,8,6,4,5,3};
        int [] c = {3,5,2,6,8,5,6};

        int ut = antallUlikeUsortert(a);

        System.out.println("Antall unike tall: " + ut);
    }
}
