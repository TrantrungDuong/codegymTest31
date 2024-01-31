package validateProduct;

import model.Product;

import java.util.List;
import java.util.Scanner;

public class Validate {
    static Scanner sc = new Scanner(System.in);
    public static double validatePrice(){
        while (true){
            try {
                System.out.println("Nhap gia san pham: ");
                return Double.parseDouble(sc.nextLine());
            }catch (Exception e){
                System.out.println("Ban nhap sai roi! Nhap lai di");
            }
        }
    }
    public static int validateQuantity(){
        while (true){
            try {
                System.out.println("Nhap so luong: ");
                return Integer.parseInt(sc.nextLine());
            }catch (Exception e){
                System.out.println("Nhap sai roi");
            }
        }
    }
    public static int validateId(List<Product> products){
        int id = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId()> id){
                id = products.get(i).getId();
            }

        }
        return id+1;
    }

}
