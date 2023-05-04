import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView

class CustomItemAnimator : DefaultItemAnimator() {

    override fun animateRemove(holder: RecyclerView.ViewHolder?): Boolean {
        val animator = super.animateRemove(holder)
        if (animator) {
            holder?.itemView?.postDelayed({
                dispatchAnimationsFinished()
                holder?.itemView?.clearAnimation()
            }, removeDuration)
        }
        return animator
    }
}