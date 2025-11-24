package kotlinBasics

fun main() {
    val number = 5      // Ek number jiski value 5 hai

    // 'in' operator se check karte hain ki number 1 se 5 ke beech hai ya nahi (inclusive)
    var result = number in 1 .. 6
    println(result)     // true, kyunki 5 range ke andar hai (1,2,3,4,5)

    // 'in' operator with 'until' keyword: yeh 1 se 5 tak ek kam tak check karega (5 exclude hoga)
    result = number in 1 until 5
    println(result)     // false, kyunki 5 range (1,2,3,4) mein nahi aata
}

/*
Android context me:
- Range operators loops aur conditions me bohot useful hote hain.
- 'in' operator se clean & readable code likh sakte hain.
- Inclusion aur exclusion boundaries ko samajhna zaruri hota hai, jaha logical conditions ka farak padta hai.
*/
