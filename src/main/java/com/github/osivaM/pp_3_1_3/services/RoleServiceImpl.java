package com.github.osivaM.pp_3_1_3.services;

import com.github.osivaM.pp_3_1_3.models.Role;
import com.github.osivaM.pp_3_1_3.repositories.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Autowired
    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role getRoleById(Long id) {
        return roleRepository.findById(id).get();
    }

    @Override
    public Role getRoleByRole(String role) {
        return roleRepository.getRoleByRole(role).get();
    }

    @Override
    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    @Transactional
    public void createRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void updateRole(Role role) {
        roleRepository.save(role);
    }

    @Override
    @Transactional
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
    }

}
