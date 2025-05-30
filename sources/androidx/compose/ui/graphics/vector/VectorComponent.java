package androidx.compose.ui.graphics.vector;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.IntSizeKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class VectorComponent extends VNode {

    @NotNull
    private final DrawCache cacheDrawScope;

    @NotNull
    private final Function1<DrawScope, Unit> drawVectorBlock;

    @NotNull
    private final MutableState intrinsicColorFilter$delegate;

    @NotNull
    private Function0<Unit> invalidateCallback;
    private boolean isDirty;
    private long previousDrawSize;

    @NotNull
    private final GroupComponent root;
    private float viewportHeight;
    private float viewportWidth;

    public VectorComponent() {
        super((DefaultConstructorMarker) null);
        MutableState mutableStateOf$default;
        GroupComponent groupComponent = new GroupComponent();
        groupComponent.setPivotX(0.0f);
        groupComponent.setPivotY(0.0f);
        groupComponent.setInvalidateListener$ui_release(new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$root$1$1
            {
                super(0);
            }

            public /* bridge */ /* synthetic */ Object invoke() {
                m1335invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1335invoke() {
                VectorComponent.this.doInvalidate();
            }
        });
        this.root = groupComponent;
        this.isDirty = true;
        this.cacheDrawScope = new DrawCache();
        this.invalidateCallback = new Function0<Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$invalidateCallback$1
            public /* bridge */ /* synthetic */ Object invoke() {
                m1334invoke();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m1334invoke() {
            }
        };
        mutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
        this.intrinsicColorFilter$delegate = mutableStateOf$default;
        this.previousDrawSize = Size.Companion.getUnspecified-NH-jbRc();
        this.drawVectorBlock = new Function1<DrawScope, Unit>() { // from class: androidx.compose.ui.graphics.vector.VectorComponent$drawVectorBlock$1
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DrawScope) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull DrawScope drawScope) {
                Intrinsics.checkNotNullParameter(drawScope, "$this$null");
                VectorComponent.this.getRoot().draw(drawScope);
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void doInvalidate() {
        this.isDirty = true;
        this.invalidateCallback.invoke();
    }

    public final void draw(@NotNull DrawScope drawScope, float f, @Nullable ColorFilter colorFilter) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        if (colorFilter == null) {
            colorFilter = getIntrinsicColorFilter$ui_release();
        }
        if (this.isDirty || !Size.equals-impl0(this.previousDrawSize, drawScope.getSize-NH-jbRc())) {
            this.root.setScaleX(Size.getWidth-impl(drawScope.getSize-NH-jbRc()) / this.viewportWidth);
            this.root.setScaleY(Size.getHeight-impl(drawScope.getSize-NH-jbRc()) / this.viewportHeight);
            this.cacheDrawScope.m1321drawCachedImageCJJARo(IntSizeKt.IntSize((int) Math.ceil(Size.getWidth-impl(drawScope.getSize-NH-jbRc())), (int) Math.ceil(Size.getHeight-impl(drawScope.getSize-NH-jbRc()))), drawScope, drawScope.getLayoutDirection(), this.drawVectorBlock);
            this.isDirty = false;
            this.previousDrawSize = drawScope.getSize-NH-jbRc();
        }
        this.cacheDrawScope.drawInto(drawScope, f, colorFilter);
    }

    @Nullable
    public final ColorFilter getIntrinsicColorFilter$ui_release() {
        return (ColorFilter) this.intrinsicColorFilter$delegate.getValue();
    }

    @NotNull
    public final Function0<Unit> getInvalidateCallback$ui_release() {
        return this.invalidateCallback;
    }

    @NotNull
    public final String getName() {
        return this.root.getName();
    }

    @NotNull
    public final GroupComponent getRoot() {
        return this.root;
    }

    public final float getViewportHeight() {
        return this.viewportHeight;
    }

    public final float getViewportWidth() {
        return this.viewportWidth;
    }

    public final void setIntrinsicColorFilter$ui_release(@Nullable ColorFilter colorFilter) {
        this.intrinsicColorFilter$delegate.setValue(colorFilter);
    }

    public final void setInvalidateCallback$ui_release(@NotNull Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(function0, "<set-?>");
        this.invalidateCallback = function0;
    }

    public final void setName(@NotNull String str) {
        Intrinsics.checkNotNullParameter(str, "value");
        this.root.setName(str);
    }

    public final void setViewportHeight(float f) {
        if (this.viewportHeight == f) {
            return;
        }
        this.viewportHeight = f;
        doInvalidate();
    }

    public final void setViewportWidth(float f) {
        if (this.viewportWidth == f) {
            return;
        }
        this.viewportWidth = f;
        doInvalidate();
    }

    @NotNull
    public String toString() {
        String str = "Params: \tname: " + getName() + "\n\tviewportWidth: " + this.viewportWidth + "\n\tviewportHeight: " + this.viewportHeight + "\n";
        Intrinsics.checkNotNullExpressionValue(str, "StringBuilder().apply(builderAction).toString()");
        return str;
    }

    public void draw(@NotNull DrawScope drawScope) {
        Intrinsics.checkNotNullParameter(drawScope, "<this>");
        draw(drawScope, 1.0f, null);
    }
}
