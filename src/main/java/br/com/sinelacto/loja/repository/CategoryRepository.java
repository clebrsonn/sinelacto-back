package br.com.sinelacto.loja.repository;

import br.com.sinelacto.loja.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {
}