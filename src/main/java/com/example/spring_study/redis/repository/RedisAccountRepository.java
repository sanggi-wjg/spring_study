package com.example.spring_study.redis.repository;

import com.example.spring_study.redis.vo.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisAccountRepository extends CrudRepository<Account, String> {

}
