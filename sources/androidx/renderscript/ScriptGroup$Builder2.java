package androidx.renderscript;

import android.util.Pair;
import androidx.renderscript.Script;
import androidx.renderscript.ScriptGroup;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
public final class ScriptGroup$Builder2 {
    private static final String TAG = "ScriptGroup.Builder2";
    List<ScriptGroup.Closure> mClosures = new ArrayList();
    List<ScriptGroup$Input> mInputs = new ArrayList();
    RenderScript mRS;

    public ScriptGroup$Builder2(RenderScript renderScript) {
        this.mRS = renderScript;
    }

    private ScriptGroup.Closure addInvokeInternal(Script.InvokeID invokeID, Object[] objArr, Map<Script$FieldID, Object> map) {
        ScriptGroup.Closure closure = new ScriptGroup.Closure(this.mRS, invokeID, objArr, map);
        this.mClosures.add(closure);
        return closure;
    }

    private ScriptGroup.Closure addKernelInternal(Script.KernelID kernelID, Type type, Object[] objArr, Map<Script$FieldID, Object> map) {
        ScriptGroup.Closure closure = new ScriptGroup.Closure(this.mRS, kernelID, type, objArr, map);
        this.mClosures.add(closure);
        return closure;
    }

    private boolean seperateArgsAndBindings(Object[] objArr, ArrayList<Object> arrayList, Map<Script$FieldID, Object> map) {
        int i = 0;
        while (i < objArr.length && !(objArr[i] instanceof ScriptGroup$Binding)) {
            arrayList.add(objArr[i]);
            i++;
        }
        while (i < objArr.length) {
            if (!(objArr[i] instanceof ScriptGroup$Binding)) {
                return false;
            }
            ScriptGroup$Binding scriptGroup$Binding = (ScriptGroup$Binding) objArr[i];
            map.put(scriptGroup$Binding.getField(), scriptGroup$Binding.getValue());
            i++;
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.renderscript.ScriptGroup$Input, java.lang.Object] */
    public ScriptGroup$Input addInput() {
        ?? r0 = new Object() { // from class: androidx.renderscript.ScriptGroup$Input
            Object mValue;
            List<Pair<ScriptGroup.Closure, Script$FieldID>> mFieldID = new ArrayList();
            List<Pair<ScriptGroup.Closure, Integer>> mArgIndex = new ArrayList();

            void addReference(ScriptGroup.Closure closure, int i) {
                this.mArgIndex.add(Pair.create(closure, Integer.valueOf(i)));
            }

            Object get() {
                return this.mValue;
            }

            void set(Object obj) {
                this.mValue = obj;
                for (Pair<ScriptGroup.Closure, Integer> pair : this.mArgIndex) {
                    ((ScriptGroup.Closure) pair.first).setArg(((Integer) pair.second).intValue(), obj);
                }
                for (Pair<ScriptGroup.Closure, Script$FieldID> pair2 : this.mFieldID) {
                    ((ScriptGroup.Closure) pair2.first).setGlobal((Script$FieldID) pair2.second, obj);
                }
            }

            void addReference(ScriptGroup.Closure closure, Script$FieldID script$FieldID) {
                this.mFieldID.add(Pair.create(closure, script$FieldID));
            }
        };
        this.mInputs.add(r0);
        return r0;
    }

    public ScriptGroup.Closure addInvoke(Script.InvokeID invokeID, Object... objArr) {
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        if (seperateArgsAndBindings(objArr, arrayList, hashMap)) {
            return addInvokeInternal(invokeID, arrayList.toArray(), hashMap);
        }
        return null;
    }

    public ScriptGroup.Closure addKernel(Script.KernelID kernelID, Type type, Object... objArr) {
        ArrayList<Object> arrayList = new ArrayList<>();
        HashMap hashMap = new HashMap();
        if (seperateArgsAndBindings(objArr, arrayList, hashMap)) {
            return addKernelInternal(kernelID, type, arrayList.toArray(), hashMap);
        }
        return null;
    }

    public ScriptGroup create(String str, ScriptGroup$Future... scriptGroup$FutureArr) {
        if (str == null || str.isEmpty() || str.length() > 100 || !str.equals(str.replaceAll("[^a-zA-Z0-9-]", "_"))) {
            throw new RSIllegalArgumentException("invalid script group name");
        }
        return new ScriptGroup(this.mRS, str, this.mClosures, this.mInputs, scriptGroup$FutureArr);
    }
}
