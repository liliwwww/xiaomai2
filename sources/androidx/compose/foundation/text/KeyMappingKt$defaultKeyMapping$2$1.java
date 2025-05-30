package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class KeyMappingKt$defaultKeyMapping$2$1 implements KeyMapping {
    final /* synthetic */ KeyMapping $common;

    KeyMappingKt$defaultKeyMapping$2$1(KeyMapping keyMapping) {
        this.$common = keyMapping;
    }

    @Override // androidx.compose.foundation.text.KeyMapping
    @Nullable
    /* renamed from: map-ZmokQxo */
    public KeyCommand mo396mapZmokQxo(@NotNull KeyEvent keyEvent) {
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        KeyCommand keyCommand = null;
        if (KeyEvent_androidKt.isShiftPressed-ZmokQxo(keyEvent) && KeyEvent_androidKt.isCtrlPressed-ZmokQxo(keyEvent)) {
            long j = KeyEvent_androidKt.getKey-ZmokQxo(keyEvent);
            MappedKeys mappedKeys = MappedKeys.INSTANCE;
            if (Key.m1383equalsimpl0(j, mappedKeys.m414getDirectionLeftEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_LEFT_WORD;
            } else if (Key.m1383equalsimpl0(j, mappedKeys.m415getDirectionRightEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_RIGHT_WORD;
            } else if (Key.m1383equalsimpl0(j, mappedKeys.m416getDirectionUpEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
            } else if (Key.m1383equalsimpl0(j, mappedKeys.m413getDirectionDownEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
            }
        } else if (KeyEvent_androidKt.isCtrlPressed-ZmokQxo(keyEvent)) {
            long j2 = KeyEvent_androidKt.getKey-ZmokQxo(keyEvent);
            MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
            if (Key.m1383equalsimpl0(j2, mappedKeys2.m414getDirectionLeftEK5gGoQ())) {
                keyCommand = KeyCommand.LEFT_WORD;
            } else if (Key.m1383equalsimpl0(j2, mappedKeys2.m415getDirectionRightEK5gGoQ())) {
                keyCommand = KeyCommand.RIGHT_WORD;
            } else if (Key.m1383equalsimpl0(j2, mappedKeys2.m416getDirectionUpEK5gGoQ())) {
                keyCommand = KeyCommand.PREV_PARAGRAPH;
            } else if (Key.m1383equalsimpl0(j2, mappedKeys2.m413getDirectionDownEK5gGoQ())) {
                keyCommand = KeyCommand.NEXT_PARAGRAPH;
            } else if (Key.m1383equalsimpl0(j2, mappedKeys2.m418getHEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_PREV_CHAR;
            } else if (Key.m1383equalsimpl0(j2, mappedKeys2.m412getDeleteEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_NEXT_WORD;
            } else if (Key.m1383equalsimpl0(j2, mappedKeys2.m409getBackspaceEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_PREV_WORD;
            } else if (Key.m1383equalsimpl0(j2, mappedKeys2.m408getBackslashEK5gGoQ())) {
                keyCommand = KeyCommand.DESELECT;
            }
        } else if (KeyEvent_androidKt.isShiftPressed-ZmokQxo(keyEvent)) {
            long j3 = KeyEvent_androidKt.getKey-ZmokQxo(keyEvent);
            MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
            if (Key.m1383equalsimpl0(j3, mappedKeys3.m421getMoveHomeEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_HOME;
            } else if (Key.m1383equalsimpl0(j3, mappedKeys3.m420getMoveEndEK5gGoQ())) {
                keyCommand = KeyCommand.SELECT_END;
            }
        } else if (KeyEvent_androidKt.isAltPressed-ZmokQxo(keyEvent)) {
            long j4 = KeyEvent_androidKt.getKey-ZmokQxo(keyEvent);
            MappedKeys mappedKeys4 = MappedKeys.INSTANCE;
            if (Key.m1383equalsimpl0(j4, mappedKeys4.m409getBackspaceEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_FROM_LINE_START;
            } else if (Key.m1383equalsimpl0(j4, mappedKeys4.m412getDeleteEK5gGoQ())) {
                keyCommand = KeyCommand.DELETE_TO_LINE_END;
            }
        }
        return keyCommand == null ? this.$common.mo396mapZmokQxo(keyEvent) : keyCommand;
    }
}
