package com.truskappka.truskappka_backend.config.minio;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "minio")
public class MinioProperties {

    private String url;
    private String accessKey;
    private String secretKey;
    private String bucket;
    private String publicUrl;
}