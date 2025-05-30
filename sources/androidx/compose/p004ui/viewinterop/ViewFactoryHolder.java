package androidx.compose.p004ui.viewinterop;

import android.content.Context;
import android.view.View;
import androidx.compose.p004ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.p004ui.platform.AbstractComposeView;
import androidx.compose.p004ui.platform.ViewRootForInspector;
import androidx.compose.runtime.CompositionContext;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.r56;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class ViewFactoryHolder<T extends View> extends AndroidViewHolder implements ViewRootForInspector {

    @Nullable
    private Function1<? super Context, ? extends T> factory;

    @Nullable
    private T typedView;

    @NotNull
    private Function1<? super T, Unit> updateBlock;

    public /* synthetic */ ViewFactoryHolder(Context context, CompositionContext compositionContext, NestedScrollDispatcher nestedScrollDispatcher, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? null : compositionContext, (i & 4) != 0 ? new NestedScrollDispatcher() : nestedScrollDispatcher);
    }

    @Nullable
    public final Function1<Context, T> getFactory() {
        return this.factory;
    }

    @Override // androidx.compose.p004ui.platform.ViewRootForInspector
    public /* synthetic */ AbstractComposeView getSubCompositionView() {
        return r56.a(this);
    }

    @Nullable
    public final T getTypedView$ui_release() {
        return this.typedView;
    }

    @NotNull
    public final Function1<T, Unit> getUpdateBlock() {
        return this.updateBlock;
    }

    @Override // androidx.compose.p004ui.platform.ViewRootForInspector
    @NotNull
    public View getViewRoot() {
        return this;
    }

    public final void setFactory(@Nullable Function1<? super Context, ? extends T> function1) {
        this.factory = function1;
        if (function1 != null) {
            Context context = getContext();
            Intrinsics.checkNotNullExpressionValue(context, "context");
            T t = (T) function1.invoke(context);
            this.typedView = t;
            setView$ui_release(t);
        }
    }

    public final void setTypedView$ui_release(@Nullable T t) {
        this.typedView = t;
    }

    public final void setUpdateBlock(@NotNull Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "value");
        this.updateBlock = function1;
        setUpdate(new Function0<Unit>(this) { // from class: androidx.compose.ui.viewinterop.ViewFactoryHolder$updateBlock$1
            final /* synthetic */ ViewFactoryHolder<T> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                this.this$0 = this;
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m5459invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m5459invoke() {
                View typedView$ui_release = this.this$0.getTypedView$ui_release();
                if (typedView$ui_release != null) {
                    this.this$0.getUpdateBlock().invoke(typedView$ui_release);
                }
            }
        });
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ViewFactoryHolder(@NotNull Context context, @Nullable CompositionContext compositionContext, @NotNull NestedScrollDispatcher nestedScrollDispatcher) {
        super(context, compositionContext, nestedScrollDispatcher);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(nestedScrollDispatcher, "dispatcher");
        setClipChildren(false);
        this.updateBlock = AndroidView_androidKt.getNoOpUpdate();
    }
}
