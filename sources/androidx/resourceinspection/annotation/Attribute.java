package androidx.resourceinspection.annotation;

import androidx.annotation.NonNull;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.SOURCE)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public @interface Attribute {

    /* compiled from: Taobao */
    @Target({})
    @Retention(RetentionPolicy.SOURCE)
    public @interface IntMap {
        int mask() default 0;

        @NonNull
        String name();

        int value();
    }

    @NonNull
    IntMap[] intMapping() default {};

    @NonNull
    String value();
}
