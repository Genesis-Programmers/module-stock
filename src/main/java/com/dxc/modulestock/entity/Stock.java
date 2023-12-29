package com.dxc.modulestock.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Stock {
    @Id
    @GeneratedValue
    private Long id;
    private Long productId;
    private Integer quantity;
    private Boolean status;
    private LocalDateTime createdAt;
    private LocalDateTime lastUpdated;
}
