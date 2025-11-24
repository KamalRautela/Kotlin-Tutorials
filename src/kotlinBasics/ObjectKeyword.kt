fun main() {
    // Anonymous object creation — limited to main function scope
    var testObj = object {
        val x = 10
        fun method() {
            print("I am test")
        }
    }
    testObj.method() // Output: I am test

    // Singleton object pattern — global, shared throughout app
    K.num = 20

    L.test() // Output: I am object B

    // Singleton utility example (like global counter manager)
    SharingWidget.incrementTwitterLikes()
    SharingWidget.incrementFacebookLikes()
    SharingWidget.display() // Facebook - 1  Twitter - 1
}

object K {
    var num: Int = 10
}

object L {
    var p: Int = 18
    fun test() = print("I am object B")
}

object SharingWidget {
    private var twitterLikes = 0
    private var fbLikes = 0

    fun incrementTwitterLikes() = twitterLikes++
    fun incrementFacebookLikes() = fbLikes++

    fun display() = println("Facebook - $fbLikes  Twitter - $twitterLikes")
}
