package androidx.renderscript;

import android.os.Build;
import androidx.renderscript.Script;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public class ScriptIntrinsic3DLUT extends ScriptIntrinsic {
    private static final int INTRINSIC_API_LEVEL = 19;
    private Element mElement;
    private Allocation mLUT;

    protected ScriptIntrinsic3DLUT(long j, RenderScript renderScript, Element element) {
        super(j, renderScript);
        this.mElement = element;
    }

    public static ScriptIntrinsic3DLUT create(RenderScript renderScript, Element element) {
        if (!element.isCompatible(Element.U8_4(renderScript))) {
            throw new RSIllegalArgumentException("Element must be compatible with uchar4.");
        }
        boolean z = renderScript.isUseNative() && Build.VERSION.SDK_INT < 19;
        ScriptIntrinsic3DLUT scriptIntrinsic3DLUT = new ScriptIntrinsic3DLUT(renderScript.nScriptIntrinsicCreate(8, element.getID(renderScript), z), renderScript, element);
        scriptIntrinsic3DLUT.setIncSupp(z);
        return scriptIntrinsic3DLUT;
    }

    public void forEach(Allocation allocation, Allocation allocation2) {
        forEach(0, allocation, allocation2, (FieldPacker) null);
    }

    public Script.KernelID getKernelID() {
        return createKernelID(0, 3, (Element) null, (Element) null);
    }

    public void setLUT(Allocation allocation) {
        Type type = allocation.getType();
        if (type.getZ() == 0) {
            throw new RSIllegalArgumentException("LUT must be 3d.");
        }
        if (!type.getElement().isCompatible(this.mElement)) {
            throw new RSIllegalArgumentException("LUT element type must match.");
        }
        this.mLUT = allocation;
        setVar(0, allocation);
    }
}
