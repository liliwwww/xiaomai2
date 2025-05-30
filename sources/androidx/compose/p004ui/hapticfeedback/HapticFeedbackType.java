package androidx.compose.p004ui.hapticfeedback;

import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class HapticFeedbackType {

    @NotNull
    public static final Companion Companion = new Companion(null);
    private final int value;

    /* compiled from: Taobao */
    /* loaded from: classes2.dex */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getLongPress-5zf0vsI, reason: not valid java name */
        public final int m3349getLongPress5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m3351getLongPress5zf0vsI();
        }

        /* renamed from: getTextHandleMove-5zf0vsI, reason: not valid java name */
        public final int m3350getTextHandleMove5zf0vsI() {
            return PlatformHapticFeedbackType.INSTANCE.m3352getTextHandleMove5zf0vsI();
        }

        @NotNull
        public final List<HapticFeedbackType> values() {
            return CollectionsKt.listOf(new HapticFeedbackType[]{HapticFeedbackType.m3342boximpl(m3349getLongPress5zf0vsI()), HapticFeedbackType.m3342boximpl(m3350getTextHandleMove5zf0vsI())});
        }
    }

    private /* synthetic */ HapticFeedbackType(int i) {
        this.value = i;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ HapticFeedbackType m3342boximpl(int i) {
        return new HapticFeedbackType(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m3343constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3344equalsimpl(int i, Object obj) {
        return (obj instanceof HapticFeedbackType) && i == ((HapticFeedbackType) obj).m3348unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3345equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3346hashCodeimpl(int i) {
        return i;
    }

    @NotNull
    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3347toStringimpl(int i) {
        Companion companion = Companion;
        return m3345equalsimpl0(i, companion.m3349getLongPress5zf0vsI()) ? "LongPress" : m3345equalsimpl0(i, companion.m3350getTextHandleMove5zf0vsI()) ? "TextHandleMove" : "Invalid";
    }

    public boolean equals(Object obj) {
        return m3344equalsimpl(this.value, obj);
    }

    public int hashCode() {
        return m3346hashCodeimpl(this.value);
    }

    @NotNull
    public String toString() {
        return m3347toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3348unboximpl() {
        return this.value;
    }
}
