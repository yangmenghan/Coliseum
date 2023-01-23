package games.windrose.coliseum.view.utils

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MarginItemDecoration(
    private val horizontalSpaceSize: Int = 0,
    private val verticalSpaceSize: Int = 0,
) : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(
        outRect: Rect, view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        with(outRect) {
            if (parent.getChildAdapterPosition(view) == 0) {
                top = verticalSpaceSize
            }
            bottom = verticalSpaceSize
            left = horizontalSpaceSize
            right = horizontalSpaceSize
        }
    }
}