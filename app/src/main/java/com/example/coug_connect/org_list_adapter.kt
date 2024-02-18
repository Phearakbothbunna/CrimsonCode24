import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coug_connect.R
import com.example.coug_connect.organizations_model

class OrgListAdapter(private val context: Context, private val orgmodels: ArrayList<organizations_model>) : RecyclerView.Adapter<OrgListAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.row_org_recycle_view, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tv1.text = orgmodels[position].orgName
        holder.tv2.text = "xyz" // Replace with the actual property from your OrganizationsModel
        holder.tv3.text = "123" // Replace with the actual property from your OrganizationsModel
        holder.imageView.setImageResource(orgmodels[position].orgPFP)
    }

    override fun getItemCount(): Int {
        return orgmodels.size
    }

    inner class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView: ImageView = itemView.findViewById(R.id.pfp_org)
        val tv1: TextView = itemView.findViewById(R.id.orgTileName)
        val tv2: TextView = itemView.findViewById(R.id.tileCategory2)
        val tv3: TextView = itemView.findViewById(R.id.tileCategory2)
    }
}



//package com.example.coug_connect
//
//import android.view.LayoutInflater
//import android.widget.TextView
//import org.checkerframework.checker.nullness.qual.NonNull
//
//class org_list_adapter extends RecyclerView.Adapter<org_list_adapter.MyViewHolder> {
//
//    Context = context;
//    ArrayList<organizations_model> orgmodels;
//
//    public org_list_adapter(Context context, ArrayList<organizations_model> orgmodels)
//    {
//        this.context = context;
//        this.orgmodels = orgmodels;
//    }
//
//    @NonNull
//    @Override
//    public org_list_adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
//    {
//        LayoutInflater inflater = LayoutInflater.from(context);
//        View view = inflater.inflate(R.layout.row_orgRecycView, parent, attachToRoot false);
//        return new org_list_adapter.MyViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull org_list_adapter.MyViewHolder holder, int position)
//    {
//        holder.tv1.setText(orgmodels.get(position).my_dummy_org_list());
//        holder.tv2.setText(orgmodels.get(position)."xyz");
//        holder.tv3.setText(orgmodels.get(position)."123");
//        holder.orgImages.setImageResource(orgmodels.get(position).my_dummy_org_list());
//    }
//
//    @Override
//    public int getItemCount()
//    {
//        return orgmodels.size();
//    }
//
//    public static class MyViewHolder extends organizations.MyViewHolder{
//
//        ImageView imageView;
//        TextView tv1, tv2, tv3;
//
//        public MyViewHolder(@NonNull View itemView)
//        {
//            super(itemView);
//
//            imageView = itemView.findViewbyID(R.id.pfp_org);
//            tv1 = itemView.findViewbyID(R.id.orgTileName);
//            tv2 = itemView.findViewbyID(R.id.tileCategory1);
//            tv3 = itemView.findViewbyID(R.id.tileCategory2);
//        }
//    }
//}