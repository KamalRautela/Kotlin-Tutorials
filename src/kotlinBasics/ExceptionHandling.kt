fun main() {
    val arr = arrayOf(1, 4, 5)     // Array with 3 elements

    try {
        println(arr[5])            // Array index out of bounds (sirf 0,1,2 valid hai)
    }
    catch (e: NullPointerException) {
        // Agar NullPointerException aata toh ye block run karta (lekin yahan nahi hoga)
    }
    catch (e: ArrayIndexOutOfBoundsException) {
        // Agar index galat hua toh ye block run karega
        // Yahan se hum ek naya NullPointerException throw kar rahe hain
        throw NullPointerException("Solve it")  // Program yahan se crash karega
    }
    catch (e: Exception) {
        // Agar koi aur general exception hua toh ye block run karega
        println("Exception caught")
    }
    finally {
        // Ye block hamesha run hota hai—chahe exception ho ya na ho
        println("Finally")
    }
    // Agar program crash nahi hota toh yahan tak code aata
    println("The End")       // Ye line exception ke baad nahi print hogi
}
