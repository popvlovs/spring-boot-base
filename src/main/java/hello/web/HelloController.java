
/**
 * Created by Think on 2017/8/1.
 */
package hello.web;

import hello.domain.AutoUserEntity;
import hello.domain.AutoUserRepository;
import hello.domain.User;
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
    private AutoUserRepository autoUserRepository;

    @Autowired
    private CrudService initService;

    @GetMapping(path = "/") // Map ONLY GET Requests
    public @ResponseBody
    String index() {

        return "hello world！";
    }

    @GetMapping(path = "/add") // Map ONLY GET Requests
    public @ResponseBody
    String addNewUser(@RequestParam String name
            , @RequestParam String email) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        User n = new User();
        n.setName(name);
        n.setEmail(email);
        userRepository.save(n);
        return "Saved";
    }

    @GetMapping(path = "/all")
    public @ResponseBody
    Iterable<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping(path = "/users")
    public @ResponseBody
    Iterable<AutoUserEntity> getAllAutoUsers() {
        return autoUserRepository.findAll();
    }

    @GetMapping(path = "/find")
    public @ResponseBody
    List<User> getUsers(@RequestParam(required = false) String name,
                        @RequestParam(required = false) String email) {

        if (!StringUtils.isEmpty(name) && !StringUtils.isEmpty(email))
            return userRepository.findByNameAndEmail(name, email);

        if (!StringUtils.isEmpty(name))
            return userRepository.findByName(name);

        if (!StringUtils.isEmpty(email))
            return userRepository.findByEml(email);

        return null;
    }

    @GetMapping(path = "/init")
    public @ResponseBody
    List<User> initUsers() {

        initService.InitUsers();

        return null;
    }
}