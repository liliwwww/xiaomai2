package androidx.compose.p004ui.tooling;

import androidx.compose.p004ui.tooling.data.Group;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
final class ComposeViewAdapter$findRememberCall$rememberCalls$1$1 extends Lambda implements Function1<Group, Boolean> {
    public static final ComposeViewAdapter$findRememberCall$rememberCalls$1$1 INSTANCE = new ComposeViewAdapter$findRememberCall$rememberCalls$1$1();

    public ComposeViewAdapter$findRememberCall$rememberCalls$1$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull Group group) {
        Intrinsics.checkNotNullParameter(group, NotificationCompat.CATEGORY_CALL);
        return Boolean.valueOf(Intrinsics.areEqual(group.getName(), "remember"));
    }
}
