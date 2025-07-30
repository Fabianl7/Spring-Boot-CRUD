package com.myapp.desk.service;

import com.myapp.desk.domain.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import com.myapp.desk.respository.InstrumentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class InstrumentServiceImpl implements InstrumentService {

    @Autowired
    private InstrumentRepository instrumentRepository;

    @Override
    public Instrument createInstrument(Instrument instrument) {
        return instrumentRepository.save(instrument);
    }

    @Override
    @Cacheable(value = "instruments", key = "#id")
    public Instrument getInstrumentById(Long id) {
        return instrumentRepository.findById(id).orElse(null);
    }

    @Override
    public List<Instrument> getAllInstruments() {
        return instrumentRepository.findAll();
    }

    @Override
    public Instrument updateInstrument(Long id, Instrument instrument) {
        Optional<Instrument> optionalInstrument = instrumentRepository.findById(id);
        if (optionalInstrument.isPresent()) {
            instrument.setId(id);
            return instrumentRepository.save(instrument);
        }
        return null;
    }

    @Override
    public void deleteInstrument(Long id) {
        instrumentRepository.deleteById(id);
    }
}