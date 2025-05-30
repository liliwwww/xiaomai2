package androidx.lifecycle;

import androidx.annotation.RestrictTo;
import androidx.lifecycle.ViewModelProvider;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ViewModelProvider$NewInstanceFactory$Companion {
    private ViewModelProvider$NewInstanceFactory$Companion() {
    }

    public /* synthetic */ ViewModelProvider$NewInstanceFactory$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @JvmStatic
    public static /* synthetic */ void getInstance$annotations() {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
    @NotNull
    public final ViewModelProvider.NewInstanceFactory getInstance() {
        if (ViewModelProvider.NewInstanceFactory.access$getSInstance$cp() == null) {
            ViewModelProvider.NewInstanceFactory.access$setSInstance$cp(new ViewModelProvider.NewInstanceFactory());
        }
        ViewModelProvider.NewInstanceFactory access$getSInstance$cp = ViewModelProvider.NewInstanceFactory.access$getSInstance$cp();
        Intrinsics.checkNotNull(access$getSInstance$cp);
        return access$getSInstance$cp;
    }
}
