package androidx.compose.runtime;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ComposeCompilerApi
/* loaded from: classes2.dex */
public interface ScopeUpdateScope {
    void updateScope(@NotNull Function2<? super Composer, ? super Integer, Unit> function2);
}
