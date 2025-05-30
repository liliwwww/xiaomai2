package androidx.compose.ui.text.style;

import androidx.compose.runtime.Immutable;
import androidx.compose.ui.text.ExperimentalTextApi;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.l3;

/* compiled from: Taobao */
@Immutable
@ExperimentalTextApi
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextMotion {

    @NotNull
    private static final TextMotion Animated;

    @NotNull
    public static final Companion Companion;

    @NotNull
    private static final TextMotion Static;
    private final int linearity;
    private final boolean subpixelTextPositioning;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @NotNull
        public final TextMotion getAnimated() {
            return TextMotion.Animated;
        }

        @NotNull
        public final TextMotion getStatic() {
            return TextMotion.Static;
        }
    }

    static {
        DefaultConstructorMarker defaultConstructorMarker = null;
        Companion = new Companion(defaultConstructorMarker);
        TextMotion$Linearity$Companion textMotion$Linearity$Companion = Linearity.Companion;
        Static = new TextMotion(textMotion$Linearity$Companion.m2081getFontHinting4e0Vf04(), false, defaultConstructorMarker);
        Animated = new TextMotion(textMotion$Linearity$Companion.m2082getLinear4e0Vf04(), true, defaultConstructorMarker);
    }

    private TextMotion(int i, boolean z) {
        this.linearity = i;
        this.subpixelTextPositioning = z;
    }

    public /* synthetic */ TextMotion(int i, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(i, z);
    }

    /* renamed from: copy-JdDtMQo$ui_text_release$default, reason: not valid java name */
    public static /* synthetic */ TextMotion m2078copyJdDtMQo$ui_text_release$default(TextMotion textMotion, int i, boolean z, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            i = textMotion.linearity;
        }
        if ((i2 & 2) != 0) {
            z = textMotion.subpixelTextPositioning;
        }
        return textMotion.m2079copyJdDtMQo$ui_text_release(i, z);
    }

    @NotNull
    /* renamed from: copy-JdDtMQo$ui_text_release, reason: not valid java name */
    public final TextMotion m2079copyJdDtMQo$ui_text_release(int i, boolean z) {
        return new TextMotion(i, z, null);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextMotion)) {
            return false;
        }
        TextMotion textMotion = (TextMotion) obj;
        return Linearity.equals-impl0(this.linearity, textMotion.linearity) && this.subpixelTextPositioning == textMotion.subpixelTextPositioning;
    }

    /* renamed from: getLinearity-4e0Vf04$ui_text_release, reason: not valid java name */
    public final int m2080getLinearity4e0Vf04$ui_text_release() {
        return this.linearity;
    }

    public final boolean getSubpixelTextPositioning$ui_text_release() {
        return this.subpixelTextPositioning;
    }

    public int hashCode() {
        return (Linearity.hashCode-impl(this.linearity) * 31) + l3.a(this.subpixelTextPositioning);
    }

    @NotNull
    public String toString() {
        return Intrinsics.areEqual(this, Static) ? "TextMotion.Static" : Intrinsics.areEqual(this, Animated) ? "TextMotion.Animated" : "Invalid";
    }
}
