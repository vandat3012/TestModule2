package views;

import controller.ManagerProduct;
import model.Product;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<Product> products = ManagerProduct.productList;

    public static void main(String[] args) {
        Product product1 = new Product(1, "a", 23, 4, "good");
        Product product2 = new Product(3, "c", 26, 3, "bad");
        Product product3 = new Product(3, "c", 288, 3, "bad");
        Product product4 = new Product(2, "d", 2886, 4, "bad");
        Product product5 = new Product(2, "b", 826, 3, "bad");
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
        products.add(product5);

        int choice = -1;
        do {
            System.out.println("Menu");
            System.out.println("1.Hiển thị danh sách");
            System.out.println("2.Thêm");
            System.out.println("3.Sửa");
            System.out.println("4.Xóa");
            System.out.println("5.Sắp xếp theo giá");
            System.out.println("6.Tìm sản phẩm có giá đắt nhất");
            System.out.println("7.Đọc file");
            System.out.println("8.Ghi file");
            System.out.println("9. exit");

            Scanner scanner = new Scanner(System.in);
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println(ManagerProduct.productList);
                    break;
                case 2:
                    Product newProduct = createProduct();
                    ManagerProduct.addProduct(newProduct);
                    System.out.println(ManagerProduct.productList);
                    break;
                case 3:
                    int idEdit = toStringId();
                    ManagerProduct.editProduct(idEdit);
                    System.out.println(ManagerProduct.productList);
                    break;
                case 4:
                    int idDelete = toStringId();
                    ManagerProduct.deleteById(idDelete);
                    System.out.println(ManagerProduct.productList);
                    break;
                case 5:
                    ManagerProduct.sortByPrice();
                    break;
                case 6:
                    ManagerProduct.findProductMaxPrice();
                    break;
                case 7:
                    ReadWriteFile.getInstance().readFile();
                    break;
                case 8:
                    ReadWriteFile.getInstance().writeFile(products);
                    break;
                case 9:
                    System.exit(0);
                    break;
            }

        } while (choice != -1);
    }

    public static Product createProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập id");
        int id = scanner.nextInt();
        System.out.println("Nhập name");
        Scanner scanner1 = new Scanner(System.in);
        String name = scanner1.nextLine();
        System.out.println("Nhập price");
        double price = scanner.nextDouble();
        System.out.println("Nhập number");
        int number = scanner.nextInt();
        System.out.println("Nhập description");
        String description = scanner1.nextLine();
        Product product = new Product(id, name, price, number, description);
        return product;
    }

    public static int toStringId() {
        System.out.println("Nhập id của bạn");
        Scanner scanner = new Scanner(System.in);
        int id = scanner.nextInt();
        return id;
    }
}