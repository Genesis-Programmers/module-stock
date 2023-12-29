package com.dxc.modulestock.service;

import com.dxc.modulestock.common.Product;
import com.dxc.modulestock.dto.StockDto;
import com.dxc.modulestock.dto.StockResponse;
import com.dxc.modulestock.entity.Stock;
import com.dxc.modulestock.repository.StockRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.time.LocalDateTime;

@Service
@AllArgsConstructor
public class StockService {

    private StockRepository repository;
    private RestTemplate restTemplate;

    public Stock add(StockDto stockDto) {
        Stock stock = Stock.builder()
                .productId(stockDto.getProductId())
                .quantity(stockDto.getQuantity())
                .status(stockDto.getStatus())
                .createdAt(LocalDateTime.now())
                .lastUpdated(LocalDateTime.now())
                .build();

        return repository.save(stock);
    }

    public StockResponse findById(Long id) {
        Stock stock = repository.findById(id).orElseThrow();

        String URL = "http://MODULE-PRODUCT/api/v1/products/" + stock.getProductId();
        ResponseEntity<Product> product = restTemplate.getForEntity(URL, Product.class);

        return StockResponse.builder()
                .stock(stock)
                .product(product.getBody())
                .build();
    }
}
