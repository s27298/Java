public class Student {
    String imie = null;
    String nazwisko = null;
    int index;
    double obecnosc;
    int pojOceny;

    public Student(){
        this.imie = "unknown";
        this.nazwisko = "unknown";
    }
    public Student(String imie, String nazwisko, int index){
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.index = index;
    }

    public void setImie(String imie){
        this.imie = imie;
    }
    public String getImie(){
        return imie;
    }
    public void setNazwisko(String nazwisko){
        this.nazwisko = nazwisko;
    }
    public String getNazwisko(){
        return nazwisko;
    }
    public void setIndex(int index){
        this.index = index;
    }
    public int getIndex(){
        return index;
    }
    public void setObecnosc(double obecnosc){
        this.obecnosc = obecnosc;
    }
    public double getObecnosc(){
        return obecnosc;
    }
    public void setPojOceny(int pojOceny){
        this.pojOceny = pojOceny;
    }
    public int getPojOceny(){
        if (obecnosc < 50.0){
            return 2;
        }else {
            return pojOceny;
        }
    }
}
