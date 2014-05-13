package me.ruici.upyun.model;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
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

        public static ObjectType fromString(String value) {
            Preconditions.checkNotNull(value);
            for (ObjectType type : ObjectType.values()) {
                if (value.equals(type.value)) {
                    return type;
                }
            }
            return null;
        }
    }

    private Map<String, Object> metadata = Maps.newHashMap();

    private ObjectType type;

    private int size;

    private Date created;

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

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("type", getType())
                .add("size", getSize())
                .add("createdDate", getCreated())
                .toString();

    }
}
