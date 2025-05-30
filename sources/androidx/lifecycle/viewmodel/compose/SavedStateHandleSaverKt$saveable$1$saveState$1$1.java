package androidx.lifecycle.viewmodel.compose;

import androidx.compose.runtime.saveable.SaverScope;
import androidx.lifecycle.SavedStateHandle$Companion;
import kotlin.Function;
import kotlin.jvm.internal.FunctionAdapter;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
/* synthetic */ class SavedStateHandleSaverKt$saveable$1$saveState$1$1 implements SaverScope, FunctionAdapter {
    final /* synthetic */ SavedStateHandle$Companion $tmp0;

    SavedStateHandleSaverKt$saveable$1$saveState$1$1(SavedStateHandle$Companion savedStateHandle$Companion) {
        this.$tmp0 = savedStateHandle$Companion;
    }

    public final boolean canBeSaved(@Nullable Object obj) {
        return this.$tmp0.validateValue(obj);
    }

    public final boolean equals(@Nullable Object obj) {
        if ((obj instanceof SaverScope) && (obj instanceof FunctionAdapter)) {
            return Intrinsics.areEqual(getFunctionDelegate(), ((FunctionAdapter) obj).getFunctionDelegate());
        }
        return false;
    }

    @NotNull
    public final Function<?> getFunctionDelegate() {
        return new FunctionReferenceImpl(1, this.$tmp0, SavedStateHandle$Companion.class, "validateValue", "validateValue(Ljava/lang/Object;)Z", 0);
    }

    public final int hashCode() {
        return getFunctionDelegate().hashCode();
    }
}
