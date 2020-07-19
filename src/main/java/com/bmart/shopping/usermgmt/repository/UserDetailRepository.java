package com.bmart.shopping.usermgmt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bmart.shopping.usermgmt.model.UserDetails;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetails, Long> {

	//@Query("from UserDetails where lower(status)=lower(:status) order by userId desc")
	//public List<UserDetails> getUsersByStatus(@Param("status") String status);
}
