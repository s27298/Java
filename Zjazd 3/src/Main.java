import java.util.ArrayList;

/*
*   Author: s27298
* */
public class Main{
    public static void main(String[] args){

    }

    /*
     * Zadanie 1
     * Zaimplementuj abstrakcyjną klasę Maszyna z chronionymi atrybutami marka, nazwa, pojemnoscSilnika i rodzajSilnika. Ten ostatni ma być enumeracją.
     * */

    // Klasa Abstrakcyjna
    abstract class Maszyna {
        protected String marka;
        protected String nazwa;
        protected int pojemnoscSilnika;
        protected RodzajSilnika rodzajSilnika;

        private enum RodzajSilnika{
            BENZYNA, DIESEL, ELEKTRYCZNY
        }
    }

    /*
     * Zadanie 2
     * Zaimplementuj klasę Lokomotywa dziedziczącą po maszynie. Klasa ta ma dodawać dwa prywatne atrybuty charakterystyczne dla lokomotyw i
     * nieuwzględnione wcześniej w maszynie. Klasa ta ma mieć konstruktor, przyjmujący komplet 6 parametrów oraz metodę wyswietl, wyrzucającą
     * w zamyśle na ekran wyczerpujący opis danej lokomotywy.
     * */
    public class Lokomotywa extends Maszyna{
        private enum Rodzaj {
            PASAZERSKIE, TOWAROWE, MANEWROWE, UNIWERSALNE
        }
        private Rodzaj rodzaj;
        private int iloscWagonow;

        // Konstruktor
        public Lokomotywa(String marka, String nazwa, int iloscWagonow, Rodzaj rodzaj, int pojemnoscSilnika, RodzajSilnika rodzajSilnika) {
            this.marka = marka;
            this.nazwa = nazwa;
            this.rodzaj = rodzaj;
            this.rodzajSilnika = rodzajSilnika;
            this.pojemnoscSilnika = pojemnoscSilnika;
            this.iloscWagonow = iloscWagonow;
        }

        public void wyswietl(){
            System.out.println("Lokomotywa " + nazwa + " marki " + marka);
            System.out.println("Rodzaj: " + rodzaj);
            System.out.println("Silnik: " + rodzajSilnika + " " + pojemnoscSilnika);
            System.out.println("wagony: " + iloscWagonow);
        }
    }

    /*
     * Zadanie 3
     * Uzupełnij repozytorium o klasę Kosiarka, która: - dziedziczy z maszyny; - wprowadza prywatne atrybuty czyMelekser (typu boolean),
     * czyNaped(j.w.) i liczbaOstrzy (typu int); - posiada, analogicznie jak klasa Kosiarka, jeden konstruktor i metodę wyswietl, która wyświetla
     * komplet 7 atrybutów w zorganizowanej formie; - dodatkowo, klasa ma zawierać metody set dla wszystkich trzech nowowprowadzanych atrybutów
     * */
    public class Kosiarka extends Maszyna{
        private boolean czyMelekser;
        private boolean czyNaped;
        private int liczbaOstrzy;

        public void setCzyMelekser(boolean czyMelekser) {
            this.czyMelekser = czyMelekser;
        }

        public void setCzyNaped(boolean czyNaped) {
            this.czyNaped = czyNaped;
        }

        public void setLiczbaOstrzy(int liczbaOstrzy) {
            this.liczbaOstrzy = liczbaOstrzy;
        }

        public Kosiarka(boolean czyMelekser, boolean czyNaped, int liczbaOstrzy, String marka, String nazwa, int pojemnoscSilnika, RodzajSilnika rodzajSilnika) {
            this.czyMelekser = czyMelekser;
            this.czyNaped = czyNaped;
            this.liczbaOstrzy = liczbaOstrzy;
            this.marka = marka;
            this.nazwa = nazwa;
            this.rodzajSilnika = rodzajSilnika;
            this.pojemnoscSilnika = pojemnoscSilnika;
        }

        public void wyswietl(){
            System.out.println("Kosiarka " + nazwa + " marki " + marka);
            System.out.println("Ilosc ostrzy: " + liczbaOstrzy);
            System.out.println("Naped: " + czyNaped);
            System.out.println("Melekser: " + czyMelekser);
            System.out.println("Silnik: " + rodzajSilnika + " " + pojemnoscSilnika);
        }
    }

