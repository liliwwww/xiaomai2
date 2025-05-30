package androidx.vectordrawable.graphics.drawable;

import android.content.res.Resources;
import android.graphics.Path;
import android.util.Log;
import androidx.core.graphics.PathParser;
import androidx.core.graphics.PathParser$PathDataNode;
import androidx.vectordrawable.graphics.drawable.VectorDrawableCompat;

/* JADX INFO: Access modifiers changed from: private */
/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
public abstract class VectorDrawableCompat$VPath extends VectorDrawableCompat.VObject {
    protected static final int FILL_TYPE_WINDING = 0;
    int mChangingConfigurations;
    int mFillRule;
    protected PathParser$PathDataNode[] mNodes;
    String mPathName;

    public VectorDrawableCompat$VPath() {
        super((VectorDrawableCompat$1) null);
        this.mNodes = null;
        this.mFillRule = 0;
    }

    public void applyTheme(Resources.Theme theme) {
    }

    public boolean canApplyTheme() {
        return false;
    }

    public PathParser$PathDataNode[] getPathData() {
        return this.mNodes;
    }

    public String getPathName() {
        return this.mPathName;
    }

    public boolean isClipPath() {
        return false;
    }

    public String nodesToString(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
        String str = " ";
        for (int i = 0; i < pathParser$PathDataNodeArr.length; i++) {
            str = str + pathParser$PathDataNodeArr[i].mType + ":";
            for (float f : pathParser$PathDataNodeArr[i].mParams) {
                str = str + f + ",";
            }
        }
        return str;
    }

    public void printVPath(int i) {
        String str = "";
        for (int i2 = 0; i2 < i; i2++) {
            str = str + "    ";
        }
        Log.v("VectorDrawableCompat", str + "current path is :" + this.mPathName + " pathData is " + nodesToString(this.mNodes));
    }

    public void setPathData(PathParser$PathDataNode[] pathParser$PathDataNodeArr) {
        if (PathParser.canMorph(this.mNodes, pathParser$PathDataNodeArr)) {
            PathParser.updateNodes(this.mNodes, pathParser$PathDataNodeArr);
        } else {
            this.mNodes = PathParser.deepCopyNodes(pathParser$PathDataNodeArr);
        }
    }

    public void toPath(Path path) {
        path.reset();
        PathParser$PathDataNode[] pathParser$PathDataNodeArr = this.mNodes;
        if (pathParser$PathDataNodeArr != null) {
            PathParser$PathDataNode.nodesToPath(pathParser$PathDataNodeArr, path);
        }
    }

    public VectorDrawableCompat$VPath(VectorDrawableCompat$VPath vectorDrawableCompat$VPath) {
        super((VectorDrawableCompat$1) null);
        this.mNodes = null;
        this.mFillRule = 0;
        this.mPathName = vectorDrawableCompat$VPath.mPathName;
        this.mChangingConfigurations = vectorDrawableCompat$VPath.mChangingConfigurations;
        this.mNodes = PathParser.deepCopyNodes(vectorDrawableCompat$VPath.mNodes);
    }
}
