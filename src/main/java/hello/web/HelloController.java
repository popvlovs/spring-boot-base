
/**
 * Created by Think on 2017/8/1.
 */
package hello.web;

import hello.domain.UserEntity;
import hello.domain.UserRepository;
import hello.service.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping(path = "/demo")
public class HelloController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CrudService initService;

    @GetMapping(path = "/") // Map ONLY GET Requests
    public @ResponseBody
    String index() {
        return "hello world！";
    }
}