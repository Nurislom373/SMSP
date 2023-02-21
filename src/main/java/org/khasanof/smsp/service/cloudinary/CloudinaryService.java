package org.khasanof.smsp.service.cloudinary;

import org.khasanof.smsp.dto.cloudinary.CloudinaryDetailDTO;
import org.khasanof.smsp.dto.cloudinary.CloudinaryGetDTO;
import org.khasanof.smsp.entity.cloudinary.CloudinaryEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 8:40 PM
 * <br/>
 * Package: org.khasanof.smsp.service.cloudinary
 */
public interface CloudinaryService {

    CloudinaryGetDTO upload(MultipartFile file);

    List<CloudinaryGetDTO> multiUpload(MultipartFile[] files);

    String save(MultipartFile file);

    CloudinaryGetDTO get(Integer id);

    CloudinaryDetailDTO detail(Integer id);

    void delete(Integer id);

    void delete(CloudinaryEntity entity);

    List<CloudinaryGetDTO> getMultiGet(List<Integer> ids);

}
