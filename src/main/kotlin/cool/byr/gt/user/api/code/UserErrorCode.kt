package cool.byr.gt.user.api.code

enum class UserErrorCode(
    val code: String,
    val msg: String,
    val description: String
) {
    ALL_DUPLICATE(
        "ALL_DUPLICATE",
        "所有随机生成的名字恰好都与已有的名字重复了！",
        "在用户数量小于一万的时候，这是非常罕见的情况，一旦出现有必要考虑服务端出错。" +
                "但随着数据量增大，尤其是逼近一百二十万（现有编码体系的最大容量）时，几乎百分之百会出现，考虑改变生成算法。"
    ),
    CLOSE_TO_NEW(
        "CLOSE_TO_NEW",
        "停止新用户注册/游客访问",
        "熔断机制，同时也方便不停机更新。"
    )
}