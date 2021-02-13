package com.polimigo.pos.pos.bluPrint;

import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface BluePrintController<Object> {
    public abstract ResponseEntity getObject();
    public abstract ResponseEntity<Map<String, Object>> getPages(Integer page, Integer size, String sortBy);
    public abstract Object getObjectById( Long id);
    public abstract Object addObject( Object object);
    public abstract Object updateObject(Long id, Object object);
    public abstract void deleteObject( Long id);

}
