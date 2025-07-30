package com.myapp.desk.service;

import com.myapp.desk.domain.Trade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.myapp.desk.respository.TradeRepository;

import java.util.List;
import java.util.Optional;

@Service
public class TradeServiceImpl implements TradeService {

    @Autowired
    private TradeRepository tradeRepository;

    @Override
    public Trade createTrade(Trade trade) {
        return tradeRepository.save(trade);
    }

    @Override
    @Cacheable(value = "trades", key = "#id")
    public Trade getTradeById(Long id) {
        return tradeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Trade> getAllTrades() {
        return tradeRepository.findAll();
    }

    @Override
    public Trade updateTrade(Long id, Trade trade) {
        Optional<Trade> optionalTrade = tradeRepository.findById(id);
        if (optionalTrade.isPresent()) {
            trade.setId(id);
            return tradeRepository.save(trade);
        }
        return null;
    }

    @Override
    public void deleteTrade(Long id) {
        tradeRepository.deleteById(id);
    }
}