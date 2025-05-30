package com.ali.mobisecenhance.ld.util;

import com.ali.mobisecenhance.ld.RecordLog;
import com.j2c.enhance.SoLoad992979061;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ReflectUtil {
    private static final String TAG;
    private static final RecordLog logger;

    private static native Method doFindMethod(Class<?> cls, String str, Class<?>[] clsArr);

    private static native Field findField(Class<?> cls, String str) throws NoSuchFieldException;

    public static native Object getFieldValue(Class<?> cls, Object obj, String str) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException;

    public static native Object getFieldValue(Class<?> cls, String str) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException;

    public static native Object getFieldValue(Object obj, String str) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException;

    public static native <T> T getInstanceFieldValue(Class<?> cls, Object obj, String str) throws NoSuchFieldException, IllegalAccessException;

    public static native <T> T getInstanceFieldValue(Object obj, String str) throws NoSuchFieldException, IllegalAccessException;

    private static native Method get_Methods(Method[] methodArr, String str, Class<?>[] clsArr);

    public static native Object invokeMethod(Class<?> cls, Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    public static native Object invokeMethod(Class<?> cls, String str, Class<?>[] clsArr, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    public static native Object invokeMethod(Object obj, String str) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    public static native Object invokeMethod(Object obj, String str, Class<?>[] clsArr, Object[] objArr) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    public static native Object invokeMethod(String str, String str2) throws ClassNotFoundException, IllegalAccessException, IllegalArgumentException, InvocationTargetException;

    public static native void rethrow(Throwable th);

    public static native void setFieldValue(Class<?> cls, Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException;

    public static native void setFieldValue(Class<?> cls, String str, Object obj) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException;

    public static native void setFieldValue(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalArgumentException, IllegalAccessException;

    public static native void setInstanceFieldValue(Object obj, String str, Object obj2) throws NoSuchFieldException, IllegalAccessException;

    static {
        SoLoad992979061.loadJ2CSo("cn.damai_shell_alijtca_plus", ReflectUtil.class);
        TAG = ReflectUtil.class.getSimpleName();
        logger = new RecordLog();
    }
}
