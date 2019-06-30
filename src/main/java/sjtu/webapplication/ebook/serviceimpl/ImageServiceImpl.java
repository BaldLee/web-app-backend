package sjtu.webapplication.ebook.serviceimpl;

import org.bson.types.Binary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import sjtu.webapplication.ebook.dao.BookDao;
import sjtu.webapplication.ebook.dao.ImageDao;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.entity.UploadFile;
import sjtu.webapplication.ebook.service.ImageService;

import java.io.IOException;

@Service
@Transactional
public class ImageServiceImpl implements ImageService {
    @Autowired
    private ImageDao imageDao;

    @Override
    @Transactional
    public String saveImage(MultipartFile file) {
        if (file.isEmpty())
            return "file is null";

        String result = null;
        String fileName = file.getOriginalFilename();
        try {
            UploadFile uploadFile = new UploadFile();
            uploadFile.setName(fileName);
            uploadFile.setContent(new Binary(file.getBytes()));
            uploadFile.setContentType(file.getContentType());
            uploadFile.setSize(file.getSize());

            String id = imageDao.save(uploadFile).getId();
            result = "upload success, id:" + id;
        } catch (IOException e) {
            e.printStackTrace();
            result = "upload fail";
        }
        return result;
    }

    @Override
    @Transactional
    public byte[] getImageById(String id) {
        byte[] data = null;
        UploadFile file = imageDao.findById(id);
        if (file != null) {
            data = file.getContent().getData();
        }
        return data;
    }

    @Override
    @Transactional
    public String updateImage(String id, MultipartFile file) {
        if (file.isEmpty())
            return "file is null";

        String result = null;
        String fileName = file.getOriginalFilename();
        try{
            UploadFile uploadFile = new UploadFile();
            uploadFile.setId(id);
            uploadFile.setName(fileName);
            uploadFile.setContent(new Binary(file.getBytes()));
            uploadFile.setContentType(file.getContentType());
            uploadFile.setSize(file.getSize());

            imageDao.save(uploadFile);
            result = "update success";
        } catch (IOException e) {
            e.printStackTrace();
            result = "update fail";
        }
        return result;
    }
}
