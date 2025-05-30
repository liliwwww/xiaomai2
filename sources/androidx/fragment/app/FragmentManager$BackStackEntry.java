package androidx.fragment.app;

import androidx.annotation.Nullable;
import androidx.annotation.StringRes;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface FragmentManager$BackStackEntry {
    @Nullable
    @Deprecated
    CharSequence getBreadCrumbShortTitle();

    @StringRes
    @Deprecated
    int getBreadCrumbShortTitleRes();

    @Nullable
    @Deprecated
    CharSequence getBreadCrumbTitle();

    @StringRes
    @Deprecated
    int getBreadCrumbTitleRes();

    int getId();

    @Nullable
    String getName();
}
