package sjtu.webapplication.ebook.daoimpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;
import sjtu.webapplication.ebook.dao.ImageDao;
import sjtu.webapplication.ebook.entity.UploadFile;

@Repository
public class ImageDaoImpl implements ImageDao {
    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public UploadFile save(UploadFile uploadFile){
        return mongoTemplate.save(uploadFile);
    }

    @Override
    public UploadFile findById(String id){
        return mongoTemplate.findById(id,UploadFile.class);
    }
}
