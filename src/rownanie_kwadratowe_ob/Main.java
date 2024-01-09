package rownanie_kwadratowe_ob;

import java.io.*;

class Trojmian
{
    double a, b, c, delta, x1, x2;
    char liczbaPierwiastkow;

    public void czytajDane()
        throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Progrm oblicza pierwiastki rownania kwadratowego\n dla dowolnych wartosci a, b oraz c.");
        System.out.println("Podaj a");
        a = Double.parseDouble(br.readLine());

        if(a == 0)
        {
            System.out.println("Niedozwolona wartosc wspolczynnika a.");
            System.exit(0); //wyjscie z programu
        }
        else
        {
            System.out.println("Podaj b.");
            b = Double.parseDouble(br.readLine());
            System.out.println("Podaj c.");
            c = Double.parseDouble(br.readLine());
        }
    }

    public void przetworzDane()
    {
        delta = b * b - 4 * a * c;

        if(delta < 0) liczbaPierwiastkow = 0;
        if(delta == 0) liczbaPierwiastkow = 1;
        if(delta > 0) liczbaPierwiastkow = 2;

        switch (liczbaPierwiastkow)
        {
            case 1 : x1 = -b / (2 * a);
            break;
            case 2 :
            {
                x1 = (-b - Math.sqrt(delta)) / (2 * a);
                x2 = (-b + Math.sqrt(delta)) / (2 * a);
            }
            break;
        }
    }

    public void wyswietlWynik()
    {
        System.out.println("Dla wprowadzonych liczb: ");
        System.out.printf("a = " + "%2.2f", a);
        System.out.printf("\tb = " + "%2.2f", b);
        System.out.printf("\tc = " + "%2.2f", c);

        switch(liczbaPierwiastkow)
        {
            case 0 : System.out.println("\tBrak pierwiastków reczywistych. \n");
            break;
            case 1 : System.out.printf("\tTrojmian ma jeden pierwiastek podwojny:" + "x1 = " + "%2.2f.\n, x1");
            break;
            case 2 :
            {
                System.out.print("\tTrojmian ma dwa pierwiastki: ");
                System.out.printf("x1 = " + "%2.2f", x1);
                System.out.printf(", x2 = " + "%2.2f\n", x2);
            }
            break;
        }
    }
}
public class Main {

    public static void main(String[] args)
        throws IOException
    {
        Trojmian trojmian1 = new Trojmian();

        trojmian1.czytajDane();
        trojmian1.przetworzDane();
        trojmian1.wyswietlWynik();
    }
}
