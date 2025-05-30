package androidx.renderscript;

import androidx.renderscript.ScriptGroup;
import java.util.Comparator;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
class ScriptGroup$Builder$1 implements Comparator<ScriptGroup.Node> {
    final /* synthetic */ ScriptGroup.Builder this$0;

    ScriptGroup$Builder$1(ScriptGroup.Builder builder) {
        this.this$0 = builder;
    }

    @Override // java.util.Comparator
    public int compare(ScriptGroup.Node node, ScriptGroup.Node node2) {
        return node.mOrder - node2.mOrder;
    }
}
