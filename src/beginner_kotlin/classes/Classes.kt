package beginner_kotlin.classes

class BankAccount(
    val accountNumber: Long,
    val holderName: String,
    var balance: Double = 0.0   // default — secondary constructor ki zaroorat nahi
) {
    // init — har baar object bante waqt chalta hai
    init {
        println("Account Created — Holder: $holderName, Balance: $balance")
    }

    fun deposit(amount: Double) {
        balance += amount
        println("Deposited: $amount | Total Balance: $balance")
    }

    fun withdraw(amount: Double) {
        if (amount > balance) {
            println("Insufficient balance!")
            return
        }
        balance -= amount
        println("Withdrawn: $amount | Remaining Balance: $balance")
    }
}

fun main() {
    // primary constructor — balance diya
    val acc1 = BankAccount(1001L, "Kamal", 5000.0)
    acc1.deposit(1000.0)
    acc1.withdraw(500.0)
    acc1.withdraw(10000.0)  // insufficient balance

    // default balance = 0.0
    val acc2 = BankAccount(1002L, "Rautela")
    acc2.deposit(2000.0)
}