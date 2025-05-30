package androidx.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationTarget;

/* compiled from: Taobao */
@Target({ElementType.FIELD, ElementType.METHOD, ElementType.PARAMETER})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.FIELD, AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER, AnnotationTarget.VALUE_PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public @interface RequiresPermission$Write {
    RequiresPermission value() default @RequiresPermission;
}
