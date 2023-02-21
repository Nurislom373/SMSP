package org.khasanof.smsp.controller.cloudinary;

import org.khasanof.smsp.service.cloudinary.CloudinaryService;
import org.springframework.stereotype.Controller;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 8:53 PM
 * <br/>
 * Package: org.khasanof.smsp.controller.cloudinary
 */
public class CloudinaryController {

    private final CloudinaryService service;

    public CloudinaryController(CloudinaryService service) {
        this.service = service;
    }
}
