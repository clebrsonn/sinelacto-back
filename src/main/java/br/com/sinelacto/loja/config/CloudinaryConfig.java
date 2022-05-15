package br.com.sinelacto.loja.config;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class CloudinaryConfig {
    @Value("${cloudnary.cloud_name}")
    private String name;

    @Value("${cloudnary.api_key}")
    private String key;

    @Value("${cloudnary.api_secret}")
    private String secret;

    @Bean
    public Cloudinary client(){
        return new Cloudinary(ObjectUtils.asMap(
                "cloud_name", name,
                "api_key", key,
                "api_secret",secret));
    }

}
