import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //System.out.println("Hello world!");


        //Zad01();
        //Zad02();
        //Zad03();
        //Zad04();
        //Zad05();
        Zad06();
    }

    public static void Zad01(){
        Scanner scan = new Scanner(System.in);
        System.out.print("Podaj bok a: ");
        int a = scan.nextInt();
        System.out.print("Podaj bok b: ");
        int b = scan.nextInt();
        System.out.println("Pole prostokata: " + a * b);
    }

    public static void Zad02 (){
        /* Math.PI -> liczba pi   Math.sqrt() -> pierwiastek kwadratowy */
        double number = Math.sqrt(Math.PI);
        /* Math.round -> zaokrąglanie liczby */
        System.out.println(Math.round(number *100)/100.0);
    }

    public static void Zad03(){
        Scanner scan = new Scanner(System.in);
        String text = scan.nextLine();
        String[] strings = text.split("\\s");

        for (int i = 0; i < strings.length; i++){
            System.out.println(strings[i]);
        }
    }

    public static void Zad04(){
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        if ((a+b>c)&&(a+c>b)&&(b+c>a)){
            System.out.println("TAK");
        }else if((a < 0) || (b < 0) || (c < 0)){
            System.out.println("BŁAD");
        }
        else{
            System.out.println("NIE");
        }
    }

    public static void Zad05(){
        Scanner scan = new Scanner(System.in);
        String[][] Tab = {
                {
                        "Styczeń",
                        "Luty",
                        "Marzec",
                        "Kwiecień",
                        "Maj",
                        "Czerwiec",
                        "Lipiec",
                        "Sierpień",
                        "Wrzesień",
                        "Pażdziernik",
                        "Listopad",
                        "Grydzień"
                },
                {
                        "31",
                        "28",
                        "31",
                        "30",
                        "31",
                        "30",
                        "31",
                        "31",
                        "30",
                        "31",
                        "30",
                        "31"
                }
        };
        System.out.println("Podaj liczbę z zakresu 1-12");
        int index = scan.nextInt();
        switch (index){
            case 1:
                System.out.println(Tab[0][index-1] + " " + Tab[1][index-1]);
                break;
            case 2:
                System.out.println(Tab[0][index -1] + " " + Tab[1][index-1]);
                break;
            case 3:
                System.out.println(Tab[0][index-1] + " " + Tab[1][index-1]);
                break;
            case 4:
                System.out.println(Tab[0][index -1] + " " + Tab[1][index-1]);
                break;
            case 5:
                System.out.println(Tab[0][index-1] + " " + Tab[1][index-1]);
                break;
            case 6:
                System.out.println(Tab[0][index -1] + " " + Tab[1][index-1]);
                break;
            case 7:
                System.out.println(Tab[0][index-1] + " " + Tab[1][index-1]);
                break;
            case 8:
                System.out.println(Tab[0][index -1] + " " + Tab[1][index-1]);
                break;
            case 9:
                System.out.println(Tab[0][index-1] + " " + Tab[1][index-1]);
                break;
            case 10:
                System.out.println(Tab[0][index -1] + " " + Tab[1][index-1]);
                break;
            case 11:
                System.out.println(Tab[0][index -1] + " " + Tab[1][index-1]);
                break;
            case 12:
                System.out.println(Tab[0][index -1] + " " + Tab[1][index-1]);
                break;
        }
    }


    public static void sortUp(double[] array){
        /* Booble sort */

            for (int i = 0;i < array.length; i++){
                //System.out.println(i + " : " + array[i] + " " + array[i+1] + " " + array[i+2]);

                if (i < array.length){
                    if(array[i] > array[i+1]){

                        double j = array[i];
                        array[i] = array[i+1];
                        array[i+1] = j;
                        //System.out.println(array[0]+","+array[1]+","+array[2]);
                    }else {}
                }else {
                    System.out.println("BLAD");
                }
                if ((array[0]<array[1]) && (array[1]<array[2])){
                    break;
                }
            }
        for (double e : array){
            System.out.println(e);
        }
    }
    public static void sortDown(double[] array){
        /* Booble sort */

        for (int i = 0;i < array.length; i++){
            //System.out.println(i + " : " + array[i] + " " + array[i+1] + " " + array[i+2]);

            if (i < array.length){
                if(array[i] < array[i+1]){
                    double j = array[i];
                    array[i] = array[i+1];
                    array[i+1] = j;
                    //System.out.println(array[0]+","+array[1]+","+array[2]);
                }else {}
            }else {
                System.out.println("BLAD");
            }
            if ((array[0]>array[1]) && (array[1]>array[2])){
                break;
            }
        }
        System.out.println(array[0]+","+array[1]+","+array[2]);
    }
    public static void Zad06(){
        Scanner scan = new Scanner(System.in);
        int a1 = scan.nextInt();
        int b1 = scan.nextInt();
        int c1 = scan.nextInt();
        //int d1 = scan.nextInt();
        double a = (double)a1 ;
        double b = (double)b1;
        double c = (double)c1;
        //double d = (double)d1;
        double[] array = {
                a,b,c
        };

        //sortDown(array);

        sortUp(array);
/*
        // iteracja po tablicy array
        for (double e : array){
            System.out.println();
        }
*/
    }
}