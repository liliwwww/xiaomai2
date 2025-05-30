package androidx.compose.p004ui.draw;

import androidx.compose.p004ui.geometry.Rect;
import androidx.compose.p004ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.p004ui.graphics.drawscope.DrawScope;
import androidx.compose.p004ui.unit.Density;
import androidx.compose.p004ui.unit.DpRect;
import androidx.compose.p004ui.unit.LayoutDirection;
import androidx.compose.runtime.internal.StabilityInferred;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jw0;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: classes2.dex */
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

    @Override // androidx.compose.p004ui.unit.Density
    public float getDensity() {
        return this.cacheParams.getDensity().getDensity();
    }

    @Nullable
    public final DrawResult getDrawResult$ui_release() {
        return this.drawResult;
    }

    @Override // androidx.compose.p004ui.unit.Density
    public float getFontScale() {
        return this.cacheParams.getDensity().getFontScale();
    }

    @NotNull
    public final LayoutDirection getLayoutDirection() {
        return this.cacheParams.getLayoutDirection();
    }

    /* renamed from: getSize-NH-jbRc, reason: not valid java name */
    public final long m2466getSizeNHjbRc() {
        return this.cacheParams.mo2465getSizeNHjbRc();
    }

    @NotNull
    public final DrawResult onDrawBehind(@NotNull final Function1<? super DrawScope, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        return onDrawWithContent(new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.ui.draw.CacheDrawScope$onDrawBehind$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: roundToPx--R2X_6o */
    public /* synthetic */ int mo1276roundToPxR2X_6o(long j) {
        return jw0.a(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: roundToPx-0680j_4 */
    public /* synthetic */ int mo1277roundToPx0680j_4(float f) {
        return jw0.b(this, f);
    }

    public final void setCacheParams$ui_release(@NotNull BuildDrawCacheParams buildDrawCacheParams) {
        Intrinsics.checkNotNullParameter(buildDrawCacheParams, "<set-?>");
        this.cacheParams = buildDrawCacheParams;
    }

    public final void setDrawResult$ui_release(@Nullable DrawResult drawResult) {
        this.drawResult = drawResult;
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-GaN1DYA */
    public /* synthetic */ float mo1278toDpGaN1DYA(long j) {
        return jw0.c(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo1279toDpu2uoSUM(float f) {
        return jw0.d(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDp-u2uoSUM */
    public /* synthetic */ float mo1280toDpu2uoSUM(int i) {
        return jw0.e(this, i);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toDpSize-k-rfVVM */
    public /* synthetic */ long mo1281toDpSizekrfVVM(long j) {
        return jw0.f(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toPx--R2X_6o */
    public /* synthetic */ float mo1282toPxR2X_6o(long j) {
        return jw0.g(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toPx-0680j_4 */
    public /* synthetic */ float mo1283toPx0680j_4(float f) {
        return jw0.h(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return jw0.i(this, dpRect);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSize-XkaWNTQ */
    public /* synthetic */ long mo1284toSizeXkaWNTQ(long j) {
        return jw0.j(this, j);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-0xMU5do */
    public /* synthetic */ long mo1285toSp0xMU5do(float f) {
        return jw0.k(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo1286toSpkPz2Gy4(float f) {
        return jw0.l(this, f);
    }

    @Override // androidx.compose.p004ui.unit.Density
    /* renamed from: toSp-kPz2Gy4 */
    public /* synthetic */ long mo1287toSpkPz2Gy4(int i) {
        return jw0.m(this, i);
    }
}
