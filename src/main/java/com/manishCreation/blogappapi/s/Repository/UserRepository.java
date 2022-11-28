package com.manishCreation.blogappapi.s.Repository;

import com.manishCreation.blogappapi.s.Modules.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
