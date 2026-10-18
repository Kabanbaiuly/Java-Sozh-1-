import java.util.Scanner;

public class DishApp {
    public static void main(String[] args) {
        DishLog log = new DishLog();

        // !!! Мына деректерді ӨЗ шынайы деректеріңізбен ауыстырыңыз (кемінде 10 жазба, 5 түрлі күн)
        log.addRecord("05.10", "палау", 1800, false);
        log.addRecord("05.10", "сорпа", 0, true);
        log.addRecord("06.10", "лағман", 2200, false);
        log.addRecord("06.10", "самса", 450, false);
        log.addRecord("07.10", "бешбармақ", 0, true);
        log.addRecord("08.10", "палау", 0, true);
        log.addRecord("08.10", "бургер", 2900, false);
        log.addRecord("09.10", "мәнті", 1500, false);
        log.addRecord("10.10", "лағман", 0, true);
        log.addRecord("11.10", "самса", 600, false);

        Scanner scanner = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println();
            System.out.println("=== Не жедім ===");
            System.out.println("1 - Барлық жазбалар");
            System.out.println("2 - Жазбалар саны, қосынды, орташа мән");
            System.out.println("3 - Ең үлкен мәні бар жазба");
            System.out.println("4 - Ереже: баға 1000 теңгеден төмен");
            System.out.println("5 - Сүзу: тағам атауы");
            System.out.println("6 - Өз функциям: сыртта жұмсалған қосынды");
            System.out.println("0 - Шығу");
            System.out.print("Таңдауыңыз: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                log.printAll();
            } else if (choice == 2) {
                System.out.println("Жазбалар саны: " + log.getCount());
                System.out.println("Қосынды: " + log.getTotal() + " тг");
                System.out.println("Орташа мән: " + log.getAverage() + " тг");
            } else if (choice == 3) {
                Dish max = log.findMax();
                if (max != null) {
                    max.printInfo();
                }
            } else if (choice == 4) {
                System.out.println("Ережеге сай жазбалар: " + log.countMatches());
            } else if (choice == 5) {
                System.out.print("Тағам атауы: ");
                String text = scanner.nextLine();
                log.printByCategory(text);
            } else if (choice == 6) {
                System.out.println("Сыртта жұмсалған қосынды: " + log.getOutsideTotal() + " тг");
            } else if (choice != 0) {
                System.out.println("Мұндай пункт жоқ");
            }
        }

        System.out.println("Сау болыңыз!");
        scanner.close();
    }
}
