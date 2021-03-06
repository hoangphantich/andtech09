package bt01.QuanLyBanHang;

import java.util.List;
import java.util.Scanner;

public class ProductManager {

    String no1 = "Plasma Tivi 32 inches";
    String no2 = "Machbook pro 18";
    String no3 = "Mitsumi mouse";
    String no4 = "Elead PC";
    String no5 = "Bkav antivirus";

    public void doBuyProducts(List<Product> list) {
        System.out.println("Our product:");
        System.out.printf("1- %-25s %-10s\n", no1, "1000$");
        System.out.printf("2- %-25s %-10s\n", no2, "1500$");
        System.out.printf("3- %-25s %-10s\n", no3, "5$");
        System.out.printf("4- %-25s %-10s\n", no4, "500$");
        System.out.printf("5- %-25s %-10s\n", no5, "30$");
        doBuy(list);
    }

    // Hàm thực hiện việc mua hàng
    void doBuy(List<Product> list) {
        Product product = new Product();
        int idBuyed = getProductBuyed();

        if (idBuyed == 1) {
            product.setId("1");
            product.setNameProduct(no1);
            product.setPrice(1000);
        } else if (idBuyed == 2) {
            product.setId("2");
            product.setNameProduct(no2);
            product.setPrice(1500);
        } else if (idBuyed == 3) {
            product.setId("3");
            product.setNameProduct(no3);
            product.setPrice(5);
        } else if (idBuyed == 4) {
            product.setId("4");
            product.setNameProduct(no4);
            product.setPrice(500);
        } else if (idBuyed == 5) {
            product.setId("5");
            product.setNameProduct(no5);
            product.setPrice(30);
        }

        int num = getAmountOf(product.getNameProduct());
        product.setQuantity(num);

        list.add(product);

        if (getYesNo().equals("y")) {
            doBuy(list);
        }
    }

    // Hàm trả về id loại hàng được chọn
    public int getProductBuyed() {
        boolean check = false;
        int value = 0;
        do {
            Scanner s = new Scanner(System.in);
            check = false;
            System.out.print("-> Do you want to buy? <1,2,3,4,5>: ");
            try {
                value = s.nextInt();
                if (value < 0 || value > 5) {
                    check = true;
                }
            } catch (Exception ex) {
                check = true;
            }
        } while (check);
        return value;
    }

    // Hàm trả về số lượng hàng hóa khách đặt mua
    public int getAmountOf(String name) {
        boolean check = false;
        int value = 0;
        do {
            Scanner s = new Scanner(System.in);
            check = false;
            System.out.print("You buy '" + name + "', how many item: ");
            try {
                value = s.nextInt();
                if (value < 1) {
                    check = true;
                }
            } catch (Exception ex) {
                check = true;
            }
        } while (check);
        return value;
    }

    // Hàm trả về y, n
    public String getYesNo() {
        boolean check = false;
        String value = "";
        do {
            Scanner scanner = new Scanner(System.in);
            check = false;
            System.out.print("Do you want to buy more <y,n>: ");
            try {
                value = scanner.next();
                if (value.equals("y")) {
                    check = false;
                } else if (value.equals("n")) {
                    check = false;
                } else {
                    check = true;
                }
            } catch (Exception ex) {
                check = true;
            }
        } while (check);
        return value;
    }
}
