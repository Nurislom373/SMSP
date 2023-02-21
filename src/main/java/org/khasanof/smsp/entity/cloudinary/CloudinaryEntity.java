package org.khasanof.smsp.entity.cloudinary;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import org.khasanof.smsp.entity.Auditable;

/**
 * Author: Nurislom
 * <br/>
 * Date: 2/21/2023
 * <br/>
 * Time: 8:36 PM
 * <br/>
 * Package: org.khasanof.smsp.entity.cloudinary
 */
@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cloudinary")
public class CloudinaryEntity extends Auditable {
    @Column(name = "asset_id")
    private String asset_id;
    @Column(name = "public_id")
    private String public_id;
    @Column(name = "version")
    private Integer version;
    @Column(name = "version_id")
    private String version_id;
    @Column(name = "api_key")
    private String api_key;
    @Column(name = "signature")
    private String signature;
    @Column(name = "width")
    private Integer width;
    @Column(name = "height")
    private Integer height;
    @Column(name = "format")
    private String format;
    @Column(name = "overwritten")
    private Boolean overwritten;
    @Column(name = "original_extension")
    private String original_extension;
    @Column(name = "resource_type")
    private String resource_type;
    @Column(name = "tags")
    private String tags;
    @Column(name = "folder")
    private String folder;
    @Column(name = "pages")
    private Integer pages;
    @Column(name = "bytes")
    private Integer bytes;
    @Column(name = "type")
    private String type;
    @Column(name = "etag")
    private String etag;
    @Column(name = "placeholder")
    private boolean placeholder;
    @Column(name = "url")
    private String url;
    @Column(name = "secure_url")
    private String secure_url;
    @Column(name = "access_mode")
    private String access_mode;
    @Column(name = "original_filename")
    private String original_filename;
}
