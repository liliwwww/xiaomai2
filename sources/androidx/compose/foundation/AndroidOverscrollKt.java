package androidx.compose.foundation;

import android.content.Context;
import android.os.Build;
import androidx.compose.p004ui.Modifier;
import androidx.compose.p004ui.geometry.Offset;
import androidx.compose.p004ui.layout.LayoutModifierKt;
import androidx.compose.p004ui.layout.Measurable;
import androidx.compose.p004ui.layout.MeasureResult;
import androidx.compose.p004ui.layout.MeasureScope;
import androidx.compose.p004ui.layout.Placeable;
import androidx.compose.p004ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.p004ui.unit.C0856Dp;
import androidx.compose.p004ui.unit.Constraints;
import androidx.compose.p004ui.unit.Velocity;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class AndroidOverscrollKt {

    @NotNull
    private static final AndroidOverscrollKt$NoOpOverscrollEffect$1 NoOpOverscrollEffect = new OverscrollEffect() { // from class: androidx.compose.foundation.AndroidOverscrollKt$NoOpOverscrollEffect$1
        @Override // androidx.compose.foundation.OverscrollEffect
        @Nullable
        /* renamed from: consumePostFling-sF-c-tU */
        public Object mo1108consumePostFlingsFctU(long j, @NotNull Continuation<? super Unit> continuation) {
            return Unit.INSTANCE;
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* renamed from: consumePostScroll-OMhpSzk */
        public void mo1109consumePostScrollOMhpSzk(long j, long j2, int i) {
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        @Nullable
        /* renamed from: consumePreFling-QWom1Mo */
        public Object mo1110consumePreFlingQWom1Mo(long j, @NotNull Continuation<? super Velocity> continuation) {
            return Velocity.m5432boximpl(Velocity.Companion.m5452getZero9UxMQ8M());
        }

        @Override // androidx.compose.foundation.OverscrollEffect
        /* renamed from: consumePreScroll-OzD1aCk */
        public long mo1111consumePreScrollOzD1aCk(long j, int i) {
            return Offset.Companion.m2572getZeroF1C5BW0();
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
    };

    @NotNull
    private static final Modifier StretchOverscrollNonClippingLayer;

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.compose.foundation.AndroidOverscrollKt$NoOpOverscrollEffect$1] */
    static {
        StretchOverscrollNonClippingLayer = Build.VERSION.SDK_INT >= 31 ? LayoutModifierKt.layout(LayoutModifierKt.layout(Modifier.Companion, new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m1113invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m5190unboximpl());
            }

            @NotNull
            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m1113invoke3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(measureScope, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(j);
                final int mo1277roundToPx0680j_4 = measureScope.mo1277roundToPx0680j_4(C0856Dp.m5216constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * 2));
                return MeasureScope.CC.m140p(measureScope, mo4187measureBRTryo0.getMeasuredWidth() - mo1277roundToPx0680j_4, mo4187measureBRTryo0.getMeasuredHeight() - mo1277roundToPx0680j_4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$1.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                        Placeable placeable = Placeable.this;
                        Placeable.PlacementScope.placeWithLayer$default(placementScope, placeable, ((-mo1277roundToPx0680j_4) / 2) - ((placeable.getWidth() - Placeable.this.getMeasuredWidth()) / 2), ((-mo1277roundToPx0680j_4) / 2) - ((Placeable.this.getHeight() - Placeable.this.getMeasuredHeight()) / 2), 0.0f, null, 12, null);
                    }
                }, 4, null);
            }
        }), new Function3<MeasureScope, Measurable, Constraints, MeasureResult>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
                return m1114invoke3p2s80s((MeasureScope) obj, (Measurable) obj2, ((Constraints) obj3).m5190unboximpl());
            }

            @NotNull
            /* renamed from: invoke-3p2s80s, reason: not valid java name */
            public final MeasureResult m1114invoke3p2s80s(@NotNull MeasureScope measureScope, @NotNull Measurable measurable, long j) {
                Intrinsics.checkNotNullParameter(measureScope, "$this$layout");
                Intrinsics.checkNotNullParameter(measurable, "measurable");
                final Placeable mo4187measureBRTryo0 = measurable.mo4187measureBRTryo0(j);
                final int mo1277roundToPx0680j_4 = measureScope.mo1277roundToPx0680j_4(C0856Dp.m5216constructorimpl(ClipScrollableContainerKt.getMaxSupportedElevation() * 2));
                return MeasureScope.CC.m140p(measureScope, mo4187measureBRTryo0.getWidth() + mo1277roundToPx0680j_4, mo4187measureBRTryo0.getHeight() + mo1277roundToPx0680j_4, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.foundation.AndroidOverscrollKt$StretchOverscrollNonClippingLayer$2.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((Placeable.PlacementScope) obj);
                        return Unit.INSTANCE;
                    }

                    public final void invoke(@NotNull Placeable.PlacementScope placementScope) {
                        Intrinsics.checkNotNullParameter(placementScope, "$this$layout");
                        Placeable placeable = Placeable.this;
                        int i = mo1277roundToPx0680j_4;
                        Placeable.PlacementScope.place$default(placementScope, placeable, i / 2, i / 2, 0.0f, 4, null);
                    }
                }, 4, null);
            }
        }) : Modifier.Companion;
    }

    private static /* synthetic */ void getNoOpOverscrollEffect$annotations() {
    }

    @Composable
    @NotNull
    public static final OverscrollEffect rememberOverscrollEffect(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-81138291);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-81138291, i, -1, "androidx.compose.foundation.rememberOverscrollEffect (AndroidOverscroll.kt:62)");
        }
        Context context = (Context) composer.consume(AndroidCompositionLocals_androidKt.getLocalContext());
        OverscrollConfiguration overscrollConfiguration = (OverscrollConfiguration) composer.consume(OverscrollConfigurationKt.getLocalOverscrollConfiguration());
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(context) | composer.changed(overscrollConfiguration);
        Object rememberedValue = composer.rememberedValue();
        if (changed || rememberedValue == Composer.Companion.getEmpty()) {
            rememberedValue = overscrollConfiguration != null ? new AndroidEdgeEffectOverscrollEffect(context, overscrollConfiguration) : NoOpOverscrollEffect;
            composer.updateRememberedValue(rememberedValue);
        }
        composer.endReplaceableGroup();
        OverscrollEffect overscrollEffect = (OverscrollEffect) rememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return overscrollEffect;
    }
}
