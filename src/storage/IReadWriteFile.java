package storage;

import model.Product;

import java.util.List;

public interface IReadWriteFile {
    public List<Product> readFile();
    void writeFile(List<Product> productList);
}
