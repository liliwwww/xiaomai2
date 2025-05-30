package androidx.compose.p004ui.layout;

import androidx.compose.runtime.Immutable;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
/* loaded from: classes2.dex */
public abstract class AlignmentLine {

    @NotNull
    public static final Companion Companion = new Companion(null);
    public static final int Unspecified = Integer.MIN_VALUE;

    @NotNull
    private final Function2<Integer, Integer, Integer> merger;

    /* compiled from: Taobao */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private AlignmentLine(Function2<? super Integer, ? super Integer, Integer> function2) {
        this.merger = function2;
    }

    public /* synthetic */ AlignmentLine(Function2 function2, DefaultConstructorMarker defaultConstructorMarker) {
        this(function2);
    }

    @NotNull
    public final Function2<Integer, Integer, Integer> getMerger$ui_release() {
        return this.merger;
    }
}
