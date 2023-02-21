package org.khasanof.smsp.dto.cloudinary;

import lombok.*;
import org.khasanof.smsp.dto.GenericDTO;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 8:39 PM
 * <br/>
 * Package: org.khasanof.smsp.dto.cloudinary
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CloudinaryGetDTO extends GenericDTO {
    private String signature;
    private String format;
    private String resource_type;
    private String secure_url;
    private String url;
    private Integer bytes;
}
