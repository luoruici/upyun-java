package me.ruici.upyun.model;

import com.google.common.collect.Maps;

import java.util.Date;
import java.util.Map;

public class ObjectMetadata {

    public enum ObjectType {
        FILE("file"), DIR("folder");

        private final String value;

        ObjectType(final String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

    }

    private Map<String, Object> metadata;

    private ObjectType type;

    private int size;

    private Date created;

    public ObjectMetadata() {
        this.metadata = Maps.newHashMap();
    }

    public ObjectType getType() {
        return type;
    }

    public void setType(ObjectType type) {
        this.type = type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
