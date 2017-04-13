/**
 * 添加用户 校验
 * Created by zxy on 2016/7/9.
 */
var userno_length = "<span style='COLOR:#ff0000'>用户编号长度必须为8!</span>";
var userno_cant = "<span style='COLOR:#ff0000'>用户编号已经存在,请重新输入!</span>";
var userno_can = "<span style='COLOR:#006600'> √该用户编号可以添加!</span>";
var username_cant = "<span style='COLOR:#006600'>请输入合理的姓名</span>";

var userno_flag = false;
var username_flag = false;

function check() {
    document.getElementById("userno_notice").innerHTML = "";
    document.getElementById("username_notice").innerHTML = "";
    var no = document.getElementById("userno").value;
    var name = document.getElementById("username").value;
    checkUserNo(no);
    checkUserrName(name);
    if (userno_flag && username_flag) {
        document.getElementById("submit").setAttribute("class", "btn btn-primary");
    }
    else {
        document.getElementById("submit").setAttribute("class", "btn btn-primary disabled");
    }
}

function checkUserNo(userno) {
    if (/^\d{8}$/.test(userno)) {
        $.ajax({
            type: "POST",
            url: "/ntr/admin/checkUser",
            data: userno, //组装参数
            dataType: "text",
            success: function (data) {
                if (data === "1") {
                    userno_flag = true;
                    showInfo("userno_notice", userno_can);
                }
                else
                    showInfo("userno_notice", userno_cant);
            }
        });
    }else{
        showInfo("userno_notice", userno_length);
    }
}

function checkUserrName(username) {
    if (/[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/.test(username))
        username_flag = true;
    else
        showInfo("username_notice",username_cant);
}

function showInfo(target, Infos) {
    document.getElementById(target).setAttribute("class", "");
    document.getElementById(target).innerHTML = Infos;
}