package androidx.compose.foundation.text;

import androidx.compose.p004ui.text.Placeholder;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Immutable;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
public final class InlineTextContent {

    @NotNull
    private final Function3<String, Composer, Integer, Unit> children;

    @NotNull
    private final Placeholder placeholder;

    /* JADX WARN: Multi-variable type inference failed */
    public InlineTextContent(@NotNull Placeholder placeholder, @NotNull Function3<? super String, ? super Composer, ? super Integer, Unit> function3) {
        Intrinsics.checkNotNullParameter(placeholder, "placeholder");
        Intrinsics.checkNotNullParameter(function3, "children");
        this.placeholder = placeholder;
        this.children = function3;
    }

    @NotNull
    public final Function3<String, Composer, Integer, Unit> getChildren() {
        return this.children;
    }

    @NotNull
    public final Placeholder getPlaceholder() {
        return this.placeholder;
    }
}
