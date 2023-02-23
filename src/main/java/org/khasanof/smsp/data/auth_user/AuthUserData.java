package org.khasanof.smsp.data.auth_user;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.khasanof.smsp.data.AbstractData;
import org.khasanof.smsp.entity.auth_user.AuthUserEntity;
import org.khasanof.smsp.entity.organization.OrganizationEntity;
import org.khasanof.smsp.enums.auth_user.AuthUserRole;
import org.khasanof.smsp.enums.auth_user.AuthUserStatus;
import org.khasanof.smsp.enums.language.LanguageEnum;
import org.khasanof.smsp.repository.organization.OrganizationRepository;
import org.khasanof.smsp.repository.user.AuthUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Random;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/23/2023
 * <br/>
 * Time: 3:26 PM
 * <br/>
 * Package: org.khasanof.smsp.data.auth_user
 */
//@Component
@Slf4j
public class AuthUserData extends AbstractData<AuthUserRepository, AuthUserEntity> {

    private final OrganizationRepository organizationRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthUserData(AuthUserRepository repository, OrganizationRepository organizationRepository, PasswordEncoder passwordEncoder) {
        super(repository);
        this.organizationRepository = organizationRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        TypeReference<List<AuthUserEntity>> reference = new TypeReference<>() {};

        List<OrganizationEntity> all = organizationRepository.findAll();

        try (InputStream resourceAsStream = getClass().getResourceAsStream("/data/auth_user/auth_user_data.json")) {
            List<AuthUserEntity> list = objectMapper.readValue(resourceAsStream, reference);

            list.forEach(obj -> {
                obj.setPassword(passwordEncoder.encode(obj.getPassword()));
                obj.setImagePath("https://picsum.photos/200");
                obj.setOrganization(all.get(new Random().nextInt(all.size())));
                obj.setStatus(AuthUserStatus.findAny());
                obj.setRole(AuthUserRole.findAny());
                obj.setLanguage(LanguageEnum.findAny());
                repository.save(obj);
            });
            log.info(list.size() + " users saved!");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    // need to run once!
}
