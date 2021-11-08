package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.demo.entities.Stock;

import java.util.List;
@Service
public class StockServiceImpl implements StockService{

    @Autowired
    private StockService stockService;

    @Override
    public Stock get(Long id) {
        return stockService.get(id);
    }

    @Override
    public Stock saveStock(Stock s) {
        stockService.saveStock(s);
        return s;
    }

    @Override
    public Stock updateStock(Stock s) {
        stockService.saveStock(s);
        return s;
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
}
