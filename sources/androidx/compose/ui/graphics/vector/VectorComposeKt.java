package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.StrokeJoin;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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
    @androidx.compose.ui.graphics.vector.VectorComposable
    @androidx.compose.runtime.Composable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Group(@org.jetbrains.annotations.Nullable java.lang.String r20, float r21, float r22, float r23, float r24, float r25, float r26, float r27, @org.jetbrains.annotations.Nullable java.util.List<? extends androidx.compose.ui.graphics.vector.PathNode> r28, @org.jetbrains.annotations.NotNull final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, @org.jetbrains.annotations.Nullable androidx.compose.runtime.Composer r30, final int r31, final int r32) {
        /*
            Method dump skipped, instructions count: 622
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.vector.VectorComposeKt.Group(java.lang.String, float, float, float, float, float, float, float, java.util.List, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    @VectorComposable
    @Composable
    /* renamed from: Path-9cdaXJ4, reason: not valid java name */
    public static final void m1336Path9cdaXJ4(@NotNull List<? extends PathNode> list, int i, @Nullable String str, @Nullable Brush brush, float f, @Nullable Brush brush2, float f2, float f3, int i2, int i3, float f4, float f5, float f6, float f7, @Nullable Composer composer, int i4, int i5, int i6) {
        Intrinsics.checkNotNullParameter(list, "pathData");
        Composer startRestartGroup = composer.startRestartGroup(-1478270750);
        int defaultFillType = (i6 & 2) != 0 ? VectorKt.getDefaultFillType() : i;
        String str2 = (i6 & 4) != 0 ? "" : str;
        Brush brush3 = (i6 & 8) != 0 ? null : brush;
        float f8 = (i6 & 16) != 0 ? 1.0f : f;
        Brush brush4 = (i6 & 32) == 0 ? brush2 : null;
        float f9 = (i6 & 64) != 0 ? 1.0f : f2;
        float f10 = (i6 & 128) != 0 ? 0.0f : f3;
        int defaultStrokeLineCap = (i6 & 256) != 0 ? VectorKt.getDefaultStrokeLineCap() : i2;
        int defaultStrokeLineJoin = (i6 & 512) != 0 ? VectorKt.getDefaultStrokeLineJoin() : i3;
        float f11 = (i6 & AccessibilityEventCompat.TYPE_TOUCH_EXPLORATION_GESTURE_END) != 0 ? 4.0f : f4;
        float f12 = (i6 & AccessibilityEventCompat.TYPE_WINDOW_CONTENT_CHANGED) != 0 ? 0.0f : f5;
        float f13 = (i6 & AccessibilityEventCompat.TYPE_VIEW_SCROLLED) != 0 ? 1.0f : f6;
        float f14 = (i6 & AccessibilityEventCompat.TYPE_VIEW_TEXT_SELECTION_CHANGED) != 0 ? 0.0f : f7;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1478270750, i4, i5, "androidx.compose.ui.graphics.vector.Path (VectorCompose.kt:99)");
        }
        final Path.1 r0 = Path.1.INSTANCE;
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
                    return r0.invoke();
                }
            });
        } else {
            startRestartGroup.useNode();
        }
        Composer composer2 = Updater.constructor-impl(startRestartGroup);
        Updater.set-impl(composer2, str2, new Function2<PathComponent, String, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$1
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
        Updater.set-impl(composer2, list, new Function2<PathComponent, List<? extends PathNode>, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$2
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
        Updater.set-impl(composer2, PathFillType.m1180boximpl(defaultFillType), new Function2<PathComponent, PathFillType, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$3
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m1339invokepweu1eQ((PathComponent) obj, ((PathFillType) obj2).m1186unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-pweu1eQ, reason: not valid java name */
            public final void m1339invokepweu1eQ(@NotNull PathComponent pathComponent, int i7) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.m1331setPathFillTypeoQ8Xj4U(i7);
            }
        });
        Updater.set-impl(composer2, brush3, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$4
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, (Brush) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, @Nullable Brush brush5) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setFill(brush5);
            }
        });
        Updater.set-impl(composer2, Float.valueOf(f8), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$5
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setFillAlpha(f15);
            }
        });
        Updater.set-impl(composer2, brush4, new Function2<PathComponent, Brush, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$6
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, (Brush) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, @Nullable Brush brush5) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setStroke(brush5);
            }
        });
        Updater.set-impl(composer2, Float.valueOf(f9), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$7
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setStrokeAlpha(f15);
            }
        });
        Updater.set-impl(composer2, Float.valueOf(f10), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$8
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setStrokeLineWidth(f15);
            }
        });
        Updater.set-impl(composer2, StrokeJoin.box-impl(defaultStrokeLineJoin), new Function2<PathComponent, StrokeJoin, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$9
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m1340invokekLtJ_vA((PathComponent) obj, ((StrokeJoin) obj2).unbox-impl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-kLtJ_vA, reason: not valid java name */
            public final void m1340invokekLtJ_vA(@NotNull PathComponent pathComponent, int i7) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.m1333setStrokeLineJoinWw9F2mQ(i7);
            }
        });
        Updater.set-impl(composer2, StrokeCap.box-impl(defaultStrokeLineCap), new Function2<PathComponent, StrokeCap, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$10
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                m1338invokeCSYIeUk((PathComponent) obj, ((StrokeCap) obj2).unbox-impl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-CSYIeUk, reason: not valid java name */
            public final void m1338invokeCSYIeUk(@NotNull PathComponent pathComponent, int i7) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.m1332setStrokeLineCapBeK7IIE(i7);
            }
        });
        Updater.set-impl(composer2, Float.valueOf(f11), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$11
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setStrokeLineMiter(f15);
            }
        });
        Updater.set-impl(composer2, Float.valueOf(f12), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$12
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setTrimPathStart(f15);
            }
        });
        Updater.set-impl(composer2, Float.valueOf(f13), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$13
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((PathComponent) obj, ((Number) obj2).floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull PathComponent pathComponent, float f15) {
                Intrinsics.checkNotNullParameter(pathComponent, "$this$set");
                pathComponent.setTrimPathEnd(f15);
            }
        });
        Updater.set-impl(composer2, Float.valueOf(f14), new Function2<PathComponent, Float, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComposeKt$Path$2$14
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
        endRestartGroup.updateScope(new Path.3(list, defaultFillType, str2, brush3, f8, brush4, f9, f10, defaultStrokeLineCap, defaultStrokeLineJoin, f11, f12, f13, f14, i4, i5, i6));
    }
}
