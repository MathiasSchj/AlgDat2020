package kodeTesting;

import eksempeklasser.*;
import hjelpeklasser.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Program {

    public static void main(String[] args) {

        Student[] s = new Student[7];  // en Studenttabell

        s[0] = new Student("Kari", "Svendsen", Studium.Data);    // Kari Svendsen
        s[1] = new Student("Boris", "Zukanovic", Studium.IT);    // Boris Zukanovic
        s[2] = new Student("Ali", "Kahn", Studium.Anvendt);      // Ali Kahn
        s[3] = new Student("Azra", "Zukanovic", Studium.IT);     // Azra Zukanovic
        s[4] = new Student("Kari", "Pettersen", Studium.Data);   // Kari Pettersen
        s[5] = new Student("Ola", "Helvete", Studium.Elektro);     // Azra Zukanovic
        s[6] = new Student("Frank", "Smidal", Studium.Elektro);   // Kari Pettersen

        Tabell.innsettingssortering(s);                     // Programkode 1.4.2 e)
        for (Student t : s) System.out.println(t);

        // Utskrift:
        // Ali Kahn Anvendt
        // Kari Pettersen Data
        // Kari Svendsen Data
        // Azra Zukanovic IT
        // Boris Zukanovic IT

    }

} // class Program
