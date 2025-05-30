package androidx.compose.runtime;

import androidx.exifinterface.media.ExifInterface;
import kotlin.NotImplementedError;
import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public final class ComposablesKt {
    @Composable
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(final Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        composer.startReplaceableGroup(1886828752);
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(new Function0<T>() { // from class: androidx.compose.runtime.ComposablesKt$ComposeNode$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @NotNull
                public final T invoke() {
                    return (T) function0.invoke();
                }
            });
        } else {
            composer.useNode();
        }
        function1.invoke(Updater.m2409boximpl(Updater.m2410constructorimpl(composer)));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(final Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        composer.startReplaceableGroup(1405779621);
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(new Function0<T>() { // from class: androidx.compose.runtime.ComposablesKt$ReusableComposeNode$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                @NotNull
                public final T invoke() {
                    return (T) function0.invoke();
                }
            });
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        function1.invoke(Updater.m2409boximpl(Updater.m2410constructorimpl(composer)));
        composer.enableReusing();
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final void ReusableContent(@Nullable Object obj, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function2, "content");
        composer.startReplaceableGroup(444418301);
        composer.startReusableGroup(ComposerKt.reuseKey, obj);
        function2.invoke(composer, Integer.valueOf((i >> 3) & 14));
        composer.endReusableGroup();
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final void ReusableContentHost(boolean z, @NotNull Function2<? super Composer, ? super Integer, Unit> function2, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function2, "content");
        composer.startReusableGroup(ComposerKt.reuseKey, Boolean.valueOf(z));
        boolean changed = composer.changed(z);
        if (z) {
            function2.invoke(composer, Integer.valueOf((i >> 3) & 14));
        } else {
            composer.deactivateToEndGroup(changed);
        }
        composer.endReusableGroup();
    }

    @JvmName(name = "getCurrentComposer")
    @NotNull
    @Composable
    @ReadOnlyComposable
    public static final Composer getCurrentComposer(@Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-554250212, i, -1, "androidx.compose.runtime.<get-currentComposer> (Composables.kt:183)");
        }
        throw new NotImplementedError("Implemented as an intrinsic");
    }

    @Composable
    @JvmName(name = "getCurrentCompositeKeyHash")
    public static final int getCurrentCompositeKeyHash(@Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(524444915, i, -1, "androidx.compose.runtime.<get-currentCompositeKeyHash> (Composables.kt:224)");
        }
        int compoundKeyHash = composer.getCompoundKeyHash();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return compoundKeyHash;
    }

    @Composable
    @JvmName(name = "getCurrentCompositionLocalContext")
    @NotNull
    public static final CompositionLocalContext getCurrentCompositionLocalContext(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-43352356);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-43352356, i, -1, "androidx.compose.runtime.<get-currentCompositionLocalContext> (Composables.kt:207)");
        }
        CompositionLocalContext compositionLocalContext = new CompositionLocalContext(composer.buildContext().getCompositionLocalScope$runtime_release());
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return compositionLocalContext;
    }

    public static /* synthetic */ void getCurrentCompositionLocalContext$annotations() {
    }

    @JvmName(name = "getCurrentRecomposeScope")
    @NotNull
    @Composable
    @ReadOnlyComposable
    public static final RecomposeScope getCurrentRecomposeScope(@Nullable Composer composer, int i) {
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(394957799, i, -1, "androidx.compose.runtime.<get-currentRecomposeScope> (Composables.kt:192)");
        }
        RecomposeScope recomposeScope = composer.getRecomposeScope();
        if (recomposeScope == null) {
            throw new IllegalStateException("no recompose scope found".toString());
        }
        composer.recordUsed(recomposeScope);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return recomposeScope;
    }

    @PublishedApi
    public static final void invalidApplier() {
        throw new IllegalStateException("Invalid applier".toString());
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final <T> T key(@NotNull Object[] objArr, @NotNull Function2<? super Composer, ? super Integer, ? extends T> function2, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(objArr, "keys");
        Intrinsics.checkNotNullParameter(function2, "block");
        composer.startReplaceableGroup(-11941951);
        T t = (T) function2.invoke(composer, Integer.valueOf((i >> 3) & 14));
        composer.endReplaceableGroup();
        return t;
    }

    @Composable
    public static final <T> T remember(@Nullable Object obj, @NotNull Function0<? extends T> function0, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        composer.startReplaceableGroup(1157296644);
        boolean changed = composer.changed(obj);
        T t = (T) composer.rememberedValue();
        if (changed || t == Composer.Companion.getEmpty()) {
            t = (T) function0.invoke();
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        return t;
    }

    @Composable
    @NotNull
    public static final CompositionContext rememberCompositionContext(@Nullable Composer composer, int i) {
        composer.startReplaceableGroup(-1165786124);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1165786124, i, -1, "androidx.compose.runtime.rememberCompositionContext (Composables.kt:486)");
        }
        CompositionContext buildContext = composer.buildContext();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return buildContext;
    }

    @Composable
    public static final <T> T remember(@Nullable Object obj, @Nullable Object obj2, @NotNull Function0<? extends T> function0, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        composer.startReplaceableGroup(511388516);
        boolean changed = composer.changed(obj) | composer.changed(obj2);
        T t = (T) composer.rememberedValue();
        if (changed || t == Composer.Companion.getEmpty()) {
            t = (T) function0.invoke();
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        return t;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer.startReplaceableGroup(-548224868);
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(function0);
        } else {
            composer.useNode();
        }
        function1.invoke(Updater.m2409boximpl(Updater.m2410constructorimpl(composer)));
        function2.invoke(composer, Integer.valueOf((i >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function2, "content");
        composer.startReplaceableGroup(-692256719);
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(function0);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        function1.invoke(Updater.m2409boximpl(Updater.m2410constructorimpl(composer)));
        composer.enableReusing();
        function2.invoke(composer, Integer.valueOf((i >> 6) & 14));
        composer.endNode();
        composer.endReplaceableGroup();
    }

    @Composable
    public static final <T> T remember(@Nullable Object obj, @Nullable Object obj2, @Nullable Object obj3, @NotNull Function0<? extends T> function0, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        composer.startReplaceableGroup(1618982084);
        boolean changed = composer.changed(obj) | composer.changed(obj2) | composer.changed(obj3);
        T t = (T) composer.rememberedValue();
        if (changed || t == Composer.Companion.getEmpty()) {
            t = (T) function0.invoke();
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        return t;
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ComposeNode(Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Function3<? super SkippableUpdater<T>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function3, "skippableUpdate");
        Intrinsics.checkNotNullParameter(function2, "content");
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startNode();
        if (composer.getInserting()) {
            composer.createNode(function0);
        } else {
            composer.useNode();
        }
        function1.invoke(Updater.m2409boximpl(Updater.m2410constructorimpl(composer)));
        function3.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(composer)), composer, Integer.valueOf((i >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
    }

    @Composable
    @ComposableInferredTarget(scheme = "[0[0][0]]")
    public static final /* synthetic */ <T, E extends Applier<?>> void ReusableComposeNode(Function0<? extends T> function0, Function1<? super Updater<T>, Unit> function1, Function3<? super SkippableUpdater<T>, ? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "factory");
        Intrinsics.checkNotNullParameter(function1, "update");
        Intrinsics.checkNotNullParameter(function3, "skippableUpdate");
        Intrinsics.checkNotNullParameter(function2, "content");
        Applier<?> applier = composer.getApplier();
        Intrinsics.reifiedOperationMarker(3, ExifInterface.LONGITUDE_EAST);
        if (!(applier instanceof Applier)) {
            invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(function0);
        } else {
            composer.useNode();
        }
        composer.disableReusing();
        function1.invoke(Updater.m2409boximpl(Updater.m2410constructorimpl(composer)));
        composer.enableReusing();
        function3.invoke(SkippableUpdater.m2398boximpl(SkippableUpdater.m2399constructorimpl(composer)), composer, Integer.valueOf((i >> 3) & 112));
        composer.startReplaceableGroup(2058660585);
        function2.invoke(composer, Integer.valueOf((i >> 9) & 14));
        composer.endReplaceableGroup();
        composer.endNode();
    }

    @Composable
    public static final <T> T remember(@NotNull Object[] objArr, @NotNull Function0<? extends T> function0, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(objArr, "keys");
        Intrinsics.checkNotNullParameter(function0, "calculation");
        composer.startReplaceableGroup(-568225417);
        boolean z = false;
        for (Object obj : objArr) {
            z |= composer.changed(obj);
        }
        T t = (T) composer.rememberedValue();
        if (z || t == Composer.Companion.getEmpty()) {
            t = (T) function0.invoke();
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        return t;
    }

    @Composable
    public static final <T> T remember(@NotNull Function0<? extends T> function0, @Nullable Composer composer, int i) {
        Intrinsics.checkNotNullParameter(function0, "calculation");
        composer.startReplaceableGroup(-492369756);
        T t = (T) composer.rememberedValue();
        if (t == Composer.Companion.getEmpty()) {
            t = (T) function0.invoke();
            composer.updateRememberedValue(t);
        }
        composer.endReplaceableGroup();
        return t;
    }
}
