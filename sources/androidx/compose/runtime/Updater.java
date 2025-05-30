package androidx.compose.runtime;

import kotlin.PublishedApi;
import kotlin.Unit;
import kotlin.jvm.JvmInline;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@JvmInline
/* loaded from: classes.dex */
public final class Updater<T> {

    @NotNull
    private final Composer composer;

    private /* synthetic */ Updater(Composer composer) {
        this.composer = composer;
    }

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Updater m2409boximpl(Composer composer) {
        return new Updater(composer);
    }

    @NotNull
    /* renamed from: constructor-impl, reason: not valid java name */
    public static <T> Composer m2410constructorimpl(@NotNull Composer composer) {
        Intrinsics.checkNotNullParameter(composer, "composer");
        return composer;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m2411equalsimpl(Composer composer, Object obj) {
        return (obj instanceof Updater) && Intrinsics.areEqual(composer, ((Updater) obj).m2421unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m2412equalsimpl0(Composer composer, Composer composer2) {
        return Intrinsics.areEqual(composer, composer2);
    }

    @PublishedApi
    public static /* synthetic */ void getComposer$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m2413hashCodeimpl(Composer composer) {
        return composer.hashCode();
    }

    /* renamed from: init-impl, reason: not valid java name */
    public static final void m2414initimpl(Composer composer, @NotNull final Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        if (composer.getInserting()) {
            composer.apply(Unit.INSTANCE, new Function2<T, Unit, Unit>() { // from class: androidx.compose.runtime.Updater$init$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                    invoke((Updater$init$1<T>) obj, (Unit) obj2);
                    return Unit.INSTANCE;
                }

                public final void invoke(T t, @NotNull Unit unit) {
                    Intrinsics.checkNotNullParameter(unit, "it");
                    function1.invoke(t);
                }
            });
        }
    }

    /* renamed from: reconcile-impl, reason: not valid java name */
    public static final void m2415reconcileimpl(Composer composer, @NotNull final Function1<? super T, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "block");
        composer.apply(Unit.INSTANCE, new Function2<T, Unit, Unit>() { // from class: androidx.compose.runtime.Updater$reconcile$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(2);
            }

            /* JADX WARN: Multi-variable type inference failed */
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Updater$reconcile$1<T>) obj, (Unit) obj2);
                return Unit.INSTANCE;
            }

            public final void invoke(T t, @NotNull Unit unit) {
                Intrinsics.checkNotNullParameter(unit, "it");
                function1.invoke(t);
            }
        });
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final void m2416setimpl(Composer composer, int i, @NotNull Function2<? super T, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            composer.apply(Integer.valueOf(i), function2);
        }
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m2418toStringimpl(Composer composer) {
        return "Updater(composer=" + composer + ')';
    }

    /* renamed from: update-impl, reason: not valid java name */
    public static final void m2419updateimpl(Composer composer, int i, @NotNull Function2<? super T, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        boolean inserting = composer.getInserting();
        if (inserting || !Intrinsics.areEqual(composer.rememberedValue(), Integer.valueOf(i))) {
            composer.updateRememberedValue(Integer.valueOf(i));
            if (inserting) {
                return;
            }
            composer.apply(Integer.valueOf(i), function2);
        }
    }

    public boolean equals(Object obj) {
        return m2411equalsimpl(this.composer, obj);
    }

    public int hashCode() {
        return m2413hashCodeimpl(this.composer);
    }

    public String toString() {
        return m2418toStringimpl(this.composer);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ Composer m2421unboximpl() {
        return this.composer;
    }

    /* renamed from: set-impl, reason: not valid java name */
    public static final <V> void m2417setimpl(Composer composer, V v, @NotNull Function2<? super T, ? super V, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        if (composer.getInserting() || !Intrinsics.areEqual(composer.rememberedValue(), v)) {
            composer.updateRememberedValue(v);
            composer.apply(v, function2);
        }
    }

    /* renamed from: update-impl, reason: not valid java name */
    public static final <V> void m2420updateimpl(Composer composer, V v, @NotNull Function2<? super T, ? super V, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "block");
        boolean inserting = composer.getInserting();
        if (inserting || !Intrinsics.areEqual(composer.rememberedValue(), v)) {
            composer.updateRememberedValue(v);
            if (inserting) {
                return;
            }
            composer.apply(v, function2);
        }
    }
}
