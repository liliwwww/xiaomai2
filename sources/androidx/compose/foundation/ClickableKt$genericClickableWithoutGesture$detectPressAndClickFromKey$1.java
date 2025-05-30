package androidx.compose.foundation;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.interaction.PressInteraction;
import androidx.compose.runtime.State;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import java.util.Map;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.d;
import org.jetbrains.annotations.NotNull;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
final class ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1 extends Lambda implements Function1<KeyEvent, Boolean> {
    final /* synthetic */ Map<Key, PressInteraction.Press> $currentKeyPressInteractions;
    final /* synthetic */ boolean $enabled;
    final /* synthetic */ CoroutineScope $indicationScope;
    final /* synthetic */ MutableInteractionSource $interactionSource;
    final /* synthetic */ State<Offset> $keyClickOffset;
    final /* synthetic */ Function0<Unit> $onClick;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ClickableKt$genericClickableWithoutGesture$detectPressAndClickFromKey$1(boolean z, Map<Key, PressInteraction.Press> map, State<Offset> state, CoroutineScope coroutineScope, Function0<Unit> function0, MutableInteractionSource mutableInteractionSource) {
        super(1);
        this.$enabled = z;
        this.$currentKeyPressInteractions = map;
        this.$keyClickOffset = state;
        this.$indicationScope = coroutineScope;
        this.$onClick = function0;
        this.$interactionSource = mutableInteractionSource;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        return m126invokeZmokQxo(((KeyEvent) obj).unbox-impl());
    }

    @NotNull
    /* renamed from: invoke-ZmokQxo, reason: not valid java name */
    public final Boolean m126invokeZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, "keyEvent");
        boolean z = true;
        if (this.$enabled && Clickable_androidKt.m129isPressZmokQxo(keyEvent)) {
            if (!this.$currentKeyPressInteractions.containsKey(Key.m1380boximpl(KeyEvent_androidKt.getKey-ZmokQxo(keyEvent)))) {
                PressInteraction.Press press = new PressInteraction.Press(((Offset) this.$keyClickOffset.getValue()).m858unboximpl(), (DefaultConstructorMarker) null);
                this.$currentKeyPressInteractions.put(Key.m1380boximpl(KeyEvent_androidKt.getKey-ZmokQxo(keyEvent)), press);
                d.d(this.$indicationScope, (CoroutineContext) null, (CoroutineStart) null, new 1(this.$interactionSource, press, (Continuation) null), 3, (Object) null);
            }
            z = false;
        } else {
            if (this.$enabled && Clickable_androidKt.m127isClickZmokQxo(keyEvent)) {
                PressInteraction.Press remove = this.$currentKeyPressInteractions.remove(Key.m1380boximpl(KeyEvent_androidKt.getKey-ZmokQxo(keyEvent)));
                if (remove != null) {
                    d.d(this.$indicationScope, (CoroutineContext) null, (CoroutineStart) null, new 2.1(this.$interactionSource, remove, (Continuation) null), 3, (Object) null);
                }
                this.$onClick.invoke();
            }
            z = false;
        }
        return Boolean.valueOf(z);
    }
}
