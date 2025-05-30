package androidx.compose.p004ui.layout;

import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface IntrinsicMeasurable {
    @Nullable
    Object getParentData();

    int maxIntrinsicHeight(int i);

    int maxIntrinsicWidth(int i);

    int minIntrinsicHeight(int i);

    int minIntrinsicWidth(int i);
}
