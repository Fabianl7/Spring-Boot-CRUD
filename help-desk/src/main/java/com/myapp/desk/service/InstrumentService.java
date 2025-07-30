package com.myapp.desk.service;

import com.myapp.desk.domain.Instrument;

import java.util.List;

public interface InstrumentService {
    Instrument createInstrument(Instrument instrument);
    Instrument getInstrumentById(Long id);
    List<Instrument> getAllInstruments();
    Instrument updateInstrument(Long id, Instrument instrument);
    void deleteInstrument(Long id);
}