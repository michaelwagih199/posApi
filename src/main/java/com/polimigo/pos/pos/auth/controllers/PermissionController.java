package com.polimigo.pos.pos.auth.controllers;

import com.polimigo.pos.pos.auth.models.Permission;
import com.polimigo.pos.pos.auth.service.permision.PermissionService;
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
@RequestMapping("api/auth/permission")
public class PermissionController implements BluePrintController<Permission> {

    @Autowired
    PermissionService permissionService;

    @GetMapping
    @Override
    public ResponseEntity getObject() {
        return new ResponseEntity(permissionService.getAllObject(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Map<String, Permission>> getPages(Integer page, Integer size, String sortBy) {
        return null;
    }

    @GetMapping("/{id}")
    @Override
    public Permission getObjectById(@Positive @PathVariable Long id) {
        return permissionService.findObject(id);
    }

    @PostMapping
    @Override
    public Permission addObject(@RequestBody @Valid Permission object) {
        return permissionService.createObject(object);
    }

    @Override
    public Permission updateObject(Long id, Permission object) {
        return null;
    }

    @DeleteMapping("{id}")
    @Override
    public void deleteObject(@Positive @PathVariable Long id) {
        permissionService.deleteObject(id);
    }

}
