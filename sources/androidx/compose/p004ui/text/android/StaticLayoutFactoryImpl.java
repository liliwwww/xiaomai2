package androidx.compose.p004ui.text.android;

import android.text.StaticLayout;
import androidx.annotation.DoNotInline;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
interface StaticLayoutFactoryImpl {
    @DoNotInline
    @NotNull
    StaticLayout create(@NotNull StaticLayoutParams staticLayoutParams);

    boolean isFallbackLineSpacingEnabled(@NotNull StaticLayout staticLayout, boolean z);
}
