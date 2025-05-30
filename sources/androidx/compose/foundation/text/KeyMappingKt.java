package androidx.compose.foundation.text;

import androidx.compose.ui.input.key.Key;
import androidx.compose.ui.input.key.KeyEvent;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public final class KeyMappingKt {

    @NotNull
    private static final KeyMapping defaultKeyMapping = new defaultKeyMapping.2.1(commonKeyMapping(defaultKeyMapping.1.INSTANCE));

    @NotNull
    public static final KeyMapping commonKeyMapping(@NotNull final Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "shortcutModifier");
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Nullable
            /* renamed from: map-ZmokQxo, reason: not valid java name */
            public KeyCommand m558mapZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                Intrinsics.checkNotNullParameter(keyEvent, "event");
                if (((Boolean) function1.invoke(KeyEvent.m1936boximpl(keyEvent))).booleanValue() && KeyEvent_androidKt.m1956isShiftPressedZmokQxo(keyEvent)) {
                    if (Key.equals-impl0(KeyEvent_androidKt.m1950getKeyZmokQxo(keyEvent), MappedKeys.INSTANCE.getZ-EK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (((Boolean) function1.invoke(KeyEvent.m1936boximpl(keyEvent))).booleanValue()) {
                    long m1950getKeyZmokQxo = KeyEvent_androidKt.m1950getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.equals-impl0(m1950getKeyZmokQxo, mappedKeys.getC-EK5gGoQ()) ? true : Key.equals-impl0(m1950getKeyZmokQxo, mappedKeys.getInsert-EK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo, mappedKeys.getV-EK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo, mappedKeys.getX-EK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo, mappedKeys.getA-EK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo, mappedKeys.getY-EK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo, mappedKeys.getZ-EK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m1954isCtrlPressedZmokQxo(keyEvent)) {
                    return null;
                }
                if (KeyEvent_androidKt.m1956isShiftPressedZmokQxo(keyEvent)) {
                    long m1950getKeyZmokQxo2 = KeyEvent_androidKt.m1950getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.equals-impl0(m1950getKeyZmokQxo2, mappedKeys2.getDirectionLeft-EK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo2, mappedKeys2.getDirectionRight-EK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo2, mappedKeys2.getDirectionUp-EK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo2, mappedKeys2.getDirectionDown-EK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo2, mappedKeys2.getPageUp-EK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo2, mappedKeys2.getPageDown-EK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo2, mappedKeys2.getMoveHome-EK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo2, mappedKeys2.getMoveEnd-EK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.equals-impl0(m1950getKeyZmokQxo2, mappedKeys2.getInsert-EK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long m1950getKeyZmokQxo3 = KeyEvent_androidKt.m1950getKeyZmokQxo(keyEvent);
                MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getDirectionLeft-EK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getDirectionRight-EK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getDirectionUp-EK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getDirectionDown-EK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getPageUp-EK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getPageDown-EK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getMoveHome-EK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getMoveEnd-EK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getEnter-EK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getBackspace-EK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getDelete-EK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getPaste-EK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getCut-EK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.equals-impl0(m1950getKeyZmokQxo3, mappedKeys3.getTab-EK5gGoQ())) {
                    return KeyCommand.TAB;
                }
                return null;
            }
        };
    }

    @NotNull
    public static final KeyMapping getDefaultKeyMapping() {
        return defaultKeyMapping;
    }
}
