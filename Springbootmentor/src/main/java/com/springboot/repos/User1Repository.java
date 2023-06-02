package com.springboot.repos;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.springboot.model.User;
@Repository
public interface User1Repository extends JpaRepository<User, Long>
{

}
