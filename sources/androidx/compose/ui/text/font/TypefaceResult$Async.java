package androidx.compose.ui.text.font;

import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class TypefaceResult$Async implements TypefaceResult, State<Object> {
    public static final int $stable = 0;

    @NotNull
    private final AsyncFontListLoader current;

    public TypefaceResult$Async(@NotNull AsyncFontListLoader asyncFontListLoader) {
        Intrinsics.checkNotNullParameter(asyncFontListLoader, "current");
        this.current = asyncFontListLoader;
    }

    public boolean getCacheable() {
        return this.current.getCacheable$ui_text_release();
    }

    @NotNull
    public final AsyncFontListLoader getCurrent$ui_text_release() {
        return this.current;
    }

    @Override // androidx.compose.runtime.State
    @NotNull
    public Object getValue() {
        return this.current.getValue();
    }
}
