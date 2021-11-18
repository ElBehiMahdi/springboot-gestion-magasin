package tn.esprit.demo.service;

import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Stock;

import java.util.List;
import java.util.Optional;

public interface StockService {
    public abstract Optional<Stock> get(Long id);
    public abstract Stock saveStock(Stock s);
    public abstract Stock updateStock(Stock s);
    public abstract List<Stock> getAllStocks();
    void deleteStock(Long id);

    boolean checkExists(Long id);

    public List<Stock> warnStock();
}
