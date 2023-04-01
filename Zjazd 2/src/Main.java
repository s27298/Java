/* Author: s27298 */


public class Main {
    public static void main(String[] args) {
        Zad03();
    }

    public static void Zad01(){
        Card card1 = new Card(Card.Wartosc.Cztery, Card.Kolor.Karo);
        Card card2 = new Card(Card.Wartosc.Dwa, Card.Kolor.Kier);
        Card card3 = new Card(Card.Wartosc.Osiem, Card.Kolor.Pik);

        System.out.println("Card 1: " + card1.getWartosc() + " " + card1.getKolor());
        System.out.println("Card 1: " + card2.getWartosc() + " " + card2.getKolor());
        System.out.println("Card 1: " + card3.getWartosc() + " " + card3.getKolor());
    }

    public static void Zad02(){
        Student student1 = new Student("Jan","Kowalski", 12345);
        student1.setObecnosc(80.0);
        student1.setPojOceny(4);

        Student student2 = new Student("Marcin", "Wiśniewski", 67892);
        student2.setObecnosc(40.0);
        student2.setPojOceny(3);

        Student student3 = new Student("Stefan", "Nowak", 654321);
        student3.setObecnosc(60.0);
        student3.setPojOceny(5);

        System.out.println(student1.getImie() + " " + student1.getNazwisko() + ", Numer Index: " + student1.getIndex() + ", Obecność : " + student1.getObecnosc() + "%, Oceny POJ : " + student1.getPojOceny());
        System.out.println(student2.getImie() + " " + student2.getNazwisko() + ", Numer Index: " + student2.getIndex() + ", Obecność : " + student2.getObecnosc() + "%, Oceny POJ : " + student2.getPojOceny());
        System.out.println(student3.getImie() + " " + student3.getNazwisko() + ", Numer Index: " + student3.getIndex() + ", Obecność : " + student3.getObecnosc() + "%, Oceny POJ : " + student3.getPojOceny());
    }

    public static void Zad03(){
        MyDate date = new MyDate(10,4,2025);
        date.displayDate();
    }

    public static void Zad04(){

    }
}