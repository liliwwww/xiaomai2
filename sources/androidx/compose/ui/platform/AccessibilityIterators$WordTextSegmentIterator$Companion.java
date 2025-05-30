package androidx.compose.ui.platform;

import android.taobao.windvane.config.WVConfigManager;
import androidx.compose.ui.platform.AccessibilityIterators;
import java.util.Locale;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class AccessibilityIterators$WordTextSegmentIterator$Companion {
    private AccessibilityIterators$WordTextSegmentIterator$Companion() {
    }

    public /* synthetic */ AccessibilityIterators$WordTextSegmentIterator$Companion(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    @NotNull
    public final AccessibilityIterators.WordTextSegmentIterator getInstance(@NotNull Locale locale) {
        Intrinsics.checkNotNullParameter(locale, WVConfigManager.CONFIGNAME_LOCALE);
        if (AccessibilityIterators.WordTextSegmentIterator.access$getInstance$cp() == null) {
            AccessibilityIterators.WordTextSegmentIterator.access$setInstance$cp(new AccessibilityIterators.WordTextSegmentIterator(locale, (DefaultConstructorMarker) null));
        }
        AccessibilityIterators.WordTextSegmentIterator access$getInstance$cp = AccessibilityIterators.WordTextSegmentIterator.access$getInstance$cp();
        Intrinsics.checkNotNull(access$getInstance$cp, "null cannot be cast to non-null type androidx.compose.ui.platform.AccessibilityIterators.WordTextSegmentIterator");
        return access$getInstance$cp;
    }
}
