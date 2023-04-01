public class Card {
    public enum Wartosc {
        Dwa, Trzy, Cztery, Pięć, Sześć, Siedem, Osiem, Dziewięć, Dziesięć, As, Walet, Dama, Król
    }
    public enum Kolor {
        Kier, Karo, Pik, Trefl
    }
    private final Wartosc wartosc;
    private final Kolor kolor;
    public Card(Wartosc wartosc, Kolor kolor){
        this.wartosc = wartosc;
        this.kolor = kolor;
    }
    public Wartosc getWartosc(){
        return wartosc;
    }
    public Kolor getKolor(){
        return kolor;
    }
}

