package androidx.compose.foundation.text;

import android.view.KeyEvent;
import androidx.appcompat.R;
import androidx.compose.foundation.text.selection.TextFieldPreparedSelection;
import androidx.compose.foundation.text.selection.TextFieldSelectionManager;
import androidx.compose.foundation.text.selection.TextPreparedSelectionState;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.input.CommitTextCommand;
import androidx.compose.ui.text.input.DeleteSurroundingTextCommand;
import androidx.compose.ui.text.input.EditCommand;
import androidx.compose.ui.text.input.EditProcessor;
import androidx.compose.ui.text.input.FinishComposingTextCommand;
import androidx.compose.ui.text.input.OffsetMapping;
import androidx.compose.ui.text.input.TextFieldValue;
import androidx.core.app.NotificationCompat;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextFieldKeyInput {
    private final boolean editable;

    @NotNull
    private final DeadKeyCombiner keyCombiner;

    @NotNull
    private final KeyMapping keyMapping;

    @NotNull
    private final OffsetMapping offsetMapping;

    @NotNull
    private final Function1<TextFieldValue, Unit> onValueChange;

    @NotNull
    private final TextPreparedSelectionState preparedSelectionState;

    @NotNull
    private final TextFieldSelectionManager selectionManager;
    private final boolean singleLine;

    @NotNull
    private final TextFieldState state;

    @Nullable
    private final UndoManager undoManager;

    @NotNull
    private final TextFieldValue value;

    /* JADX WARN: Multi-variable type inference failed */
    public TextFieldKeyInput(@NotNull TextFieldState textFieldState, @NotNull TextFieldSelectionManager textFieldSelectionManager, @NotNull TextFieldValue textFieldValue, boolean z, boolean z2, @NotNull TextPreparedSelectionState textPreparedSelectionState, @NotNull OffsetMapping offsetMapping, @Nullable UndoManager undoManager, @NotNull DeadKeyCombiner deadKeyCombiner, @NotNull KeyMapping keyMapping, @NotNull Function1<? super TextFieldValue, Unit> function1) {
        Intrinsics.checkNotNullParameter(textFieldState, "state");
        Intrinsics.checkNotNullParameter(textFieldSelectionManager, "selectionManager");
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        Intrinsics.checkNotNullParameter(textPreparedSelectionState, "preparedSelectionState");
        Intrinsics.checkNotNullParameter(offsetMapping, "offsetMapping");
        Intrinsics.checkNotNullParameter(deadKeyCombiner, "keyCombiner");
        Intrinsics.checkNotNullParameter(keyMapping, "keyMapping");
        Intrinsics.checkNotNullParameter(function1, "onValueChange");
        this.state = textFieldState;
        this.selectionManager = textFieldSelectionManager;
        this.value = textFieldValue;
        this.editable = z;
        this.singleLine = z2;
        this.preparedSelectionState = textPreparedSelectionState;
        this.offsetMapping = offsetMapping;
        this.undoManager = undoManager;
        this.keyCombiner = deadKeyCombiner;
        this.keyMapping = keyMapping;
        this.onValueChange = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(List<? extends EditCommand> list) {
        EditProcessor processor = this.state.getProcessor();
        List mutableList = CollectionsKt.toMutableList(list);
        mutableList.add(0, new FinishComposingTextCommand());
        this.onValueChange.invoke(processor.apply(mutableList));
    }

    private final void commandExecutionContext(Function1<? super TextFieldPreparedSelection, Unit> function1) {
        TextFieldPreparedSelection textFieldPreparedSelection = new TextFieldPreparedSelection(this.value, this.offsetMapping, this.state.getLayoutResult(), this.preparedSelectionState);
        function1.invoke(textFieldPreparedSelection);
        if (TextRange.equals-impl0(textFieldPreparedSelection.getSelection-d9O1mEE(), this.value.m1985getSelectiond9O1mEE()) && Intrinsics.areEqual(textFieldPreparedSelection.getAnnotatedString(), this.value.getAnnotatedString())) {
            return;
        }
        this.onValueChange.invoke(textFieldPreparedSelection.getValue());
    }

    /* renamed from: typedCommand-ZmokQxo, reason: not valid java name */
    private final CommitTextCommand m439typedCommandZmokQxo(KeyEvent keyEvent) {
        Integer m393consumeZmokQxo;
        if (!TextFieldKeyInput_androidKt.isTypedEvent-ZmokQxo(keyEvent) || (m393consumeZmokQxo = this.keyCombiner.m393consumeZmokQxo(keyEvent)) == null) {
            return null;
        }
        String sb = StringHelpers_jvmKt.appendCodePointX(new StringBuilder(), m393consumeZmokQxo.intValue()).toString();
        Intrinsics.checkNotNullExpressionValue(sb, "StringBuilder().appendCo…ntX(codePoint).toString()");
        return new CommitTextCommand(sb, 1);
    }

    public final boolean getEditable() {
        return this.editable;
    }

    @NotNull
    public final OffsetMapping getOffsetMapping() {
        return this.offsetMapping;
    }

    @NotNull
    public final TextPreparedSelectionState getPreparedSelectionState() {
        return this.preparedSelectionState;
    }

    @NotNull
    public final TextFieldSelectionManager getSelectionManager() {
        return this.selectionManager;
    }

    public final boolean getSingleLine() {
        return this.singleLine;
    }

    @NotNull
    public final TextFieldState getState() {
        return this.state;
    }

    @Nullable
    public final UndoManager getUndoManager() {
        return this.undoManager;
    }

    @NotNull
    public final TextFieldValue getValue() {
        return this.value;
    }

    /* renamed from: process-ZmokQxo, reason: not valid java name */
    public final boolean m440processZmokQxo(@NotNull KeyEvent keyEvent) {
        final KeyCommand mo396mapZmokQxo;
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        CommitTextCommand m439typedCommandZmokQxo = m439typedCommandZmokQxo(keyEvent);
        if (m439typedCommandZmokQxo != null) {
            if (!this.editable) {
                return false;
            }
            apply((EditCommand) m439typedCommandZmokQxo);
            this.preparedSelectionState.resetCachedX();
            return true;
        }
        if (!KeyEventType.equals-impl0(KeyEvent_androidKt.getType-ZmokQxo(keyEvent), KeyEventType.Companion.m1387getKeyDownCS__XNY()) || (mo396mapZmokQxo = this.keyMapping.mo396mapZmokQxo(keyEvent)) == null || (mo396mapZmokQxo.getEditsText() && !this.editable)) {
            return false;
        }
        final Ref.BooleanRef booleanRef = new Ref.BooleanRef();
        booleanRef.element = true;
        commandExecutionContext(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((TextFieldPreparedSelection) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull TextFieldPreparedSelection textFieldPreparedSelection) {
                TextFieldValue undo;
                Function1 function1;
                TextFieldValue redo;
                Function1 function12;
                Intrinsics.checkNotNullParameter(textFieldPreparedSelection, "$this$commandExecutionContext");
                switch (WhenMappings.$EnumSwitchMapping$0[KeyCommand.this.ordinal()]) {
                    case 1:
                        this.getSelectionManager().copy$foundation_release(false);
                        break;
                    case 2:
                        this.getSelectionManager().paste$foundation_release();
                        break;
                    case 3:
                        this.getSelectionManager().cut$foundation_release();
                        break;
                    case 4:
                        textFieldPreparedSelection.collapseLeftOr(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.1
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((TextFieldPreparedSelection) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Intrinsics.checkNotNullParameter(textFieldPreparedSelection2, "$this$collapseLeftOr");
                                textFieldPreparedSelection2.moveCursorLeft();
                            }
                        });
                        break;
                    case 5:
                        textFieldPreparedSelection.collapseRightOr(new Function1<TextFieldPreparedSelection, Unit>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.2
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((TextFieldPreparedSelection) obj);
                                return Unit.INSTANCE;
                            }

                            public final void invoke(@NotNull TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Intrinsics.checkNotNullParameter(textFieldPreparedSelection2, "$this$collapseRightOr");
                                textFieldPreparedSelection2.moveCursorRight();
                            }
                        });
                        break;
                    case 6:
                        textFieldPreparedSelection.moveCursorLeftByWord();
                        break;
                    case 7:
                        textFieldPreparedSelection.moveCursorRightByWord();
                        break;
                    case 8:
                        textFieldPreparedSelection.moveCursorPrevByParagraph();
                        break;
                    case 9:
                        textFieldPreparedSelection.moveCursorNextByParagraph();
                        break;
                    case 10:
                        textFieldPreparedSelection.moveCursorUpByLine();
                        break;
                    case 11:
                        textFieldPreparedSelection.moveCursorDownByLine();
                        break;
                    case 12:
                        textFieldPreparedSelection.moveCursorUpByPage();
                        break;
                    case 13:
                        textFieldPreparedSelection.moveCursorDownByPage();
                        break;
                    case 14:
                        textFieldPreparedSelection.moveCursorToLineStart();
                        break;
                    case 15:
                        textFieldPreparedSelection.moveCursorToLineEnd();
                        break;
                    case 16:
                        textFieldPreparedSelection.moveCursorToLineLeftSide();
                        break;
                    case 17:
                        textFieldPreparedSelection.moveCursorToLineRightSide();
                        break;
                    case 18:
                        textFieldPreparedSelection.moveCursorToHome();
                        break;
                    case 19:
                        textFieldPreparedSelection.moveCursorToEnd();
                        break;
                    case 20:
                        List deleteIfSelectedOr = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.3
                            @Nullable
                            public final EditCommand invoke(@NotNull TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Intrinsics.checkNotNullParameter(textFieldPreparedSelection2, "$this$deleteIfSelectedOr");
                                return new DeleteSurroundingTextCommand(TextRange.getEnd-impl(textFieldPreparedSelection2.getSelection-d9O1mEE()) - textFieldPreparedSelection2.getPrecedingCharacterIndex(), 0);
                            }
                        });
                        if (deleteIfSelectedOr != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr);
                            break;
                        }
                        break;
                    case 21:
                        List deleteIfSelectedOr2 = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.4
                            @Nullable
                            public final EditCommand invoke(@NotNull TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Intrinsics.checkNotNullParameter(textFieldPreparedSelection2, "$this$deleteIfSelectedOr");
                                int nextCharacterIndex = textFieldPreparedSelection2.getNextCharacterIndex();
                                if (nextCharacterIndex != -1) {
                                    return new DeleteSurroundingTextCommand(0, nextCharacterIndex - TextRange.getEnd-impl(textFieldPreparedSelection2.getSelection-d9O1mEE()));
                                }
                                return null;
                            }
                        });
                        if (deleteIfSelectedOr2 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr2);
                            break;
                        }
                        break;
                    case 22:
                        List deleteIfSelectedOr3 = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.5
                            @Nullable
                            public final EditCommand invoke(@NotNull TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Intrinsics.checkNotNullParameter(textFieldPreparedSelection2, "$this$deleteIfSelectedOr");
                                Integer previousWordOffset = textFieldPreparedSelection2.getPreviousWordOffset();
                                if (previousWordOffset == null) {
                                    return null;
                                }
                                return new DeleteSurroundingTextCommand(TextRange.getEnd-impl(textFieldPreparedSelection2.getSelection-d9O1mEE()) - previousWordOffset.intValue(), 0);
                            }
                        });
                        if (deleteIfSelectedOr3 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr3);
                            break;
                        }
                        break;
                    case 23:
                        List deleteIfSelectedOr4 = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.6
                            @Nullable
                            public final EditCommand invoke(@NotNull TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Intrinsics.checkNotNullParameter(textFieldPreparedSelection2, "$this$deleteIfSelectedOr");
                                Integer nextWordOffset = textFieldPreparedSelection2.getNextWordOffset();
                                if (nextWordOffset != null) {
                                    return new DeleteSurroundingTextCommand(0, nextWordOffset.intValue() - TextRange.getEnd-impl(textFieldPreparedSelection2.getSelection-d9O1mEE()));
                                }
                                return null;
                            }
                        });
                        if (deleteIfSelectedOr4 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr4);
                            break;
                        }
                        break;
                    case 24:
                        List deleteIfSelectedOr5 = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.7
                            @Nullable
                            public final EditCommand invoke(@NotNull TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Intrinsics.checkNotNullParameter(textFieldPreparedSelection2, "$this$deleteIfSelectedOr");
                                Integer lineStartByOffset = textFieldPreparedSelection2.getLineStartByOffset();
                                if (lineStartByOffset == null) {
                                    return null;
                                }
                                return new DeleteSurroundingTextCommand(TextRange.getEnd-impl(textFieldPreparedSelection2.getSelection-d9O1mEE()) - lineStartByOffset.intValue(), 0);
                            }
                        });
                        if (deleteIfSelectedOr5 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr5);
                            break;
                        }
                        break;
                    case 25:
                        List deleteIfSelectedOr6 = textFieldPreparedSelection.deleteIfSelectedOr(new Function1<TextFieldPreparedSelection, EditCommand>() { // from class: androidx.compose.foundation.text.TextFieldKeyInput$process$2.8
                            @Nullable
                            public final EditCommand invoke(@NotNull TextFieldPreparedSelection textFieldPreparedSelection2) {
                                Intrinsics.checkNotNullParameter(textFieldPreparedSelection2, "$this$deleteIfSelectedOr");
                                Integer lineEndByOffset = textFieldPreparedSelection2.getLineEndByOffset();
                                if (lineEndByOffset != null) {
                                    return new DeleteSurroundingTextCommand(0, lineEndByOffset.intValue() - TextRange.getEnd-impl(textFieldPreparedSelection2.getSelection-d9O1mEE()));
                                }
                                return null;
                            }
                        });
                        if (deleteIfSelectedOr6 != null) {
                            this.apply((List<? extends EditCommand>) deleteIfSelectedOr6);
                            break;
                        }
                        break;
                    case 26:
                        if (!this.getSingleLine()) {
                            this.apply((EditCommand) new CommitTextCommand("\n", 1));
                            break;
                        } else {
                            booleanRef.element = false;
                            break;
                        }
                    case 27:
                        if (!this.getSingleLine()) {
                            this.apply((EditCommand) new CommitTextCommand("\t", 1));
                            break;
                        } else {
                            booleanRef.element = false;
                            break;
                        }
                    case 28:
                        textFieldPreparedSelection.selectAll();
                        break;
                    case 29:
                        textFieldPreparedSelection.moveCursorLeft().selectMovement();
                        break;
                    case 30:
                        textFieldPreparedSelection.moveCursorRight().selectMovement();
                        break;
                    case 31:
                        textFieldPreparedSelection.moveCursorLeftByWord().selectMovement();
                        break;
                    case 32:
                        textFieldPreparedSelection.moveCursorRightByWord().selectMovement();
                        break;
                    case 33:
                        textFieldPreparedSelection.moveCursorPrevByParagraph().selectMovement();
                        break;
                    case 34:
                        textFieldPreparedSelection.moveCursorNextByParagraph().selectMovement();
                        break;
                    case 35:
                        textFieldPreparedSelection.moveCursorToLineStart().selectMovement();
                        break;
                    case 36:
                        textFieldPreparedSelection.moveCursorToLineEnd().selectMovement();
                        break;
                    case 37:
                        textFieldPreparedSelection.moveCursorToLineLeftSide().selectMovement();
                        break;
                    case 38:
                        textFieldPreparedSelection.moveCursorToLineRightSide().selectMovement();
                        break;
                    case 39:
                        textFieldPreparedSelection.moveCursorUpByLine().selectMovement();
                        break;
                    case 40:
                        textFieldPreparedSelection.moveCursorDownByLine().selectMovement();
                        break;
                    case 41:
                        textFieldPreparedSelection.moveCursorUpByPage().selectMovement();
                        break;
                    case 42:
                        textFieldPreparedSelection.moveCursorDownByPage().selectMovement();
                        break;
                    case 43:
                        textFieldPreparedSelection.moveCursorToHome().selectMovement();
                        break;
                    case 44:
                        textFieldPreparedSelection.moveCursorToEnd().selectMovement();
                        break;
                    case 45:
                        textFieldPreparedSelection.deselect();
                        break;
                    case 46:
                        UndoManager undoManager = this.getUndoManager();
                        if (undoManager != null) {
                            undoManager.makeSnapshot(textFieldPreparedSelection.getValue());
                        }
                        UndoManager undoManager2 = this.getUndoManager();
                        if (undoManager2 != null && (undo = undoManager2.undo()) != null) {
                            function1 = this.onValueChange;
                            function1.invoke(undo);
                            break;
                        }
                        break;
                    case 47:
                        UndoManager undoManager3 = this.getUndoManager();
                        if (undoManager3 != null && (redo = undoManager3.redo()) != null) {
                            function12 = this.onValueChange;
                            function12.invoke(redo);
                            break;
                        }
                        break;
                    case R.styleable.AppCompatTheme_checkboxStyle /* 48 */:
                        KeyEventHelpers_androidKt.showCharacterPalette();
                        break;
                }
            }
        });
        UndoManager undoManager = this.undoManager;
        if (undoManager != null) {
            undoManager.forceNextSnapshot();
        }
        return booleanRef.element;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void apply(EditCommand editCommand) {
        apply(CollectionsKt.listOf(editCommand));
    }

    public /* synthetic */ TextFieldKeyInput(TextFieldState textFieldState, TextFieldSelectionManager textFieldSelectionManager, TextFieldValue textFieldValue, boolean z, boolean z2, TextPreparedSelectionState textPreparedSelectionState, OffsetMapping offsetMapping, UndoManager undoManager, DeadKeyCombiner deadKeyCombiner, KeyMapping keyMapping, Function1 function1, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(textFieldState, textFieldSelectionManager, (i & 4) != 0 ? new TextFieldValue((String) null, 0L, (TextRange) null, 7, (DefaultConstructorMarker) null) : textFieldValue, (i & 8) != 0 ? true : z, (i & 16) != 0 ? false : z2, textPreparedSelectionState, (i & 64) != 0 ? OffsetMapping.Companion.getIdentity() : offsetMapping, (i & 128) != 0 ? null : undoManager, deadKeyCombiner, (i & 512) != 0 ? KeyMapping_androidKt.getPlatformDefaultKeyMapping() : keyMapping, (i & 1024) != 0 ? 1.INSTANCE : function1);
    }
}
