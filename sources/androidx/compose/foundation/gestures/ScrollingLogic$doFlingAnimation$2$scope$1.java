package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import kotlin.jvm.functions.Function1;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class ScrollingLogic$doFlingAnimation$2$scope$1 implements ScrollScope {
    final /* synthetic */ Function1<Offset, Offset> $outerScopeScroll;
    final /* synthetic */ ScrollingLogic this$0;

    ScrollingLogic$doFlingAnimation$2$scope$1(ScrollingLogic scrollingLogic, Function1<? super Offset, Offset> function1) {
        this.this$0 = scrollingLogic;
        this.$outerScopeScroll = function1;
    }

    @Override // androidx.compose.foundation.gestures.ScrollScope
    public float scrollBy(float f) {
        ScrollingLogic scrollingLogic = this.this$0;
        return scrollingLogic.m251toFloatk4lQ0M(((Offset) this.$outerScopeScroll.invoke(Offset.box-impl(scrollingLogic.m252toOffsettuRUvjQ(f)))).unbox-impl());
    }
}
