package androidx.compose.p004ui.platform;

import android.content.Context;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.MainThread;
import androidx.compose.p004ui.C0756R;
import androidx.compose.p004ui.node.LayoutNode;
import androidx.compose.p004ui.node.UiApplier;
import androidx.compose.runtime.ComposableInferredTarget;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.Composition;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionKt;
import java.lang.reflect.Field;
import java.util.Collections;
import java.util.WeakHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class Wrapper_androidKt {

    @NotNull
    private static final ViewGroup.LayoutParams DefaultLayoutParams = new ViewGroup.LayoutParams(-2, -2);

    @NotNull
    private static final String TAG = "Wrapper";

    @MainThread
    @NotNull
    public static final Composition createSubcomposition(@NotNull LayoutNode layoutNode, @NotNull CompositionContext compositionContext) {
        Intrinsics.checkNotNullParameter(layoutNode, "container");
        Intrinsics.checkNotNullParameter(compositionContext, "parent");
        return CompositionKt.Composition(new UiApplier(layoutNode), compositionContext);
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    private static final Composition doSetContent(AndroidComposeView androidComposeView, CompositionContext compositionContext, Function2<? super Composer, ? super Integer, Unit> function2) {
        if (inspectionWanted(androidComposeView)) {
            androidComposeView.setTag(C0756R.id.inspection_slot_table_set, Collections.newSetFromMap(new WeakHashMap()));
            enableDebugInspectorInfo();
        }
        Composition Composition = CompositionKt.Composition(new UiApplier(androidComposeView.getRoot()), compositionContext);
        View view = androidComposeView.getView();
        int i = C0756R.id.wrapped_composition_tag;
        Object tag = view.getTag(i);
        WrappedComposition wrappedComposition = tag instanceof WrappedComposition ? (WrappedComposition) tag : null;
        if (wrappedComposition == null) {
            wrappedComposition = new WrappedComposition(androidComposeView, Composition);
            androidComposeView.getView().setTag(i, wrappedComposition);
        }
        wrappedComposition.setContent(function2);
        return wrappedComposition;
    }

    private static final void enableDebugInspectorInfo() {
        if (InspectableValueKt.isDebugInspectorInfoEnabled()) {
            return;
        }
        try {
            int i = InspectableValueKt.f204a;
            Field declaredField = InspectableValueKt.class.getDeclaredField("isDebugInspectorInfoEnabled");
            declaredField.setAccessible(true);
            declaredField.setBoolean(null, true);
        } catch (Exception unused) {
            Log.w(TAG, "Could not access isDebugInspectorInfoEnabled. Please set explicitly.");
        }
    }

    private static final boolean inspectionWanted(AndroidComposeView androidComposeView) {
        return Build.VERSION.SDK_INT >= 29 && (WrapperVerificationHelperMethods.INSTANCE.attributeSourceResourceMap(androidComposeView).isEmpty() ^ true);
    }

    @ComposableInferredTarget(scheme = "[0[0]]")
    @NotNull
    public static final Composition setContent(@NotNull AbstractComposeView abstractComposeView, @NotNull CompositionContext compositionContext, @NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(abstractComposeView, "<this>");
        Intrinsics.checkNotNullParameter(compositionContext, "parent");
        Intrinsics.checkNotNullParameter(function2, "content");
        GlobalSnapshotManager.INSTANCE.ensureStarted();
        AndroidComposeView androidComposeView = null;
        if (abstractComposeView.getChildCount() > 0) {
            View childAt = abstractComposeView.getChildAt(0);
            if (childAt instanceof AndroidComposeView) {
                androidComposeView = (AndroidComposeView) childAt;
            }
        } else {
            abstractComposeView.removeAllViews();
        }
        if (androidComposeView == null) {
            Context context = abstractComposeView.getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            androidComposeView = new AndroidComposeView(context);
            abstractComposeView.addView(androidComposeView.getView(), DefaultLayoutParams);
        }
        return doSetContent(androidComposeView, compositionContext, function2);
    }
}
