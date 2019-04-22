package sjtu.webapplication.ebook.bookInfo;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;

public class BookInfoGet {

    public BookInfoGet(){}

    public ArrayList<Book> getBookIfo(){
        ArrayList<Book> result = new ArrayList<Book>();

        Book sample = new Book();
        sample.setId(1);
        sample.setName("sample-name");
        sample.setAuther("sample-author");
        sample.setImgsrc("sample-imgsrc");
        sample.setIsbn("sample-isbn");

        result.add(sample);

        return result;
    }

    public String get(){
        ArrayList<Book> result = this.getBookIfo();
        String output = JSON.toJSONString(result);
        return output;
    }
}
