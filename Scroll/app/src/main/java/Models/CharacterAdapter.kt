package Models
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.scroll.R

class CharacterAdapter (private val characters: List<Character>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterAdapter.CharacterViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout_manager, parent, false)

        return CharacterViewHolder(view)
    }

    override fun onBindViewHolder(holder: CharacterAdapter.CharacterViewHolder, position: Int) {
        val character = characters[position]
        holder.bind(character)
    }

    override fun getItemCount(): Int {
        return characters.size
    }


    class CharacterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        private  val characterName: TextView = itemView.findViewById(R.id.character_name);
        private  val characterDescription: TextView = itemView.findViewById(R.id.character_description);
        private  val characterImage: ImageView = itemView.findViewById(R.id.character_image);

        fun bind(character: Character){
            characterName.text = character.name
            characterDescription.text = character.description
            characterImage.setImageResource(character.imageResId)
        }
    }
}