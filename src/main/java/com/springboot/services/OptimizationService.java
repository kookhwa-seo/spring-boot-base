package com.springboot.services;

import com.springboot.domain.CreditCard;
import com.springboot.repository.CreditCardRepository;
import com.springboot.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptimizationService {
    private final CreditCardRepository creditCardRepository;

    public List<CreditCard> findAllWithCoveringIndex(){
        return creditCardRepository.findAllWithCoveringIndex();
    }

    public List<CreditCard> findTop2ByOrderByIdAsc(){
        return creditCardRepository.findTop2ByOrderByIdAsc();
    }
}
