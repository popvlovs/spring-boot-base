/**
 * Created by Think on 2017/8/1.
 */
package hello.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

// 增加授权验证
@Secured("hasRole('ADMIN')")
// 没有定义的话就会使用userEntity作为path
@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    //@Query("select u from user u where u.email = ?1")
    List<UserEntity> findByEmail(@Param("email") String email);

    // 需要使用@Param做rest的参数映射
    List<UserEntity> findByNameAndEmail(@Param("name") String name, @Param("email")String email);

    List<UserEntity> findByName(@Param("name")String name);

    @Override
    @Secured("hasRole('ADMIN')")
    UserEntity save(UserEntity entities);

    @Override
    @Secured("hasRole('ADMIN')")
    void delete(Long aLong);

    @Override
    @Secured("hasRole('ROLE_ADMIN')")
    UserEntity findOne(Long aLong);
}