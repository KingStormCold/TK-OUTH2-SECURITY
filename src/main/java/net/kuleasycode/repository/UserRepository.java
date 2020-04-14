package net.kuleasycode.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.kuleasycode.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, String>{

}
