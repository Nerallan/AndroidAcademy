package by.androidacademy.nerallan.ext

import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import kotlin.reflect.KClass

fun bundle(block: Bundle.() -> Unit): Bundle {
    val bundle = Bundle()
    bundle.block()
    return bundle
}

fun <T : Fragment> KClass<T>.getFragmentTag(): String = java.name

fun <T : Fragment> KClass<T>.findFragmentInManagerByTag(fragmentManager: FragmentManager): Fragment? {
    return fragmentManager.findFragmentByTag(getFragmentTag())
}

inline fun <reified T : Fragment> FragmentActivity.replaceFragment(
    @IdRes container: Int,
    fragment: T,
    addToBackStack: Boolean = false
) {
    with(supportFragmentManager.beginTransaction()) {
        replace(container, fragment, T::class.getFragmentTag())
        if (addToBackStack) addToBackStack(null)
        commit()
    }
}

inline fun <reified T : Fragment> FragmentActivity.addFragment(
    @IdRes container: Int,
    fragment: T,
    addToBackStack: Boolean = false
) {
    with(supportFragmentManager.beginTransaction()) {
        add(container, fragment, T::class.getFragmentTag())
        if (addToBackStack) addToBackStack(null)
        commit()
    }
}
