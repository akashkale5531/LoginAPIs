package com.login.system.Repository;


import com.login.system.Entity.EntityClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface RepositoryInterface extends JpaRepository<EntityClass, Long> {


    EntityClass findByEmail(String email);


    Optional<EntityClass> findOneByEmailAndPwd(String email, String encodedPassword);

    EntityClass findByMobNo(String mobNo);

    Optional<EntityClass> findOneByMobNoAndPwd(String mobNo, String encodedPwd);

    EntityClass findByMobNoOrEmail(String mobNo, String email);
}
