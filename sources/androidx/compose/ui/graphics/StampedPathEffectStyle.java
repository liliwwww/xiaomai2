package androidx.compose.ui.graphics;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class StampedPathEffectStyle {
    private final int value;

    @NotNull
    public static final Companion Companion = new Companion(null);
    private static final int Translate = m1235constructorimpl(0);
    private static final int Rotate = m1235constructorimpl(1);
    private static final int Morph = m1235constructorimpl(2);

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getMorph-Ypspkwk, reason: not valid java name */
        public final int m1241getMorphYpspkwk() {
            return StampedPathEffectStyle.Morph;
        }

        /* renamed from: getRotate-Ypspkwk, reason: not valid java name */
        public final int m1242getRotateYpspkwk() {
            return StampedPathEffectStyle.Rotate;
        }

        /* renamed from: getTranslate-Ypspkwk, reason: not valid java name */
        public final int m1243getTranslateYpspkwk() {
            return StampedPathEffectStyle.Translate;
        }
    }

    private /* synthetic */ StampedPathEffectStyle(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ StampedPathEffectStyle m1234boximpl(int i) {
        return new StampedPathEffectStyle(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m1235constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m1236equalsimpl(int i, Object obj) {
        return (obj instanceof StampedPathEffectStyle) && i == ((StampedPathEffectStyle) obj).m1240unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m1237equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m1238hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m1239toStringimpl(int i) {
        return m1237equalsimpl0(i, Translate) ? "Translate" : m1237equalsimpl0(i, Rotate) ? "Rotate" : m1237equalsimpl0(i, Morph) ? "Morph" : "Unknown";
    }

    public boolean equals(Object obj) {
        return m1236equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m1238hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m1239toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m1240unboximpl() {
        return this.value;
    }
}
