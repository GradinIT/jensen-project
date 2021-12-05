package se.jensen.project.common.dao;

public class EntityAlreadyInStorageException extends RuntimeException {
    public EntityAlreadyInStorageException(Integer entityId) {
        super(String.format("Entity with id %d already in storage",entityId));
    }
}
