package sjtu.webapplication.ebook.service;

import org.springframework.web.multipart.MultipartFile;
import sjtu.webapplication.ebook.entity.Book;

public interface ImageService {
    String saveImage(MultipartFile file);
    byte[] getImageById(String id);
    String updateImage(String id, MultipartFile file);
}
