package androidx.lifecycle;

import androidx.annotation.NonNull;

/* compiled from: Taobao */
@Deprecated
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface LifecycleRegistryOwner extends LifecycleOwner {
    @NonNull
    /* bridge */ /* synthetic */ Lifecycle getLifecycle();

    @NonNull
    /* renamed from: getLifecycle, reason: collision with other method in class */
    LifecycleRegistry m2807getLifecycle();
}
