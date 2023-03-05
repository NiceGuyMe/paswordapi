package com.project.paswordapi.Repository;


import com.project.paswordapi.Entity.PasswordEntity;
import com.project.paswordapi.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface PasswordRepository extends JpaRepository<PasswordEntity, UUID> {

    List<PasswordEntity> findByUserEntity(UserEntity userEntity);

}
