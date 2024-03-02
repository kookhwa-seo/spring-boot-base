package com.springboot.repository;

import com.springboot.domain.CreditCard;
import com.springboot.domain.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
@Slf4j
@RequiredArgsConstructor
public class H2DataLoader implements ApplicationRunner {
    private final UserRepository userRepository;
    private final CreditCardRepository creditCardRepository;

    public void run(ApplicationArguments args) {
        User user = User.builder()
                        .userId(UUID.randomUUID())
                        .name("test")
                        .build();
        user = userRepository.save(user);

        for(int i=0; i<100000; i++){
            CreditCard card = CreditCard.builder()
                                        .cardName("card"+i)
                                        .owner(user)
                                        .build();
            creditCardRepository.save(card);
        }
        creditCardRepository.findAll();
    }
}
