package androidx.compose.ui.platform;

import android.view.View;
import androidx.compose.runtime.Composable;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.tooling.InspectionTablesKt;
import androidx.compose.ui.R$id;
import androidx.lifecycle.Lifecycle;
import java.util.Set;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlinx.coroutines.CoroutineScope;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class WrappedComposition$setContent$1 extends Lambda implements Function1<AndroidComposeView$ViewTreeOwners, Unit> {
    final /* synthetic */ Function2<Composer, Integer, Unit> $content;
    final /* synthetic */ WrappedComposition this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WrappedComposition$setContent$1(WrappedComposition wrappedComposition, Function2<? super Composer, ? super Integer, Unit> function2) {
        super(1);
        this.this$0 = wrappedComposition;
        this.$content = function2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((AndroidComposeView$ViewTreeOwners) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(@NotNull AndroidComposeView$ViewTreeOwners androidComposeView$ViewTreeOwners) {
        Intrinsics.checkNotNullParameter(androidComposeView$ViewTreeOwners, "it");
        if (WrappedComposition.access$getDisposed$p(this.this$0)) {
            return;
        }
        Lifecycle lifecycle = androidComposeView$ViewTreeOwners.getLifecycleOwner().getLifecycle();
        Intrinsics.checkNotNullExpressionValue(lifecycle, "it.lifecycleOwner.lifecycle");
        WrappedComposition.access$setLastContent$p(this.this$0, this.$content);
        if (WrappedComposition.access$getAddedToLifecycle$p(this.this$0) == null) {
            WrappedComposition.access$setAddedToLifecycle$p(this.this$0, lifecycle);
            lifecycle.addObserver(this.this$0);
        } else if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.CREATED)) {
            Composition original = this.this$0.getOriginal();
            final WrappedComposition wrappedComposition = this.this$0;
            final Function2<Composer, Integer, Unit> function2 = this.$content;
            original.setContent(ComposableLambdaKt.composableLambdaInstance(-2000640158, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.platform.WrappedComposition$setContent$1.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Composer) obj, ((Number) obj2).intValue());
                    return Unit.INSTANCE;
                }

                @Composable
                public final void invoke(@Nullable Composer composer, int i) {
                    if ((i & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2000640158, i, -1, "androidx.compose.ui.platform.WrappedComposition.setContent.<anonymous>.<anonymous> (Wrapper.android.kt:139)");
                    }
                    AndroidComposeView owner = wrappedComposition.getOwner();
                    int i2 = R$id.inspection_slot_table_set;
                    Object tag = owner.getTag(i2);
                    Set set = TypeIntrinsics.isMutableSet(tag) ? (Set) tag : null;
                    if (set == null) {
                        Object parent = wrappedComposition.getOwner().getParent();
                        View view = parent instanceof View ? (View) parent : null;
                        Object tag2 = view != null ? view.getTag(i2) : null;
                        set = TypeIntrinsics.isMutableSet(tag2) ? (Set) tag2 : null;
                    }
                    if (set != null) {
                        set.add(composer.getCompositionData());
                        composer.collectParameterInformation();
                    }
                    EffectsKt.LaunchedEffect(wrappedComposition.getOwner(), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new 1(wrappedComposition, (Continuation) null), composer, 72);
                    EffectsKt.LaunchedEffect(wrappedComposition.getOwner(), (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) new 2(wrappedComposition, (Continuation) null), composer, 72);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{InspectionTablesKt.getLocalInspectionTables().provides(set)}, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.composableLambda(composer, -1193460702, true, new 3(wrappedComposition, function2)), composer, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
        }
    }
}
