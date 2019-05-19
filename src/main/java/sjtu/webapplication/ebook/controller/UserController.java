package sjtu.webapplication.ebook.controller;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import sjtu.webapplication.ebook.entity.User;
import sjtu.webapplication.ebook.service.UserService;

@RestController
@RequestMapping("/ebook/users")
public class UserController {
    @Autowired
    private UserService userService;

    @CrossOrigin
    @RequestMapping(value = "/getall", method = RequestMethod.POST, consumes = "application/json")
    public String usersGetAll() {
        return userService.getAll();
    }

    @CrossOrigin
    @RequestMapping(value = "/check", method = RequestMethod.POST, consumes = "application/json")
    public String userCheck(@RequestBody User user) {
        String username = user.getUsername();
        String password = user.getPassword();
        int result = userService.logincheck(username, password);
        return JSON.toJSONString(result);
    }

    @CrossOrigin
    @RequestMapping(value = "/update", method = RequestMethod.POST, consumes = "application/json")
    public String usersUpdate(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @CrossOrigin
    @RequestMapping(value = "/delete", method = RequestMethod.POST, consumes = "application/json")
    public String usersDelete(@RequestBody User user) {
        userService.deleteUser(user);
        return "user delete done";
    }

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST, consumes = "application/json")
    public String usersAdd(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
