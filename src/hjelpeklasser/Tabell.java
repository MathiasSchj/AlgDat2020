package hjelpeklasser;

import eksempeklasser.Komparator;

import java.util.*;

public class Tabell     // Samleklasse for tabellmetoder
{

    private Tabell() {}   // privat standardkonstruktør - hindrer instansiering


    // Metoden bytt(int[] a, int i, int j)       Programkode 1.1.8 d)
    public static void bytt(int[] a, int i, int j)
    {
        int temp = a[i]; a[i] = a[j]; a[j] = temp;
    }


    // Metoden randPerm(int n)                   Programkode 1.1.8 e)
    public static int[] randPerm(int n)  // en effektiv versjon
    {
        Random r = new Random();         // en randomgenerator
        int[] a = new int[n];            // en tabell med plass til n tall

        Arrays.setAll(a, i -> i + 1);    // legger inn tallene 1, 2, . , n

        for (int k = n - 1; k > 0; k--)  // løkke som går n - 1 ganger
        {
            int i = r.nextInt(k+1);        // en tilfeldig tall fra 0 til k
            bytt(a,k,i);                   // bytter om
        }

        return a;                        // permutasjonen returneres
    }


    // Metoden randPerm(int[] a)                 Programkode 1.1.8 f)
    public static void randPerm(int[] a)  // stokker om a
    {
        Random r = new Random();     // en randomgenerator

        for (int k = a.length - 1; k > 0; k--)
        {
            int i = r.nextInt(k + 1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);
        }
    }


    // Metoden maks(int[] a, int fra, int til)   Programkode 1.2.1 b)
    public static int maks(int[] a, int fra, int til)
    {
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Illegalt intervall!");

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        if (a == null) {
            throw new IllegalArgumentException("Arrayet er null");
        }

        fratilKontroll(a.length, fra, til);

        int m = fra;              // indeks til største verdi i a[fra:til>
        int maksverdi = a[fra];   // største verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++)
        {
            if (a[i] > maksverdi)
            {
                m = i;                // indeks til største verdi oppdateres
                maksverdi = a[m];     // største verdi oppdateres
            }
        }

        return m;  // posisjonen til største verdi i a[fra:til>
    }


    // Metoden maks(int[] a)                     Programkode 1.2.1 c)
    public static int maks(int[] a)  // bruker hele tabellen
    {
        return maks(a,0,a.length);     // kaller metoden over
    }


