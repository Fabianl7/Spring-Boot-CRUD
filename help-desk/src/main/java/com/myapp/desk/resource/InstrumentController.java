package com.myapp.desk.resource;

import com.myapp.desk.domain.Instrument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.myapp.desk.service.InstrumentService;

import java.util.List;

@RestController
@RequestMapping("/api/instruments")
public class InstrumentController {

    @Autowired
    private InstrumentService instrumentService;

    @PostMapping
    public Instrument createInstrument(@RequestBody Instrument instrument) {
        return instrumentService.createInstrument(instrument);
    }

    @GetMapping("/{id}")
    public Instrument getInstrumentById(@PathVariable Long id) {
        return instrumentService.getInstrumentById(id);
    }

    @GetMapping
    public List<Instrument> getAllInstruments() {
        return instrumentService.getAllInstruments();
    }

    @PutMapping("/{id}")
    public Instrument updateInstrument(@PathVariable Long id, @RequestBody Instrument instrument) {
        return instrumentService.updateInstrument(id, instrument);
    }

    @DeleteMapping("/{id}")
    public void deleteInstrument(@PathVariable Long id) {
        instrumentService.deleteInstrument(id);
    }
}