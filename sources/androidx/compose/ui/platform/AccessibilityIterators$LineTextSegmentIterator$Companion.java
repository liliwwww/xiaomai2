package androidx.compose.ui.platform;

import androidx.compose.ui.platform.AccessibilityIterators;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class AccessibilityIterators$LineTextSegmentIterator$Companion {
    private AccessibilityIterators$LineTextSegmentIterator$Companion() {
    }

    public /* synthetic */ AccessibilityIterators$LineTextSegmentIterator$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final AccessibilityIterators.LineTextSegmentIterator getInstance() {
        if (AccessibilityIterators.LineTextSegmentIterator.access$getLineInstance$cp() == null) {
            AccessibilityIterators.LineTextSegmentIterator.access$setLineInstance$cp(new AccessibilityIterators.LineTextSegmentIterator((DefaultConstructorMarker) null));
        }
        AccessibilityIterators.LineTextSegmentIterator access$getLineInstance$cp = AccessibilityIterators.LineTextSegmentIterator.access$getLineInstance$cp();
        Intrinsics.checkNotNull(access$getLineInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.LineTextSegmentIterator");
        return access$getLineInstance$cp;
    }
}
