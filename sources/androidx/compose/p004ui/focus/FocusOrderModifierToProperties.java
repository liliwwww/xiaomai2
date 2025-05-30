package androidx.compose.p004ui.focus;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class FocusOrderModifierToProperties implements Function1<FocusProperties, Unit> {

    @NotNull
    private final FocusOrderModifier modifier;

    public FocusOrderModifierToProperties(@NotNull FocusOrderModifier focusOrderModifier) {
        Intrinsics.checkNotNullParameter(focusOrderModifier, "modifier");
        this.modifier = focusOrderModifier;
    }

    @NotNull
    public final FocusOrderModifier getModifier() {
        return this.modifier;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((FocusProperties) obj);
        return Unit.INSTANCE;
    }

    public void invoke(@NotNull FocusProperties focusProperties) {
        Intrinsics.checkNotNullParameter(focusProperties, "focusProperties");
        this.modifier.populateFocusOrder(new FocusOrder(focusProperties));
    }
}
