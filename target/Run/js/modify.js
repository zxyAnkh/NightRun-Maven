/**
 * Created by zxy on 5/30/2016.
 */
function submit() {

}
function show() {
    document.getElementById("oldpwd").value = "";
    document.getElementById("newpwd").classList = "form-group form-group-sm";
}
function check() {
    var newname = document.getElementById("name").value;
    var old = document.getElementById("oldpwd").value;
    var newpwd1 = document.getElementById("newpwd1").value;
    var newpwd2 = document.getElementById("newpwd2").value;
    // 是否修改名字或密码 如果只改一个照样可以进行保存
    // 同时改两个时 还是可以点保存 5-31 14:43
    var bool_name = (newname == "" || newname.length > 20 || newname.length == 0);
    var bool_pwd = (old == "" || newpwd1 == "" || newpwd2 == "" || newpwd1 != newpwd2);
    if (!bool_name && !bool_pwd) {
        document.getElementById("submit").classList = "btn btn-primary disabled";
        document.getElementById("submit").disabled = true;
    }
    if (bool_pwd && bool_name) {
        document.getElementById("submit").classList = "btn btn-primary disabled";
        document.getElementById("submit").disabled = true;
    }
    else {
        document.getElementById("submit").classList = "btn btn-primary";
        document.getElementById("submit").disabled = false;
    }
}