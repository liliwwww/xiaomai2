package androidx.fragment.app;

import androidx.annotation.NonNull;
import androidx.lifecycle.Lifecycle;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes2.dex */
final class FragmentTransaction$Op {
    int mCmd;
    Lifecycle.State mCurrentMaxState;
    int mEnterAnim;
    int mExitAnim;
    Fragment mFragment;
    boolean mFromExpandedOp;
    Lifecycle.State mOldMaxState;
    int mPopEnterAnim;
    int mPopExitAnim;

    FragmentTransaction$Op() {
    }

    FragmentTransaction$Op(int i, Fragment fragment) {
        this.mCmd = i;
        this.mFragment = fragment;
        this.mFromExpandedOp = false;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.mOldMaxState = state;
        this.mCurrentMaxState = state;
    }

    FragmentTransaction$Op(int i, Fragment fragment, boolean z) {
        this.mCmd = i;
        this.mFragment = fragment;
        this.mFromExpandedOp = z;
        Lifecycle.State state = Lifecycle.State.RESUMED;
        this.mOldMaxState = state;
        this.mCurrentMaxState = state;
    }

    FragmentTransaction$Op(int i, @NonNull Fragment fragment, Lifecycle.State state) {
        this.mCmd = i;
        this.mFragment = fragment;
        this.mFromExpandedOp = false;
        this.mOldMaxState = fragment.mMaxState;
        this.mCurrentMaxState = state;
    }

    FragmentTransaction$Op(FragmentTransaction$Op fragmentTransaction$Op) {
        this.mCmd = fragmentTransaction$Op.mCmd;
        this.mFragment = fragmentTransaction$Op.mFragment;
        this.mFromExpandedOp = fragmentTransaction$Op.mFromExpandedOp;
        this.mEnterAnim = fragmentTransaction$Op.mEnterAnim;
        this.mExitAnim = fragmentTransaction$Op.mExitAnim;
        this.mPopEnterAnim = fragmentTransaction$Op.mPopEnterAnim;
        this.mPopExitAnim = fragmentTransaction$Op.mPopExitAnim;
        this.mOldMaxState = fragmentTransaction$Op.mOldMaxState;
        this.mCurrentMaxState = fragmentTransaction$Op.mCurrentMaxState;
    }
}
