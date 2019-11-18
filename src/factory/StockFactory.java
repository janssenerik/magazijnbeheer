package factory;

import model.Product;
import model.Stock;

import java.util.Random;

public class StockFactory {
    public static Stock creeerStock(Product p) throws Exception {
        Random r = new Random();
        Stock s = new Stock(Stock.StockBeweging.values()[r.nextInt(Stock.StockBeweging.values().length)],Stock.StockBeweging.values()[r.nextInt(Stock.StockBeweging.values().length)].toString(),p,r.nextInt(p.maxStock));

        if ( p.getStatus().equals("High") ){
            Exception e = new Exception("Stock is al te hoog");
            throw e;
        }

        //Check aanmaak?
        // En hoe exception boodschap opnemen?

        p.verhoogStock(p,s.hoeveelheid);
        s.logStockBeweging(s);
        return s;
    }
}
