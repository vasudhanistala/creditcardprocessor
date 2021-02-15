package com.creditcard.springtest.services;

import java.util.List;

import com.creditcard.springtest.beans.CCAccount;

public interface CCAccountService {

    void add(CCAccount account);

    List<CCAccount> findAll();
    
}
