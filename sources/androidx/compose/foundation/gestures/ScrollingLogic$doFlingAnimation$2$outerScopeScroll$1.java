package androidx.compose.foundation.gestures;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1 extends Lambda implements Function1<Offset, Offset> {
    final /* synthetic */ ScrollScope $$this$scroll;
    final /* synthetic */ ScrollingLogic this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScrollingLogic$doFlingAnimation$2$outerScopeScroll$1(ScrollingLogic scrollingLogic, ScrollScope scrollScope) {
        super(1);
        this.this$0 = scrollingLogic;
        this.$$this$scroll = scrollScope;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return Offset.box-impl(m254invokeMKHz9U(((Offset) obj).unbox-impl()));
    }

    /* renamed from: invoke-MK-Hz9U, reason: not valid java name */
    public final long m254invokeMKHz9U(long j) {
        ScrollingLogic scrollingLogic = this.this$0;
        return scrollingLogic.m247reverseIfNeededMKHz9U(scrollingLogic.m242dispatchScroll3eAAhYA(this.$$this$scroll, scrollingLogic.m247reverseIfNeededMKHz9U(j), NestedScrollSource.Companion.getFling-WNlRxjI()));
    }
}
