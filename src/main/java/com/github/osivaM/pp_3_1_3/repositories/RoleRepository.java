package com.github.osivaM.pp_3_1_3.repositories;

import com.github.osivaM.pp_3_1_3.models.Role;
import org.springframework.data.repository.ListCrudRepository;

import java.util.Optional;

public interface RoleRepository extends ListCrudRepository<Role, Long> {

    Optional<Role> getRoleByRole(String role);

}
