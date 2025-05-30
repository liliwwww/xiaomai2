package androidx.compose.material;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Stable;
import androidx.compose.ui.graphics.Color;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Stable
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
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
        this.primary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j), SnapshotStateKt.structuralEqualityPolicy());
        this.primaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j2), SnapshotStateKt.structuralEqualityPolicy());
        this.secondary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j3), SnapshotStateKt.structuralEqualityPolicy());
        this.secondaryVariant$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j4), SnapshotStateKt.structuralEqualityPolicy());
        this.background$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j5), SnapshotStateKt.structuralEqualityPolicy());
        this.surface$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j6), SnapshotStateKt.structuralEqualityPolicy());
        this.error$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j7), SnapshotStateKt.structuralEqualityPolicy());
        this.onPrimary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j8), SnapshotStateKt.structuralEqualityPolicy());
        this.onSecondary$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j9), SnapshotStateKt.structuralEqualityPolicy());
        this.onBackground$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j10), SnapshotStateKt.structuralEqualityPolicy());
        this.onSurface$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j11), SnapshotStateKt.structuralEqualityPolicy());
        this.onError$delegate = SnapshotStateKt.mutableStateOf(Color.box-impl(j12), SnapshotStateKt.structuralEqualityPolicy());
        this.isLight$delegate = SnapshotStateKt.mutableStateOf(Boolean.valueOf(z), SnapshotStateKt.structuralEqualityPolicy());
    }

    public /* synthetic */ Colors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z);
    }

    @NotNull
    /* renamed from: copy-pvPzIIM, reason: not valid java name */
    public final Colors m687copypvPzIIM(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, long j9, long j10, long j11, long j12, boolean z) {
        return new Colors(j, j2, j3, j4, j5, j6, j7, j8, j9, j10, j11, j12, z, null);
    }

    /* renamed from: getBackground-0d7_KjU, reason: not valid java name */
    public final long m688getBackground0d7_KjU() {
        return ((Color) this.background$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getError-0d7_KjU, reason: not valid java name */
    public final long m689getError0d7_KjU() {
        return ((Color) this.error$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getOnBackground-0d7_KjU, reason: not valid java name */
    public final long m690getOnBackground0d7_KjU() {
        return ((Color) this.onBackground$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getOnError-0d7_KjU, reason: not valid java name */
    public final long m691getOnError0d7_KjU() {
        return ((Color) this.onError$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getOnPrimary-0d7_KjU, reason: not valid java name */
    public final long m692getOnPrimary0d7_KjU() {
        return ((Color) this.onPrimary$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getOnSecondary-0d7_KjU, reason: not valid java name */
    public final long m693getOnSecondary0d7_KjU() {
        return ((Color) this.onSecondary$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getOnSurface-0d7_KjU, reason: not valid java name */
    public final long m694getOnSurface0d7_KjU() {
        return ((Color) this.onSurface$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getPrimary-0d7_KjU, reason: not valid java name */
    public final long m695getPrimary0d7_KjU() {
        return ((Color) this.primary$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getPrimaryVariant-0d7_KjU, reason: not valid java name */
    public final long m696getPrimaryVariant0d7_KjU() {
        return ((Color) this.primaryVariant$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getSecondary-0d7_KjU, reason: not valid java name */
    public final long m697getSecondary0d7_KjU() {
        return ((Color) this.secondary$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getSecondaryVariant-0d7_KjU, reason: not valid java name */
    public final long m698getSecondaryVariant0d7_KjU() {
        return ((Color) this.secondaryVariant$delegate.getValue()).unbox-impl();
    }

    /* renamed from: getSurface-0d7_KjU, reason: not valid java name */
    public final long m699getSurface0d7_KjU() {
        return ((Color) this.surface$delegate.getValue()).unbox-impl();
    }

    public final boolean isLight() {
        return ((Boolean) this.isLight$delegate.getValue()).booleanValue();
    }

    /* renamed from: setBackground-8_81llA$material_release, reason: not valid java name */
    public final void m700setBackground8_81llA$material_release(long j) {
        this.background$delegate.setValue(Color.box-impl(j));
    }

    /* renamed from: setError-8_81llA$material_release, reason: not valid java name */
    public final void m701setError8_81llA$material_release(long j) {
        this.error$delegate.setValue(Color.box-impl(j));
    }

    public final void setLight$material_release(boolean z) {
        this.isLight$delegate.setValue(Boolean.valueOf(z));
    }

    /* renamed from: setOnBackground-8_81llA$material_release, reason: not valid java name */
    public final void m702setOnBackground8_81llA$material_release(long j) {
        this.onBackground$delegate.setValue(Color.box-impl(j));
    }

    /* renamed from: setOnError-8_81llA$material_release, reason: not valid java name */
    public final void m703setOnError8_81llA$material_release(long j) {
        this.onError$delegate.setValue(Color.box-impl(j));
    }

    /* renamed from: setOnPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m704setOnPrimary8_81llA$material_release(long j) {
        this.onPrimary$delegate.setValue(Color.box-impl(j));
    }

    /* renamed from: setOnSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m705setOnSecondary8_81llA$material_release(long j) {
        this.onSecondary$delegate.setValue(Color.box-impl(j));
    }

    /* renamed from: setOnSurface-8_81llA$material_release, reason: not valid java name */
    public final void m706setOnSurface8_81llA$material_release(long j) {
        this.onSurface$delegate.setValue(Color.box-impl(j));
    }

    /* renamed from: setPrimary-8_81llA$material_release, reason: not valid java name */
    public final void m707setPrimary8_81llA$material_release(long j) {
        this.primary$delegate.setValue(Color.box-impl(j));
    }

    /* renamed from: setPrimaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m708setPrimaryVariant8_81llA$material_release(long j) {
        this.primaryVariant$delegate.setValue(Color.box-impl(j));
    }

    /* renamed from: setSecondary-8_81llA$material_release, reason: not valid java name */
    public final void m709setSecondary8_81llA$material_release(long j) {
        this.secondary$delegate.setValue(Color.box-impl(j));
    }

    /* renamed from: setSecondaryVariant-8_81llA$material_release, reason: not valid java name */
    public final void m710setSecondaryVariant8_81llA$material_release(long j) {
        this.secondaryVariant$delegate.setValue(Color.box-impl(j));
    }

    /* renamed from: setSurface-8_81llA$material_release, reason: not valid java name */
    public final void m711setSurface8_81llA$material_release(long j) {
        this.surface$delegate.setValue(Color.box-impl(j));
    }

    @NotNull
    public String toString() {
        return "Colors(primary=" + ((Object) Color.toString-impl(m695getPrimary0d7_KjU())) + ", primaryVariant=" + ((Object) Color.toString-impl(m696getPrimaryVariant0d7_KjU())) + ", secondary=" + ((Object) Color.toString-impl(m697getSecondary0d7_KjU())) + ", secondaryVariant=" + ((Object) Color.toString-impl(m698getSecondaryVariant0d7_KjU())) + ", background=" + ((Object) Color.toString-impl(m688getBackground0d7_KjU())) + ", surface=" + ((Object) Color.toString-impl(m699getSurface0d7_KjU())) + ", error=" + ((Object) Color.toString-impl(m689getError0d7_KjU())) + ", onPrimary=" + ((Object) Color.toString-impl(m692getOnPrimary0d7_KjU())) + ", onSecondary=" + ((Object) Color.toString-impl(m693getOnSecondary0d7_KjU())) + ", onBackground=" + ((Object) Color.toString-impl(m690getOnBackground0d7_KjU())) + ", onSurface=" + ((Object) Color.toString-impl(m694getOnSurface0d7_KjU())) + ", onError=" + ((Object) Color.toString-impl(m691getOnError0d7_KjU())) + ", isLight=" + isLight() + ')';
    }
}
