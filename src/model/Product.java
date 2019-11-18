package model;

import java.util.LinkedList;
import java.util.StringJoiner;

public class Product {

    public LinkedList<Stock> bewegingen = new LinkedList<>();

    public int minStock;
    public int maxStock;
    public int criticalStock;
    public Status status = new CriticalStatus();
    public String omschrijving;
    int delta = 0;

    public Product(int minStock, int maxStock, String omschrijving) {
        this.minStock = minStock;
        this.maxStock = maxStock;
        this.omschrijving = omschrijving;
        criticalStock = this.minStock / 2;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void verhoogStock(Product p, int hoeveelheid) {
        Stock verhoog = new Stock(Stock.StockBeweging.IN,Stock.AanvullenStock.AANKOOP.toString(), p, hoeveelheid);
        bewegingen.add(verhoog);
        CheckStatus(p);
    }

    public void verlaagStock(Product p, int hoeveelheid) {
        Stock verlaag = new Stock(Stock.StockBeweging.UIT,Stock.VerminderenStock.VERKOOP.toString(), p, hoeveelheid);
        bewegingen.add(verlaag);
        CheckStatus(p);
    }

    public String getStatus() {
        return status.getStatus();
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void CheckStatus(Product p) {

        for (Stock stock : bewegingen
        ) {
            if ( stock.product == p ) {
                delta += stock.hoeveelheid;
            }

        }

        if ( delta >= p.maxStock * 0.8 ) {
            p.setStatus(new HighStatus());
        } else if ( delta < p.maxStock * 0.8 || delta >= p.maxStock * 0.6 ) {
            p.setStatus(new NormalStatus());
        } else if ( delta < p.maxStock * 0.6 || delta > p.maxStock * 0.4 ) {
            p.setStatus(new LowStatus());
        } else if ( delta <= p.maxStock * 0.4 ) {
            p.setStatus(new CriticalStatus());
        }

    }

    @Override
    public String toString() {
        StringJoiner sj = new StringJoiner(" ").add(omschrijving).add(Integer.toString(minStock)).add(Integer.toString(maxStock)).add(Integer.toString(delta)).add(getStatus().toString());
        return sj.toString();
    }
}
