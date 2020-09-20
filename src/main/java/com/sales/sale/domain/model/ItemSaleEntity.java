package com.sales.sale.domain.model;

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "ITEM_SALE")
public class ItemSaleEntity {

    @Id
    @Column(name = "ID_ITEM_SALE")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "PRODUCT_CODE")
    private String code;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "VALUE")
    private BigDecimal value;

    @Column(name = "QUANTITY")
    private BigDecimal quantity;

    @ManyToOne
    @JoinColumn(name = "ID_SALE")
    private SaleEntity sale;

}
