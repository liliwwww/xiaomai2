package androidx.compose.p004ui.graphics.vector;

import androidx.compose.p004ui.graphics.Brush;
import androidx.compose.p004ui.graphics.PathFillType;
import androidx.compose.p004ui.graphics.StrokeCap;
import androidx.compose.p004ui.graphics.StrokeJoin;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class VectorComposeKt {
    /* JADX WARN: Removed duplicated region for block: B:101:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:10:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:47:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x024b  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0195  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0199  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0115  */
    @androidx.compose.p004ui.graphics.vector.VectorComposable
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void Group(@org.jetbrains.annotations.Nullable java.lang.String r20, float r21, float r22, float r23, float r24, float r25, float r26, float r27, @org.jetbrains.annotations.Nullable java.util.List<? extends androidx.compose.p004ui.graphics.vector.PathNode> r28, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    @VectorComposable
    @Composable
    /* renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m3323Path9cdaXJ4(@NotNull final List<? extends PathNode> list, int i, @Nullable String str, @Nullable Brush brush, float f, @Nullable Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, @Nullable Composer composer, final int i4, final int i5, final int i6) {
        Intrinsics.checkNotNullParameter(list, "pathData");
        Composer startRestartGroup = composer.startRestartGroup(-1478270750);
        int defaultFillType = (i6 & 2) != 0 ? VectorKt.getDefaultFillType() : i;
        String str2 = (i6 & 4) != 0 ? "" : str;
        Brush brush3 = (i6 & 8) != 0 ? null : brush;
        float f8 = (i6 & 16) != 0 ? 1.0f : f;
        final Brush brush4 = (i6 & 32) == 0 ? brush2 : null;
        float f9 = (i6 & 64) != 0 ? 1.0f : f2;
        float f10 = (i6 & 128) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i6 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
        int defaultStrokeLineJoin = (i6 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
        float f11 = (i6 & 1024) != 0 ? 4.0f : f4;
        float f12 = (i6 & 2048) != 0 ? 0.0f : f5;
        float f13 = (i6 & 4096) != 0 ? 1.0f : f6;
        float f14 = (i6 & 8192) != 0 ? 0.0f : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1478270750, i4, i5, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:99)");
        }
        final VectorComposeKt$Path$1 vectorComposeKt$Path$1 = new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$1
            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final PathComponent m3325invoke() {
                return new PathComponent();
            }
        };
        startRestartGroup.startReplaceableGroup(1886828752);
        if (!(startRestartGroup.getApplier() instanceof VectorApplier)) {
            ComposablesKt.invalidApplier();
        }
        startRestartGroup.startNode();
        if (startRestartGroup.getInserting()) {
            startRestartGroup.createNode(new Function0<PathComponent>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path-9cdaXJ4$$inlined$ComposeNode$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Type inference failed for: r0v1, types: [androidx.compose.ui.graphics.vector.PathComponent, java.lang.Object] */
                @NotNull
                public final PathComponent invoke() {
                    return vectorComposeKt$Path$1.invoke();
                }
            });
        } else {
            startRestartGroup.useNode();
        }
        Composer m2410constructorimpl = Updater.m2410constructorimpl(startRestartGroup);
        Updater.m2417setimpl(m2410constructorimpl, str2, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, (String) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, @NotNull String str3) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                Intrinsics.checkNotNullParameter(str3, "it");
                pathComponent.setName(str3);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, list, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, (List<? extends PathNode>) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, @NotNull List<? extends PathNode> list2) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                Intrinsics.checkNotNullParameter(list2, "it");
                pathComponent.setPathData(list2);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, PathFillType.m3023boximpl(defaultFillType), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m3327invokepweu1eQ((PathComponent) obj, ((PathFillType) obj2).m3029unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-pweu1eQ, reason: not valid java name */
            public final void m3327invokepweu1eQ(@NotNull PathComponent pathComponent, int i7) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.m3317setPathFillTypeoQ8Xj4U(i7);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, brush3, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, (Brush) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, @Nullable Brush brush5) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setFill(brush5);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, Float.valueOf(f8), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setFillAlpha(f15);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, brush4, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, (Brush) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, @Nullable Brush brush5) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setStroke(brush5);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, Float.valueOf(f9), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setStrokeAlpha(f15);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, Float.valueOf(f10), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setStrokeLineWidth(f15);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, StrokeJoin.m3095boximpl(defaultStrokeLineJoin), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m3328invokekLtJ_vA((PathComponent) obj, ((StrokeJoin) obj2).m3101unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-kLtJ_vA, reason: not valid java name */
            public final void m3328invokekLtJ_vA(@NotNull PathComponent pathComponent, int i7) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.m3319setStrokeLineJoinWw9F2mQ(i7);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, StrokeCap.m3085boximpl(defaultStrokeLineCap), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m3326invokeCSYIeUk((PathComponent) obj, ((StrokeCap) obj2).m3091unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-CSYIeUk, reason: not valid java name */
            public final void m3326invokeCSYIeUk(@NotNull PathComponent pathComponent, int i7) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.m3318setStrokeLineCapBeK7IIE(i7);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, Float.valueOf(f11), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setStrokeLineMiter(f15);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, Float.valueOf(f12), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setTrimPathStart(f15);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, Float.valueOf(f13), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setTrimPathEnd(f15);
            }
        });
        Updater.m2417setimpl(m2410constructorimpl, Float.valueOf(f14), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setTrimPathOffset(f15);
            }
        });
        startRestartGroup.endNode();
        startRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        final int i7 = defaultFillType;
        final String str3 = str2;
        final Brush brush5 = brush3;
        final float f15 = f8;
        final float f16 = f9;
        final float f17 = f10;
        final int i8 = defaultStrokeLineCap;
        final int i9 = defaultStrokeLineJoin;
        final float f18 = f11;
        final float f19 = f12;
        final float f20 = f13;
        final float f21 = f14;
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i10) {
                VectorComposeKt.m3323Path9cdaXJ4(list, i7, str3, brush5, f15, brush4, f16, f17, i8, i9, f18, f19, f20, f21, composer2, RecomposeScopeImplKt.updateChangedFlags(i4 | 1), RecomposeScopeImplKt.updateChangedFlags(i5), i6);
            }
        });
    }
}
