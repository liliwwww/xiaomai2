package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.ExperimentalFoundationApi;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@ExperimentalFoundationApi
/* loaded from: classes2.dex */
public interface LazyStaggeredGridItemInfo {
    int getIndex();

    @NotNull
    Object getKey();

    int getLane();

    /* renamed from: getOffset-nOcc-ac, reason: not valid java name */
    long mo1629getOffsetnOccac();

    /* renamed from: getSize-YbymL2g, reason: not valid java name */
    long mo1630getSizeYbymL2g();
}
