package com.github.osivaM.pp_3_1_3.services;

import com.github.osivaM.pp_3_1_3.models.Role;

import java.util.List;

public interface RoleService {

    Role getRoleById(Long id);

    Role getRoleByRole(String role);

    List<Role> getAllRoles();

    void createRole(Role role);

    void updateRole(Role role);

    void deleteRole(Long id);

}
