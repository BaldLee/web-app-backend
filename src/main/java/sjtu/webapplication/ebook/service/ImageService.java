package sjtu.webapplication.ebook.service;

import org.springframework.web.multipart.MultipartFile;

public interface ImageService {
    String saveImage(MultipartFile file);
    byte[] getImageById(String id);
}
