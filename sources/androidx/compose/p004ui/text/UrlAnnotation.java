package androidx.compose.p004ui.text;

import android.taobao.windvane.connect.HttpConnector;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
@ExperimentalTextApi
/* loaded from: classes2.dex */
public final class UrlAnnotation {
    public static final int $stable = 0;

    @NotNull
    private final String url;

    public UrlAnnotation(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, HttpConnector.URL);
        this.url = str;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof UrlAnnotation) && Intrinsics.areEqual(this.url, ((UrlAnnotation) obj).url);
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    public int hashCode() {
        return this.url.hashCode();
    }

    @NotNull
    public String toString() {
        return "UrlAnnotation(url=" + this.url + ')';
    }
}
