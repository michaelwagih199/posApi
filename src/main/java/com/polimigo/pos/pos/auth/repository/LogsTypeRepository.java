package com.polimigo.pos.pos.auth.repository;

import com.polimigo.pos.pos.auth.models.UserLogsType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author michael wagih
 */
public interface LogsTypeRepository extends CrudRepository<UserLogsType,Long> {
}
