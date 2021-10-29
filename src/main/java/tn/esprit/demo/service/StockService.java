package tn.esprit.demo.service;

import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Stock;

import java.util.List;

public interface StockService {
    public abstract Stock get(Long id);
    public abstract void saveStock(Stock s);
    public abstract void updateStock(Stock s);
    public abstract List<Stock> getAllStocks();
}
