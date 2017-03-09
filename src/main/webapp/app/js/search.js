/**
 * 查询 函数
 * Created by zxy on 2016/7/7.
 */
/**
 * 通过时间查询
 */
function timeQuery() {
    var stime = document.getElementById("stime").value;
    var etime = document.getElementById("etime").value;
    var sy = stime.substr(0, 4);
    var sM = stime.substr(5, 2);
    var sd = stime.substr(8, 2);
    var ey = etime.substr(0, 4);
    var eM = etime.substr(5, 2);
    var ed = etime.substr(8, 2);
    location.href = "search?type=time&keyword=" + sy + sM + sd + ey + eM + ed + ed;
}
function timeChange() {
    var stime = document.getElementById("stime").value;
    var etime = document.getElementById("etime").value;
    if (stime != "" && etime != "" && (Date.parse(etime) - Date.parse(stime) ) >= 0) {
        document.getElementById("time").disabled = false;
        document.getElementById("time").setAttribute('class', "btn btn-primary");
    }
}
/**
 * 通过keyword查询
 */
function find() {
    var keyword = document.getElementById("search").value;
    if (keyword != null && "" != (keyword))
        location.href = "ntr/admin/search?type=all&keyword=" + keyword + "&page=1";
}

/**
 * 判断搜索类型显示不同的table
 */
function searchType() {
    var url = window.location.href;
    var type = url.substring(url.lastIndexOf('?') + 1, url.lastIndexOf("keyword")-1);
    if("type=all" == type){
        document.getElementById("resultAll").innerHTML = "搜索结果<span class='divider' id='resultAllSpan'>/</span>";
        document.getElementById("resultAll").setAttribute("class", "active");
        document.getElementById("searchTable").setAttribute("class", "table table-striped");
    }else if("type=details" == type){
        document.getElementById("resultAll").innerHTML = "<a href='javascript :;' onClick='javascript :history.back(-1);'>搜索结果</a><span class='divider' id='resultAllSpan'>/</span>";
        document.getElementById("resultAllSpan").setAttribute("class", "divider");
        document.getElementById("resultDetails").setAttribute("class", "active");
        document.getElementById("detailsTable").setAttribute("class", "table table-striped");
    }
}