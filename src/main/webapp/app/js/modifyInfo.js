/**
 * 管理员修改个人信息校验
 * Created by zxy on 2016/7/8.
 */



var name_flag = false;
var pwd_flag = false;

function check() {
    var newname = document.getElementById("username");
    var old = document.getElementById("oldpassword");
    var new1 = document.getElementById("newpassword1");
    var new2 = document.getElementById("newpassword2");

    newname.addEventListener("input", checkName(newname.value), false);
    old.addEventListener("input", checkPwd(old.value, new1.value, new2.value), false);
    new1.addEventListener("input", checkPwd(old.value, new1.value, new2.value), false);
    new2.addEventListener("input", checkPwd(old.value, new1.value, new2.value), false);

    if (name_flag && pwd_flag)
        document.getElementById("submit").setAttribute("class","btn btn-primary");

}

function checkName(name) {
    if (name !== "")
        name_flag = true;
    else
        name_flag = false;
}
function checkPwd(old, new1, new2) {
    if (old == "") {
        pwd_flag = false;
    } else if (old != "") {
        if (new1 == "" && new2 == "") {
            pwd_flag = true;
        } else if (old == new1 || old == new2) {
            pwd_flag = false;
        } else if (new1 != new2 && (new1 == "" || new2 == "")) {
            pwd_flag = false;
        } else if (new1 != "" && new1 == new2)
            pwd_flag = true;
    }
}