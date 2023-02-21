package org.khasanof.smsp.data;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.khasanof.smsp.entity.BaseEntity;
import org.khasanof.smsp.repository.BaseRepository;
import org.springframework.boot.CommandLineRunner;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 3:27 PM
 * <br/>
 * Package: org.khasanof.smsp.data
 */
@RequiredArgsConstructor
public abstract class AbstractData<R extends BaseRepository, E extends BaseEntity> implements CommandLineRunner {

    protected final R repository;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public List<E> getEntities(String path) {
        TypeReference<List<E>> reference = new TypeReference<>() {};

        try (InputStream resourceAsStream = getClass().getResourceAsStream(path)) {
            return objectMapper.readValue(resourceAsStream, reference);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
