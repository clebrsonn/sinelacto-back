package br.com.sinelacto.loja.repository;

import br.com.sinelacto.loja.models.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByAuthority(String authority);
}