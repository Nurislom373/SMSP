package org.khasanof.smsp.service.cloudinary;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 8:41 PM
 * <br/>
 * Package: org.khasanof.smsp.service.cloudinary
 */
@Service
public class LocalFileService {

    private ConcurrentHashMap<String, Boolean> concurrentFiles = new ConcurrentHashMap<>();

    public static final String PATH_HTML = "src/main/resources/uploads/";

    public String writeFile(MultipartFile file) {
        try {
            String org_name = file.getOriginalFilename();
            String extension = StringUtils.getFilenameExtension(org_name);
            String generatedName = System.currentTimeMillis() + "." + extension;
            Files.copy(file.getInputStream(), Paths.get(PATH_HTML, generatedName), StandardCopyOption.REPLACE_EXISTING);
            return PATH_HTML + generatedName;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void addConcurrent(String asset_id) {
        concurrentFiles.put(asset_id, false);
    }

    public void updateConcurrent(String asset_id, Boolean value) {
        concurrentFiles.put(asset_id, value);
    }

    @Scheduled(fixedDelay = 30000)
    public void deleteFiles() {
        concurrentFiles.keys().asIterator().forEachRemaining((key) -> {
            if (concurrentFiles.get(key)) {
                concurrentFiles.remove(key);
                if (new File(key).delete()) {
                    System.out.println("File is successfully deleted with - " + Thread.currentThread().getName());
                } else {
                    System.out.println("File doesn't exit");
                }
            }
        });
    }
}
