package shavkatjon.hotnews.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shavkatjon.hotnews.entity.Role;

import java.util.UUID;

public interface RoleRepository extends JpaRepository<Role, UUID> {
}
