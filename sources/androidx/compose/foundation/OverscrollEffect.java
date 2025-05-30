package androidx.compose.foundation;

import androidx.compose.runtime.Stable;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.unit.Velocity;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@Stable
@ExperimentalFoundationApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface OverscrollEffect {
    @Nullable
    /* renamed from: consumePostFling-sF-c-tU */
    Object mo109consumePostFlingsFctU(long j, @NotNull Continuation<? super Unit> continuation);

    /* renamed from: consumePostScroll-OMhpSzk */
    void mo110consumePostScrollOMhpSzk(long j, long j2, int i);

    @Nullable
    /* renamed from: consumePreFling-QWom1Mo */
    Object mo111consumePreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation);

    /* renamed from: consumePreScroll-OzD1aCk */
    long mo112consumePreScrollOzD1aCk(long j, int i);

    @NotNull
    Modifier getEffectModifier();

    boolean isInProgress();
}
