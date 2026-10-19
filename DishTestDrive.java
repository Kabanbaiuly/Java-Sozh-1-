// Тестілеуші класс
public class DishTestDrive {
    public static void main(String[] args) {

        // ТЕСТ 1: жоғарғы шектен асқан мән қабылданмайды
        Dish d = new Dish();
        d.setPrice(500);
        d.setPrice(25000);
        if (d.getPrice() == 500) {
            System.out.println("ТЕСТ 1 (жоғарғы шектен асқан мән қабылданбайды): OK");
        } else {
            System.out.println("ТЕСТ 1: ҚАТЕ");
        }

        // ТЕСТ 2: төменгі шектен кем мән қабылданбайды
        d.setPrice(-5);
        if (d.getPrice() == 500) {
            System.out.println("ТЕСТ 2 (төменгі шектен кем мән қабылданбайды): OK");
        } else {
            System.out.println("ТЕСТ 2: ҚАТЕ");
        }

        // Үш тест жазбасы: 1500 + 0 + 800 = 2300
        DishLog log = new DishLog();
        log.addRecord("01.10", "палау", 1500, false);
        log.addRecord("01.10", "сорпа", 0, true);
        log.addRecord("02.10", "самса", 800, false);

        // ТЕСТ 3: қосынды
        if (log.getTotal() == 2300) {
            System.out.println("ТЕСТ 3 (қосынды): OK");
        } else {
            System.out.println("ТЕСТ 3: ҚАТЕ");
        }

        // ТЕСТ 4: ең үлкен мән (палау, 1500)
        Dish max = log.findMax();
        if (max != null && max.getDish().equals("палау") && max.getPrice() == 1500) {
            System.out.println("ТЕСТ 4 (ең үлкен мән): OK");
        } else {
            System.out.println("ТЕСТ 4: ҚАТЕ");
        }

        // ТЕСТ 5: баға < 1000: сорпа (0) және самса (800) -> 2
        if (log.countMatches() == 2) {
            System.out.println("ТЕСТ 5 (ереже бойынша санау): OK");
        } else {
            System.out.println("ТЕСТ 5: ҚАТЕ");
        }

        // Қосымша тест 6: орташа мән (2300 / 3 = 766)
        if (log.getAverage() == 766) {
            System.out.println("ТЕСТ 6 (орташа мән): OK");
        } else {
            System.out.println("ТЕСТ 6: ҚАТЕ");
        }

        // Қосымша тест 7: сыртта жұмсалған қосынды (1500 + 800 = 2300)
        if (log.getOutsideTotal() == 2300) {
            System.out.println("ТЕСТ 7 (сыртта жұмсалған қосынды): OK");
        } else {
            System.out.println("ТЕСТ 7: ҚАТЕ");
        }
    }
}
