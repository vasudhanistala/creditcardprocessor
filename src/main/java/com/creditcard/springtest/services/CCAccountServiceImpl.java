package com.creditcard.springtest.services;

import java.util.List;

import com.creditcard.springtest.beans.CCAccount;
import com.creditcard.springtest.repository.CCAccountsRepository;

import org.springframework.stereotype.Service;

@Service
public class CCAccountServiceImpl implements CCAccountService {
	
    private final CCAccountsRepository ccAccountsRepository;

    public CCAccountServiceImpl(CCAccountsRepository ccAccountsRepository) {
        this.ccAccountsRepository = ccAccountsRepository;
    }

    @Override
    public void add(CCAccount account) {
        ccAccountsRepository.save(account);
    }

    @Override
    public List<CCAccount> findAll() {
       return ccAccountsRepository.findAll();
    }


}
