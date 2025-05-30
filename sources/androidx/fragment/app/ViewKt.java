package androidx.fragment.app;

import android.view.View;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ViewKt {
    @NotNull
    public static final <F extends Fragment> F findFragment(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "<this>");
        F f = (F) FragmentManager.findFragment(view);
        Intrinsics.checkNotNullExpressionValue(f, "findFragment(this)");
        return f;
    }
}
