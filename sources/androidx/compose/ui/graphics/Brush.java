package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.geometry.Size;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class Brush {

    @NotNull
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private final long intrinsicSize;

    private Brush() {
        this.intrinsicSize = Size.Companion.getUnspecified-NH-jbRc();
    }

    public /* synthetic */ Brush(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: applyTo-Pq9zytI, reason: not valid java name */
    public abstract void m1044applyToPq9zytI(long j, @NotNull Paint paint, float f);

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m1045getIntrinsicSizeNHjbRc() {
        return this.intrinsicSize;
    }
}
