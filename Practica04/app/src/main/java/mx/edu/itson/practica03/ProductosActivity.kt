package mx.edu.itson.practica03

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class ProductosActivity : AppCompatActivity() {
    var menu: ArrayList<Product> = ArrayList<Product>()

    override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_productos)

            agregarProductos()
            var listView: ListView = findViewById(R.id.litview) as ListView
            var adaptador : AdaptadorProductos = AdaptadorProductos(this, menu)
        listView.adapter = adaptador
    }
    fun agregarProductos(){
        menu.add(Product("Quesadillas", R.drawable.quesadillas,"Rellenas con su carne favorita, servidas con ensalada. Filled with your choice of meat, served with salad.", 6.29))
        menu.add(Product("Huaraches", R.drawable.huaraches,"Tortilla gruesa con frijoles, tu carne favorita, lechuga, queso fresco y crema - Big thick tortilla with beans, your choice of meat, fresh cheese, and sour cream.", 11.49))
        menu.add(Product("Gringas", R.drawable.gringas,"Tortilla de harina con queso, carne al pastor y piña.  Flour tortilla filled with cheese, marinated pork and pineapple.", 8.39))
        menu.add(Product("Sincronizadas", R.drawable.sincronizadas,"Tortilla de harina rellena con queso y jamón. Acompañada de lechuga, crema y guacamole. Two four tortillas filled with ham and cheese. Served with lettuce, sour cream, and guacamole.", 7.99))
        menu.add(Product("Sopes", R.drawable.sopes,"Tortilla gruesa cubierta de frijoles, tu carne favorita, lechuga, queso fresco y crema. Fried thick tortilla with beans, your choice of meat, lettuce, fresh cheese, and sour cream.", 3.99))
        menu.add(Product("Tostadas", R.drawable.tostadas,"Tortilla frita con frijoles, tu carne favorita, lechuga, queso fresco, crema y jitomate. Fried tortilla with beans, your choice of meat, lettuce, fresh cheese, sour cream and tomatoes.", 4.59))
    }

    private class AdaptadorProductos: BaseAdapter {
        var producto= ArrayList<Product>()
        var contexto: Context?=null

        constructor(contexto:Context, producto: ArrayList<Product>){
            this.producto=producto
            this.contexto=contexto
        }

        override fun getCount(): Int {
            return producto.size
        }

        override fun getItem(position: Int): Any? {
            return producto[position]
        }

        override fun getItemId(position: Int): Long {
            return position.toLong()
        }

        override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
            var prod=producto [position]
            var inflador= LayoutInflater.from(contexto)
            var vista=inflador.inflate(R.layout.producto_view, null)

            var imagen=vista.findViewById(R.id.producto_img) as ImageView
            var nombre=vista.findViewById(R.id.producto_nombre) as TextView
            var desc=vista.findViewById(R.id.producto_desc) as TextView
            var precio=vista.findViewById(R.id.producto_precio) as TextView

            imagen.setImageResource(prod.image)
            nombre.setText(prod.name)
            desc.setText(prod.description)
            precio.setText("$${prod.price}")
            return vista
        }
    }
}