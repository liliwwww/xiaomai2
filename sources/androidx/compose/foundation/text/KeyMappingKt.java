package androidx.compose.foundation.text;

import androidx.compose.p004ui.input.key.Key;
import androidx.compose.p004ui.input.key.KeyEvent;
import androidx.compose.p004ui.input.key.KeyEvent_androidKt;
import androidx.core.app.NotificationCompat;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class KeyMappingKt {

    @NotNull
    private static final KeyMapping defaultKeyMapping;

    static {
        final KeyMapping commonKeyMapping = commonKeyMapping(new PropertyReference1Impl() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$1
            @Nullable
            public Object get(@Nullable Object obj) {
                return Boolean.valueOf(KeyEvent_androidKt.m3968isCtrlPressedZmokQxo(((KeyEvent) obj).m3953unboximpl()));
            }
        });
        defaultKeyMapping = new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$defaultKeyMapping$2$1
            @Override // androidx.compose.foundation.text.KeyMapping
            @Nullable
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo1728mapZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
                KeyCommand keyCommand = null;
                if (KeyEvent_androidKt.m3970isShiftPressedZmokQxo(keyEvent) && KeyEvent_androidKt.m3968isCtrlPressedZmokQxo(keyEvent)) {
                    long m3964getKeyZmokQxo = KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1751getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_LEFT_WORD;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1752getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_RIGHT_WORD;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1753getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_PREV_PARAGRAPH;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1750getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_NEXT_PARAGRAPH;
                    }
                } else if (KeyEvent_androidKt.m3968isCtrlPressedZmokQxo(keyEvent)) {
                    long m3964getKeyZmokQxo2 = KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1751getDirectionLeftEK5gGoQ())) {
                        keyCommand = KeyCommand.LEFT_WORD;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1752getDirectionRightEK5gGoQ())) {
                        keyCommand = KeyCommand.RIGHT_WORD;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1753getDirectionUpEK5gGoQ())) {
                        keyCommand = KeyCommand.PREV_PARAGRAPH;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1750getDirectionDownEK5gGoQ())) {
                        keyCommand = KeyCommand.NEXT_PARAGRAPH;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1755getHEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_CHAR;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1749getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_NEXT_WORD;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1746getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_PREV_WORD;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1745getBackslashEK5gGoQ())) {
                        keyCommand = KeyCommand.DESELECT;
                    }
                } else if (KeyEvent_androidKt.m3970isShiftPressedZmokQxo(keyEvent)) {
                    long m3964getKeyZmokQxo3 = KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1758getMoveHomeEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_HOME;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1757getMoveEndEK5gGoQ())) {
                        keyCommand = KeyCommand.SELECT_END;
                    }
                } else if (KeyEvent_androidKt.m3967isAltPressedZmokQxo(keyEvent)) {
                    long m3964getKeyZmokQxo4 = KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys4 = MappedKeys.INSTANCE;
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo4, mappedKeys4.m1746getBackspaceEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_FROM_LINE_START;
                    } else if (Key.m3369equalsimpl0(m3964getKeyZmokQxo4, mappedKeys4.m1749getDeleteEK5gGoQ())) {
                        keyCommand = KeyCommand.DELETE_TO_LINE_END;
                    }
                }
                return keyCommand == null ? KeyMapping.this.mo1728mapZmokQxo(keyEvent) : keyCommand;
            }
        };
    }

    @NotNull
    public static final KeyMapping commonKeyMapping(@NotNull final Function1<? super KeyEvent, Boolean> function1) {
        Intrinsics.checkNotNullParameter(function1, "shortcutModifier");
        return new KeyMapping() { // from class: androidx.compose.foundation.text.KeyMappingKt$commonKeyMapping$1
            @Override // androidx.compose.foundation.text.KeyMapping
            @Nullable
            /* renamed from: map-ZmokQxo */
            public KeyCommand mo1728mapZmokQxo(@NotNull android.view.KeyEvent keyEvent) {
                Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
                if (((Boolean) function1.invoke(KeyEvent.m3947boximpl(keyEvent))).booleanValue() && KeyEvent_androidKt.m3970isShiftPressedZmokQxo(keyEvent)) {
                    if (Key.m3369equalsimpl0(KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent), MappedKeys.INSTANCE.m1766getZEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    return null;
                }
                if (((Boolean) function1.invoke(KeyEvent.m3947boximpl(keyEvent))).booleanValue()) {
                    long m3964getKeyZmokQxo = KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys = MappedKeys.INSTANCE;
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1747getCEK5gGoQ()) ? true : Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1756getInsertEK5gGoQ())) {
                        return KeyCommand.COPY;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1763getVEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1764getXEK5gGoQ())) {
                        return KeyCommand.CUT;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1744getAEK5gGoQ())) {
                        return KeyCommand.SELECT_ALL;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1765getYEK5gGoQ())) {
                        return KeyCommand.REDO;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo, mappedKeys.m1766getZEK5gGoQ())) {
                        return KeyCommand.UNDO;
                    }
                    return null;
                }
                if (KeyEvent_androidKt.m3968isCtrlPressedZmokQxo(keyEvent)) {
                    return null;
                }
                if (KeyEvent_androidKt.m3970isShiftPressedZmokQxo(keyEvent)) {
                    long m3964getKeyZmokQxo2 = KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent);
                    MappedKeys mappedKeys2 = MappedKeys.INSTANCE;
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1751getDirectionLeftEK5gGoQ())) {
                        return KeyCommand.SELECT_LEFT_CHAR;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1752getDirectionRightEK5gGoQ())) {
                        return KeyCommand.SELECT_RIGHT_CHAR;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1753getDirectionUpEK5gGoQ())) {
                        return KeyCommand.SELECT_UP;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1750getDirectionDownEK5gGoQ())) {
                        return KeyCommand.SELECT_DOWN;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1760getPageUpEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_UP;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1759getPageDownEK5gGoQ())) {
                        return KeyCommand.SELECT_PAGE_DOWN;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1758getMoveHomeEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_START;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1757getMoveEndEK5gGoQ())) {
                        return KeyCommand.SELECT_LINE_END;
                    }
                    if (Key.m3369equalsimpl0(m3964getKeyZmokQxo2, mappedKeys2.m1756getInsertEK5gGoQ())) {
                        return KeyCommand.PASTE;
                    }
                    return null;
                }
                long m3964getKeyZmokQxo3 = KeyEvent_androidKt.m3964getKeyZmokQxo(keyEvent);
                MappedKeys mappedKeys3 = MappedKeys.INSTANCE;
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1751getDirectionLeftEK5gGoQ())) {
                    return KeyCommand.LEFT_CHAR;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1752getDirectionRightEK5gGoQ())) {
                    return KeyCommand.RIGHT_CHAR;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1753getDirectionUpEK5gGoQ())) {
                    return KeyCommand.UP;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1750getDirectionDownEK5gGoQ())) {
                    return KeyCommand.DOWN;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1760getPageUpEK5gGoQ())) {
                    return KeyCommand.PAGE_UP;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1759getPageDownEK5gGoQ())) {
                    return KeyCommand.PAGE_DOWN;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1758getMoveHomeEK5gGoQ())) {
                    return KeyCommand.LINE_START;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1757getMoveEndEK5gGoQ())) {
                    return KeyCommand.LINE_END;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1754getEnterEK5gGoQ())) {
                    return KeyCommand.NEW_LINE;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1746getBackspaceEK5gGoQ())) {
                    return KeyCommand.DELETE_PREV_CHAR;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1749getDeleteEK5gGoQ())) {
                    return KeyCommand.DELETE_NEXT_CHAR;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1761getPasteEK5gGoQ())) {
                    return KeyCommand.PASTE;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1748getCutEK5gGoQ())) {
                    return KeyCommand.CUT;
                }
                if (Key.m3369equalsimpl0(m3964getKeyZmokQxo3, mappedKeys3.m1762getTabEK5gGoQ())) {
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
