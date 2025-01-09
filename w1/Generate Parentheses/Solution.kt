class Solution {
    private val memo = mutableMapOf<Int, List<String>>()
    fun generateParenthesis(n: Int): List<String> {
        if (memo.containsKey(n)) return memo[n]!!

        val result = mutableListOf<String>()

        if (n == 0) {
            result.add("")
        } else {
            for (i in 0 until n) {
                val insideList = generateParenthesis(i)
                val outsideList = generateParenthesis(n - 1 - i)

                for (inside in insideList) {
                    for (outside in outsideList) {
                        result.add("$outside($inside)")
                    }
                }
            }
        }

        memo[n] = result
        return result
    }
}
