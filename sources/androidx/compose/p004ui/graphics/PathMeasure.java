package androidx.compose.p004ui.graphics;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface PathMeasure {

    /* compiled from: Taobao */
    public static final class DefaultImpls {
    }

    float getLength();

    boolean getSegment(float f, float f2, @NotNull Path path, boolean z);

    void setPath(@Nullable Path path, boolean z);
}
