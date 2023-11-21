package com.bal.asha.nurture.server.common.util;

import com.bal.asha.nurture.server.common.exception.NurtureServerException;
import jakarta.persistence.EmbeddedId;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Optional;

@Slf4j
public class ProjectionUtil {

    public static <T, R> R map(T object, Class<R> clazz) {
        try {
            Constructor<R> constructor = clazz.getDeclaredConstructor();
            R r = constructor.newInstance();
            BeanUtils.copyProperties(r, object);
            Optional<T> primaryKeyValue = getPrimaryKeyValue(object);
            if (primaryKeyValue.isPresent()) {
                BeanUtils.copyProperties(r, primaryKeyValue.get());
            }
            return r;
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException |
                 InvocationTargetException e) {
            log.error("Error occurred while mapping object to given clazz ", e);
            throw new NurtureServerException("Error occurred while mapping object to given class ", e);
        }
    }

    private static <T> Optional<T> getPrimaryKeyValue(T entity) throws IllegalAccessException {
        Field[] fields = entity.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(EmbeddedId.class)) {
                field.setAccessible(true);
                return Optional.of((T) field.get(entity));
            }
        }
        return Optional.empty();
    }
}
