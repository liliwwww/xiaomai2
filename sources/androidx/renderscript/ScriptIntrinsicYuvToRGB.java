package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ScriptIntrinsicYuvToRGB extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private Allocation mInput;

    ScriptIntrinsicYuvToRGB(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    public static ScriptIntrinsicYuvToRGB create(RenderScript renderScript, Element element) {
        boolean z = renderScript.isUseNative() && Build.VERSION.SDK_INT < 19;
        ScriptIntrinsicYuvToRGB scriptIntrinsicYuvToRGB = new ScriptIntrinsicYuvToRGB(renderScript.nScriptIntrinsicCreate(6, element.getID(renderScript), z), renderScript);
        scriptIntrinsicYuvToRGB.setIncSupp(z);
        return scriptIntrinsicYuvToRGB;
    }

    public void forEach(Allocation allocation) {
        forEach(0, (Allocation) null, allocation, (FieldPacker) null);
    }

    public Script$FieldID getFieldID_Input() {
        return createFieldID(0, (Element) null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 2, (Element) null, (Element) null);
    }

    public void setInput(Allocation allocation) {
        this.mInput = allocation;
        setVar(0, allocation);
    }
}