    //Maks-metode i form av desimal
    public static int maks(double[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        double maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }


    //Maks med bruk av CHar
    public static int maks(char[] a)     // legges i class Tabell
    {
        int m = 0;                           // indeks til største verdi
        char maksverdi = a[0];             // største verdi

        for (int i = 1; i < a.length; i++) if (a[i] > maksverdi)
        {
            maksverdi = a[i];     // største verdi oppdateres
            m = i;                // indeks til største verdi oppdaters
        }
        return m;     // returnerer posisjonen til største verdi
    }


    //Maks metode med Integer og IKKE int
    public static int maks(Integer[] a)
    {
        int m = 0;                          // indeks til største verdi
        Integer maksverdi = a[0];           // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi

    } // maks


    //Metoden nestMaks - returnerer et array med den største tallet og nest sørste tallet.
    //                   Dette gjøres ved return av en ny array som sendes tilbake.
    public static int[] nestMaks(int[] a) // ny versjon
    {
        int n = a.length;     // tabellens lengde
        if (n < 2) throw      // må ha minst to verdier
                new java.util.NoSuchElementException("a.length(" + n + ") < 2!");

        int m = 0;      // m er posisjonen til største verdi
        int nm = 1;     // nm er posisjonen til nest største verdi

        // bytter om m og nm hvis a[1] er større enn a[0]
        if (a[1] > a[0]) { m = 1; nm = 0; }

        int maksverdi = a[m];                // største verdi
        int nestmaksverdi = a[nm];           // nest største verdi

        int teller = 0;

        for (int i = 2; i < n; i++)
        {
            if (a[i] > nestmaksverdi)
            teller++;
            {
                if (a[i] > maksverdi)
                {
                    nm = m;
                    nestmaksverdi = maksverdi;     // ny nest størst

                    m = i;
                    maksverdi = a[m];              // ny størst
                }
                else
                {
                    nm = i;
                    nestmaksverdi = a[nm];         // ny nest størst
                }
            }
        } // for

        return new int[] {m,nm};    // n i posisjon 0, nm i posisjon 1

    } // nestMaks


    public static int[] nestMaksTre(int[] a)   // en turnering
    {
        int n = a.length;                // for å forenkle notasjonen

        if (n < 2) // må ha minst to verdier!
            throw new IllegalArgumentException("a.length(" + n + ") < 2!");

        int[] b = new int[2*n];          // turneringstreet
        System.arraycopy(a,0,b,n,n);     // legger a bakerst i b

        for (int k = 2*n-2; k > 1; k -= 2)   // lager turneringstreet
            b[k/2] = Math.max(b[k],b[k+1]);

        System.out.println(Arrays.toString(b));  // utskrift av b

        int maksverdi = b[1], nestmaksverdi = Integer.MIN_VALUE;

        for (int m = 2*n - 1, k = 2; k < m; k *= 2)
        {
            int tempverdi = b[k+1];  // ok hvis maksverdi er b[k]
            if (maksverdi != b[k]) { tempverdi = b[k]; k++; }
            if (tempverdi > nestmaksverdi) nestmaksverdi = tempverdi;
        }

        return new int[] {maksverdi,nestmaksverdi}; // størst og nest størst

    } // nestMaks


    public static void kopier(int[] a, int i, int[] b, int j, int ant)
    {
        for (int n = i + ant; i < n; ) b[j++] = a[i++];
    }


    // min-metodene - se Oppgave 1 i Avsnitt 1.2.1
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

    // Metoden min(int[] a)
    public static int min(int[] a)  // bruker hele tabellen
    {
        return min(a,0,a.length);     // kaller metoden over
    }


    // Metoden skrivIntervall - Skriver ut intervallet
    public static void skriv(int[] a, int fra, int til) {
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
    }

    // Metoden skriv - Skriver ut hele arrayet
    public static void skriv(int [] a){
        for (int k : a) System.out.print(k + " ");  // skriver ut a
    }

    // Metoden skrivIntervallLn - Skriver ut intervallet men med linjeskift på slutten
    public static void skrivLn(int[] a, int fra, int til) {
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    // Metoden skrivLn - Skriver ut hele arrayet men med linjeskift på slutten
    public static void skrivLn(int [] a){
        for (int k : a) System.out.print(k + " ");  // skriver ut a
        System.out.println();
    }

    // Metoden fratilKontroll - kontrollerer HALVÅPNE intervallet vi sender inn i div parametere
    public static void fratilKontroll(int tablengde, int fra, int til)
    {
        if (fra < 0)                                  // fra er negativ
            throw new ArrayIndexOutOfBoundsException
                    ("fra(" + fra + ") er negativ!");

        if (til > tablengde)                          // til er utenfor tabellen
            throw new ArrayIndexOutOfBoundsException
                    ("til(" + til + ") > tablengde(" + tablengde + ")");

        if (fra > til)                                // fra er større enn til
            throw new IllegalArgumentException
                    ("fra(" + fra + ") > til(" + til + ") - illegalt intervall!");

        if (fra == til)
            throw new NoSuchElementException
                    ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");
    }

    //Metoden vhKontroll - Kontrolerer LUKKEDE intervall som sennes inn i div parametere
    public static void vhKontroll(int tablengde, int v, int h)
    {
        if (v < 0)
            throw new ArrayIndexOutOfBoundsException("v(" + v + ") < 0");

        if (h >= tablengde)
            throw new ArrayIndexOutOfBoundsException
                    ("h(" + h + ") >= tablengde(" + tablengde + ")");

        if (v > h + 1)
            throw new IllegalArgumentException
                    ("v = " + v + ", h = " + h);
    }


    //metode for å snu tabellen
    public static void snu(int[] a, int v, int h)  // snur intervallet a[v:h]
    {
        while (v < h) bytt(a, v++, h--);
    }

    public static void snu(int[] a, int v)  // snur fra og med v og ut tabellen
    {
        snu(a, v, a.length - 1);
    }

    public static void snu(int[] a)  // snur hele tabellen
    {
        snu(a, 0, a.length - 1);
    }


    //Metode for å finne neste leksiografiske permutasjon
    public static boolean nestePermutasjon(int[] a)
    {
        int i = a.length - 2;                    // i starter nest bakerst
        while (i >= 0 && a[i] > a[i + 1]) i--;   // går mot venstre
        if (i < 0) return false;                 // a = {n, n-1, . . . , 2, 1}

        int j = a.length - 1;                    // j starter bakerst
        while (a[j] < a[i]) j--;                 // stopper når a[j] > a[i]
        bytt(a,i,j); snu(a,i + 1);               // bytter og snur

        return true;                             // en ny permutasjon
    }


    //Utvalgssortering
    public static void utvalgssortering(int[] a)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length));  // to hjelpemetoder
    }


    //Metode for linneærsøk
    public static int lineærsøk(int[] a, int verdi) // legges i class Tabell
    {
        if (a.length == 0 || verdi > a[a.length-1])
            return -(a.length + 1);  // verdi er større enn den største

        int i = 0; for( ; a[i] < verdi; i++);  // siste verdi er vaktpost

        return verdi == a[i] ? i : -(i + 1);   // sjekker innholdet i a[i]
    }


    // 1. versjon av binærsøk - returverdier som for Programkode 1.3.6 a)
    public static int binærsøk1(int[] a, int fra, int til, int verdi)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;  // v og h er intervallets endepunkter

        while (v <= h)    // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;      // heltallsdivisjon - finner midten
            int midtverdi = a[m];   // hjelpevariabel for midtverdien

            if (verdi == midtverdi) return m;          // funnet
            else if (verdi > midtverdi) v = m + 1;     // verdi i a[m+1:h]
            else  h = m - 1;                           // verdi i a[v:m-1]
        }

        return -(v + 1);    // ikke funnet, v er relativt innsettingspunkt
    }

    public static int binærsøk1(int[] a, int verdi)  // søker i hele a
    {
        return binærsøk1(a,0,a.length,verdi);  // bruker metoden over
    }


    // 3. versjon av binærsøk - returverdier som for Programkode 1.3.6 a)
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

    //Ved duplikat verdier vil den siste instansen av det sammetallet bli returnert i versjon 1 og 2.
    //i versjon 3 derimmot vil den første instansen returneres.
    //Versjon 3 er den mest effektive binærsøk versjon
    //Alle versjonen har en kompleksitet på log2(n)

    //Generic klasse for å sammenligne datatyper
    public static <T extends Comparable<? super T>> int maks(T[] a)
    {
        int m = 0;                     // indeks til største verdi
        T maksverdi = a[0];            // største verdi

        for (int i = 1; i < a.length; i++) if (a[i].compareTo(maksverdi) > 0)
        {
            maksverdi = a[i];  // største verdi oppdateres
            m = i;             // indeks til største verdi oppdaters
        }
        return m;  // returnerer posisjonen til største verdi
    } // maks


    //Generic for innsettingssortering av datatyper
    public static <T extends Comparable<? super T>> void innsettingssortering(T[] a)
    {
        for (int i = 1; i < a.length; i++)  // starter med i = 1
        {
            T verdi = a[i];        // verdi er et tabellelemnet
            int  j = i - 1;        // j er en indeks
            // sammenligner og forskyver:
            for (; j >= 0 && verdi.compareTo(a[j]) < 0 ; j--) a[j+1] = a[j];

            a[j + 1] = verdi;      // j + 1 er rett sortert plass
        }
    }


    //Generic skriv
    public static <Object extends Comparable<? super Object>> void skriv(Object[] a, int fra, int til) {
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
    }


    //Generic skriver hele arrayet

    public static <Object extends Comparable<? super Object>> void skriv(Object[] a) {
        for (Object k : a) System.out.print(k + " ");  // skriver ut a
    }


    //Generic skrivLn
    public static <Object extends Comparable<? super Object>> void skrivLn(Object[] a, int fra, int til) {
        for (int i = fra; i < til; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }


    //Generic bytt
    public static <Object extends Comparable<? super Object>> void bytt(Object[] a, int i, int j) {
        Object temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static Integer[] randPermInteger(int n)
    {
        Integer[] a = new Integer[n];               // en Integer-tabell
        Arrays.setAll(a, i -> i + 1);               // tallene fra 1 til n

        Random r = new Random();   // hentes fra  java.util

        for (int k = n - 1; k > 0; k--)
        {
            int i = r.nextInt(k+1);  // tilfeldig tall fra [0,k]
            bytt(a,k,i);             // bytter om
        }
        return a;  // tabellen med permutasjonen returneres
    }


    public static <T> void innsettingssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 1; i < a.length; i++)
        {
            T temp = a[i];  // flytter a[i] til en hjelpevariabel

            int j = i-1;    // starter med neste tabellposisjon

            // en og en verdi flyttes inntil rett sortert plass er funnet
            for (; j >= 0 && c.compare(temp,a[j]) < 0; j--) a[j+1] = a[j];

            a[j+1] = temp;  // temp legges inn på rett plass
        }
    } // innsettingssortering
    public static <T> int maks(T[] a, Comparator<? super T> c)
    {
        return maks(a, 0, a.length, c);  // kaller metoden under
    }

    public static <T> int maks(T[] a, int fra, int til, Comparator<? super T> c)
    {
        fratilKontroll(a.length,fra,til);

        if (fra == til) throw new NoSuchElementException
                ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;                // indeks til største verdi
        T maksverdi = a[fra];       // største verdi

        for (int i = fra + 1; i < til; i++)   // går gjennom intervallet
        {
            if (c.compare(a[i],maksverdi) > 0)  // bruker komparatoren
            {
                maksverdi = a[i];     // største verdi oppdateres
                m = i;                // indeks til største verdi oppdateres
            }
        }
        return m;                 // posisjonen til største verdi

    }  // maks


    public static <T> int maks(T[] a, Komparator<? super T> c)
    {
        return maks(a, 0, a.length, c);  // kaller metoden nedenfor
    }

    public static <T> int maks(T[] a, int fra, int til, Komparator<? super T> c)
    {
        fratilKontroll(a.length,fra,til);

        if (fra == til) throw new NoSuchElementException
                ("fra(" + fra + ") = til(" + til + ") - tomt tabellintervall!");

        int m = fra;                // indeks til største verdi
        T maksverdi = a[fra];       // største verdi

        for (int i = fra + 1; i < til; i++)   // går gjennom intervallet
        {
            if (c.compare(a[i],maksverdi) > 0)  // bruker komparatoren
            {
                maksverdi = a[i];     // største verdi oppdateres
                m = i;                // indeks til største verdi oppdateres
            }
        }
        return m;                 // posisjonen til største verdi

    }  // maks


    public static <T> void bytt(T[] a, int i, int j)
    {
        T temp = a[i]; a[i] = a[j]; a[j] = temp;
    }

    public static <T> int min(T[] a, int fra, int til, Comparator<? super T> c)
    {
        if (fra < 0 || til > a.length || fra >= til)
            throw new IllegalArgumentException("Illegalt intervall!");

        int m = fra;           // indeks til minste verdi i a[fra:til>
        T minverdi = a[fra];   // minste verdi i a[fra:til>

        for (int i = fra + 1; i < til; i++) if (c.compare(a[i], minverdi) < 0)
        {
            m = i;               // indeks til minste verdi oppdateres
            minverdi = a[m];     // minste verdi oppdateres
        }

        return m;  // posisjonen til minste verdi i a[fra:til>
    }

    public static <T> int min(T[] a, Comparator<? super T> c)  // bruker hele tabellen
    {
        return min(a,0,a.length,c);     // kaller metoden over
    }

    public static <T> void utvalgssortering(T[] a, Comparator<? super T> c)
    {
        for (int i = 0; i < a.length - 1; i++)
            bytt(a, i, min(a, i, a.length, c));  // to hjelpemetoder
    }


    public static <T>
    int binærsøk(T[] a, int fra, int til, T verdi, Comparator<? super T> c)
    {
        Tabell.fratilKontroll(a.length,fra,til);  // se Programkode 1.2.3 a)
        int v = fra, h = til - 1;    // v og h er intervallets endepunkter

        while (v <= h)  // fortsetter så lenge som a[v:h] ikke er tom
        {
            int m = (v + h)/2;     // heltallsdivisjon - finner midten
            T midtverdi = a[m];  // hjelpevariabel for  midtverdien

            int cmp = c.compare(verdi, midtverdi);

            if (cmp > 0) v = m + 1;        // verdi i a[m+1:h]
            else if (cmp < 0) h = m - 1;   // verdi i a[v:m-1]
            else return m;                 // funnet
        }

        return -(v + 1);   // ikke funnet, v er relativt innsettingspunkt
    }

    public static <T> int binærsøk(T[] a, T verdi, Comparator<? super T> c)
    {
        return binærsøk(a,0,a.length,verdi,c);  // bruker metoden over
    }


    public static <T>
    int parter(T[] a, int v, int h, T skilleverdi, Comparator<? super T> c)
    {
        while (v <= h && c.compare(a[v],skilleverdi) < 0) v++;
        while (v <= h && c.compare(skilleverdi,a[h]) <= 0) h--;

        while (true)
        {
            if (v < h) Tabell.bytt(a,v++,h--); else return v;
            while (c.compare(a[v],skilleverdi) < 0) v++;
            while (c.compare(skilleverdi,a[h]) <= 0) h--;
        }
    }

    public static <T> int parter(T[] a, T skilleverdi, Comparator<? super T> c)
    {
        return parter(a,0,a.length-1,skilleverdi,c);  // kaller metoden over
    }

    public static <T>
    int sParter(T[] a, int v, int h, int k, Comparator<? super T> c)
    {
        if (v < 0 || h >= a.length || k < v || k > h) throw new
                IllegalArgumentException("Ulovlig parameterverdi");

        bytt(a,k,h);   // bytter - skilleverdien a[k] legges bakerst
        int p = parter(a,v,h-1,a[h],c);  // partisjonerer a[v:h-1]
        bytt(a,p,h);   // bytter for å få skilleverdien på rett plass

        return p;    // returnerer posisjonen til skilleverdien
    }

    public static <T>
    int sParter(T[] a, int k, Comparator<? super T> c)   // bruker hele tabellen
    {
        return sParter(a,0,a.length-1,k,c); // v = 0 og h = a.lenght-1
    }

    private static <T>
    void kvikksortering(T[] a, int v, int h, Comparator<? super T> c)
    {
        if (v >= h) return;  // hvis v = h er a[v:h] allerede sortert

        int p = sParter(a,v,h,(v + h)/2,c);
        kvikksortering(a,v,p-1,c);
        kvikksortering(a,p+1,h,c);
    }

    public static <T>
    void kvikksortering(T[] a, Comparator<? super T> c) // sorterer hele tabellen
    {
        kvikksortering(a,0,a.length-1,c);
    }


    private static <T>
    void flett(T[] a, T[] b, int fra, int m, int til, Comparator<? super T> c)
    {
        int n = m - fra;   // antall elementer i a[fra:m>
        System.arraycopy(a,fra,b,0,n); // kopierer a[fra:m> over i b[0:n>

        int i = 0, j = m, k = fra;     // løkkevariabler og indekser

        while (i < n && j < til)  // fletter b[0:n> og a[m:til>, legger
            a[k++] = c.compare(b[i],a[j]) <= 0 ? b[i++] : a[j++];  // resultatet i a[fra:til>

        while (i < n) a[k++] = b[i++];  // tar med resten av b[0:n>
    }

    public static <T>
    void flettesortering(T[] a, T[] b, int fra, int til, Comparator<? super T> c)
    {
        if (til - fra <= 1) return;     // a[fra:til> har maks ett element

        int m = (fra + til)/2;          // midt mellom fra og til

        flettesortering(a,b,fra,m,c);   // sorterer a[fra:m>
        flettesortering(a,b,m,til,c);   // sorterer a[m:til>

        flett(a,b,fra,m,til,c);         // fletter a[fra:m> og a[m:til>
    }

    public static <T> void flettesortering(T[] a, Comparator<? super T> c)
    {
        T[] b = Arrays.copyOf(a, a.length/2);
        flettesortering(a,b,0,a.length,c);  // kaller metoden over
    }

}
