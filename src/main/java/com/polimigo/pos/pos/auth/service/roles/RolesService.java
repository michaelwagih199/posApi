package com.polimigo.pos.pos.auth.service.roles;


import com.polimigo.pos.pos.auth.models.Permission;
import com.polimigo.pos.pos.auth.models.Role;
import com.polimigo.pos.pos.auth.payload.request.RolesRequest;
import com.polimigo.pos.pos.bluPrint.BluePrintService;

import java.util.List;
import java.util.Set;

public interface RolesService extends BluePrintService<Role> {
    public Role createRoles(RolesRequest rolesRequest);
    List<Set<Permission>> getRolePermissions(Long roleId);
}
