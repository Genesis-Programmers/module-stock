package com.dxc.modulestock.controller;

import com.dxc.modulestock.dto.StockDto;
import com.dxc.modulestock.dto.StockResponse;
import com.dxc.modulestock.entity.Stock;
import com.dxc.modulestock.service.StockService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping("/api/v1/stocks")
@AllArgsConstructor
public class StockController {

    private StockService service;

    @PostMapping
    public Stock add(@RequestBody StockDto stockDto) {
        return service.add(stockDto);
    }

    @GetMapping("/{id}")
    public StockResponse findByid(@PathVariable  Long id) {
        return service.findById(id);
    }
}
