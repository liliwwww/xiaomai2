package androidx.compose.material;

import androidx.compose.p004ui.graphics.Color;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: classes2.dex */
public final class Colors {

    @NotNull
    private final MutableState background$delegate;

    @NotNull
    private final MutableState error$delegate;

    @NotNull
    private final MutableState isLight$delegate;

    @NotNull
    private final MutableState onBackground$delegate;

    @NotNull
    private final MutableState onError$delegate;

    @NotNull
    private final MutableState onPrimary$delegate;

    @NotNull
    private final MutableState onSecondary$delegate;

    @NotNull
    private final MutableState onSurface$delegate;

    @NotNull
    private final MutableState primary$delegate;

    @NotNull
    private final MutableState primaryVariant$delegate;

    @NotNull
    private final MutableState secondary$delegate;

    @NotNull
    private final MutableState secondaryVariant$delegate;

    @NotNull
    private final MutableState surface$delegate;

    private Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z) {
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j2), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j3), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j4), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.m2777boximpl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight$delegate = SnapshotStateKt.mutableStateOf(Boolean.valueOf(z), SnapshotStateKt.structuralEqualityPolicy());
    }

    public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z);
    }

    @NotNull
    /* renamed from: copy-pvPzIIM, reason: not valid java name */
    public final Colors m2008copypvPzIIM(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m2009getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m2010getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m2011getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m2012getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m2013getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m2014getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m2015getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m2016getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m2017getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m2018getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m2019getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m2020getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).m2797unboximpl();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isLight() {
        return ((Boolean) this.isLight$delegate.getValue()).booleanValue();
    }

    /* renamed from: setBackground-8_81llA$material_release, reason: not valid java name */
    public final void m2021setBackground8_81llA$material_release(long j) {
        this.background$delegate.setValue(Color.m2777boximpl(j));
    }

    /* renamed from: setError-8_81llA$material_release, reason: not valid java name */
    public final void m2022setError8_81llA$material_release(long j) {
        this.error$delegate.setValue(Color.m2777boximpl(j));
    }

    public final void setLight$material_release(boolean z) {
        this.isLight$delegate.setValue(Boolean.valueOf(z));
    }

    /* renamed from: setOnBackground-8_81llA$material_release, reason: not valid java name */
    public final void m2023setOnBackground8_81llA$material_release(long j) {
        this.onBackground$delegate.setValue(Color.m2777boximpl(j));
    }

    /* renamed from: setOnError-8_81llA$material_release, reason: not valid java name */
    public final void m2024setOnError8_81llA$material_release(long j) {
        this.onError$delegate.setValue(Color.m2777boximpl(j));
    }

    /* renamed from: setOnPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m2025setOnPrimary8_81llA$material_release(long j) {
        this.onPrimary$delegate.setValue(Color.m2777boximpl(j));
    }

    /* renamed from: setOnSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m2026setOnSecondary8_81llA$material_release(long j) {
        this.onSecondary$delegate.setValue(Color.m2777boximpl(j));
    }

    /* renamed from: setOnSurface-8_81llA$material_release, reason: not valid java name */
    public final void m2027setOnSurface8_81llA$material_release(long j) {
        this.onSurface$delegate.setValue(Color.m2777boximpl(j));
    }

    /* renamed from: setPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m2028setPrimary8_81llA$material_release(long j) {
        this.primary$delegate.setValue(Color.m2777boximpl(j));
    }

    /* renamed from: setPrimaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m2029setPrimaryVariant8_81llA$material_release(long j) {
        this.primaryVariant$delegate.setValue(Color.m2777boximpl(j));
    }

    /* renamed from: setSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m2030setSecondary8_81llA$material_release(long j) {
        this.secondary$delegate.setValue(Color.m2777boximpl(j));
    }

    /* renamed from: setSecondaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m2031setSecondaryVariant8_81llA$material_release(long j) {
        this.secondaryVariant$delegate.setValue(Color.m2777boximpl(j));
    }

    /* renamed from: setSurface-8_81llA$material_release, reason: not valid java name */
    public final void m2032setSurface8_81llA$material_release(long j) {
        this.surface$delegate.setValue(Color.m2777boximpl(j));
    }

    @NotNull
    public String toString() {
        return "Colors(primary=" + ((Object) Color.m2795toStringimpl(m2016getPrimary0d7_KjU())) + ", primaryVariant=" + ((Object) Color.m2795toStringimpl(m2017getPrimaryVariant0d7_KjU())) + ", secondary=" + ((Object) Color.m2795toStringimpl(m2018getSecondary0d7_KjU())) + ", secondaryVariant=" + ((Object) Color.m2795toStringimpl(m2019getSecondaryVariant0d7_KjU())) + ", background=" + ((Object) Color.m2795toStringimpl(m2009getBackground0d7_KjU())) + ", surface=" + ((Object) Color.m2795toStringimpl(m2020getSurface0d7_KjU())) + ", error=" + ((Object) Color.m2795toStringimpl(m2010getError0d7_KjU())) + ", onPrimary=" + ((Object) Color.m2795toStringimpl(m2013getOnPrimary0d7_KjU())) + ", onSecondary=" + ((Object) Color.m2795toStringimpl(m2014getOnSecondary0d7_KjU())) + ", onBackground=" + ((Object) Color.m2795toStringimpl(m2011getOnBackground0d7_KjU())) + ", onSurface=" + ((Object) Color.m2795toStringimpl(m2015getOnSurface0d7_KjU())) + ", onError=" + ((Object) Color.m2795toStringimpl(m2012getOnError0d7_KjU())) + ", isLight=" + isLight() + ')';
    }
}
