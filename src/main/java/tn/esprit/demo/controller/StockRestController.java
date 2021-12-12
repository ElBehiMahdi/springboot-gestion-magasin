package tn.esprit.demo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.demo.entities.Client;
import tn.esprit.demo.entities.Stock;
import tn.esprit.demo.service.ClientService;
import tn.esprit.demo.service.StockService;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@Api(tags = "Stock management")
@RequestMapping("/stock")
public class StockRestController {

    @Autowired
    StockService stockService;

    //http://localhost:8089/SpringMVC/stock/retrieve-all-stocks
    @GetMapping("/retrieve-all-stocks")
    @ApiOperation(value = "Récupérer la liste des stocks")
    @ResponseBody
    public List<Stock> getStocks() {
        List<Stock> listStocks = stockService.getAllStocks();
        return listStocks;
    }

    //http://localhost:8089/SpringMVC/stock/retrieve-all-stocks
    @GetMapping("/warn")
    @ApiOperation(value = "Récupérer la warn des stocks")
    @ResponseBody
    public List<Stock> warnStock() {
        List<Stock> result = stockService.warnStock();
        return result;
    }

    // http://localhost:8089/SpringMVC/stock/retrieve-stock/1
    @GetMapping("/retrieve-stock/{stock-id}")
    @ApiOperation(value = "Récupérer un stock par id")
    @ResponseBody
    public Optional<Stock> retrieveStock(@PathVariable("stock-id") Long stockId) {
        return stockService.get(stockId);
    }

    //http://localhost:8089/SpringMVC/stock/add-stock
    @PostMapping("/add-stock")
    @ApiOperation(value = "Ajouter un stock")
    @ResponseBody
    public Stock addStock(@RequestBody Stock s) {
        Stock stock = stockService.saveStock(s);
        return stock;
    }

    //http://localhost:8089/SpringMVC/stock/modify-stock
    @PutMapping("/modify-stock")
    @ApiOperation(value = "Modifier un stock")
    @ResponseBody
    public Stock modifyStock(@RequestBody Stock stock) {
        return stockService.updateStock(stock);
    }


    //http://localhost:8089/SpringMVC/client/remove-stock/1
    @DeleteMapping("remove-stock/{idStock}")
    @ApiOperation(value = "Remove stock by id")
    @ResponseBody
    public void removeStockById(@PathVariable("idStock") Long idStock) {
        stockService.deleteStock(idStock);
    }
}