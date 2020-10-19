package com.bmart.shopping.usermgmt.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bmart.shopping.usermgmt.model.BmartUser;

@Repository
public interface UserRepository extends JpaRepository<BmartUser, Long> {
    BmartUser findByUsername(String username);
}