package com.windrose.coliseum.ludicoliseum.view.utils

import androidx.fragment.app.Fragment
import com.windrose.coliseum.ludicoliseum.R


fun Fragment.routeToFragment(fragment: Fragment) {
    val transaction = fragmentManager?.beginTransaction()
    transaction?.replace(R.id.fragment_container, fragment)
    transaction?.commit()
}