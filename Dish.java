// Модель класы: бір жазба (бір тағам)
public class Dish {

    private String date;      // күні, "КК.АА" форматы
    private String dish;      // тағам атауы
    private int price;        // бағасы (тг), 0..20000
    private boolean homemade; // үйде дайындалған ба

    // ---- date ----
    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        if (date != null && !date.equals("")) {
            this.date = date;
        } else {
            System.out.println("Қате: күні бос болмауы керек");
        }
    }

    // ---- dish ----
    public String getDish() {
        return dish;
    }

    public void setDish(String dish) {
        if (dish != null && !dish.equals("")) {
            this.dish = dish;
        } else {
            System.out.println("Қате: тағам атауы бос болмауы керек");
        }
    }

    // ---- price ----
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        if (price >= 0 && price <= 20000) {
            this.price = price;
        } else {
            System.out.println("Қате: баға 0..20000 аралығында болуы керек");
        }
    }

    // ---- homemade ----
    public boolean isHomemade() {
        return homemade;
    }

    public void setHomemade(boolean homemade) {
        this.homemade = homemade;
    }

    // Ереже әдісі: баға 1000 теңгеден төмен болса, true
    public boolean isCheap() {
        return price < 1000;
    }

    // Жазбаны бір жолға шығару: күн | тағам | баға | үйде/сыртта
    public void printInfo() {
        String place;
        if (homemade) {
            place = "үйде дайындалған";
        } else {
            place = "сыртта";
        }
        System.out.println(date + " │ " + dish + " │ " + price + " тг │ " + place);
    }
}
