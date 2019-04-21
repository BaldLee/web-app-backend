package sjtu.webapplication.ebook;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Controller
@Configuration
@SpringBootApplication
public class EbookApplication {
    public static void main(String[] args) {
        SpringApplication.run(EbookApplication.class, args);
    }
}
