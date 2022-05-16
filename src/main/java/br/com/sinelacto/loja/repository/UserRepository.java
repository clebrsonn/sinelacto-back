package br.com.sinelacto.loja.repository;

import br.com.sinelacto.loja.models.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, String> {

    Optional<User> findByEmail(String email);

    @Query("SELECT DISTINCT obj FROM User obj WHERE "
            + "(LOWER(obj.firstName) LIKE LOWER(CONCAT('%',:name,'%')) )")
    Page<User> find(String name, Pageable pageable);

}