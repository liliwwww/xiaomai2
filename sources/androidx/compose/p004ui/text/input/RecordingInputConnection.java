package androidx.compose.p004ui.text.input;

import android.os.Bundle;
import android.os.Handler;
import android.taobao.windvane.monitor.WVPackageMonitorInterface;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.compose.p004ui.text.TextRange;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import com.alibaba.surgeon.bridge.ISurgeon;
import com.alibaba.surgeon.instrument.InstrumentAPI;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* compiled from: Taobao */
/* loaded from: classes2.dex */
public final class RecordingInputConnection implements InputConnection {
    private static transient /* synthetic */ ISurgeon $surgeonFlag;
    private final boolean autoCorrect;
    private int batchDepth;
    private int currentExtractedTextRequestToken;

    @NotNull
    private final List<EditCommand> editCommands;

    @NotNull
    private final InputEventCallback2 eventCallback;
    private boolean extractedTextMonitorMode;
    private boolean isActive;

    @NotNull
    private TextFieldValue mTextFieldValue;

    public RecordingInputConnection(@NotNull TextFieldValue textFieldValue, @NotNull InputEventCallback2 inputEventCallback2, boolean z) {
        Intrinsics.checkNotNullParameter(textFieldValue, "initState");
        Intrinsics.checkNotNullParameter(inputEventCallback2, "eventCallback");
        this.eventCallback = inputEventCallback2;
        this.autoCorrect = z;
        this.mTextFieldValue = textFieldValue;
        this.editCommands = new ArrayList();
        this.isActive = true;
    }

