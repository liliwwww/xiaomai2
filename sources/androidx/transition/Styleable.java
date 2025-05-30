package androidx.transition;

import android.R;
import android.annotation.SuppressLint;
import androidx.annotation.StyleableRes;

/* compiled from: Taobao */
@SuppressLint({"InlinedApi"})
/* loaded from: E:\ai\xiaomai1\gradle\app\src\main\classes.dex */
class Styleable {

    @StyleableRes
    static final int[] TRANSITION_TARGET = {R.attr.targetClass, R.attr.targetId, R.attr.excludeId, R.attr.excludeClass, R.attr.targetName, R.attr.excludeName};

    @StyleableRes
    static final int[] TRANSITION_MANAGER = {R.attr.fromScene, R.attr.toScene, R.attr.transition};

    @StyleableRes
    static final int[] TRANSITION = {R.attr.interpolator, R.attr.duration, R.attr.startDelay, R.attr.matchOrder};

    @StyleableRes
    static final int[] CHANGE_BOUNDS = {R.attr.resizeClip};

    @StyleableRes
    static final int[] VISIBILITY_TRANSITION = {R.attr.transitionVisibilityMode};

    @StyleableRes
    static final int[] FADE = {R.attr.fadingMode};

    @StyleableRes
    static final int[] CHANGE_TRANSFORM = {R.attr.reparent, R.attr.reparentWithOverlay};

    @StyleableRes
    static final int[] SLIDE = {R.attr.slideEdge};

    @StyleableRes
    static final int[] TRANSITION_SET = {R.attr.transitionOrdering};

    @StyleableRes
    static final int[] ARC_MOTION = {R.attr.minimumHorizontalAngle, R.attr.minimumVerticalAngle, R.attr.maximumAngle};

    @StyleableRes
    static final int[] PATTERN_PATH_MOTION = {R.attr.patternPathData};

    /* compiled from: Taobao */
    interface ChangeTransform {

        @StyleableRes
        public static final int REPARENT = 0;

        @StyleableRes
        public static final int REPARENT_WITH_OVERLAY = 1;
    }

    /* compiled from: Taobao */
    interface PatternPathMotion {

        @StyleableRes
        public static final int PATTERN_PATH_DATA = 0;
    }

    /* compiled from: Taobao */
    interface Transition {

        @StyleableRes
        public static final int DURATION = 1;

        @StyleableRes
        public static final int INTERPOLATOR = 0;

        @StyleableRes
        public static final int MATCH_ORDER = 3;

        @StyleableRes
        public static final int START_DELAY = 2;
    }

    /* compiled from: Taobao */
    interface TransitionManager {

        @StyleableRes
        public static final int FROM_SCENE = 0;

        @StyleableRes
        public static final int TO_SCENE = 1;

        @StyleableRes
        public static final int TRANSITION = 2;
    }

    /* compiled from: Taobao */
    interface TransitionTarget {

        @StyleableRes
        public static final int EXCLUDE_CLASS = 3;

        @StyleableRes
        public static final int EXCLUDE_ID = 2;

        @StyleableRes
        public static final int EXCLUDE_NAME = 5;

        @StyleableRes
        public static final int TARGET_CLASS = 0;

        @StyleableRes
        public static final int TARGET_ID = 1;

        @StyleableRes
        public static final int TARGET_NAME = 4;
    }

    /* compiled from: Taobao */
    interface VisibilityTransition {

        @StyleableRes
        public static final int TRANSITION_VISIBILITY_MODE = 0;
    }

    private Styleable() {
    }
}
