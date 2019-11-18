package view;

import factory.ProductFactory;
import factory.StockFactory;
import model.Product;

import javax.swing.*;
import java.util.HashSet;

public class TestMagazijn {

    public static void main(String[] args) throws Exception {

        StockFactory stockFactory = new StockFactory();
        ProductFactory productFactory = new ProductFactory();

        HashSet<Product> magazijn = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            Product testProduct = productFactory.creeerProduct();
            stockFactory.creeerStock(testProduct);
            magazijn.add(testProduct);
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (Product p : magazijn) {
            stringBuilder.append(p.toString()).append("\n");
        }
        String sb = stringBuilder.toString();

        JOptionPane.showMessageDialog(null, sb);

    }

}
