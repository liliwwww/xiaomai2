package androidx.compose.foundation;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.unit.Velocity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AndroidOverscrollKt$NoOpOverscrollEffect$1 implements OverscrollEffect {
    AndroidOverscrollKt$NoOpOverscrollEffect$1() {
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    @Nullable
    /* renamed from: consumePostFling-sF-c-tU, reason: not valid java name */
    public Object mo109consumePostFlingsFctU(long j, @NotNull Continuation<? super Unit> continuation) {
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: consumePostScroll-OMhpSzk, reason: not valid java name */
    public void mo110consumePostScrollOMhpSzk(long j, long j2, int i) {
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    @Nullable
    /* renamed from: consumePreFling-QWom1Mo, reason: not valid java name */
    public Object mo111consumePreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation) {
        return Velocity.box-impl(Velocity.Companion.m2239getZero9UxMQ8M());
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    /* renamed from: consumePreScroll-OzD1aCk, reason: not valid java name */
    public long mo112consumePreScrollOzD1aCk(long j, int i) {
        return Offset.Companion.getZero-F1C5BW0();
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    @NotNull
    public Modifier getEffectModifier() {
        return Modifier.Companion;
    }

    @Override // androidx.compose.foundation.OverscrollEffect
    public boolean isInProgress() {
        return false;
    }
}
