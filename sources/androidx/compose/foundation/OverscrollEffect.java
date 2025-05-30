package androidx.compose.foundation;

import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.unit.Velocity;
import androidx.compose.runtime.Stable;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: classes.dex */
public interface OverscrollEffect {
    @Nullable
    /* renamed from: consumePostFling-sF-c-tU */
    Object mo1108consumePostFlingsFctU(long j, @NotNull Continuation<? super Unit> continuation);

    /* renamed from: consumePostScroll-OMhpSzk */
    void mo1109consumePostScrollOMhpSzk(long j, long j2, int i);

    @Nullable
    /* renamed from: consumePreFling-QWom1Mo */
    Object mo1110consumePreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation);

    /* renamed from: consumePreScroll-OzD1aCk */
    long mo1111consumePreScrollOzD1aCk(long j, int i);

    @NotNull
    Modifier getEffectModifier();

    boolean isInProgress();
}
