package androidx.compose.runtime;

import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@InternalComposeApi
/* loaded from: classes2.dex */
public interface RecomposerErrorInfo {
    @NotNull
    Exception getCause();

    boolean getRecoverable();
}
