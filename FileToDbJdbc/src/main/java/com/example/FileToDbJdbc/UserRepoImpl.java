package com.example.FileToDbJdbc;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepoImpl extends JpaRepository<User, Long>{

}
