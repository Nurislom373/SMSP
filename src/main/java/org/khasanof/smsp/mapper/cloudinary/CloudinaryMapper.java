package org.khasanof.smsp.mapper.cloudinary;

import org.khasanof.smsp.dto.cloudinary.CloudinaryGetDTO;
import org.khasanof.smsp.dto.cloudinary.CloudinaryDetailDTO;
import org.khasanof.smsp.entity.cloudinary.CloudinaryEntity;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 8:47 PM
 * <br/>
 * Package: org.khasanof.smsp.mapper.cloudinary
 */
@Component
@Mapper(componentModel = "spring")
public interface CloudinaryMapper {

    CloudinaryGetDTO getDTO(CloudinaryEntity entity);

    CloudinaryDetailDTO detailDTO(CloudinaryEntity entity);

    List<CloudinaryGetDTO> getListDTO(List<CloudinaryEntity> entities);
}
