import java.util.Scanner;

public class Main {
    static Drink[] drinks = new Drink[100];
    static int index = 0;

    //menu
    public static void menu () {
        System.out.println("====CoffeeShop Pro====");
        System.out.println("1. Thêm món");
        System.out.println("2. Hiển thị menu");
        System.out.println("3. Áp mã giảm giá");
        System.out.println("4. Xóa món");
        System.out.println("5. Thống kê");
        System.out.println("0. Thoát");

        System.out.println("Nhập lựa chọn: ");
    }

    //Thêm món
    public static void addDrink(Scanner sc) {

        System.out.println("1. Coffee");
        System.out.println("2. Fruit Tea");

        int choice = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập ID: ");
        int id = Integer.parseInt(sc.nextLine());

        System.out.print("Nhập tên: ");
        String name = sc.nextLine();

        System.out.print("Nhập giá: ");
        double price = Double.parseDouble(sc.nextLine());

        switch (choice) {
            case 1:
                drinks[index++] = new Coffee(id, name, price);
                break;

            case 2:
                drinks[index++] = new FruitTea(id, name, price);
                break;

            default:
                System.out.println("Không hợp lệ");
        }
    }

    //hiển thị menu
    public static void displayMenu() {

        if (index == 0) {
            System.out.println("Danh sách rỗng");
            return;
        }

        for (int i = 0; i < index; i++) {
            drinks[i].displayInfo();
            System.out.println("-----------");
        }
    }

    //áp mã giảm giá
    public static void applyPromotion(Scanner sc) {

        System.out.print("Nhập % giảm giá: ");
        double percent =
                Double.parseDouble(sc.nextLine());

        for (int i = 0; i < index; i++) {
            drinks[i].applyDiscount(percent);
        }

        System.out.println("Đã áp dụng giảm giá");
    }

    //xóa món
    public static void removeDrink(Scanner sc) {

        System.out.print("Nhập ID cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());
        int found = -1;

        for (int i = 0; i < index; i++) {
            if (drinks[i].getId() == id) {
                found = i;
                break;
            }
        }

        if (found == -1) {
            System.out.println("Không tìm thấy");
            return;
        }

        for (int i = found; i < index - 1; i++) {
            drinks[i] = drinks[i + 1];
        }
        drinks[index - 1] = null;
        index--;

        System.out.println("Xóa thành công");
    }

    //thống kê
    public static void statistics() {

        if (index == 0) {
            System.out.println("Menu rỗng");
            return;
        }

        double sum = 0;

        for (int i = 0; i < index; i++) {
            sum += drinks[i].getPrice();
        }

        System.out.println("Giá trung bình: " + (sum / index));
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        do {
            menu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:
                    addDrink(sc);
                    break;
                case 2:
                    displayMenu();
                    break;
                case 3:
                    applyPromotion(sc);
                    break;
                case 4:
                    removeDrink(sc);
                    break;
                case 5:
                    statistics();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }

        } while (true);
    }
}
