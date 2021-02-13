package com.polimigo.pos.pos.auth.controllers;
import com.polimigo.pos.pos.auth.models.Role;
import com.polimigo.pos.pos.auth.payload.request.RolesRequest;
import com.polimigo.pos.pos.auth.service.roles.RolesService;
import com.polimigo.pos.pos.bluPrint.BluePrintController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.Map;

/**
 * @author michael wagih
 */

@RestController
@RequestMapping("api/auth/roles")
public class RolesController implements BluePrintController<Role> {

    @Autowired
    RolesService rolesService;

    @GetMapping
    @Override
    public ResponseEntity getObject() {
        return new ResponseEntity(rolesService.getAllObject(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Role>> getPages(Integer page, Integer size, String sortBy) {
        return null;
    }

    @GetMapping("{id}")
    @Override
    public Role getObjectById(@PathVariable @Positive Long id) {
        return rolesService.findObject(id);
    }

    @GetMapping("rolePermissions/{roleId}")
    public ResponseEntity getRolePermissions(@Positive @PathVariable Long roleId){
        return new ResponseEntity(rolesService.getRolePermissions(roleId).get(0), HttpStatus.OK);
    }

    @Override
    public Role addObject(@RequestBody Role object) {
        return rolesService.createObject(object);
    }

    @Override
    public Role updateObject(Long id, Role object) {
        return null;
    }


    @DeleteMapping("{id}")
    @Override
    public void deleteObject(@Positive @PathVariable Long id) {
        rolesService.deleteObject(id);
    }


    @PostMapping
    public Role createRoles(@Valid @RequestBody RolesRequest role){
        return rolesService.createRoles(role);
    }

}
