package org.khasanof.smsp.dto.cloudinary;

import lombok.*;
import org.khasanof.smsp.dto.GenericDTO;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 8:38 PM
 * <br/>
 * Package: org.khasanof.smsp.dto.cloudinary
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class CloudinaryDetailDTO extends GenericDTO {
    private String asset_id;
    private String public_id;
    private Integer version;
    private String version_id;
    private String api_key;
    private String signature;
    private Integer width;
    private Integer height;
    private String format;
    private Boolean overwritten;
    private String original_extension;
    private String resource_type;
    private String tags;
    private String folder;
    private Integer pages;
    private Integer bytes;
    private String type;
    private String etag;
    private boolean placeholder;
    private String url;
    private String secure_url;
    private String access_mode;
    private String original_filename;
}
