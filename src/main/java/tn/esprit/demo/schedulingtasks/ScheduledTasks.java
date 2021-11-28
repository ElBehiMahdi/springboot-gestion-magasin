package tn.esprit.demo.schedulingtasks;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tn.esprit.demo.entities.Stock;
import tn.esprit.demo.service.FactureService;
import tn.esprit.demo.service.StockService;

import java.text.SimpleDateFormat;
import java.util.Date;


@Component
public class ScheduledTasks {
    private static final Logger log = LoggerFactory.getLogger(ScheduledTasks.class);
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
    @Autowired
    private StockService sr;

    SimpleDateFormat formater = new SimpleDateFormat("YYYY-MM-dd");


    @Scheduled(fixedRate = 60000)
    public void check() {
        for(Stock s : sr.warnStock()) {
        log.info("STOCK EN DANGER DETECTE "+s.getLibelle(), dateFormat.format(new Date())); }
    }

}
