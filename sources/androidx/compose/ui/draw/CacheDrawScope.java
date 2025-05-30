package androidx.compose.ui.draw;

import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jw0;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class CacheDrawScope implements Density {
    public static final int $stable = 0;

    @NotNull
    private BuildDrawCacheParams cacheParams = EmptyBuildDrawCacheParams.INSTANCE;

    @Nullable
    private DrawResult drawResult;

    @NotNull
    public final BuildDrawCacheParams getCacheParams$ui_release() {
        return this.cacheParams;
    }

    public float getDensity() {
        return this.cacheParams.getDensity().getDensity();
    }

    @Nullable
    public final DrawResult getDrawResult$ui_release() {
        return this.drawResult;
    }

    public float getFontScale() {
        return this.cacheParams.getDensity().getFontScale();
    }

    @NotNull
    public final LayoutDirection getLayoutDirection() {
        return this.cacheParams.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m943getSizeNHjbRc() {
        return this.cacheParams.getSize-NH-jbRc();
    }

    @NotNull
    public final DrawResult onDrawBehind(@NotNull final Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.ui.draw.CacheDrawScope$onDrawBehind$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ContentDrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull ContentDrawScope contentDrawScope) {
                Intrinsics.checkNotNullParameter(contentDrawScope, "$this$onDrawWithContent");
                function1.invoke(contentDrawScope);
                contentDrawScope.drawContent();
            }
        });
    }

    @NotNull
    public final DrawResult onDrawWithContent(@NotNull Function1<? super ContentDrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        DrawResult drawResult = new DrawResult(function1);
        this.drawResult = drawResult;
        return drawResult;
    }

    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public /* synthetic */ int m944roundToPxR2X_6o(long j) {
        return jw0.a(this, j);
    }

    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public /* synthetic */ int m945roundToPx0680j_4(float f) {
        return jw0.b(this, f);
    }

    public final void setCacheParams$ui_release(@NotNull BuildDrawCacheParams buildDrawCacheParams) {
        Intrinsics.checkNotNullParameter(buildDrawCacheParams, "<set-?>");
        this.cacheParams = buildDrawCacheParams;
    }

    public final void setDrawResult$ui_release(@Nullable DrawResult drawResult) {
        this.drawResult = drawResult;
    }

    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public /* synthetic */ float m946toDpGaN1DYA(long j) {
        return jw0.c(this, j);
    }

    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public /* synthetic */ float m947toDpu2uoSUM(float f) {
        return jw0.d(this, f);
    }

    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public /* synthetic */ float m948toDpu2uoSUM(int i) {
        return jw0.e(this, i);
    }

    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public /* synthetic */ long m949toDpSizekrfVVM(long j) {
        return jw0.f(this, j);
    }

    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public /* synthetic */ float m950toPxR2X_6o(long j) {
        return jw0.g(this, j);
    }

    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public /* synthetic */ float m951toPx0680j_4(float f) {
        return jw0.h(this, f);
    }

    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return jw0.i(this, dpRect);
    }

    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public /* synthetic */ long m952toSizeXkaWNTQ(long j) {
        return jw0.j(this, j);
    }

    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public /* synthetic */ long m953toSp0xMU5do(float f) {
        return jw0.k(this, f);
    }

    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public /* synthetic */ long m954toSpkPz2Gy4(float f) {
        return jw0.l(this, f);
    }

    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public /* synthetic */ long m955toSpkPz2Gy4(int i) {
        return jw0.m(this, i);
    }
}
