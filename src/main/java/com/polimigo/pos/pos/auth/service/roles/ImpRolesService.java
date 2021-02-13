package com.polimigo.pos.pos.auth.service.roles;


import com.polimigo.pos.pos.auth.models.Permission;
import com.polimigo.pos.pos.auth.models.Role;
import com.polimigo.pos.pos.auth.payload.request.RolesRequest;
import com.polimigo.pos.pos.auth.repository.PermissionRepository;
import com.polimigo.pos.pos.auth.repository.RoleRepository;
import com.polimigo.pos.pos.auth.repository.UserRepository;
import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ImpRolesService implements RolesService {

    private final RoleRepository rolesRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    PermissionRepository permissionRepository;

    public ImpRolesService(RoleRepository rolesRepository) {
        this.rolesRepository = rolesRepository;
    }

    @Override
    public Role createObject(Role object) {
        return null;
    }

    @Override
    public Role updateObject(Long id, Role object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {
        rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("role id" + id + "not found"));
        rolesRepository.deleteById(id);
    }

    @Override
    public Iterable<Role> getAllObject() {
        return rolesRepository.findAll();
    }

    @Override
    public Role findObject(Long id) {
        return rolesRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("role id" + id + "not found"));
    }

    @Override
    public Page<Role> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }

    @Override
    public Role createRoles(RolesRequest rolesRequest) {
        var permissionList = rolesRequest.getPermissionIdsLongs()
                .stream()
                .map(p -> permissionRepository.findById(p)
                        .orElseThrow(() -> new ResourceNotFoundException("role Id:" + p + "-not found")))
                .collect(Collectors.toSet());
        Role role = new Role();
        role.setName(rolesRequest.getName());
        role.setPermissions(permissionList);
        return rolesRepository.save(role);
    }

    @Override
    public List<Set<Permission>> getRolePermissions(Long roleId) {
        var permission = rolesRepository.findById(roleId).stream()
                .map(role -> role.getPermissions())
                .collect(Collectors.toList());
        return permission;
    }


}
