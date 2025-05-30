package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public class ScriptIntrinsicResize extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 21;
    private Allocation mInput;

    protected ScriptIntrinsicResize(long j, RenderScript renderScript) {
        super(j, renderScript);
    }

    /* JADX WARN: Type inference failed for: r3v0, types: [androidx.renderscript.Script, androidx.renderscript.ScriptIntrinsicResize] */
    public static ScriptIntrinsicResize create(RenderScript renderScript) {
        boolean z = renderScript.isUseNative() && Build.VERSION.SDK_INT < 21;
        ?? scriptIntrinsicResize = new ScriptIntrinsicResize(renderScript.nScriptIntrinsicCreate(12, 0L, z), renderScript);
        scriptIntrinsicResize.setIncSupp(z);
        return scriptIntrinsicResize;
    }

    public void forEach_bicubic(Allocation allocation) {
        if (allocation == this.mInput) {
            throw new RSIllegalArgumentException("Output cannot be same as Input.");
        }
        forEach_bicubic(allocation, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Script.FieldID getFieldID_Input() {
        return createFieldID(0, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Script.KernelID getKernelID_bicubic() {
        return createKernelID(0, 2, null, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setInput(Allocation allocation) {
        Element element = allocation.getElement();
        if (!element.isCompatible(Element.U8(((BaseObj) this).mRS)) && !element.isCompatible(Element.U8_2(((BaseObj) this).mRS)) && !element.isCompatible(Element.U8_3(((BaseObj) this).mRS)) && !element.isCompatible(Element.U8_4(((BaseObj) this).mRS)) && !element.isCompatible(Element.F32(((BaseObj) this).mRS)) && !element.isCompatible(Element.F32_2(((BaseObj) this).mRS)) && !element.isCompatible(Element.F32_3(((BaseObj) this).mRS)) && !element.isCompatible(Element.F32_4(((BaseObj) this).mRS))) {
            throw new RSIllegalArgumentException("Unsuported element type.");
        }
        this.mInput = allocation;
        setVar(0, allocation);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void forEach_bicubic(Allocation allocation, Script.LaunchOptions launchOptions) {
        forEach(0, null, allocation, null, launchOptions);
    }
}
