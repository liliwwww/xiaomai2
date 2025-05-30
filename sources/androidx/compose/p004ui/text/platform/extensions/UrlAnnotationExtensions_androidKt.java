package androidx.compose.p004ui.text.platform.extensions;

import android.text.style.URLSpan;
import androidx.compose.p004ui.text.ExperimentalTextApi;
import androidx.compose.p004ui.text.UrlAnnotation;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class UrlAnnotationExtensions_androidKt {
    @ExperimentalTextApi
    @NotNull
    public static final URLSpan toSpan(@NotNull UrlAnnotation urlAnnotation) {
        Intrinsics.checkNotNullParameter(urlAnnotation, "<this>");
        return new URLSpan(urlAnnotation.getUrl());
    }
}
