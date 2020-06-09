import java.lang.Exception

class PlayerInventory(public val maxsize: Int) {
    private val inv = ArrayList<String>()

    init {
        if (this.maxsize < 0)
            throw Exception("maxsize must be non-negative")
    }

    public val size: Int
        get() {
            return this.inv.size
        }

    public operator fun get(index: Int): String {
        return this.inv[index]
    }

    public fun dropThing(index: Int): String {
        if (index >= this.size)
            throw ArrayIndexOutOfBoundsException("index must be lower then size")

        val obj = this[index]
        this.inv.removeAt(index)

        return obj;
    }

    public fun storeThing(thing: String) {
        if (this.size >= this.maxsize)
            throw Exception("hasn't space in inventory")

        this.inv.add(thing)
    }

    public fun isHaveSpace(): Boolean {
        return this.size < this.maxsize
    }
}