package androidx.compose.ui.tooling;

import androidx.compose.animation.core.Transition;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ComposeViewAdapter$findAndTrackAnimations$animatedContentSearch$1 extends Lambda implements Function1<Object, Unit> {
    final /* synthetic */ ComposeViewAdapter this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeViewAdapter$findAndTrackAnimations$animatedContentSearch$1(ComposeViewAdapter composeViewAdapter) {
        super(1);
        this.this$0 = composeViewAdapter;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        m2088invoke(obj);
        return Unit.INSTANCE;
    }

    /* renamed from: invoke, reason: collision with other method in class */
    public final void m2088invoke(@NotNull Object obj) {
        Intrinsics.checkNotNullParameter(obj, "it");
        this.this$0.getClock$ui_tooling_release().trackAnimatedContent((Transition) obj);
    }
}
