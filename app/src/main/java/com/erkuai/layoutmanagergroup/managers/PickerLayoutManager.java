package com.erkuai.layoutmanagergroup.managers;

import android.content.Context;
import android.util.Log;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public class PickerLayoutManager extends LinearLayoutManager {

    private float mScale = 0.5f;
    private boolean mIsAlpha = true;
    private LinearSnapHelper mLinearSnapHelper;
    private OnSelectedViewListener mOnSelectedViewListener;
    private int mItemViewWidth;
    private int mItemViewHeight;
    private int mItemCount = -1;
    private RecyclerView mRecyclerView;
    private int mOrientation;


    public PickerLayoutManager(Context context, RecyclerView recyclerView, int orientation, boolean reverseLayout, int itemCount, float scale, boolean isAlpha) {
        super(context, orientation, reverseLayout);
        mLinearSnapHelper = new LinearSnapHelper();
        mItemCount = itemCount;
        mOrientation = orientation;
        mRecyclerView = recyclerView;
        mIsAlpha = isAlpha;
        mScale = scale;
        if (mItemCount != 0) setAutoMeasureEnabled(false);
    }

    @Override
    public void onAttachedToWindow(RecyclerView view) {
        super.onAttachedToWindow(view);
        mLinearSnapHelper.attachToRecyclerView(view);
    }

    @Override
    public void onMeasure(@NonNull RecyclerView.Recycler recycler, @NonNull RecyclerView.State state, int widthSpec, int heightSpec) {

        Log.i("wmk","getItemCount():"+getItemCount());
        Log.i("wmk","state.getItemCount():"+state.getItemCount());
        if (state.getItemCount() != 0 && mItemCount != 0) {
            View view = recycler.getViewForPosition(0);
            measureChildWithMargins(view, widthSpec, heightSpec);

            mItemViewWidth = view.getMeasuredWidth();
            mItemViewHeight = view.getMeasuredHeight();

            if (mOrientation == VERTICAL) {
                int paddingVertical = (mItemCount - 1) / 2 * mItemViewWidth;
                mRecyclerView.setPadding(0, paddingVertical, 0, paddingVertical);
                setMeasuredDimension(mItemViewWidth, mItemViewHeight * mItemCount);
            }
        } else {
            super.onMeasure(recycler, state, widthSpec, heightSpec);
        }
    }

    @Override
    public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
        super.onLayoutChildren(recycler, state);
        if (getItemCount()<0||state.isPreLayout())return;
        if (mOrientation == VERTICAL){

        }
    }

    public interface OnSelectedViewListener {
        void onSelectedView(View view, int position);
    }

    public void setOnSelectedViewListener(OnSelectedViewListener mOnSelectedViewListener) {
        this.mOnSelectedViewListener = mOnSelectedViewListener;
    }
}
