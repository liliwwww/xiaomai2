package androidx.activity;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.CallSuper;
import androidx.annotation.StyleRes;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.x40;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ComponentDialog extends Dialog implements OnBackPressedDispatcherOwner, LifecycleOwner {

    @Nullable
    private LifecycleRegistry _lifecycleRegistry;

    @NotNull
    private final OnBackPressedDispatcher onBackPressedDispatcher;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ComponentDialog(@NotNull Context context) {
        this(context, 0, 2, null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public /* synthetic */ ComponentDialog(Context context, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? 0 : i);
    }

    private final LifecycleRegistry getLifecycleRegistry() {
        LifecycleRegistry lifecycleRegistry = this._lifecycleRegistry;
        if (lifecycleRegistry != null) {
            return lifecycleRegistry;
        }
        LifecycleRegistry lifecycleRegistry2 = new LifecycleRegistry(this);
        this._lifecycleRegistry = lifecycleRegistry2;
        return lifecycleRegistry2;
    }

    private static /* synthetic */ void getOnBackPressedDispatcher$annotations() {
    }

    private final void initViewTreeOwners() {
        Window window = getWindow();
        Intrinsics.checkNotNull(window);
        ViewTreeLifecycleOwner.set(window.getDecorView(), this);
        Window window2 = getWindow();
        Intrinsics.checkNotNull(window2);
        View decorView = window2.getDecorView();
        Intrinsics.checkNotNullExpressionValue(decorView, "window!!.decorView");
        ViewTreeOnBackPressedDispatcherOwner.set(decorView, this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: onBackPressedDispatcher$lambda-1, reason: not valid java name */
    public static final void m4onBackPressedDispatcher$lambda1(ComponentDialog componentDialog) {
        Intrinsics.checkNotNullParameter(componentDialog, "this$0");
        super.onBackPressed();
    }

    @Override // android.app.Dialog
    public void addContentView(@NotNull View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        initViewTreeOwners();
        super.addContentView(view, layoutParams);
    }

    @NotNull
    public final Lifecycle getLifecycle() {
        return getLifecycleRegistry();
    }

    @NotNull
    public final OnBackPressedDispatcher getOnBackPressedDispatcher() {
        return this.onBackPressedDispatcher;
    }

    @Override // android.app.Dialog
    @CallSuper
    public void onBackPressed() {
        this.onBackPressedDispatcher.onBackPressed();
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        if (Build.VERSION.SDK_INT >= 33) {
            this.onBackPressedDispatcher.setOnBackInvokedDispatcher(getOnBackInvokedDispatcher());
        }
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle$Event.ON_CREATE);
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onStart() {
        super.onStart();
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle$Event.ON_RESUME);
    }

    @Override // android.app.Dialog
    @CallSuper
    protected void onStop() {
        getLifecycleRegistry().handleLifecycleEvent(Lifecycle$Event.ON_DESTROY);
        this._lifecycleRegistry = null;
        super.onStop();
    }

    @Override // android.app.Dialog
    public void setContentView(int i) {
        initViewTreeOwners();
        super.setContentView(i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    @JvmOverloads
    public ComponentDialog(@NotNull Context context, @StyleRes int i) {
        super(context, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.onBackPressedDispatcher = new OnBackPressedDispatcher(new x40(this));
    }

    @Override // android.app.Dialog
    public void setContentView(@NotNull View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        initViewTreeOwners();
        super.setContentView(view);
    }

    @Override // android.app.Dialog
    public void setContentView(@NotNull View view, @Nullable ViewGroup.LayoutParams layoutParams) {
        Intrinsics.checkNotNullParameter(view, "view");
        initViewTreeOwners();
        super.setContentView(view, layoutParams);
    }
}
