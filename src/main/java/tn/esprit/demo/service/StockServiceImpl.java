package tn.esprit.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import tn.esprit.demo.entities.Stock;
import tn.esprit.demo.repository.ClientRepository;

import javax.transaction.Transactional;
import java.util.List;

public class StockServiceImpl implements StockService{

    @Autowired
    private StockService stockService;

    @Override
    public Stock get(Long id) {
        return stockService.get(id);
    }

    @Override
    public void saveStock(Stock s) {
        stockService.saveStock(s);
    }

    @Override
    public void updateStock(Stock s) {
        stockService.saveStock(s);
    }

    @Override
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }
}
