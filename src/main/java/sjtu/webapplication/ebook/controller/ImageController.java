package sjtu.webapplication.ebook.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import sjtu.webapplication.ebook.entity.Book;
import sjtu.webapplication.ebook.service.ImageService;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/ebook/image")
public class ImageController {
    @Autowired
    private ImageService imageService;

    @CrossOrigin
    @GetMapping(value = "/{id}", produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE})
    @ResponseBody
    public byte[] image(@PathVariable String id){
        return imageService.getImageById(id);
    }

    @CrossOrigin
    @PostMapping(value="/upload",consumes = "multipart/form-data")
    @ResponseBody
    public String uploadImage(@RequestParam(value="image")MultipartFile file){
        return imageService.saveImage(file);
    }

//    @CrossOrigin
//    @PostMapping(value="update",consumes = "multipart/form-data")
//    @ResponseBody
//    public  String updateImage(@RequestParam(value="image")MultipartFile file, @RequestParam(value="book")String book){
//        JSONObject jsonObject = JSONObject.parseObject(book);
//        String id = jsonObject.getString("imgId");
//        return imageService.updateImage(id,file);
//    }
}
