package androidx.constraintlayout.compose;

import androidx.compose.runtime.Immutable;
import androidx.compose.runtime.Stable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
@Immutable
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0007\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0007\u0010\bR\u001c\u0010\u0003\u001a\u00020\u00028\u0000@\u0000X\u0080\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006¨\u0006\n"}, d2 = {"Landroidx/constraintlayout/compose/Visibility;", "", "", "solverValue", "I", "getSolverValue$compose_release", "()I", "<init>", "(I)V", "Companion", "compose_release"}, k = 1, mv = {1, 5, 1})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class Visibility {
    private final int solverValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    @NotNull
    public static final Companion INSTANCE = new Companion(null);

    @NotNull
    private static final Visibility Visible = new Visibility(0);

    @NotNull
    private static final Visibility Invisible = new Visibility(4);

    @NotNull
    private static final Visibility Gone = new Visibility(8);

    /* compiled from: Taobao */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u000f\u0010\bR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\"\u0010\t\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\t\u0010\u0004\u0012\u0004\b\u000b\u0010\b\u001a\u0004\b\n\u0010\u0006R\"\u0010\f\u001a\u00020\u00028\u0006@\u0007X\u0087\u0004¢\u0006\u0012\n\u0004\b\f\u0010\u0004\u0012\u0004\b\u000e\u0010\b\u001a\u0004\b\r\u0010\u0006¨\u0006\u0010"}, d2 = {"Landroidx/constraintlayout/compose/Visibility$Companion;", "", "Landroidx/constraintlayout/compose/Visibility;", "Visible", "Landroidx/constraintlayout/compose/Visibility;", "getVisible", "()Landroidx/constraintlayout/compose/Visibility;", "getVisible$annotations", "()V", "Invisible", "getInvisible", "getInvisible$annotations", "Gone", "getGone", "getGone$annotations", "<init>", "compose_release"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @Stable
        public static /* synthetic */ void getGone$annotations() {
        }

        @Stable
        public static /* synthetic */ void getInvisible$annotations() {
        }

        @Stable
        public static /* synthetic */ void getVisible$annotations() {
        }

        @NotNull
        public final Visibility getGone() {
            return Visibility.Gone;
        }

        @NotNull
        public final Visibility getInvisible() {
            return Visibility.Invisible;
        }

        @NotNull
        public final Visibility getVisible() {
            return Visibility.Visible;
        }
    }

    public Visibility(int i) {
        this.solverValue = i;
    }

    /* renamed from: getSolverValue$compose_release, reason: from getter */
    public final int getSolverValue() {
        return this.solverValue;
    }
}
