package com.dxc.modulestock.dto;

import com.dxc.modulestock.common.Product;
import com.dxc.modulestock.entity.Stock;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockResponse {

    private Stock stock;
    private Product product;
}
