package com.creditcard.springtest.repository;

import com.creditcard.springtest.beans.CCAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CCAccountsRepository extends JpaRepository<CCAccount,Long> {
}
