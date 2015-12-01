package com.yongchun.library.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.yongchun.library.R;
import com.yongchun.library.model.LocalMedia;
import com.yongchun.library.model.LocalMediaFolder;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by dee on 15/11/20.
 */
public class ImageFolderAdapter extends RecyclerView.Adapter<ImageFolderAdapter.ViewHolder>{
    private Context context;
    private List<LocalMediaFolder> folders = new ArrayList<>();
    private int checkedIndex = 0;

    private OnItemClickListener onItemClickListener;
    public ImageFolderAdapter(Context context) {
        this.context = context;
    }

    public void bindFolder(List<LocalMediaFolder> folders){
        this.folders = folders;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(R.layout.item_folder,parent,false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final LocalMediaFolder folder = folders.get(position);
        Glide.with(context)
                .load(new File(folder.getFirstImagePath()))
                .placeholder(R.mipmap.ic_placeholder)
                .error(R.mipmap.ic_placeholder)
                .centerCrop()
                .into(holder.firstImage);
        holder.folderName.setText(folder.getName());
        holder.imageNum.setText(context.getString(R.string.num_postfix,folder.getImageNum()));

        holder.isSelected.setVisibility(checkedIndex == position ? View.VISIBLE : View.GONE);

        holder.contentView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener != null) {
                    checkedIndex = position;
                    notifyDataSetChanged();
                    onItemClickListener.onItemClick(folder.getName(),folder.getImages());
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return folders.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView firstImage;
        TextView folderName;
        TextView imageNum;
        ImageView isSelected;

        View contentView;
        public ViewHolder(View itemView) {
            super(itemView);
            contentView = itemView;
            firstImage = (ImageView) itemView.findViewById(R.id.first_image);
            folderName = (TextView) itemView.findViewById(R.id.folder_name);
            imageNum = (TextView) itemView.findViewById(R.id.image_num);
            isSelected = (ImageView) itemView.findViewById(R.id.is_selected);
        }
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        this.onItemClickListener = onItemClickListener;
    }
    public interface OnItemClickListener{
        void onItemClick(String folderName,List<LocalMedia> images);
    }
}
