package androidx.compose.runtime;

import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class SkippableUpdater<T> {

    @NotNull
    private final Composer composer;

    private /* synthetic */ SkippableUpdater(Composer composer) {
        this.composer = composer;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ SkippableUpdater m907boximpl(Composer composer) {
        return new SkippableUpdater(composer);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m908constructorimpl(@NotNull Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        return composer;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m909equalsimpl(Composer composer, Object obj) {
        return (obj instanceof SkippableUpdater) && Intrinsics.areEqual(composer, ((SkippableUpdater) obj).m914unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m910equalsimpl0(Composer composer, Composer composer2) {
        return Intrinsics.areEqual(composer, composer2);
    }

    @PublishedApi
    public static /* synthetic */ void getComposer$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m911hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m912toStringimpl(Composer composer) {
        return "SkippableUpdater(composer=" + composer + ')';
    }

    /* renamed from: update-impl, reason: not valid java name */
    public static final void m913updateimpl(Composer composer, @NotNull Function1<? super Updater<T>, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        composer.startReplaceableGroup(509942095);
        function1.invoke(Updater.box-impl(Updater.constructor-impl(composer)));
        composer.endReplaceableGroup();
    }

    public boolean equals(Object obj) {
        return m909equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m911hashCodeimpl(this.composer);
    }

    public String toString() {
        return m912toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Composer m914unboximpl() {
        return this.composer;
    }
}
