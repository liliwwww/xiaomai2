package androidx.lifecycle;

import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.MutableStateFlow;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class SavedStateHandle$SavingStateLiveData<T> extends MutableLiveData<T> {

    @Nullable
    private SavedStateHandle handle;

    @NotNull
    private String key;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SavedStateHandle$SavingStateLiveData(@Nullable SavedStateHandle savedStateHandle, @NotNull String str, T t) {
        super(t);
        Intrinsics.checkNotNullParameter(str, "key");
        this.key = str;
        this.handle = savedStateHandle;
    }

    public final void detach() {
        this.handle = null;
    }

    @Override // androidx.lifecycle.MutableLiveData, androidx.lifecycle.LiveData
    public void setValue(T t) {
        SavedStateHandle savedStateHandle = this.handle;
        if (savedStateHandle != null) {
            SavedStateHandle.access$getRegular$p(savedStateHandle).put(this.key, t);
            MutableStateFlow mutableStateFlow = (MutableStateFlow) SavedStateHandle.access$getFlows$p(savedStateHandle).get(this.key);
            if (mutableStateFlow != null) {
                mutableStateFlow.setValue(t);
            }
        }
        super.setValue(t);
    }

    public SavedStateHandle$SavingStateLiveData(@Nullable SavedStateHandle savedStateHandle, @NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        this.key = str;
        this.handle = savedStateHandle;
    }
}
