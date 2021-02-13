package com.polimigo.pos.pos.auth.repository;


import com.polimigo.pos.pos.auth.models.Permission;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission,Long> {

}
