package androidx.compose.ui.graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface PathMeasure {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
    }

    float getLength();

    boolean getSegment(float f, float f2, @NotNull Path path, boolean z);

    void setPath(@Nullable Path path, boolean z);
}
