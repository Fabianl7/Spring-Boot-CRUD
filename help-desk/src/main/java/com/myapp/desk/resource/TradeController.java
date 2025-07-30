package com.myapp.desk.resource;

import com.myapp.desk.domain.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.myapp.desk.service.TradeService;

import java.util.List;

@RestController
@RequestMapping("/api/trades")
public class TradeController {

    @Autowired
    private TradeService tradeService;

    @PostMapping
    public Trade createTrade(@RequestBody Trade trade) {
        return tradeService.createTrade(trade);
    }

    @GetMapping("/{id}")
    public Trade getTradeById(@PathVariable Long id) {
        return tradeService.getTradeById(id);
    }

    @GetMapping
    public List<Trade> getAllTrades() {
        return tradeService.getAllTrades();
    }

    @PutMapping("/{id}")
    public Trade updateTrade(@PathVariable Long id, @RequestBody Trade trade) {
        return tradeService.updateTrade(id, trade);
    }

    @DeleteMapping("/{id}")
    public void deleteTrade(@PathVariable Long id) {
        tradeService.deleteTrade(id);
    }
}