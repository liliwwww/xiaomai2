package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.Composable;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.internal.StabilityInferred;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.unit.LayoutDirection;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
@StabilityInferred(parameters = 0)
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VectorPainter extends Painter {
    public static final int $stable = 8;

    @NotNull
    private final MutableState autoMirror$delegate;

    @Nullable
    private Composition composition;
    private float currentAlpha;

    @Nullable
    private ColorFilter currentColorFilter;

    @NotNull
    private final MutableState isDirty$delegate;

    @NotNull
    private final MutableState size$delegate;

    @NotNull
    private final VectorComponent vector;

    public VectorPainter() {
        MutableState mutableStateOf$default;
        MutableState mutableStateOf$default2;
        MutableState mutableStateOf$default3;
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Size.box-impl(Size.Companion.getZero-NH-jbRc()), null, 2, null);
        this.size$delegate = mutableStateOf$default;
        mutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
        this.autoMirror$delegate = mutableStateOf$default2;
        VectorComponent vectorComponent = new VectorComponent();
        vectorComponent.setInvalidateCallback$ui_release(new vector.1.1(this));
        this.vector = vectorComponent;
        mutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
        this.isDirty$delegate = mutableStateOf$default3;
        this.currentAlpha = 1.0f;
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    private final Composition composeVector(CompositionContext compositionContext, final Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4) {
        Composition composition = this.composition;
        if (composition == null || composition.isDisposed()) {
            composition = CompositionKt.Composition(new VectorApplier(this.vector.getRoot()), compositionContext);
        }
        this.composition = composition;
        composition.setContent(ComposableLambdaKt.composableLambdaInstance(-1916507005, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$composeVector$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            @Composable
            public final void invoke(@Nullable Composer composer, int i) {
                VectorComponent vectorComponent;
                VectorComponent vectorComponent2;
                if ((i & 11) == 2 && composer.getSkipping()) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1916507005, i, -1, "androidx.compose.ui.graphics.vector.VectorPainter.composeVector.<anonymous> (VectorPainter.kt:212)");
                }
                Function4<Float, Float, Composer, Integer, Unit> function42 = function4;
                vectorComponent = this.vector;
                Float valueOf = Float.valueOf(vectorComponent.getViewportWidth());
                vectorComponent2 = this.vector;
                function42.invoke(valueOf, Float.valueOf(vectorComponent2.getViewportHeight()), composer, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return composition;
    }

    private final boolean isDirty() {
        return ((Boolean) this.isDirty$delegate.getValue()).booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDirty(boolean z) {
        this.isDirty$delegate.setValue(Boolean.valueOf(z));
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public final void RenderVector$ui_release(@NotNull final String str, final float f, final float f2, @NotNull final Function4<? super Float, ? super Float, ? super Composer, ? super Integer, Unit> function4, @Nullable Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(str, "name");
        Intrinsics.checkNotNullParameter(function4, "content");
        Composer startRestartGroup = composer.startRestartGroup(1264894527);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1264894527, i, -1, "androidx.compose.ui.graphics.vector.VectorPainter.RenderVector (VectorPainter.kt:221)");
        }
        VectorComponent vectorComponent = this.vector;
        vectorComponent.setName(str);
        vectorComponent.setViewportWidth(f);
        vectorComponent.setViewportHeight(f2);
        final Composition composeVector = composeVector(ComposablesKt.rememberCompositionContext(startRestartGroup, 0), function4);
        EffectsKt.DisposableEffect((Object) composeVector, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) new Function1<DisposableEffectScope, DisposableEffectResult>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$RenderVector$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @NotNull
            public final DisposableEffectResult invoke(@NotNull DisposableEffectScope disposableEffectScope) {
                Intrinsics.checkNotNullParameter(disposableEffectScope, "$this$DisposableEffect");
                final Composition composition = composeVector;
                return new DisposableEffectResult() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$RenderVector$2$invoke$$inlined$onDispose$1
                    public void dispose() {
                        composition.dispose();
                    }
                };
            }
        }, startRestartGroup, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope endRestartGroup = startRestartGroup.endRestartGroup();
        if (endRestartGroup == null) {
            return;
        }
        endRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorPainter$RenderVector$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Composer) obj, ((Number) obj2).intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(@Nullable Composer composer2, int i2) {
                VectorPainter.this.RenderVector$ui_release(str, f, f2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
            }
        });
    }

    protected boolean applyAlpha(float f) {
        this.currentAlpha = f;
        return true;
    }

    protected boolean applyColorFilter(@Nullable ColorFilter colorFilter) {
        this.currentColorFilter = colorFilter;
        return true;
    }

    public final boolean getAutoMirror$ui_release() {
        return ((Boolean) this.autoMirror$delegate.getValue()).booleanValue();
    }

    @Nullable
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return this.vector.getIntrinsicColorFilter$ui_release();
    }

    /* renamed from: getIntrinsicSize-NH-jbRc, reason: not valid java name */
    public long m1341getIntrinsicSizeNHjbRc() {
        return m1342getSizeNHjbRc$ui_release();
    }

    /* renamed from: getSize-NH-jbRc$ui_release, reason: not valid java name */
    public final long m1342getSizeNHjbRc$ui_release() {
        return ((Size) this.size$delegate.getValue()).unbox-impl();
    }

    protected void onDraw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        VectorComponent vectorComponent = this.vector;
        ColorFilter colorFilter = this.currentColorFilter;
        if (colorFilter == null) {
            colorFilter = vectorComponent.getIntrinsicColorFilter$ui_release();
        }
        if (getAutoMirror$ui_release() && drawScope.getLayoutDirection() == LayoutDirection.Rtl) {
            long j = drawScope.getCenter-F1C5BW0();
            DrawContext drawContext = drawScope.getDrawContext();
            long mo1254getSizeNHjbRc = drawContext.mo1254getSizeNHjbRc();
            drawContext.getCanvas().save();
            drawContext.getTransform().scale-0AR0LA0(-1.0f, 1.0f, j);
            vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
            drawContext.getCanvas().restore();
            drawContext.mo1255setSizeuvyYCjk(mo1254getSizeNHjbRc);
        } else {
            vectorComponent.draw(drawScope, this.currentAlpha, colorFilter);
        }
        if (isDirty()) {
            setDirty(false);
        }
    }

    public final void setAutoMirror$ui_release(boolean z) {
        this.autoMirror$delegate.setValue(Boolean.valueOf(z));
    }

    public final void setIntrinsicColorFilter$ui_release(@Nullable ColorFilter colorFilter) {
        this.vector.setIntrinsicColorFilter$ui_release(colorFilter);
    }

    /* renamed from: setSize-uvyYCjk$ui_release, reason: not valid java name */
    public final void m1343setSizeuvyYCjk$ui_release(long j) {
        this.size$delegate.setValue(Size.box-impl(j));
    }
}
