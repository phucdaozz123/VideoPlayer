package tlu.cse.android.ht63.videoplayer.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import tlu.cse.android.ht63.videoplayer.MediaFiles;
import tlu.cse.android.ht63.videoplayer.R;
import tlu.cse.android.ht63.videoplayer.VideoFiles;

public class VideoFolderAdapter extends RecyclerView.Adapter<VideoFolderAdapter.ViewHolder> {
    private ArrayList<MediaFiles>   mediaFiles;
    private ArrayList<String>   folderPath;
    private Context context;

    public VideoFolderAdapter(ArrayList<MediaFiles> mediaFiles, ArrayList<String> folderPath, Context context) {
        this.mediaFiles = mediaFiles;
        this.folderPath = folderPath;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.folder_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//      /storage/Media/Videos
        int indexPath = folderPath.get(position).lastIndexOf("/");
        String nameOfFolder = folderPath.get(position).substring(indexPath+1);
        holder.folder_name.setText(nameOfFolder);
        holder.folder_path.setText(folderPath.get(position));
        holder.no_of_files.setText("5 videos");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, VideoFiles.class);
                intent.putExtra("folderName",nameOfFolder);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return folderPath.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView folder_name,folder_path,no_of_files;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            folder_name = itemView.findViewById(R.id.folderName);
            folder_path = itemView.findViewById(R.id.folderPath);
            no_of_files = itemView.findViewById(R.id.noOfFiles);
        }
    }
}
