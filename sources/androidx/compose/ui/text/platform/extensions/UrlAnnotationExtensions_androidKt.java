package androidx.compose.ui.text.platform.extensions;

import android.text.style.URLSpan;
import androidx.compose.ui.text.ExperimentalTextApi;
import androidx.compose.ui.text.UrlAnnotation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class UrlAnnotationExtensions_androidKt {
    @ExperimentalTextApi
    @NotNull
    public static final URLSpan toSpan(@NotNull UrlAnnotation urlAnnotation) {
        Intrinsics.checkNotNullParameter(urlAnnotation, "<this>");
        return new URLSpan(urlAnnotation.getUrl());
    }
}
