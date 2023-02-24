package org.khasanof.smsp.data.grade;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.khasanof.smsp.data.AbstractData;
import org.khasanof.smsp.entity.grade.GradeEntity;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.enums.grade.GradeStatus;
import org.khasanof.smsp.repository.grade.GradeRepository;
import org.khasanof.smsp.repository.organization.OrganizationRepository;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/24/2023
 * <br/>
 * Time: 9:13 PM
 * <br/>
 * Package: org.khasanof.smsp.data.grade
 */
//@Component
public class GradeData extends AbstractData<GradeRepository, GradeEntity> {

    private final OrganizationRepository organizationRepository;

    public GradeData(GradeRepository repository, OrganizationRepository organizationRepository) {
        super(repository);
        this.organizationRepository = organizationRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<GradeEntity>> reference = new TypeReference<>() {};

        final List<OrganizationEntity> all = organizationRepository.findAll();

        try (InputStream resourceAsStream = getClass().getResourceAsStream("/data/grade/grade_data.json")) {
            List<GradeEntity> list = objectMapper.readValue(resourceAsStream, reference);

            list.forEach(obj -> {
                obj.setStatus(GradeStatus.findAny());
                obj.setOrganization(all.get(new Random().nextInt(all.size())));
                repository.save(obj);
            });
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
