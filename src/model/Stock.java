package model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringJoiner;

public class Stock {
    public enum StockBeweging {IN, UIT}

    public enum AanvullenStock {AANMAAK, AANKOOP, PRODUCTIE}

    public enum VerminderenStock {VERKOOP, RESERVATIE, TRANSPORT, QUARANTAINE}

    public StockBeweging stockBeweging;
    public String beweging;
    public Product product;
    public int hoeveelheid;

    public Stock(Enum<StockBeweging> stockBewegingEnum, String beweging, Product product, int hoeveelheid) {
        this.stockBeweging = (StockBeweging) stockBewegingEnum;
        this.beweging = beweging;
        this.product = product;
        this.hoeveelheid = hoeveelheid;
    }

    public void logStockBeweging(Stock stock) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("logbestand.txt",true))) {

            writer.write(new StringJoiner(" ").add(stock.beweging).add(Integer.toString(stock.hoeveelheid)).add(stock.product.getStatus()).add(stock.product.omschrijving).add("\n").toString());

            //aparte klasse voor log is mogelijk
        }

    }

}