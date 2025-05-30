package androidx.compose.ui.tooling.preview;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* compiled from: Taobao */
@Retention(RetentionPolicy.RUNTIME)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public @interface PreviewParameter {
    int limit() default Integer.MAX_VALUE;

    Class<? extends PreviewParameterProvider<?>> provider();
}
