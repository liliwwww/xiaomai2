package androidx.compose.p004ui.graphics;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class Float16Kt {
    /* renamed from: max-AoSsdG0, reason: not valid java name */
    public static final short m2928maxAoSsdG0(short s, short s2) {
        return (Float16.m2901isNaNimpl(s) || Float16.m2901isNaNimpl(s2)) ? Float16.Companion.m2923getNaNslo4al4() : Float16.m2888compareTo41bOqos(s, s2) >= 0 ? s : s2;
    }

    /* renamed from: min-AoSsdG0, reason: not valid java name */
    public static final short m2929minAoSsdG0(short s, short s2) {
        return (Float16.m2901isNaNimpl(s) || Float16.m2901isNaNimpl(s2)) ? Float16.Companion.m2923getNaNslo4al4() : Float16.m2888compareTo41bOqos(s, s2) <= 0 ? s : s2;
    }
}
