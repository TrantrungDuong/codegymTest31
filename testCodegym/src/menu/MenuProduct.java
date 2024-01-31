package menu;

import manageProduct.Manage;

import java.util.Scanner;

public class MenuProduct {
    public void menu(){
        Manage manage = new Manage();
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("Menu quan ly san pham");
            System.out.println("1. Xem danh sach");
            System.out.println("2. Them moi");
            System.out.println("3. Cap nhat");
            System.out.println("4. Xoa");
            System.out.println("5. Sap xep");
            System.out.println("6. Tim san pham dat nhat");
            System.out.println("7. Doc tu file");
            System.out.println("8. Ghi vao file");
            System.out.println("9. Thoat");
            int choice = 0;
            while (true){
                try {
                    System.out.println("Nhap lua chon");
                    choice = Integer.parseInt(sc.nextLine());
                    break;
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            switch (choice){
                case 1:
                    manage.display();
                    break;
                case 2:
                    manage.add(manage.create());
                    break;
                case 3:
                    manage.edit();
                    break;
                case 4:
                    manage.delete();
                    break;
                case 5:
                    manage.sortProdcut();
                    break;
                case 6:
                    manage.findMax();
                    break;
                case 7:
                    manage.read();
                    break;
                case 8:
                    manage.write();
                    break;
                case 9:
                    return;
            }
        }
    }
}
