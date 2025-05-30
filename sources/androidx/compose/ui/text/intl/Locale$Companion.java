package androidx.compose.ui.text.intl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class Locale$Companion {
    private Locale$Companion() {
    }

    public /* synthetic */ Locale$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final Locale getCurrent() {
        return new Locale(PlatformLocaleKt.getPlatformLocaleDelegate().getCurrent().get(0));
    }
}
