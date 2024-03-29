package com.swiftrides.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.swiftrides.models.Login;


@Repository
@Transactional
public interface LoginRepository extends JpaRepository<Login, Integer> {
	
	@Query("select l from Login l where login_id= :login_id and password= :password")
	public Optional<Login> getLogin(String login_id,String password);
	
	@Modifying
	@Query("update Login l set l.status=?1 where l.id=?2")
	public int updateStatus(boolean status,int id);
}
