package com.db.rep;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.db.model.Quote;

@Repository
public interface QuoteRep extends JpaRepository<Quote,Integer> {

	@Query("select c from Quote c where c.username=:username")
	List<Quote> findByUserName(@Param("username") String username);

	//void deleteUser(List<Quote> quotes);
	
	
	//@Query("select c from UserManagement c where c.city=:city")
	//UserManagement findByCity(@Param("city") String city);


}
