package androidx.compose.ui.layout;

import androidx.compose.runtime.Composer;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.LayoutDirection;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.jw0;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class LayoutNodeSubcompositionsState$Scope implements SubcomposeMeasureScope {
    private float density;
    private float fontScale;

    @NotNull
    private LayoutDirection layoutDirection = LayoutDirection.Rtl;
    final /* synthetic */ LayoutNodeSubcompositionsState this$0;

    public LayoutNodeSubcompositionsState$Scope(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState) {
        this.this$0 = layoutNodeSubcompositionsState;
    }

    public float getDensity() {
        return this.density;
    }

    public float getFontScale() {
        return this.fontScale;
    }

    @NotNull
    public LayoutDirection getLayoutDirection() {
        return this.layoutDirection;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ MeasureResult layout(int i, int i2, Map map, Function1 function1) {
        return MeasureScope.-CC.a(this, i, i2, map, function1);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: roundToPx--R2X_6o, reason: not valid java name */
    public /* synthetic */ int m1528roundToPxR2X_6o(long j) {
        return jw0.a(this, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: roundToPx-0680j_4, reason: not valid java name */
    public /* synthetic */ int m1529roundToPx0680j_4(float f) {
        return jw0.b(this, f);
    }

    public void setDensity(float f) {
        this.density = f;
    }

    public void setFontScale(float f) {
        this.fontScale = f;
    }

    public void setLayoutDirection(@NotNull LayoutDirection layoutDirection) {
        Intrinsics.checkNotNullParameter(layoutDirection, "<set-?>");
        this.layoutDirection = layoutDirection;
    }

    @NotNull
    public List<Measurable> subcompose(@Nullable Object obj, @NotNull Function2<? super Composer, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "content");
        return this.this$0.subcompose(obj, function2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toDp-GaN1DYA, reason: not valid java name */
    public /* synthetic */ float m1530toDpGaN1DYA(long j) {
        return jw0.c(this, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public /* synthetic */ float m1531toDpu2uoSUM(float f) {
        return jw0.d(this, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toDp-u2uoSUM, reason: not valid java name */
    public /* synthetic */ float m1532toDpu2uoSUM(int i) {
        return jw0.e(this, i);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toDpSize-k-rfVVM, reason: not valid java name */
    public /* synthetic */ long m1533toDpSizekrfVVM(long j) {
        return jw0.f(this, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toPx--R2X_6o, reason: not valid java name */
    public /* synthetic */ float m1534toPxR2X_6o(long j) {
        return jw0.g(this, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toPx-0680j_4, reason: not valid java name */
    public /* synthetic */ float m1535toPx0680j_4(float f) {
        return jw0.h(this, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public /* synthetic */ Rect toRect(DpRect dpRect) {
        return jw0.i(this, dpRect);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toSize-XkaWNTQ, reason: not valid java name */
    public /* synthetic */ long m1536toSizeXkaWNTQ(long j) {
        return jw0.j(this, j);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toSp-0xMU5do, reason: not valid java name */
    public /* synthetic */ long m1537toSp0xMU5do(float f) {
        return jw0.k(this, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public /* synthetic */ long m1538toSpkPz2Gy4(float f) {
        return jw0.l(this, f);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: toSp-kPz2Gy4, reason: not valid java name */
    public /* synthetic */ long m1539toSpkPz2Gy4(int i) {
        return jw0.m(this, i);
    }
}
