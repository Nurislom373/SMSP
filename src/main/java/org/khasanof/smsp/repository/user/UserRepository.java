package org.khasanof.smsp.repository.user;

import org.khasanof.smsp.entity.auth_user.AuthUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/23/2023
 * <br/>
 * Time: 10:26 AM
 * <br/>
 * Package: org.khasanof.smsp.repository.user
 */
@Repository
public interface UserRepository extends JpaRepository<AuthUserEntity, Integer> {
}
