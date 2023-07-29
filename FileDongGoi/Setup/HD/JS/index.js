$(document).ready(function () {

    var i = 1;
    function kiemTraTen() {
        var i = 1;
        let mauKT = /([A-Z]{1}[a-z]+)((\s{1}[A-Z]{1}[a-z]+){1,})$/;
        if ($("#Name").val() == "") {
            $("#tbName").html("Không để trống");
            return false;
        }
        else if (!mauKT.test($("#Name").val())) {
            $("#tbName").html("Ký tự đầu viết hoa và không có số");
            return false;
        }
        else {
            $("#tbName").html("*");
            return true;
        }
    }
    $("#Name").blur(kiemTraTen);
    function kiemTraSoAo() {
        var mauKT = /^\d*$/;
        if ($("#Ao").val() == "") {
            $("#tbAo").html("Không để trống");
            return false;
        }
        else if (!mauKT.test($("#Ao").val())) {
            $("#tbAo").html("1- 100");
            return false;
        }
        else {
            $("#tbAo").html("*");
            return true;
        }
    }
    $("#Ao").blur(kiemTraSoAo);
    ////////////////////
    function kiemTraDiaChi() {
        var mauKT = /^[A-Z0-9][a-z0-9]*(\s[A-Z0-9][a-z0-9]*)*$/;
        if ($("#DC").val() == "") {
            $("#tbDc").html("Không để trống");
            return false;
        }
        else if (!mauKT.test($("#DC").val())) {
            $("#tbDc").html("Ký tự đầu viết hoa và không có số");
            return false;
        }
        else {
            $("#tbDc").html("*");
            return true;
        }
    }
    $("#DC").blur(kiemTraDiaChi);
    ////////////////////////
    function kiemTraNTT(){
        if($("#NTT").val()==""){
             $("#tbNTT").html("Không để trống");
             return false;
        }
        var today = new Date();
        var ntt =new Date($("#NTT").val());
        today = today.setDate(today.getDate()+7)
        if(today>ntt){
             $("#tbNTT").html("Phải sau ngày ht 7 ngày");
             return false;
        }
        else{
             $("#tbNTT").html("*");
             return true;
        }
    }
    $("#NTT").blur(kiemTraNTT);
    /////////////////////////
    function kiemTraSDT(){
        var mauKT = /^0\d{3}-\d{3}-\d{3}/;
        if($("#SDT").val()==""){
             $("#tbSDT").html("Không để trống");
             return false;
        }
        else if(!mauKT.test($("#SDT").val())){
             $("#tbSDT").html("Theo dạng 0xxx-xxx-xxx");
             return false;
        }
        else{
             $("#tbSDT").html("*");
             return true;
        }
    }
    $("#SDT").blur(kiemTraSDT);

    $("#Save").click(function(){
        if(kiemTraTen()==true && kiemTraSoAo()==true &&
           kiemTraDiaChi()==true && kiemTraNTT()==true &&
           kiemTraSDT()==true){
               row ="<tr>";
               row +="<th>" +(i++)+"</th>";
               row +="<th>" +$("#Name").val()+"</th>";
               row +="<th>" +$("#Ao").val()+"</th>";
               row +="<th>" +$("#DC").val()+"</th>";
               row +="<th>" +$("#NTT").val()+"</th>";
               row +="<th>" +$("#SDT").val()+"</th>";
               row +="<th>" +$("#ADD").val()+"</th>";
               $("#danhSach").append(row);
               $("#myModal").modal("hide");
           }
    })
})