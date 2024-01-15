package controller;

import model.Product;
import storage.ReadWriteFile;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {

    public static List<Product> productList = ReadWriteFile.getInstance().readFile();

    public static void addProduct(Product product) {
        ManagerProduct.productList.add(product);
    }

    public static Product editProduct(int id) {
        for (Product products : productList) {
            if (products.getId() == id) {
                System.out.println("Thông tin cần sửa");
                System.out.println("0.exit");
                System.out.println("1.id");
                System.out.println("2.name");
                System.out.println("3.price");
                System.out.println("4.number");
                System.out.println("5.description");
                Scanner scanner = new Scanner(System.in);
                int choice1 = scanner.nextInt();
                switch (choice1) {
                    case 0:
                        System.exit(0);
                        break;
                    case 1:
                        System.out.println("Nhập id muốn sửa");
                        int newId = scanner.nextInt();
                        Product product1 = new Product(newId, products.getName(), products.getPrice(), products.getNumber(), products.getIntroduction());
                        return product1;
                    case 2:
                        System.out.println("Nhập name muốn sửa");
                        Scanner scanner1 = new Scanner(System.in);
                        String newName = scanner1.nextLine();
                        Product product2 = new Product(products.getId(), newName, products.getPrice(), products.getNumber(), products.getIntroduction());
                        return product2;
                    case 3:
                        System.out.println("Nhập price muốn sửa");
                        double newPrice = scanner.nextDouble();
                        Product product3 = new Product(products.getId(), products.getName(), newPrice, products.getNumber(), products.getIntroduction());
                        return product3;
                    case 4:
                        System.out.println("Nhập số lượng sửa");
                        int newNumber = scanner.nextInt();
                        Product product4 = new Product(products.getId(), products.getName(), products.getPrice(), newNumber, products.getIntroduction());
                        return product4;
                    case 5:
                        System.out.println("Nhập thông tin sửa");
                        String newDescription = scanner.next();
                        Product product5 = new Product(products.getId(), products.getName(), products.getPrice(), products.getNumber(), newDescription);
                        return product5;
                }
            } else {
                System.out.println("id không tồn tại");
            }
        }
        return null;
    }

    public static void deleteById(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                ManagerProduct.productList.remove(product);
                break;
            } else {
                System.out.println("Không tìm thấy id");
            }
        }
    }

    public static void findProductMaxPrice() {
        Collections.sort(productList);
        System.out.println(ManagerProduct.productList.get(productList.size() - 1));
    }

    public static void sortByPrice() {
        Collections.sort(productList);
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public ManagerProduct() {
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public static void setProductList(List<Product> productList) {
        ManagerProduct.productList = productList;
    }

}
