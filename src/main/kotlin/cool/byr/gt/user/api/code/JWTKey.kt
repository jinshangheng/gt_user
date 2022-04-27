package cool.byr.gt.user.api.code

enum class JWTKey(val key: String, val description: String) {
    AVAILABLE_USERNAMES("av_name_list", "候选用户名列表"),
    SELECTED_USERNAME("sl_name", "选择的用户名")
}