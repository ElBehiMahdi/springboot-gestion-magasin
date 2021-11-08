package tn.esprit.demo.service;

import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Stock;

import java.util.List;

public interface StockService {
    public abstract Stock get(Long id);
    public abstract Stock saveStock(Stock s);
    public abstract Stock updateStock(Stock s);
    public abstract List<Stock> getAllStocks();
}
