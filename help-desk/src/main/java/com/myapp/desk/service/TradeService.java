package com.myapp.desk.service;

import com.myapp.desk.domain.Trade;

import java.util.List;

public interface TradeService {
    Trade createTrade(Trade trade);
    Trade getTradeById(Long id);
    List<Trade> getAllTrades();
    Trade updateTrade(Long id, Trade trade);
    void deleteTrade(Long id);
}