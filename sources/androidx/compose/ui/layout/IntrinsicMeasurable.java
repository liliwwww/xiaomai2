package androidx.compose.ui.layout;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface IntrinsicMeasurable {
    @Nullable
    Object getParentData();

    int maxIntrinsicHeight(int i);

    int maxIntrinsicWidth(int i);

    int minIntrinsicHeight(int i);

    int minIntrinsicWidth(int i);
}
