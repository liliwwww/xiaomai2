package androidx.compose.ui.text.font;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class FontStyle$Companion {
    private FontStyle$Companion() {
    }

    public /* synthetic */ FontStyle$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    /* renamed from: getItalic-_-LCdwA, reason: not valid java name */
    public final int m2383getItalic_LCdwA() {
        return FontStyle.access$getItalic$cp();
    }

    /* renamed from: getNormal-_-LCdwA, reason: not valid java name */
    public final int m2384getNormal_LCdwA() {
        return FontStyle.access$getNormal$cp();
    }

    @NotNull
    public final List<FontStyle> values() {
        return CollectionsKt.listOf(new FontStyle[]{FontStyle.box-impl(m2384getNormal_LCdwA()), FontStyle.box-impl(m2383getItalic_LCdwA())});
    }
}
