package androidx.compose.runtime;

import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes2.dex */
public final class SkippableUpdater<T> {

    @NotNull
    private final Composer composer;

    private /* synthetic */ SkippableUpdater(Composer composer) {
        this.composer = composer;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SkippableUpdater m2398boximpl(Composer composer) {
        return new SkippableUpdater(composer);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m2399constructorimpl(@NotNull Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        return composer;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2400equalsimpl(Composer composer, Object obj) {
        return (obj instanceof SkippableUpdater) && Intrinsics.areEqual(composer, ((SkippableUpdater) obj).m2405unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2401equalsimpl0(Composer composer, Composer composer2) {
        return Intrinsics.areEqual(composer, composer2);
    }

    @PublishedApi
    public static /* synthetic */ void getComposer$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2402hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2403toStringimpl(Composer composer) {
        return "SkippableUpdater(composer=" + composer + ')';
    }

    /* renamed from: update-impl, reason: not valid java name */
    public static final void m2404updateimpl(Composer composer, @NotNull Function1<? super Updater<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        composer.startReplaceableGroup(509942095);
        function1.invoke(Updater.m2409boximpl(Updater.m2410constructorimpl(composer)));
        composer.endReplaceableGroup();
    }

    public boolean equals(Object obj) {
        return m2400equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m2402hashCodeimpl(this.composer);
    }

    public String toString() {
        return m2403toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Composer m2405unboximpl() {
        return this.composer;
    }
}
