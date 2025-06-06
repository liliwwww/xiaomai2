package androidx.room;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/* compiled from: Taobao */
@Target({})
@Retention(RetentionPolicy.CLASS)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public @interface BuiltInTypeConverters {

    /* compiled from: Taobao */
    public enum State {
        ENABLED,
        DISABLED,
        INHERITED
    }

    State enums() default State.INHERITED;

    State uuid() default State.INHERITED;
}
