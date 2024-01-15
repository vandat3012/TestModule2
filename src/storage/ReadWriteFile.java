package storage;

import model.Product;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteFile implements IReadWriteFile {
    private final String PATH = "D:\\code_gym\\git\\module2\\TestModule2\\src\\data\\products.csv";

        public List<Product> products = new ArrayList<>();
        private static ReadWriteFile instance;
        private ReadWriteFile(){}
        public static ReadWriteFile getInstance(){
            if (instance == null){
                instance = new ReadWriteFile();
            }
            return instance;
        }


        @Override
        public List<Product> readFile() {
            try {
                File file = new File(PATH);
                FileReader fileReader = new FileReader(file);
                BufferedReader bufferedReader = new BufferedReader(fileReader);
                String line;
                while ((line = bufferedReader.readLine())!= null){
                    String[] data = line.split(",");
                    if (data.length == 5){
                        Product products = new Product();

                    }else {
                        System.out.println("File Not Data" + line);
                    }
                }
                bufferedReader.close();
                fileReader.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            return products;
        }



    public void writeFile(List<Product> product) {
            try {
                File file = new File(PATH);
                FileWriter fileWriter = new FileWriter(file);
                if (!file.exists()){
                    file.createNewFile();
                }
                BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
                for (Product pro: product){
                    bufferedWriter.write(pro.getId()+","+pro.getName()+","+pro.getName()+","+pro.getPrice()+"," + pro.getNumber() + "," + pro.getIntroduction());
                    bufferedWriter.newLine();
                }
                bufferedWriter.close();
                fileWriter.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }


