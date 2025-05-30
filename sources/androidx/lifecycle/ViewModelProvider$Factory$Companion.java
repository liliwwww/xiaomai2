package androidx.lifecycle;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.viewmodel.InitializerViewModelFactory;
import androidx.lifecycle.viewmodel.ViewModelInitializer;
import java.util.Arrays;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ViewModelProvider$Factory$Companion {
    static final /* synthetic */ ViewModelProvider$Factory$Companion $$INSTANCE = new ViewModelProvider$Factory$Companion();

    private ViewModelProvider$Factory$Companion() {
    }

    @JvmStatic
    @NotNull
    public final ViewModelProvider.Factory from(@NotNull ViewModelInitializer<?>... viewModelInitializerArr) {
        Intrinsics.checkNotNullParameter(viewModelInitializerArr, "initializers");
        return new InitializerViewModelFactory((ViewModelInitializer[]) Arrays.copyOf(viewModelInitializerArr, viewModelInitializerArr.length));
    }
}
