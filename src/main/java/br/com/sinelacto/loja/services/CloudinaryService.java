package br.com.sinelacto.loja.services;

import br.com.sinelacto.loja.config.CloudinaryConfig;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

@Service
public class CloudinaryService implements StorageService{
    @Autowired
    private CloudinaryConfig cloudinary;

    @Override
    public void init() {

    }

    @Override
    public URI store(MultipartFile file) {
        try {
            var result = cloudinary.client().uploader().upload(file.getBytes(), ObjectUtils.emptyMap());
            return URI.create((String) result.get("secure_url"));

        }
        catch (IOException e) {
            e.printStackTrace();
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    @Override
    public Stream<Path> loadAll() {
        return null;
    }

    @Override
    public Path load(String filename) {
        return null;
    }

    @Override
    public Resource loadAsResource(String filename) {
        return null;
    }

    @Override
    public void deleteAll() {

    }
}
