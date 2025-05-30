package androidx.core.graphics;

import android.content.Context;
import android.graphics.Typeface;
import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.RestrictTo$Scope;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* compiled from: Taobao */
@RequiresApi(28)
@RestrictTo({RestrictTo$Scope.LIBRARY_GROUP_PREFIX})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class TypefaceCompatApi28Impl extends TypefaceCompatApi26Impl {
    private static final String CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD = "createFromFamiliesWithDefault";
    private static final String DEFAULT_FAMILY = "sans-serif";
    private static final int RESOLVE_BY_FONT_TABLE = -1;

    protected Typeface createFromFamiliesWithDefault(Object obj) {
        try {
            Object newInstance = Array.newInstance((Class<?>) ((TypefaceCompatApi26Impl) this).mFontFamily, 1);
            Array.set(newInstance, 0, obj);
            return (Typeface) ((TypefaceCompatApi26Impl) this).mCreateFromFamiliesWithDefault.invoke(null, newInstance, DEFAULT_FAMILY, -1, -1);
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    @NonNull
    Typeface createWeightStyle(@NonNull Context context, @NonNull Typeface typeface, int i, boolean z) {
        return Typeface.create(typeface, i, z);
    }

    protected Method obtainCreateFromFamiliesWithDefaultMethod(Class<?> cls) throws NoSuchMethodException {
        Class cls2 = Integer.TYPE;
        Method declaredMethod = Typeface.class.getDeclaredMethod(CREATE_FROM_FAMILIES_WITH_DEFAULT_METHOD, Array.newInstance(cls, 1).getClass(), String.class, cls2, cls2);
        declaredMethod.setAccessible(true);
        return declaredMethod;
    }
}
