package kodeTesting;

import hjelpeklasser.*;

public class Program
{
    public static void main(String [] args)      // hovedprogram
    {
        /*int[] a = Tabell.randPerm(20);              // en tilfeldig tabell
        for (int k : a) System.out.print(k + " ");  // skriver ut a

        int m = Tabell.maks(a, 7,10); // finner posisjonen til største verdi

        System.out.println("\nStørste verdi ligger på plass " + m);
         */


        /*int[] a = Tabell.randPerm(20); // tilfeldig permutasjon av 1 . . 20
        int[] b = Tabell.nestMaks(a);  // metoden returnerer en tabell

        int m = b[0], nm = b[1];       // m for maks, nm for nestmaks

        Tabell.skrivLn(a);        // se Oppgave 5 i Avsnitt 1.2.2
        System.out.print("Størst(" + a[m] + ") har posisjon " + m);
        System.out.println(", nest størst(" + a[nm] + ") har posisjon " + nm);

         */

        int[] a = Tabell.randPerm(8);

        int [] b = Tabell.nestMaksTre(a);

        System.out.println("Største verdi " + b[0] + ".");
        System.out.println("Neste største verdi " + b[1] + ".");

    } // main

} // class Program
