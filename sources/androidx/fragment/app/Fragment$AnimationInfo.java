package androidx.fragment.app;

import android.view.View;
import androidx.annotation.AnimRes;
import androidx.core.app.SharedElementCallback;
import java.util.ArrayList;

/* compiled from: Taobao */
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class Fragment$AnimationInfo {
    Boolean mAllowEnterTransitionOverlap;
    Boolean mAllowReturnTransitionOverlap;
    View mAnimatingAway;

    @AnimRes
    int mEnterAnim;
    Object mEnterTransition = null;
    SharedElementCallback mEnterTransitionCallback;
    boolean mEnterTransitionPostponed;

    @AnimRes
    int mExitAnim;
    Object mExitTransition;
    SharedElementCallback mExitTransitionCallback;
    View mFocusedView;
    boolean mIsPop;
    int mNextTransition;

    @AnimRes
    int mPopEnterAnim;

    @AnimRes
    int mPopExitAnim;
    float mPostOnViewCreatedAlpha;
    Object mReenterTransition;
    Object mReturnTransition;
    Object mSharedElementEnterTransition;
    Object mSharedElementReturnTransition;
    ArrayList<String> mSharedElementSourceNames;
    ArrayList<String> mSharedElementTargetNames;

    Fragment$AnimationInfo() {
        Object obj = Fragment.USE_DEFAULT_TRANSITION;
        this.mReturnTransition = obj;
        this.mExitTransition = null;
        this.mReenterTransition = obj;
        this.mSharedElementEnterTransition = null;
        this.mSharedElementReturnTransition = obj;
        this.mEnterTransitionCallback = null;
        this.mExitTransitionCallback = null;
        this.mPostOnViewCreatedAlpha = 1.0f;
        this.mFocusedView = null;
    }
}
