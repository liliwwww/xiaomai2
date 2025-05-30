package androidx.compose.runtime;

import kotlin.KotlinNothingValueException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import tb.ka;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class OffsetApplier<N> implements Applier<N> {

    @NotNull
    private final Applier<N> applier;
    private int nesting;
    private final int offset;

    public OffsetApplier(@NotNull Applier<N> applier, int i) {
        Intrinsics.checkNotNullParameter(applier, "applier");
        this.applier = applier;
        this.offset = i;
    }

    public void clear() {
        ComposerKt.composeRuntimeError("Clear is not valid on OffsetApplier".toString());
        throw new KotlinNothingValueException();
    }

    public void down(N n) {
        this.nesting++;
        this.applier.down(n);
    }

    public N getCurrent() {
        return (N) this.applier.getCurrent();
    }

    public void insertBottomUp(int i, N n) {
        this.applier.insertBottomUp(i + (this.nesting == 0 ? this.offset : 0), n);
    }

    public void insertTopDown(int i, N n) {
        this.applier.insertTopDown(i + (this.nesting == 0 ? this.offset : 0), n);
    }

    public void move(int i, int i2, int i3) {
        int i4 = this.nesting == 0 ? this.offset : 0;
        this.applier.move(i + i4, i2 + i4, i3);
    }

    public /* synthetic */ void onBeginChanges() {
        ka.a(this);
    }

    public /* synthetic */ void onEndChanges() {
        ka.b(this);
    }

    public void remove(int i, int i2) {
        this.applier.remove(i + (this.nesting == 0 ? this.offset : 0), i2);
    }

    public void up() {
        int i = this.nesting;
        if (!(i > 0)) {
            ComposerKt.composeRuntimeError("OffsetApplier up called with no corresponding down".toString());
            throw new KotlinNothingValueException();
        }
        this.nesting = i - 1;
        this.applier.up();
    }
}
