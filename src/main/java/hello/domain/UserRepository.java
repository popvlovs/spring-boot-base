/**
 * Created by Think on 2017/8/1.
 */
package hello.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    @Query("select u from User u where u.email = ?1")
    List<User> findByEml(String email);

    List<User> findByNameAndEmail(String name, String email);

    List<User> findByName(String name);
}