package co.com.registropersonamovil2021.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import co.com.registropersonamovil2021.R;
import co.com.registropersonamovil2021.entity.Persona;

public class PersonaAdapter extends BaseAdapter {

    private final LayoutInflater inflater;

    private final List<Persona> personas;

    public PersonaAdapter(Context context, List<Persona> personas) {
        inflater = LayoutInflater.from(context);
        this.personas = personas;
    }

    @Override
    public int getCount() {
        return personas.size();
    }

    @Override
    public Persona getItem(int position) {
        return personas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return personas.get(position).getIdPersona().longValue();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = inflater.inflate(R.layout.item_persona, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }
        holder.numeroDocumento.setText(personas.get(position).getNumeroDocumentoIdentidad());
        holder.nombre.setText(personas.get(position).getNombrePersona());
        holder.apellido.setText(personas.get(position).getApellidoPersona());
        return convertView;
    }




    class ViewHolder {
        @BindView(R.id.txtNumeroDocumento)
        TextView numeroDocumento;
        @BindView(R.id.txNombre)
        TextView nombre;
        @BindView(R.id.txtApellido)
        TextView apellido;
        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
