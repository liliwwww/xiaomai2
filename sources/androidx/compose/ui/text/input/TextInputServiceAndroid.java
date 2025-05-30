package androidx.compose.ui.text.input;

import android.graphics.Rect;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.compose.ui.text.TextRange;
import androidx.core.app.NotificationCompat;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.channels.Channel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import tb.gs;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class TextInputServiceAndroid implements PlatformTextInputService {

    @NotNull
    private final Lazy baseInputConnection$delegate;
    private boolean editorHasFocus;

    @Nullable
    private Rect focusedRect;

    @NotNull
    private List<WeakReference<RecordingInputConnection>> ics;

    @NotNull
    private ImeOptions imeOptions;

    @NotNull
    private final InputMethodManager inputMethodManager;

    @NotNull
    private Function1<? super List<? extends EditCommand>, Unit> onEditCommand;

    @NotNull
    private Function1<? super ImeAction, Unit> onImeActionPerformed;

    @NotNull
    private TextFieldValue state;

    @NotNull
    private final Channel<TextInputCommand> textInputCommandChannel;

    @NotNull
    private final View view;

    /* compiled from: Taobao */
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TextInputCommand.values().length];
            try {
                iArr[TextInputCommand.StartInput.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TextInputCommand.StopInput.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[TextInputCommand.ShowKeyboard.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[TextInputCommand.HideKeyboard.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public TextInputServiceAndroid(@NotNull View view, @NotNull InputMethodManager inputMethodManager) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(inputMethodManager, "inputMethodManager");
        this.view = view;
        this.inputMethodManager = inputMethodManager;
        this.onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onEditCommand$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends EditCommand>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull List<? extends EditCommand> list) {
                Intrinsics.checkNotNullParameter(list, "it");
            }
        };
        this.onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$onImeActionPerformed$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1989invokeKlQnJC8(((ImeAction) obj).m1950unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-KlQnJC8, reason: not valid java name */
            public final void m1989invokeKlQnJC8(int i) {
            }
        };
        this.state = new TextFieldValue("", TextRange.Companion.m1893getZerod9O1mEE(), (TextRange) null, 4, (DefaultConstructorMarker) null);
        this.imeOptions = ImeOptions.Companion.getDefault();
        this.ics = new ArrayList();
        this.baseInputConnection$delegate = LazyKt.lazy(LazyThreadSafetyMode.NONE, new Function0<BaseInputConnection>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$baseInputConnection$2
            {
                super(0);
            }

            @NotNull
            /* renamed from: invoke, reason: merged with bridge method [inline-methods] */
            public final BaseInputConnection m1987invoke() {
                return new BaseInputConnection(TextInputServiceAndroid.this.getView(), false);
            }
        });
        this.textInputCommandChannel = gs.b(Integer.MAX_VALUE, (BufferOverflow) null, (Function1) null, 6, (Object) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final BaseInputConnection getBaseInputConnection() {
        return (BaseInputConnection) this.baseInputConnection$delegate.getValue();
    }

    private final void restartInputImmediately() {
        this.inputMethodManager.restartInput();
    }

    private final void setKeyboardVisibleImmediately(boolean z) {
        if (z) {
            this.inputMethodManager.showSoftInput();
        } else {
            this.inputMethodManager.hideSoftInput();
        }
    }

    private static final void textInputCommandEventLoop$applyToState(TextInputCommand textInputCommand, Ref.ObjectRef<Boolean> objectRef, Ref.ObjectRef<Boolean> objectRef2) {
        int i = WhenMappings.$EnumSwitchMapping$0[textInputCommand.ordinal()];
        if (i == 1) {
            Boolean bool = Boolean.TRUE;
            objectRef.element = bool;
            objectRef2.element = bool;
        } else if (i == 2) {
            Boolean bool2 = Boolean.FALSE;
            objectRef.element = bool2;
            objectRef2.element = bool2;
        } else if ((i == 3 || i == 4) && !Intrinsics.areEqual(objectRef.element, Boolean.FALSE)) {
            objectRef2.element = Boolean.valueOf(textInputCommand == TextInputCommand.ShowKeyboard);
        }
    }

    @Nullable
    public final InputConnection createInputConnection(@NotNull EditorInfo editorInfo) {
        Intrinsics.checkNotNullParameter(editorInfo, "outAttrs");
        if (!this.editorHasFocus) {
            return null;
        }
        TextInputServiceAndroid_androidKt.update(editorInfo, this.imeOptions, this.state);
        TextInputServiceAndroid_androidKt.updateWithEmojiCompat(editorInfo);
        RecordingInputConnection recordingInputConnection = new RecordingInputConnection(this.state, new InputEventCallback2() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$createInputConnection$1
            public void onConnectionClosed(@NotNull RecordingInputConnection recordingInputConnection2) {
                List list;
                List list2;
                List list3;
                Intrinsics.checkNotNullParameter(recordingInputConnection2, "ic");
                list = TextInputServiceAndroid.this.ics;
                int size = list.size();
                for (int i = 0; i < size; i++) {
                    list2 = TextInputServiceAndroid.this.ics;
                    if (Intrinsics.areEqual(((WeakReference) list2.get(i)).get(), recordingInputConnection2)) {
                        list3 = TextInputServiceAndroid.this.ics;
                        list3.remove(i);
                        return;
                    }
                }
            }

            public void onEditCommands(@NotNull List<? extends EditCommand> list) {
                Function1 function1;
                Intrinsics.checkNotNullParameter(list, "editCommands");
                function1 = TextInputServiceAndroid.this.onEditCommand;
                function1.invoke(list);
            }

            /* renamed from: onImeAction-KlQnJC8, reason: not valid java name */
            public void m1988onImeActionKlQnJC8(int i) {
                Function1 function1;
                function1 = TextInputServiceAndroid.this.onImeActionPerformed;
                function1.invoke(ImeAction.m1944boximpl(i));
            }

            public void onKeyEvent(@NotNull KeyEvent keyEvent) {
                BaseInputConnection baseInputConnection;
                Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
                baseInputConnection = TextInputServiceAndroid.this.getBaseInputConnection();
                baseInputConnection.sendKeyEvent(keyEvent);
            }
        }, this.imeOptions.getAutoCorrect());
        this.ics.add(new WeakReference<>(recordingInputConnection));
        return recordingInputConnection;
    }

    @NotNull
    public final TextFieldValue getState$ui_release() {
        return this.state;
    }

    @NotNull
    public final View getView() {
        return this.view;
    }

    public void hideSoftwareKeyboard() {
        this.textInputCommandChannel.trySend-JP2dKIU(TextInputCommand.HideKeyboard);
    }

    public final boolean isEditorFocused() {
        return this.editorHasFocus;
    }

    @Deprecated(message = "This method should not be called, used BringIntoViewRequester instead.")
    public void notifyFocusedRect(@NotNull androidx.compose.ui.geometry.Rect rect) {
        Rect rect2;
        Intrinsics.checkNotNullParameter(rect, "rect");
        this.focusedRect = new Rect(MathKt.roundToInt(rect.getLeft()), MathKt.roundToInt(rect.getTop()), MathKt.roundToInt(rect.getRight()), MathKt.roundToInt(rect.getBottom()));
        if (!this.ics.isEmpty() || (rect2 = this.focusedRect) == null) {
            return;
        }
        this.view.requestRectangleOnScreen(new Rect(rect2));
    }

    public void showSoftwareKeyboard() {
        this.textInputCommandChannel.trySend-JP2dKIU(TextInputCommand.ShowKeyboard);
    }

    public void startInput(@NotNull TextFieldValue textFieldValue, @NotNull ImeOptions imeOptions, @NotNull Function1<? super List<? extends EditCommand>, Unit> function1, @NotNull Function1<? super ImeAction, Unit> function12) {
        Intrinsics.checkNotNullParameter(textFieldValue, "value");
        Intrinsics.checkNotNullParameter(imeOptions, "imeOptions");
        Intrinsics.checkNotNullParameter(function1, "onEditCommand");
        Intrinsics.checkNotNullParameter(function12, "onImeActionPerformed");
        this.editorHasFocus = true;
        this.state = textFieldValue;
        this.imeOptions = imeOptions;
        this.onEditCommand = function1;
        this.onImeActionPerformed = function12;
        this.textInputCommandChannel.trySend-JP2dKIU(TextInputCommand.StartInput);
    }

    public void stopInput() {
        this.editorHasFocus = false;
        this.onEditCommand = new Function1<List<? extends EditCommand>, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((List<? extends EditCommand>) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(@NotNull List<? extends EditCommand> list) {
                Intrinsics.checkNotNullParameter(list, "it");
            }
        };
        this.onImeActionPerformed = new Function1<ImeAction, Unit>() { // from class: androidx.compose.ui.text.input.TextInputServiceAndroid$stopInput$2
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                m1990invokeKlQnJC8(((ImeAction) obj).m1950unboximpl());
                return Unit.INSTANCE;
            }

            /* renamed from: invoke-KlQnJC8, reason: not valid java name */
            public final void m1990invokeKlQnJC8(int i) {
            }
        };
        this.focusedRect = null;
        this.textInputCommandChannel.trySend-JP2dKIU(TextInputCommand.StopInput);
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:19:0x0050 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0039  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0023  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x004e -> B:10:0x0051). Please report as a decompilation issue!!! */
    @org.jetbrains.annotations.Nullable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object textInputCommandEventLoop(@org.jetbrains.annotations.NotNull kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.compose.ui.text.input.TextInputServiceAndroid.textInputCommandEventLoop.1
            if (r0 == 0) goto L13
            r0 = r9
            androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1 r0 = (androidx.compose.ui.text.input.TextInputServiceAndroid.textInputCommandEventLoop.1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1 r0 = new androidx.compose.ui.text.input.TextInputServiceAndroid$textInputCommandEventLoop$1
            r0.<init>(r8, r9)
        L18:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L39
            if (r2 != r3) goto L31
            java.lang.Object r2 = r0.L$1
            kotlinx.coroutines.channels.ChannelIterator r2 = (kotlinx.coroutines.channels.ChannelIterator) r2
            java.lang.Object r4 = r0.L$0
            androidx.compose.ui.text.input.TextInputServiceAndroid r4 = (androidx.compose.ui.text.input.TextInputServiceAndroid) r4
            kotlin.ResultKt.throwOnFailure(r9)
            goto L51
        L31:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L39:
            kotlin.ResultKt.throwOnFailure(r9)
            kotlinx.coroutines.channels.Channel<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r9 = r8.textInputCommandChannel
            kotlinx.coroutines.channels.ChannelIterator r9 = r9.iterator()
            r4 = r8
            r2 = r9
        L44:
            r0.L$0 = r4
            r0.L$1 = r2
            r0.label = r3
            java.lang.Object r9 = r2.hasNext(r0)
            if (r9 != r1) goto L51
            return r1
        L51:
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto Lbd
            java.lang.Object r9 = r2.next()
            androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r9 = (androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand) r9
            android.view.View r5 = r4.view
            boolean r5 = r5.isFocused()
            if (r5 != 0) goto L74
        L67:
            kotlinx.coroutines.channels.Channel<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r9 = r4.textInputCommandChannel
            java.lang.Object r9 = r9.tryReceive-PtdJZtk()
            boolean r9 = tb.is.j(r9)
            if (r9 != 0) goto L67
            goto L44
        L74:
            kotlin.jvm.internal.Ref$ObjectRef r5 = new kotlin.jvm.internal.Ref$ObjectRef
            r5.<init>()
            kotlin.jvm.internal.Ref$ObjectRef r6 = new kotlin.jvm.internal.Ref$ObjectRef
            r6.<init>()
        L7e:
            if (r9 == 0) goto L90
            textInputCommandEventLoop$applyToState(r9, r5, r6)
            kotlinx.coroutines.channels.Channel<androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand> r9 = r4.textInputCommandChannel
            java.lang.Object r9 = r9.tryReceive-PtdJZtk()
            java.lang.Object r9 = tb.is.f(r9)
            androidx.compose.ui.text.input.TextInputServiceAndroid$TextInputCommand r9 = (androidx.compose.ui.text.input.TextInputServiceAndroid.TextInputCommand) r9
            goto L7e
        L90:
            java.lang.Object r9 = r5.element
            java.lang.Boolean r7 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r3)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r7)
            if (r9 == 0) goto L9f
            r4.restartInputImmediately()
        L9f:
            java.lang.Object r9 = r6.element
            java.lang.Boolean r9 = (java.lang.Boolean) r9
            if (r9 == 0) goto Lac
            boolean r9 = r9.booleanValue()
            r4.setKeyboardVisibleImmediately(r9)
        Lac:
            java.lang.Object r9 = r5.element
            r5 = 0
            java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r5)
            if (r9 == 0) goto L44
            r4.restartInputImmediately()
            goto L44
        Lbd:
            kotlin.Unit r9 = kotlin.Unit.INSTANCE
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.input.TextInputServiceAndroid.textInputCommandEventLoop(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public void updateState(@Nullable TextFieldValue textFieldValue, @NotNull TextFieldValue textFieldValue2) {
        Intrinsics.checkNotNullParameter(textFieldValue2, "newValue");
        boolean z = true;
        boolean z2 = (TextRange.equals-impl0(this.state.m1985getSelectiond9O1mEE(), textFieldValue2.m1985getSelectiond9O1mEE()) && Intrinsics.areEqual(this.state.m1984getCompositionMzsxiRA(), textFieldValue2.m1984getCompositionMzsxiRA())) ? false : true;
        this.state = textFieldValue2;
        int size = this.ics.size();
        for (int i = 0; i < size; i++) {
            RecordingInputConnection recordingInputConnection = this.ics.get(i).get();
            if (recordingInputConnection != null) {
                recordingInputConnection.setMTextFieldValue$ui_release(textFieldValue2);
            }
        }
        if (Intrinsics.areEqual(textFieldValue, textFieldValue2)) {
            if (z2) {
                InputMethodManager inputMethodManager = this.inputMethodManager;
                int i2 = TextRange.getMin-impl(textFieldValue2.m1985getSelectiond9O1mEE());
                int i3 = TextRange.getMax-impl(textFieldValue2.m1985getSelectiond9O1mEE());
                TextRange m1984getCompositionMzsxiRA = this.state.m1984getCompositionMzsxiRA();
                int i4 = m1984getCompositionMzsxiRA != null ? TextRange.getMin-impl(m1984getCompositionMzsxiRA.unbox-impl()) : -1;
                TextRange m1984getCompositionMzsxiRA2 = this.state.m1984getCompositionMzsxiRA();
                inputMethodManager.updateSelection(i2, i3, i4, m1984getCompositionMzsxiRA2 != null ? TextRange.getMax-impl(m1984getCompositionMzsxiRA2.unbox-impl()) : -1);
                return;
            }
            return;
        }
        if (textFieldValue == null || (Intrinsics.areEqual(textFieldValue.getText(), textFieldValue2.getText()) && (!TextRange.equals-impl0(textFieldValue.m1985getSelectiond9O1mEE(), textFieldValue2.m1985getSelectiond9O1mEE()) || Intrinsics.areEqual(textFieldValue.m1984getCompositionMzsxiRA(), textFieldValue2.m1984getCompositionMzsxiRA())))) {
            z = false;
        }
        if (z) {
            restartInputImmediately();
            return;
        }
        int size2 = this.ics.size();
        for (int i5 = 0; i5 < size2; i5++) {
            RecordingInputConnection recordingInputConnection2 = this.ics.get(i5).get();
            if (recordingInputConnection2 != null) {
                recordingInputConnection2.updateInputState(this.state, this.inputMethodManager);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextInputServiceAndroid(@NotNull View view) {
        this(view, new InputMethodManagerImpl(view));
        Intrinsics.checkNotNullParameter(view, "view");
    }
}
