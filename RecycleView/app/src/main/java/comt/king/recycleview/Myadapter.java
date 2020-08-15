package comt.king.recycleview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;


public class Myadapter extends RecyclerView.Adapter<Myadapter.ViewHolder>{

    private List<LIstItem>listItems;
    private Context context;

    public Myadapter(List<LIstItem>listItems, Context context){
        this.listItems=listItems;
        this.context=context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.listitems,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        LIstItem lIstItem = listItems.get(position);

        holder.textViewHead.setText(lIstItem.getHead());
        holder.textViewDesc.setText(lIstItem.getDesc());

    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView textViewHead;
        public TextView textViewDesc;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.textviewH);
            textViewDesc = (TextView) itemView.findViewById(R.id.textviewdesc);

        }
    }
}