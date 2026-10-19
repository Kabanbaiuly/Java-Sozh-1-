// Журнал класы: жазбалар массиві және есептеу әдістері
public class DishLog {

    private Dish[] items = new Dish[30];
    private int count = 0;

    // Жаңа жазба қосу; массив толса, false қайтарады
    public boolean addRecord(String d, String name, int cost, boolean home) {
        if (count >= 30) {
            return false;
        }
        Dish item = new Dish();
        item.setDate(d);
        item.setDish(name);
        item.setPrice(cost);
        item.setHomemade(home);
        items[count] = item;
        count++;
        return true;
    }

    // Жазбалар саны
    public int getCount() {
        return count;
    }

    // Бағалардың қосындысы
    public int getTotal() {
        int sum = 0;
        int i = 0;
        while (i < count) {
            sum = sum + items[i].getPrice();
            i++;
        }
        return sum;
    }

    // Орташа баға (бүтін бөлу); жазба жоқ болса, 0
    public int getAverage() {
        if (count == 0) {
            return 0;
        }
        return getTotal() / count;
    }

    // Бағасы ең үлкен жазба (бірдей болса, біріншісі); жазба жоқ болса, null
    public Dish findMax() {
        if (count == 0) {
            return null;
        }
        Dish max = items[0];
        int i = 1;
        while (i < count) {
            if (items[i].getPrice() > max.getPrice()) {
                max = items[i];
            }
            i++;
        }
        return max;
    }

    // isCheap() true қайтаратын жазбалар саны
    public int countMatches() {
        int matches = 0;
        int i = 0;
        while (i < count) {
            if (items[i].isCheap()) {
                matches++;
            }
            i++;
        }
        return matches;
    }

    // Барлық жазбаларды нөмірлеп шығару
    public void printAll() {
        if (count == 0) {
            System.out.println("Жазба жоқ");
            return;
        }
        int i = 0;
        while (i < count) {
            System.out.print((i + 1) + ". ");
            items[i].printInfo();
            i++;
        }
    }

    // Тағам атауы берілген мәнге тең жазбаларды шығару
    public void printByCategory(String value) {
        boolean found = false;
        int i = 0;
        while (i < count) {
            if (value.equals(items[i].getDish())) {
                items[i].printInfo();
                found = true;
            }
            i++;
        }
        if (!found) {
            System.out.println("Мұндай жазба табылмады");
        }
    }

    // Өз әдіс: сыртта (үйде дайындалмаған) жеген тағамдарға кеткен қосынды
    public int getOutsideTotal() {
        int sum = 0;
        int i = 0;
        while (i < count) {
            if (!items[i].isHomemade()) {
                sum = sum + items[i].getPrice();
            }
            i++;
        }
        return sum;
    }
}
