/**
 * Created by Think on 2017/8/3.
 */

package hello.service;

import hello.domain.User;
import hello.domain.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CrudService {

    private final UserRepository userRepository;

    @Autowired
    public CrudService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional
    public void InitUsers()
    {
        userRepository.deleteAll();

        userRepository.save(new User("张三", "zhangsan@126.com"));

        userRepository.save(new User("李四", "lisi@126.com"));
    }
}