    private final void addEditCommandWithBatch(EditCommand editCommand) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "7")) {
            iSurgeon.surgeon$dispatch("7", new Object[]{this, editCommand});
            return;
        }
        beginBatchEditInternal();
        try {
            this.editCommands.add(editCommand);
        } finally {
            endBatchEditInternal();
        }
    }

    private final boolean beginBatchEditInternal() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.UNKNOWN_FAILED)) {
            return ((Boolean) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.UNKNOWN_FAILED, new Object[]{this})).booleanValue();
        }
        this.batchDepth++;
        return true;
    }

    private final boolean endBatchEditInternal() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.CREATE_STREAM_FAILED)) {
            return ((Boolean) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.CREATE_STREAM_FAILED, new Object[]{this})).booleanValue();
        }
        int i = this.batchDepth - 1;
        this.batchDepth = i;
        if (i == 0 && (!this.editCommands.isEmpty())) {
            this.eventCallback.onEditCommands(CollectionsKt.toMutableList(this.editCommands));
            this.editCommands.clear();
        }
        return this.batchDepth > 0;
    }

    private final boolean ensureActive(Function0<Unit> function0) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "5")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("5", new Object[]{this, function0})).booleanValue();
        }
        boolean z = this.isActive;
        if (z) {
            function0.invoke();
        }
        return z;
    }

    private final void logDebug(String str) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "36")) {
            iSurgeon.surgeon$dispatch("36", new Object[]{this, str});
        }
    }

    private final void sendSynthesizedKeyEvent(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.ZIP_CONFIG_EMPTY_FAILED)) {
            iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.ZIP_CONFIG_EMPTY_FAILED, new Object[]{this, Integer.valueOf(i)});
        } else {
            sendKeyEvent(new KeyEvent(0, i));
            sendKeyEvent(new KeyEvent(1, i));
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean beginBatchEdit() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "8")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("8", new Object[]{this})).booleanValue();
        }
        boolean z = this.isActive;
        return z ? beginBatchEditInternal() : z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean clearMetaKeyStates(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "31")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("31", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public void closeConnection() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.READ_LOCAL_FILE_FAILED)) {
            iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.READ_LOCAL_FILE_FAILED, new Object[]{this});
            return;
        }
        this.editCommands.clear();
        this.batchDepth = 0;
        this.isActive = false;
        this.eventCallback.onConnectionClosed(this);
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCompletion(@Nullable CompletionInfo completionInfo) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "28")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("28", new Object[]{this, completionInfo})).booleanValue();
        }
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitContent(@NotNull InputContentInfo inputContentInfo, int i, @Nullable Bundle bundle) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "35")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("35", new Object[]{this, inputContentInfo, Integer.valueOf(i), bundle})).booleanValue();
        }
        Intrinsics.checkNotNullParameter(inputContentInfo, "inputContentInfo");
        boolean z = this.isActive;
        if (z) {
            return false;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitCorrection(@Nullable CorrectionInfo correctionInfo) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "29")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("29", new Object[]{this, correctionInfo})).booleanValue();
        }
        boolean z = this.isActive;
        return z ? this.autoCorrect : z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean commitText(@Nullable CharSequence charSequence, int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.MAPPING_URL_NULL_FAILED)) {
            return ((Boolean) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.MAPPING_URL_NULL_FAILED, new Object[]{this, charSequence, Integer.valueOf(i)})).booleanValue();
        }
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new CommitTextCommand(String.valueOf(charSequence), i));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingText(int i, int i2) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "16")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("16", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextCommand(i, i2));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean deleteSurroundingTextInCodePoints(int i, int i2) {
        if (i >= 20000 || i2 >= 20000) {
            i = 0;
            i2 = 0;
        }
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new DeleteSurroundingTextInCodePointsCommand(i, i2));
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean endBatchEdit() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.SECURITY_FAILED) ? ((Boolean) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.SECURITY_FAILED, new Object[]{this})).booleanValue() : endBatchEditInternal();
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean finishComposingText() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "18")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("18", new Object[]{this})).booleanValue();
        }
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new FinishComposingTextCommand());
        return true;
    }

    public final boolean getAutoCorrect() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, ExifInterface.GPS_MEASUREMENT_2D) ? ((Boolean) iSurgeon.surgeon$dispatch(ExifInterface.GPS_MEASUREMENT_2D, new Object[]{this})).booleanValue() : this.autoCorrect;
    }

    @Override // android.view.inputmethod.InputConnection
    public int getCursorCapsMode(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "33") ? ((Integer) iSurgeon.surgeon$dispatch("33", new Object[]{this, Integer.valueOf(i)})).intValue() : TextUtils.getCapsMode(this.mTextFieldValue.getText(), TextRange.m4747getMinimpl(this.mTextFieldValue.m4956getSelectiond9O1mEE()), i);
    }

    @NotNull
    public final InputEventCallback2 getEventCallback() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, "1") ? (InputEventCallback2) iSurgeon.surgeon$dispatch("1", new Object[]{this}) : this.eventCallback;
    }

    @Override // android.view.inputmethod.InputConnection
    @NotNull
    public ExtractedText getExtractedText(@Nullable ExtractedTextRequest extractedTextRequest, int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.ZIP_REMOVED_BY_CLEAR)) {
            return (ExtractedText) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.ZIP_REMOVED_BY_CLEAR, new Object[]{this, extractedTextRequest, Integer.valueOf(i)});
        }
        boolean z = (i & 1) != 0;
        this.extractedTextMonitorMode = z;
        if (z) {
            this.currentExtractedTextRequestToken = extractedTextRequest != null ? extractedTextRequest.token : 0;
        }
        return InputState_androidKt.toExtractedText(this.mTextFieldValue);
    }

    @Override // android.view.inputmethod.InputConnection
    @Nullable
    public Handler getHandler() {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "30")) {
            return (Handler) iSurgeon.surgeon$dispatch("30", new Object[]{this});
        }
        return null;
    }

    @NotNull
    public final TextFieldValue getMTextFieldValue$ui_release() {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, ExifInterface.GPS_MEASUREMENT_3D) ? (TextFieldValue) iSurgeon.surgeon$dispatch(ExifInterface.GPS_MEASUREMENT_3D, new Object[]{this}) : this.mTextFieldValue;
    }

    @Override // android.view.inputmethod.InputConnection
    @Nullable
    public CharSequence getSelectedText(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.FORCE_ONLINE_FAILED)) {
            return (CharSequence) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.FORCE_ONLINE_FAILED, new Object[]{this, Integer.valueOf(i)});
        }
        if (TextRange.m4743getCollapsedimpl(this.mTextFieldValue.m4956getSelectiond9O1mEE())) {
            return null;
        }
        return TextFieldValueKt.getSelectedText(this.mTextFieldValue).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    @NotNull
    public CharSequence getTextAfterCursor(int i, int i2) {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.FORCE_UPDATE_FAILED) ? (CharSequence) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.FORCE_UPDATE_FAILED, new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)}) : TextFieldValueKt.getTextAfterSelection(this.mTextFieldValue, i).toString();
    }

    @Override // android.view.inputmethod.InputConnection
    @NotNull
    public CharSequence getTextBeforeCursor(int i, int i2) {
        ISurgeon iSurgeon = $surgeonFlag;
        return InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.NOT_INSTALL_FAILED) ? (CharSequence) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.NOT_INSTALL_FAILED, new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)}) : TextFieldValueKt.getTextBeforeSelection(this.mTextFieldValue, i).toString();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:13:0x004e, code lost:
    
        return false;
     */
    @Override // android.view.inputmethod.InputConnection
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean performContextMenuAction(int r5) {
        /*
            r4 = this;
            com.alibaba.surgeon.bridge.ISurgeon r0 = androidx.compose.p004ui.text.input.RecordingInputConnection.$surgeonFlag
            java.lang.String r1 = "25"
            boolean r2 = com.alibaba.surgeon.instrument.InstrumentAPI.support(r0, r1)
            r3 = 0
            if (r2 == 0) goto L22
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r3] = r4
            r3 = 1
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r2[r3] = r5
            java.lang.Object r5 = r0.surgeon$dispatch(r1, r2)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            return r5
        L22:
            boolean r0 = r4.isActive
            if (r0 == 0) goto L4f
            switch(r5) {
                case 16908319: goto L3c;
                case 16908320: goto L36;
                case 16908321: goto L30;
                case 16908322: goto L2a;
                default: goto L29;
            }
        L29:
            goto L4e
        L2a:
            r5 = 279(0x117, float:3.91E-43)
            r4.sendSynthesizedKeyEvent(r5)
            goto L4e
        L30:
            r5 = 278(0x116, float:3.9E-43)
            r4.sendSynthesizedKeyEvent(r5)
            goto L4e
        L36:
            r5 = 277(0x115, float:3.88E-43)
            r4.sendSynthesizedKeyEvent(r5)
            goto L4e
        L3c:
            androidx.compose.ui.text.input.SetSelectionCommand r5 = new androidx.compose.ui.text.input.SetSelectionCommand
            androidx.compose.ui.text.input.TextFieldValue r0 = r4.mTextFieldValue
            java.lang.String r0 = r0.getText()
            int r0 = r0.length()
            r5.<init>(r3, r0)
            r4.addEditCommandWithBatch(r5)
        L4e:
            return r3
        L4f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.p004ui.text.input.RecordingInputConnection.performContextMenuAction(int):boolean");
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performEditorAction(int i) {
        int m4895getDefaulteUduSuo;
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "27")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("27", new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        if (i != 0) {
            switch (i) {
                case 2:
                    m4895getDefaulteUduSuo = ImeAction.Companion.m4897getGoeUduSuo();
                    break;
                case 3:
                    m4895getDefaulteUduSuo = ImeAction.Companion.m4901getSearcheUduSuo();
                    break;
                case 4:
                    m4895getDefaulteUduSuo = ImeAction.Companion.m4902getSendeUduSuo();
                    break;
                case 5:
                    m4895getDefaulteUduSuo = ImeAction.Companion.m4898getNexteUduSuo();
                    break;
                case 6:
                    m4895getDefaulteUduSuo = ImeAction.Companion.m4896getDoneeUduSuo();
                    break;
                case 7:
                    m4895getDefaulteUduSuo = ImeAction.Companion.m4900getPreviouseUduSuo();
                    break;
                default:
                    Log.w(RecordingInputConnection_androidKt.TAG, "IME sends unsupported Editor Action: " + i);
                    m4895getDefaulteUduSuo = ImeAction.Companion.m4895getDefaulteUduSuo();
                    break;
            }
        } else {
            m4895getDefaulteUduSuo = ImeAction.Companion.m4895getDefaulteUduSuo();
        }
        this.eventCallback.mo4909onImeActionKlQnJC8(m4895getDefaulteUduSuo);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean performPrivateCommand(@Nullable String str, @Nullable Bundle bundle) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "34")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("34", new Object[]{this, str, bundle})).booleanValue();
        }
        boolean z = this.isActive;
        if (z) {
            return true;
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean reportFullscreenMode(boolean z) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "32")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("32", new Object[]{this, Boolean.valueOf(z)})).booleanValue();
        }
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean requestCursorUpdates(int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.CONFIG_CLOSED_FAILED)) {
            return ((Boolean) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.CONFIG_CLOSED_FAILED, new Object[]{this, Integer.valueOf(i)})).booleanValue();
        }
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        Log.w(RecordingInputConnection_androidKt.TAG, "requestCursorUpdates is not supported");
        return false;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean sendKeyEvent(@NotNull KeyEvent keyEvent) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "19")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("19", new Object[]{this, keyEvent})).booleanValue();
        }
        Intrinsics.checkNotNullParameter(keyEvent, NotificationCompat.CATEGORY_EVENT);
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        this.eventCallback.onKeyEvent(keyEvent);
        return true;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingRegion(int i, int i2) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.MAPPING_URL_MATCH_FAILED)) {
            return ((Boolean) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.MAPPING_URL_MATCH_FAILED, new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetComposingRegionCommand(i, i2));
        }
        return z;
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setComposingText(@Nullable CharSequence charSequence, int i) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, WVPackageMonitorInterface.READ_COMBO_LOCAL_FILE_FAILED)) {
            return ((Boolean) iSurgeon.surgeon$dispatch(WVPackageMonitorInterface.READ_COMBO_LOCAL_FILE_FAILED, new Object[]{this, charSequence, Integer.valueOf(i)})).booleanValue();
        }
        boolean z = this.isActive;
        if (z) {
            addEditCommandWithBatch(new SetComposingTextCommand(String.valueOf(charSequence), i));
        }
        return z;
    }

    public final void setMTextFieldValue$ui_release(@NotNull TextFieldValue textFieldValue) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "4")) {
            iSurgeon.surgeon$dispatch("4", new Object[]{this, textFieldValue});
        } else {
            Intrinsics.checkNotNullParameter(textFieldValue, "value");
            this.mTextFieldValue = textFieldValue;
        }
    }

    @Override // android.view.inputmethod.InputConnection
    public boolean setSelection(int i, int i2) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "17")) {
            return ((Boolean) iSurgeon.surgeon$dispatch("17", new Object[]{this, Integer.valueOf(i), Integer.valueOf(i2)})).booleanValue();
        }
        boolean z = this.isActive;
        if (!z) {
            return z;
        }
        addEditCommandWithBatch(new SetSelectionCommand(i, i2));
        return true;
    }

    public final void updateInputState(@NotNull TextFieldValue textFieldValue, @NotNull InputMethodManager inputMethodManager) {
        ISurgeon iSurgeon = $surgeonFlag;
        if (InstrumentAPI.support(iSurgeon, "6")) {
            iSurgeon.surgeon$dispatch("6", new Object[]{this, textFieldValue, inputMethodManager});
            return;
        }
        Intrinsics.checkNotNullParameter(textFieldValue, "state");
        Intrinsics.checkNotNullParameter(inputMethodManager, "inputMethodManager");
        if (this.isActive) {
            setMTextFieldValue$ui_release(textFieldValue);
            if (this.extractedTextMonitorMode) {
                inputMethodManager.updateExtractedText(this.currentExtractedTextRequestToken, InputState_androidKt.toExtractedText(textFieldValue));
            }
            TextRange m4955getCompositionMzsxiRA = textFieldValue.m4955getCompositionMzsxiRA();
            int m4747getMinimpl = m4955getCompositionMzsxiRA != null ? TextRange.m4747getMinimpl(m4955getCompositionMzsxiRA.m4753unboximpl()) : -1;
            TextRange m4955getCompositionMzsxiRA2 = textFieldValue.m4955getCompositionMzsxiRA();
            inputMethodManager.updateSelection(TextRange.m4747getMinimpl(textFieldValue.m4956getSelectiond9O1mEE()), TextRange.m4746getMaximpl(textFieldValue.m4956getSelectiond9O1mEE()), m4747getMinimpl, m4955getCompositionMzsxiRA2 != null ? TextRange.m4746getMaximpl(m4955getCompositionMzsxiRA2.m4753unboximpl()) : -1);
        }
    }
}
