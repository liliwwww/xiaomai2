package androidx.compose.ui.focus;

import androidx.compose.ui.ExperimentalComposeUiApi;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public interface FocusProperties {

    /* compiled from: Taobao */
    /* renamed from: androidx.compose.ui.focus.FocusProperties$-CC, reason: invalid class name */
    public final /* synthetic */ class CC {
        @NotNull
        public static FocusRequester a(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester b(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @ExperimentalComposeUiApi
        @NotNull
        public static Function1 c(FocusProperties _this) {
            return new Function1<FocusDirection, FocusRequester>() { // from class: androidx.compose.ui.focus.FocusProperties$enter$1
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    return m827invoke3ESFkO8(((FocusDirection) obj).unbox-impl());
                }

                @NotNull
                /* renamed from: invoke-3ESFkO8, reason: not valid java name */
                public final FocusRequester m827invoke3ESFkO8(int i) {
                    return FocusRequester.Companion.getDefault();
                }
            };
        }

        @ExperimentalComposeUiApi
        @NotNull
        public static Function1 d(FocusProperties _this) {
            return exit.1.INSTANCE;
        }

        @NotNull
        public static FocusRequester e(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester f(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester g(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester h(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester i(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        @NotNull
        public static FocusRequester j(FocusProperties _this) {
            return FocusRequester.Companion.getDefault();
        }

        public static void k(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void l(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        @ExperimentalComposeUiApi
        public static void m(@NotNull FocusProperties focusProperties, Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "<anonymous parameter 0>");
        }

        @ExperimentalComposeUiApi
        public static void n(@NotNull FocusProperties focusProperties, Function1 function1) {
            Intrinsics.checkNotNullParameter(function1, "<anonymous parameter 0>");
        }

        public static void o(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void p(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void q(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void r(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void s(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
            Intrinsics.checkNotNullParameter(focusRequester, "<anonymous parameter 0>");
        }

        public static void t(@NotNull FocusProperties focusProperties, FocusRequester focusRequester) {
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
