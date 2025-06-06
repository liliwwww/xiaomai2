package androidx.compose.runtime.livedata;

import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class LiveDataAdapterKt$observeAsState$1 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
    final /* synthetic */ LifecycleOwner $lifecycleOwner;
    final /* synthetic */ MutableState<R> $state;
    final /* synthetic */ LiveData<T> $this_observeAsState;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LiveDataAdapterKt$observeAsState$1(LiveData<T> liveData, LifecycleOwner lifecycleOwner, MutableState<R> mutableState) {
        super(1);
        this.$this_observeAsState = liveData;
        this.$lifecycleOwner = lifecycleOwner;
        this.$state = mutableState;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: invoke$lambda-0, reason: not valid java name */
    public static final void m923invoke$lambda0(MutableState mutableState, Object obj) {
        Intrinsics.checkNotNullParameter(mutableState, "$state");
        mutableState.setValue(obj);
    }

    @NotNull
    public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
        Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
        final a aVar = new a(this.$state);
        this.$this_observeAsState.observe(this.$lifecycleOwner, aVar);
        final LiveData<T> liveData = this.$this_observeAsState;
        return new DisposableEffectResult() { // from class: androidx.compose.runtime.livedata.LiveDataAdapterKt$observeAsState$1$invoke$$inlined$onDispose$1
            public void dispose() {
                liveData.removeObserver(aVar);
            }
        };
    }
}
