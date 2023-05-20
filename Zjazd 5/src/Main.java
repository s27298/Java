import java.util.*;

/*
* Author: s27298
* */

public class Main {
    public static void main(String[] args) {
        Zad03();
    }

    public static void Zad1(){
        Scanner scanner = new Scanner(System.in);
        Set<Integer> zbior = new TreeSet<>();

        System.out.println("Podaj liczby (oddzielone spacjami):");
        String input = scanner.nextLine();
        String[] liczby = input.split(" ");

        for (String liczba : liczby) {
            int parsedLiczba = Integer.parseInt(liczba);
            zbior.add(parsedLiczba);
        }

        System.out.println("Dane wyjściowe: " + zbior);
    }

    public static void Zad2(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Podaj liczby dla pierwszego zbioru, oddzielone spacjami:");
        Set<Integer> setA = new HashSet<>();
        String inputA = scanner.nextLine();
        String[] numbersA = inputA.split(" ");
        for (String number : numbersA) {
            int num = Integer.parseInt(number);
            setA.add(num);
        }

        System.out.println("Podaj liczby dla drugiego zbioru, oddzielone spacjami:");
        Set<Integer> setB = new HashSet<>();
        String inputB = scanner.nextLine();
        String[] numbersB = inputB.split(" ");
        for (String number : numbersB) {
            int num = Integer.parseInt(number);
            setB.add(num);
        }

        Set<Integer> result = new HashSet<>(setA);
        result.removeAll(setB);
        Set<Integer> tempSet = new HashSet<>(setB);
        tempSet.removeAll(setA);
        result.retainAll(tempSet);

        System.out.println("Wynik operacji: " + result);
    }

    public static void Zad03(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Wpisz ciąg znaków: ");
        String input = scanner.nextLine();

        Map<String, Integer> wordCount = new TreeMap<>();
        String[] words = input.split(" ");

        for (String word : words) {
            if (wordCount.containsKey(word)) {
                wordCount.put(word, wordCount.get(word) + 1);
            } else {
                wordCount.put(word, 1);
            }
        }

        System.out.println("Dane wyjściowe: " + wordCount);
    }

    // Zadanie 4
    public class TestScores {
        private int[] scores;

        public TestScores(int[] scores) {
            this.scores = scores;
        }

        public double calculateAverage() {
            int sum = 0;
            int count = 0;

            for (int score : scores) {
                if (score < 0 || score > 100) {
                    throw new IllegalArgumentException("Niewłaściwy wynik testu: " + score);
                }

                sum += score;
                count++;
            }

            return (double) sum / count;
        }
    }

    

}
