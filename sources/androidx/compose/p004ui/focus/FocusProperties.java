package androidx.compose.p004ui.focus;

import androidx.compose.p004ui.ExperimentalComposeUiApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes.dex */
public interface FocusProperties {

    /* compiled from: Taobao */
    /* renamed from: androidx.compose.ui.focus.FocusProperties$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @NotNull
        /* renamed from: a */
        public static FocusRequester m89a(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        /* renamed from: b */
        public static FocusRequester m90b(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @ExperimentalComposeUiApi
        @NotNull
        /* renamed from: c */
        public static Function1 m91c(FocusProperties _this) {
            return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$enter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m2503invoke3ESFkO8(((FocusDirection) obj).m2482unboximpl());
                }

                @NotNull
                /* renamed from: invoke-3ESFkO8, reason: not valid java name */
                public final FocusRequester m2503invoke3ESFkO8(int i) {
                    return FocusRequester.Companion.getDefault();
                }
            };
        }

        @ExperimentalComposeUiApi
        @NotNull
        /* renamed from: d */
        public static Function1 m92d(FocusProperties _this) {
            return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$exit$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m2504invoke3ESFkO8(((FocusDirection) obj).m2482unboximpl());
                }

                @NotNull
                /* renamed from: invoke-3ESFkO8, reason: not valid java name */
                public final FocusRequester m2504invoke3ESFkO8(int i) {
                    return FocusRequester.Companion.getDefault();
                }
            };
        }

        @NotNull
        /* renamed from: e */
        public static FocusRequester m93e(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        /* renamed from: f */
        public static FocusRequester m94f(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        /* renamed from: g */
        public static FocusRequester m95g(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        /* renamed from: h */
        public static FocusRequester m96h(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        /* renamed from: i */
        public static FocusRequester m97i(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        /* renamed from: j */
        public static FocusRequester m98j(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        /* renamed from: k */
        public static void m99k(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        /* renamed from: l */
        public static void m100l(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        @ExperimentalComposeUiApi
        /* renamed from: m */
        public static void m101m(@NotNull FocusProperties focusProperties, Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "<anonymous parameter 0>");
        }

        @ExperimentalComposeUiApi
        /* renamed from: n */
        public static void m102n(@NotNull FocusProperties focusProperties, Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "<anonymous parameter 0>");
        }

        /* renamed from: o */
        public static void m103o(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        /* renamed from: p */
        public static void m104p(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        /* renamed from: q */
        public static void m105q(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        /* renamed from: r */
        public static void m106r(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        /* renamed from: s */
        public static void m107s(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        /* renamed from: t */
        public static void m108t(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }
    }

    boolean getCanFocus();

    @NotNull
    FocusRequester getDown();

    @NotNull
    FocusRequester getEnd();

    @ExperimentalComposeUiApi
    @NotNull
    Function1<FocusDirection, FocusRequester> getEnter();

    @ExperimentalComposeUiApi
    @NotNull
    Function1<FocusDirection, FocusRequester> getExit();

    @NotNull
    FocusRequester getLeft();

    @NotNull
    FocusRequester getNext();

    @NotNull
    FocusRequester getPrevious();

    @NotNull
    FocusRequester getRight();

    @NotNull
    FocusRequester getStart();

    @NotNull
    FocusRequester getUp();

    void setCanFocus(boolean z);

    void setDown(@NotNull FocusRequester focusRequester);

    void setEnd(@NotNull FocusRequester focusRequester);

    @ExperimentalComposeUiApi
    void setEnter(@NotNull Function1<? super FocusDirection, FocusRequester> function1);

    @ExperimentalComposeUiApi
    void setExit(@NotNull Function1<? super FocusDirection, FocusRequester> function1);

    void setLeft(@NotNull FocusRequester focusRequester);

    void setNext(@NotNull FocusRequester focusRequester);

    void setPrevious(@NotNull FocusRequester focusRequester);

    void setRight(@NotNull FocusRequester focusRequester);

    void setStart(@NotNull FocusRequester focusRequester);

    void setUp(@NotNull FocusRequester focusRequester);
}