    /*
     * Zadanie 4
     * Ostatnią klasą dziedziczącą bezpośrednio z maszyny jest klasa Pojazd. Klasa zawierać będzie pojedynczy konstruktor, standardową metodę wyświetlającą
     * oraz chronione atrybuty typu double moc oraz momentObrotowy. Konstruktor ma realizować autonumerowanie pojazdów. W tym celu należy posłużyć się parą
     * klasowych atrybutów typu int: nrPojazdu oraz maxLiczbaPojazdow (ten ostatni statyczny). Metoda wyświetlająca ma uwzględniać obie wskazane informacje,
     *  np. Pojazd 7 z 12....
     * */

    public class Pojazd extends Maszyna{
        private double moc;
        private double momentObrotowy;

        int nrPojazdu = 1;
        static int maxLiczbaPojazdow = 12;

        public Pojazd(String marka, String nazwa, double moc, double momentObrotowy, int pojemnoscSilnika, RodzajSilnika rodzajSilnika) {
            this.moc = moc;
            this.momentObrotowy = momentObrotowy;
            this.marka = marka;
            this.nazwa = nazwa;
            this.pojemnoscSilnika = pojemnoscSilnika;
            this.rodzajSilnika = rodzajSilnika;
            nrPojazdu++;
        }

        public void wyswietl(){
            System.out.println("Pojazd " + nrPojazdu + " z " + maxLiczbaPojazdow);
            System.out.println("Kosiarka " + nazwa + " marki " + marka);
            System.out.println("Moc: " + moc + "KM");
            System.out.println("Moment obrotowy: " + momentObrotowy);
            System.out.println("Silnik: " + rodzajSilnika );
            System.out.println("Pojemnosc silnika: " + pojemnoscSilnika + "L");
        }
    }

    /*
     * Zadanie 5
     * Z klasy Pojazd dziedziczą Samochod (dodatkowe atrybuty segment i VIN) oraz Jednoslad (dodatkowy atrybut typ). Obie wspomniane klasy wykorzystują autorskie
     * enumeracje i zostają wyposażone w konstruktory oraz metody wyswietl, nadpisujące metody o tej samej nazwie w klasach nadrzędnych. Konstruktory mają wywoływać
     * konstruktory klasy nadrzędnej i wpisywać się w logikę autonumerowania i wyświetlania informacji o numeracji. W szczególności, klasy te powinny mieć konstruktory
     * pobierające odpowiednio 8 i 7 atrybutów - a jednoślad dodatkowo konstruktor, który nie pobiera wszystkich atrybutów (z uwagi na specyficzną logikę opisu rowerów i
     * hulajnóg tradycyjnych). Metoda wyświetlająca klasy Jednoślad ma pomijać wartości niewprowadzone.
     * */
    public class Samochod extends Pojazd{
        enum Segment{
            A, B, C, D, E, F
        }
        private Segment segment;
        private String VIN;

        public Samochod(String marka, String nazwa, double moc, double momentObrotowy, int pojemnoscSilnika, RodzajSilnika rodzajSilnika, Segment segment, String VIN) {
            // super() -> wywoływanie konstruktora klasy nadrzędnej
            super(marka, nazwa, moc, momentObrotowy, pojemnoscSilnika, rodzajSilnika);
            this.segment = segment;
            this.VIN = VIN;
        }
        public void wyswietl(){
            super.wyswietl();
            System.out.println("Segment: " + segment);
            System.out.println("VIN: " + VIN);
        }
    }

    public class Jednoslad extends Pojazd{
        enum Typ{
            ROWER, HULAJNOGA, SKUTER_ELEKTRYCZNY, MOTOROWER, MOTOR
        }
        private Typ typ;

        public Jednoslad(String marka, String nazwa, double moc, double momentObrotowy, int pojemnoscSilnika, RodzajSilnika rodzajSilnika, Typ typ) {
            super(marka, nazwa, moc, momentObrotowy, pojemnoscSilnika, rodzajSilnika);
            this.typ = typ;
        }

        public void wyswietl(){
            super.wyswietl();
            System.out.println("Typ: " + typ);
        }
    }

  /*
  * Zadanie 6
  * W metodzie głównej klasy ParkMaszynowy zadeklarować po 2 obiekty każdej klasy, w stosunku do której jest to możliwe. Wszystkie obiekty trafiają do pojedynczej kolekcji i
  * są wyświetlane pętlą for each. Jakiej modyfikacji należy dokonać w klasie Maszyna, aby było to możliwe? Wykorzystaj dodolną metodę set obiektu klasy Kosiarka i wyświetl ten obiekt ponownie.
  * */



}