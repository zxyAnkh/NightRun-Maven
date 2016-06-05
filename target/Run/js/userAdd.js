/**
 * Created by zxy on 6/3/2016.
 */
function check() {
    var no = document.getElementById("no").value;
    var name = document.getElementById("name").value;
    if (/^\d{8}$/.test(no) && /[\u4E00-\u9FA5]{2,5}(?:·[\u4E00-\u9FA5]{2,5})*/.test(name))
        document.getElementById("submit").classList = "btn btn-primary";
    else
        document.getElementById("submit").classList = "btn btn-primary disabled";
}