package com.xiaoniucr.rowmapper;

import org.springframework.jdbc.core.RowMapper;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mr.Yang
 * @create 2019/07/27 17:41
 * @copyright www.xiaoniucr.com
 */
public class BaseRowMapper<T> implements RowMapper<T> {

    private Class<? extends Object> targetClazz;
    private Map<String, Field> fieldMap;

    public BaseRowMapper(Class<? extends Object> targetClazz){
        this.targetClazz = targetClazz;
        fieldMap = new HashMap<>();
        for (Field field : targetClazz.getDeclaredFields()){
            fieldMap.put(field.getName(),field);
        }
    }

    @Override
    public T mapRow(ResultSet rs, int index) throws SQLException {

        T obj = null;
        try {
            obj = (T) targetClazz.newInstance();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnLength = metaData.getColumnCount();
            String columnName = null;
            for(int i = 0; i <=  columnLength; i++){
                columnName = metaData.getColumnName(i);
                Field field = fieldMap.get(columnName);
                Class fieldClazz = field.getType();
                field.setAccessible(true);
                if (fieldClazz == int.class || fieldClazz == Integer.class) {
                    field.set(obj, rs.getInt(columnName));
                } else if (fieldClazz == boolean.class || fieldClazz == Boolean.class) {
                    field.set(obj, rs.getBoolean(columnName));
                } else if (fieldClazz == String.class) {
                    field.set(obj, rs.getString(columnName));
                } else if (fieldClazz == float.class || fieldClazz == Float.class) {
                    field.set(obj, rs.getFloat(columnName));
                } else if (fieldClazz == double.class || fieldClazz == Double.class) {
                    field.set(obj, rs.getDouble(columnName));
                } else if (fieldClazz == BigDecimal.class) {
                    field.set(obj, rs.getBigDecimal(columnName));
                } else if (fieldClazz == short.class || fieldClazz == Short.class) {
                    field.set(obj, rs.getShort(columnName));
                } else if (fieldClazz == Date.class) {
                    field.set(obj, rs.getDate(columnName));
                } else if (fieldClazz == Timestamp.class) {
                    field.set(obj, rs.getTimestamp(columnName));
                } else if (fieldClazz == Long.class || fieldClazz == long.class) {
                    field.set(obj, rs.getLong(columnName));
                }
                field.setAccessible(false);
            }
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }
}
