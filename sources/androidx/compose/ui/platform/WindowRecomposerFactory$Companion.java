package androidx.compose.ui.platform;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class WindowRecomposerFactory$Companion {
    static final /* synthetic */ WindowRecomposerFactory$Companion $$INSTANCE = new WindowRecomposerFactory$Companion();

    @NotNull
    private static final WindowRecomposerFactory LifecycleAware = LifecycleAware.1.INSTANCE;

    private WindowRecomposerFactory$Companion() {
    }

    public static /* synthetic */ void getLifecycleAware$annotations() {
    }

    @NotNull
    public final WindowRecomposerFactory getLifecycleAware() {
        return LifecycleAware;
    }
}
