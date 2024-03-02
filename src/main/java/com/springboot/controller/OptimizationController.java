package com.springboot.controller;

import com.springboot.domain.CreditCard;
import com.springboot.services.OptimizationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/optimization")
public class OptimizationController {
    private final OptimizationService optimizationService;

    @GetMapping("")
    public ResponseEntity<List<CreditCard>> findTop2ByOrderByIdAsc() {
        return ResponseEntity.ok(optimizationService.findTop2ByOrderByIdAsc());
    }

    @GetMapping("/covering")
    public ResponseEntity<List<CreditCard>> findAllWithCoveringIndex() {
        return ResponseEntity.ok(optimizationService.findAllWithCoveringIndex());
    }

}
