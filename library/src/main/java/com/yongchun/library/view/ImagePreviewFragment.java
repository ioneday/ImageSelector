package com.yongchun.library.view;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;
import com.yongchun.library.R;

import java.io.File;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by dee on 15/11/25.
 */
public class ImagePreviewFragment extends Fragment {
    public static final String PATH = "path";

    public static ImagePreviewFragment getInstance(String path) {
        ImagePreviewFragment fragment = new ImagePreviewFragment();
        Bundle bundle = new Bundle();
        bundle.putString(PATH, path);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View contentView = inflater.inflate(R.layout.fragment_image_preview, container, false);
        final ImageView imageView = (ImageView) contentView.findViewById(R.id.preview_image);
        final PhotoViewAttacher mAttacher = new PhotoViewAttacher(imageView);
        RequestOptions options = new RequestOptions();
        options.skipMemoryCache(true)
                .centerCrop()
                .error(R.drawable.image_placeholder)
                .placeholder(R.drawable.image_placeholder);

        Glide.with(container.getContext())
                .load(new File(getArguments().getString(PATH)))
                .apply(options)
                .into(new SimpleTarget<Drawable>(480,800) {
                    @Override
                    public void onResourceReady(Drawable resource, Transition<? super Drawable> transition) {
                        imageView.setImageDrawable(resource.getCurrent());
                        mAttacher.update();
                    }
                });
        
        mAttacher.setOnViewTapListener(new PhotoViewAttacher.OnViewTapListener() {
            @Override
            public void onViewTap(View view, float x, float y) {
                ImagePreviewActivity activity = (ImagePreviewActivity) getActivity();
                activity.switchBarVisibility();
            }
        });
        return contentView;
    }
}
