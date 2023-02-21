package org.khasanof.smsp.repository.cloudinary;

import org.khasanof.smsp.entity.cloudinary.CloudinaryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 8:45 PM
 * <br/>
 * Package: org.khasanof.smsp.repository.cloudinary
 */
@Repository
public interface CloudinaryRepository extends JpaRepository<CloudinaryEntity, Integer> {
}
