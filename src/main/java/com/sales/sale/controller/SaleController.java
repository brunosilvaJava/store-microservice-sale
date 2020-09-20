package com.sales.sale.controller;

import java.util.List;

import com.sales.sale.dto.SaleDto;
import com.sales.sale.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaleController {

    private SaleService saleService;

    @Autowired
    public SaleController(SaleService saleService){
        this.saleService = saleService;
    }

    @PostMapping
    public ResponseEntity createSale(@RequestBody SaleDto saleDto){
        saleService.save(saleDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{saleId}")
    public ResponseEntity updateSale(@PathVariable Long saleId, @RequestBody SaleDto saleDto){
        saleService.update(saleDto);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{saleId}")
    public ResponseEntity deleteSale(@PathVariable Long saleId){
        saleService.delete(saleId);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping
    public ResponseEntity<List<SaleDto>> getAllSales(){
        return ResponseEntity.ok(saleService.findAll());
    }

    @GetMapping("/{saleId}")
    public ResponseEntity<SaleDto> findById(@PathVariable Long saleId){
        return ResponseEntity.ok(saleService.findBySaleId(saleId));
    }

}
