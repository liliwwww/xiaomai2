package androidx.compose.runtime.internal;

import androidx.compose.runtime.ComposeCompilerApi;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.AnnotationTarget;
import kotlin.annotation.Repeatable;

/* compiled from: Taobao */
@Target({ElementType.TYPE})
@kotlin.annotation.Target(allowedTargets = {AnnotationTarget.CLASS})
@Retention(RetentionPolicy.RUNTIME)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@ComposeCompilerApi
@Repeatable
@java.lang.annotation.Repeatable(Container.class)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public @interface FunctionKeyMeta {
    int endOffset();

    int key();

    int startOffset();
}
