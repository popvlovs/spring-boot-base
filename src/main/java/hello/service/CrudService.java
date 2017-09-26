/**
 * Created by Think on 2017/8/3.
 */

package hello.service;

import hello.domain.UserEntity;
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
    public void addUsers()
    {
        userRepository.deleteAll();

        UserEntity user1 = new UserEntity();
        user1.setName("张三");
        user1.setEmail("z3.com");
        userRepository.save(user1);

        UserEntity user2 = new UserEntity();
        user1.setName("李四");
        user1.setEmail("l4.com");
        userRepository.save(user2);
    }
}
