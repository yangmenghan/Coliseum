package games.windrose.coliseum.view.utils

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import games.windrose.coliseum.R


fun Fragment.routeToFragment(fragment: Fragment) {
    val transaction = fragmentManager?.beginTransaction()
    transaction?.replace(R.id.fragment_container, fragment)
    transaction?.commit()
}

fun AppCompatActivity.routeToFragment(fragment: Fragment) {
    val transaction = supportFragmentManager.beginTransaction()
    transaction.replace(R.id.fragment_container, fragment)
    transaction.commit()
}

fun Int.toPx() = (this * Resources.getSystem().displayMetrics.density).toInt()
