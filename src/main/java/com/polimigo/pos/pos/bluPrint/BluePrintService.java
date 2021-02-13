package com.polimigo.pos.pos.bluPrint;

import org.springframework.data.domain.Page;

public interface BluePrintService<Object> {
    public abstract Object createObject(Object object);
    public abstract Object updateObject(Long id, Object object);
    public abstract void deleteObject(Long id);
    public abstract Iterable<Object> getAllObject();
    public abstract Object findObject(Long id);
    public abstract Page<Object> getPages(Integer pageNo, Integer pageSize, String sortBy);
}
