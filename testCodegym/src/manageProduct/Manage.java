package manageProduct;

import IOProduct.ProductIO;
import model.Product;
import validateProduct.Validate;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Manage {
    List<Product> products = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    // 1. Hien thi danh sach
    public void display(){

        for (int i = 0; i < products.size(); i++) {
            System.out.println("id, Ten san pham, Gia, So luong, Noi dung: ");
            System.out.println(products.get(i).toString());
        }
    }
    // 2. Them san pham
    public void add(Product product){
        products.add(product);
    }

    // 3. Cap nhat san pham
    public void edit(){
        try {
            System.out.println("Nhap id san pham muon sua: ");
            int id = Integer.parseInt(sc.nextLine());
            int index = findIndexById(id);
            if (index!= -1){
                products.set(index, create());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public int findIndexById(int id){
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id){
                return i;
            }
        }
        return -1;
    }
    public Product create(){
        int id  = Validate.validateId(products);
        System.out.println("Nhap ten san pham");
        String name = sc.nextLine();
        double price = Validate.validatePrice();
        int quantity = Validate.validateQuantity();
        System.out.println("Nhap content: ");
        String content = sc.nextLine();
        return new Product(id, name, price, quantity, content);
    }
    // 4. Xoa san pham
    public void delete(){
            try {
                System.out.println("Nhap id muon xoa: ");
                int id = Integer.parseInt(sc.nextLine());
                int index = findIndexById(id);
                    if (index != -1) {
                        products.remove(index);
                    }
                } catch(Exception e){
                    e.printStackTrace();
            }
    }

    // 5. Sap xep
    public void sortProdcut(){
        for (int i = 0; i < products.size()-1; i++) {
            for (int j = products.size()-1; j > i ; j--) {
                if (products.get(j).getPrice() < products.get(j-1).getPrice()){
                    Product temp = products.get(j);
                    products.set(j,products.get(j-1));
                    products.set(j-1,temp);
                }
            }
        }
    }
    // 6. Tim san pham gia lon nhat
    public void findMax(){
        Product max = products.get(0);
        for (int i = 0; i < products.size(); i++) {
            if (max.getPrice()< products.get(i).getPrice()){
                max = products.get(i);
            }
        }
        System.out.println("id, Ten san pham, Gia, So luong, Noi dung: ");
        System.out.println(max);
    }
    // 7. Đọc file
    public void write(){
        ProductIO.write(products);
    }
    //8. Ghi file
    public void read(){
        products = ProductIO.read();
        System.out.println(products);
    }

}
