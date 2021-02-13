package com.polimigo.pos.pos.auth.service.permision;
import com.polimigo.pos.pos.auth.models.Permission;
import com.polimigo.pos.pos.auth.repository.PermissionRepository;
import com.polimigo.pos.pos.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;


@Service
public class ImpPermisionCodes implements PermissionService {

    private final PermissionRepository permissionRepository;


    public ImpPermisionCodes(PermissionRepository permisionCodeRepository) {
        this.permissionRepository = permisionCodeRepository;
    }

    @Override
    public Permission createObject(Permission object) {
        return permissionRepository.save(object);
    }

    @Override
    public Permission updateObject(Long id, Permission object) {
        return null;
    }

    @Override
    public void deleteObject(Long id) {
        permissionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("permission id" + id + "not found"));
        permissionRepository.deleteById(id);
    }

    @Override
    public Iterable<Permission> getAllObject() {
        return permissionRepository.findAll();
    }

    @Override
    public Permission findObject(Long id) {
        return permissionRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("permission id" + id + "not found"));

    }

    @Override
    public Page<Permission> getPages(Integer pageNo, Integer pageSize, String sortBy) {
        return null;
    }

}
