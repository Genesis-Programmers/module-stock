package com.dxc.modulestock.dto;

import lombok.Data;

@Data
public class StockDto {

    private Long productId;
    private Integer quantity;
    private Boolean status;
}
