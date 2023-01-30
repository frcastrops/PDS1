package br.com.evasion.src.repository;

import br.com.evasion.src.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.math.BigInteger;
import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, BigInteger> {

   Optional<UserEntity> findUserByUserEmailAndUserPassword(String userEmail, String userPassword);

   Optional<UserEntity> findUserByUserEmail(String userEmail);

}