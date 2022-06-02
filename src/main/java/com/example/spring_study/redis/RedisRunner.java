package com.example.spring_study.redis;

import com.example.spring_study.redis.vo.Account;
import com.example.spring_study.redis.repository.RedisAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class RedisRunner implements ApplicationRunner {

    @Autowired
    StringRedisTemplate redisTemplate;

    @Autowired
    RedisAccountRepository redisAccountRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ValueOperations<String, String> values = redisTemplate.opsForValue();
        values.set("hello", "world");
        values.set("spring", "boot");

        Account account = new Account();
        account.setEmail("test@kr.com");
        account.setUsername("Snow");
        redisAccountRepository.save(account);


        Optional<Account> findAccount = redisAccountRepository.findById(account.getId());

        System.out.println("=================================================================");
        System.out.println("[Redis]");
        System.out.println(findAccount.get().getEmail());
        System.out.println(findAccount.get().getUsername());
        System.out.println("=================================================================");
    }
}
