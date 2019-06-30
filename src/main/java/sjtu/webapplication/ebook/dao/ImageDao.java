package sjtu.webapplication.ebook.dao;

import org.springframework.web.multipart.MultipartFile;
import sjtu.webapplication.ebook.entity.UploadFile;

public interface ImageDao {
    UploadFile save(UploadFile uploadFile);
    UploadFile findById(String id);
}
