package tn.esprit.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tn.esprit.demo.entities.Stock;
import tn.esprit.demo.service.StockService;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StockServiceImplTest {
    @Autowired
    StockService stockService;

    @Test
    public void testAddStock() {
        Stock s = new Stock();
        s.setLibelle("stock test");
        s.setQte(10);
        s.setQteMin(100);
        Stock newStock = stockService.saveStock(s);
        assertNotNull(newStock);
    }

    @Test
    public void testSuppStock(){
        Stock s = new Stock();
        s.setLibelle("stock test");
        s.setQte(10);
        s.setQteMin(100);
        Stock newStock = stockService.saveStock(s);
        stockService.deleteStock(newStock.getIdStock());
        assertFalse(stockService.checkExists(newStock.getIdStock()));
    }

}
