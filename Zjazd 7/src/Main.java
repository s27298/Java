/*
    Autor: s27298
    Zadanie: W grze biorą udział dwaj generałowie ze swoimi armiami. Każdy generał posiada armię żołnierzy oraz worek ze złotymi monetami.

Żołnierze posiadają: - stopień wojskowy: szeregowy (wartość: 1), kapral (wartość: 2), kapitan (wartość: 3) i major (wartość: 4) - doświadczenie - siła żołnierza jest obliczana jako iloczyn jego stopnia i doświadczenia - żołnierz ginie, gdy jego doświadczenie = 0 - jeżeli doświadczenie osiągnie pięciokrotność wartości stopnia, awansuje na kolejny stopień oraz jego doświadczenie = 1.

Generałowie posiadają początkową (ograniczoną) liczbę złotych monet. Celem generała jest posiadanie największej i najlepiej wyszkolonej armii.

Generał może: - zarządzić manewry swojej armii (lub jej części), które powiększają doświadczenie uczestniczących w nich żołnierzy o 1; manewry kosztują: za każdego żołnierza biorącego udział w manewrach generał płaci wartość (liczbę monet) przypisaną do stopnia wojskowego - zaatakować drugiego generała; wygrywa generał, który posiada armię o większej łącznej sile; przegrany przekazuje 10% swojego złota wygrywającemu; każdy żołnierz z armii przegrywającej traci 1 punkt doświadczenia, a z wygrywającej zyskuje jeden; w przypadku remisu każdy generał musi rozstrzelać jednego swojego losowo wybranego żołnierza - kupić żołnierzy; koszt żołnierza = 10 *(jego stopień); zakupieni żołnierze posiadają doświadczenie = 1

Walczącym generałom przygląda się sekretarz prezydenta. Pisze on raporty dotyczące obu armii. Opisuje wszelkie akcje podjęte przez generałów oraz zmiany poszczególnych żołnierzy. Generał wraz ze swoimi zasobami powinien mieć możliwość zapisu i odczytu swojego stanu na / z dysku.
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        General general1 = new General("Generał 1", 1000);
        General general2 = new General("Generał 2", 500);

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        boolean isGeneral1Turn = true;

        while (choice != 6) {
            if (isGeneral1Turn) {
                System.out.println("Runda generała 1 - " + general1.getName());
            } else {
                System.out.println("Runda generała 2 - " + general2.getName());
            }

            System.out.println("Menu:");
            System.out.println("1) Atak");
            System.out.println("2) Manewry");
            System.out.println("3) Kup żołnierza");
            System.out.println("4) Zapisz grę");
            System.out.println("5) Wczytaj grę");
            System.out.println("6) Wyjście");
            System.out.print("Wybierz opcję: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    if (isGeneral1Turn) {
                        general1.attack(general2);
                    } else {
                        general2.attack(general1);
                    }
                    break;
                case 2:
                    if (isGeneral1Turn) {
                        general1.maneuverArmy();
                    } else {
                        general2.maneuverArmy();
                    }
                    break;
                case 3:
                    System.out.print("Podaj nazwę żołnierza: ");
                    String soldierName = scanner.next();
                    System.out.print("Podaj stopień wojskowy żołnierza (1-4): ");
                    int rank = scanner.nextInt();
                    Soldier newSoldier = new Soldier(soldierName, rank, 1);
                    if (isGeneral1Turn) {
                        general1.recruitSoldier(newSoldier);
                    } else {
                        general2.recruitSoldier(newSoldier);
                    }
                    break;
                case 4:
                    System.out.print("Podaj nazwę pliku: ");
                    String saveFileName = scanner.next();
                    if (isGeneral1Turn) {
                        general1.saveState(saveFileName + ".txt");
                    } else {
                        general2.saveState(saveFileName + ".txt");
                    }
                    break;
                case 5:
                    System.out.print("Podaj nazwę pliku: ");
                    String loadFileName = scanner.next();
                    General loadedGeneral = General.loadState(loadFileName);
                    if (loadedGeneral != null) {
                        if (isGeneral1Turn) {
                            general1 = loadedGeneral;
                        } else {
                            general2 = loadedGeneral;
                        }
                    }
                    break;
                case 6:
                    System.out.println("Wyjście z programu.");
                    break;
                default:
                    System.out.println("Nieprawidłowy wybór. Spróbuj ponownie.");
                    break;
            }

            System.out.println();

            System.out.println("Informacje o generałach:");
            System.out.println("Generał 1 - " + general1.getName() + " posiada " + general1.getGoldAmount() + " złota.");
            System.out.println("Generał 1 posiada armię składającą się z:");
            for (Soldier soldier : general1.getArmy()) {
                System.out.println("- " + soldier.getName() + " (Stopień: " + soldier.getRank() + ", Doświadczenie: " + soldier.getExperience() + ", Siła: " + soldier.getStrength() + ")");
            }

            System.out.println("Generał 2 - " + general2.getName() + " posiada " + general2.getGoldAmount() + " złota.");
            System.out.println("Generał 2 posiada armię składającą się z:");
            for (Soldier soldier : general2.getArmy()) {
                System.out.println("- " + soldier.getName() + " (Stopień: " + soldier.getRank() + ", Doświadczenie: " + soldier.getExperience() + ", Siła: " + soldier.getStrength() + ")");
            }

            System.out.println();

            isGeneral1Turn = !isGeneral1Turn;
        }
    }
}
