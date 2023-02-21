package org.khasanof.smsp.data.organization;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.khasanof.smsp.data.AbstractData;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.enums.organization.OrganizationStatusEnum;
import org.khasanof.smsp.repository.organization.OrganizationRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 3:28 PM
 * <br/>
 * Package: org.khasanof.smsp.data.organization
 */
//@Component
@Slf4j
public class OrganizationData extends AbstractData<OrganizationRepository, OrganizationEntity> {

    public OrganizationData(OrganizationRepository repository) {
        super(repository);
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<OrganizationEntity>> reference = new TypeReference<>() {};

        try (InputStream resourceAsStream = getClass().getResourceAsStream("/data/organization/organization_data.json")) {
            List<OrganizationEntity> list = objectMapper.readValue(resourceAsStream, reference);

            list.forEach(obj -> {
                obj.setLogoPath("https://picsum.photos/200");
                obj.setStatus(OrganizationStatusEnum.findAny());
                repository.save(obj);
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }

    }

    // need to run once!
}
