package com.polimigo.pos.pos.auth.service.userLogs;

import com.polimigo.pos.pos.auth.models.UserLogsType;
import com.polimigo.pos.pos.auth.models.UsersLogs;
import org.springframework.data.domain.Page;

/**
 * @author michael wagih
 */
public interface UserLogsService {
    UsersLogs createLoginLogs(UsersLogs usersLogs, Long logTypesId, String userName);

    Page<UsersLogs> getActiveUserLogs(Integer page, Integer size, String sortBy);

    Page<UsersLogs> getLogsByUser(Integer page, Integer size, String sortBy, Long userId);

    Page<UsersLogs> getLogsByType(Integer page, Integer size, String sortBy, Long typeId);

    Iterable<UserLogsType> getAllType();
}
