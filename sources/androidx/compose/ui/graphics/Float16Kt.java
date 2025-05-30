package androidx.compose.ui.graphics;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Float16Kt {
    /* renamed from: max-AoSsdG0, reason: not valid java name */
    public static final short m1128maxAoSsdG0(short s, short s2) {
        return (Float16.isNaN-impl(s) || Float16.isNaN-impl(s2)) ? Float16.Companion.m1123getNaNslo4al4() : Float16.compareTo-41bOqos(s, s2) >= 0 ? s : s2;
    }

    /* renamed from: min-AoSsdG0, reason: not valid java name */
    public static final short m1129minAoSsdG0(short s, short s2) {
        return (Float16.isNaN-impl(s) || Float16.isNaN-impl(s2)) ? Float16.Companion.m1123getNaNslo4al4() : Float16.compareTo-41bOqos(s, s2) <= 0 ? s : s2;
    }
}
