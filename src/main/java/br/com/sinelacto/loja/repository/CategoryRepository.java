package br.com.sinelacto.loja.repository;

import br.com.sinelacto.loja.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CategoryRepository extends JpaRepository<Category, Long> {
    @Query("SELECT DISTINCT obj FROM Category obj WHERE "
            + "(LOWER(obj.name) LIKE LOWER(CONCAT('%',:name,'%')) )")
    Page<Category> find(String name, Pageable pageable);

}