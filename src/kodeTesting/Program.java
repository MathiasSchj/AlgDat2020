package kodeTesting;

import eksempeklasser.*;
import hjelpeklasser.*;

import java.awt.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Program {

    public static int euklid(int a, int b)
    {
        System.out.println("euklid(" + a + "," + b + ") starter!");
        if (b == 0)
        {
            System.out.println("euklid(" + a + "," + b + ") er ferdig!");
            return a;
        }
        int r = a % b;            // r er resten
        int k = euklid(b,r);       // rekursivt kall
        System.out.println("euklid(" + a + "," + b + ") er ferdig!");
        return k;
    }

    public static int tverrsum(int n)
    {
        System.out.println("tverrsum(" + n + ") starter!");
        int sum = (n < 10) ? n : tverrsum(n / 10) + (n % 10);
        System.out.println("tverrsum(" + n + ") er ferdig!");
        return sum;
    }

    public static int fib(int n)         // med utskriftssetninger
    {
        System.out.println("fib(" + n + ") starter!");
        int fib = n > 1 ? fib(n-1) + fib(n-2) : n;
        System.out.println("fib(" + n + ") er ferdig!");
        return fib;      // metoden er ferdig
    }
    ////////////////////////////

    /*
    public static int binærsøk(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v < h)  // obs. må ha v < h her og ikke v <= h
        {
            int m = (v + h)/2;  // heltallsdivisjon - finner midten

            if (verdi > a[m]) v = m + 1;   // verdi må ligge i a[m+1:h]
            else  h = m;                   // verdi må ligge i a[v:m]
        }
        if (h < v || verdi < a[v]) return -(v + 1);  // ikke funnet
        else if (verdi == a[v]) return v;            // funnet
        else  return -(v + 2);                       // ikke funnet
    }
     */

    public static int binærsøk(int [] a, int fra, int til, int verdi) {
        if (fra > til) {
            return -1;
        }

        int midt = (fra + til) / 2;
        int midtverdi = a[midt];

        if (verdi > midtverdi) {
            return binærsøk(a, midt + 1, til, verdi);
        }
        else if (verdi < midtverdi) {
            return binærsøk(a, fra, midt - 1, verdi);
        }
        else {
            return midt;
        }
    }

    ////////////////////////////
/*
    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0; for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }

 */

    //////////////////////////////



    //////////////////////////////

    //Main
    public static void main(String... args)
    {
        int a [] = {2,5,3,9,58,7,4,6,12,43};

        System.out.println(binærsøk(a, 0, a.length, 7));
    }


} // class Program
