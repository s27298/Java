public class MyDate {
    int month;
    int day;
    int year;

    public MyDate(int day, int month, int year){
        if (year < 1990 || year > 2050 || month < 1 || month > 12 || day < 1 || day > 31){
            System.out.println("Nieprawidłowe dane...");
        }
        this.year = year;
        this.month = month;
        this.day = day;
    }
    public int getYear(){
        return year;
    }
    public void setYear(int year){
        this.year = year;
    }
    public int getMonth(){
        return month;
    }
    public void setMonth(int month){
        this.month = month;
    }
    public int getDay(){
        return day;
    }
    public void SetDay(int day){
        this.day = day;
    }
    public void displayDate(){
        System.out.println(getDay() + "/" + getMonth() + "/" + getYear());
    }
}
