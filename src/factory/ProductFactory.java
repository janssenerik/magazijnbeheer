package factory;

import model.Product;

import java.util.Random;

public class ProductFactory {
    public static Product creeerProduct(){
        Random r = new Random();
        Product p = new Product(r.nextInt(10),r.nextInt(100),"test"+r.nextInt(5));
        return p;
    }

}
