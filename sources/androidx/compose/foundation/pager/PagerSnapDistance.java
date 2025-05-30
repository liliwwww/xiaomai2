package androidx.compose.foundation.pager;

import androidx.compose.foundation.ExperimentalFoundationApi;
import androidx.compose.runtime.Stable;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public interface PagerSnapDistance {

    @NotNull
    public static final Companion Companion = Companion.$$INSTANCE;

    int calculateTargetPage(int i, int i2, float f, int i3, int i4);
}
