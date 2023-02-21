package org.khasanof.smsp.service.cloudinary;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import org.khasanof.smsp.dto.cloudinary.CloudinaryDetailDTO;
import org.khasanof.smsp.dto.cloudinary.CloudinaryGetDTO;
import org.khasanof.smsp.entity.cloudinary.CloudinaryEntity;
import org.khasanof.smsp.exception.exceptions.NotFoundException;
import org.khasanof.smsp.mapper.cloudinary.CloudinaryMapper;
import org.khasanof.smsp.repository.cloudinary.CloudinaryRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 8:45 PM
 * <br/>
 * Package: org.khasanof.smsp.service.cloudinary
 */
@Service
public class SimpleCloudinaryService implements CloudinaryService {

    private final CloudinaryRepository cloudinaryRepository;
    private final LocalFileService localFileService;
    private final Cloudinary cloudinary;
    private final CloudinaryMapper cloudinaryMapper;

    public SimpleCloudinaryService(CloudinaryRepository couldinaryRepository, LocalFileService localFileService, CloudinaryMapper cloudinaryMapper) {
        this.cloudinaryRepository = couldinaryRepository;
        this.localFileService = localFileService;
        this.cloudinaryMapper = cloudinaryMapper;
        this.cloudinary = new Cloudinary(ObjectUtils.asMap(
                "cloud_name", "dtkrdcbhi",
                "api_key", "723978565627878",
                "api_secret", "8j21viAfIolIivwVxeum9endXYg"));
    }

    @Override
    public CloudinaryGetDTO upload(MultipartFile file) {
        Assert.notNull(file, "file must be not null required!");
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            ObjectNode objectNode = objectMapper.createObjectNode();

            String path = localFileService.writeFile(file);
            var public_id = cloudinary.uploader().upload(
                    new File(path),
                    ObjectUtils.asMap("public_id",
                            file.getOriginalFilename()));

            for (Object o : public_id.keySet()) {
                if (!String.valueOf(o).equals("created_at"))
                    objectNode.put(String.valueOf(o), String.valueOf(public_id.get(o.toString())));
            }

            localFileService.addConcurrent(path);
            CloudinaryEntity entity = objectMapper.readValue(objectNode.toString().getBytes(), CloudinaryEntity.class);
            localFileService.updateConcurrent(path, true);
            return cloudinaryMapper.getDTO(cloudinaryRepository.save(entity));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String save(MultipartFile file) {
        String fileName = localFileService.writeFile(file);
        return LocalFileService.PATH_HTML + fileName;
    }

    @Override
    public List<CloudinaryGetDTO> multiUpload(MultipartFile[] files) {
        return Arrays.stream(files)
                .map(this::upload)
                .toList();
    }

    @Override
    public CloudinaryGetDTO get(Integer id) {
        Assert.notNull(id, "id must be not null required!");
        return cloudinaryMapper.getDTO(
                cloudinaryRepository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("File not found");
                        }));
    }

    @Override
    public CloudinaryDetailDTO detail(Integer id) {
        Assert.notNull(id, "id must be not null required!");
        return cloudinaryMapper.detailDTO(
                cloudinaryRepository.findById(id)
                        .orElseThrow(() -> {
                            throw new NotFoundException("File not found");
                        }));
    }

    @Override
    public void delete(Integer id) {
        Assert.notNull(id, "id must be not null required!");
        if (cloudinaryRepository.existsById(id))
            cloudinaryRepository.deleteById(id);
        else
            throw new NotFoundException("Cloudinary not found");
    }

    @Override
    public void delete(CloudinaryEntity entity) {
        Assert.notNull(entity, "entity must be not null required!");
        if (cloudinaryRepository.existsById(entity.getId())) {
            cloudinaryRepository.delete(entity);
        } else {
            throw new NotFoundException("Cloudinary not found");
        }
    }

    @Override
    public List<CloudinaryGetDTO> getMultiGet(List<Integer> ids) {
        return ids.stream()
                .map(this::get)
                .toList();
    }
}
