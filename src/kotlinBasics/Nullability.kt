package kotlinBasics

import java.util.Locale
import java.util.Locale.getDefault

fun main() {
    // gender variable ko nullable banaya (iske andar kuch bhi ho sakta hai: value ya null)
    val gender: String? = null

    // Safe call operator (?.) — agar gender null hoga to kuch nahi karega, warna uppercase karega
    println(gender?.uppercase(getDefault()))
    // Output: null (kyunki gender abhi null hai)

    // let block — hamesha execute hoga, chahe gender null ho ya value ho
    gender.let {
        println("Line 1")               // Hamesha print hoga
        println("Line 1 $gender")       // gender ki value print hogi, yahan null
        println("Line 1 $it")           // it ki value bhi gender hi hai, so again null
    }

    // Elvis operator (?:) — agar gender null hai, to "NA" assign ho jayega
    val selectedValue = gender ?: "NA"
    // Output: selectedValue = "NA"

    // Not-null assertion (!!) — yahan crash hoga, kyunki gender null hai
    val value = gender!!.uppercase()
    // Output: Throws KotlinNullPointerException (program ya app yahan crash ho jayega)
}
