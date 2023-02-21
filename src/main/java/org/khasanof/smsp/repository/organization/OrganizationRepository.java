package org.khasanof.smsp.repository.organization;

import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.repository.BaseRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 2:58 PM
 * <br/>
 * Package: org.khasanof.smsp.repository.organization
 */
@Repository
public interface OrganizationRepository extends JpaRepository<OrganizationEntity, Integer>, BaseRepository {

    boolean existsByEmail(String email);

}
