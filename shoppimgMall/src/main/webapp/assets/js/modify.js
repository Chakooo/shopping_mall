$(function(){
    $("#modify").addClass("current")

    

    $("#check_btn").click(function(){
        let pwd = $("#password").val();
        let seq = $("#seq").val();
        let data = {
            mi_pwd:pwd,
            mi_seq:seq
        }
        $.ajax({
            type:"post",
            url:"/member/pwdCheck",
            data:JSON.stringify(data),
            contentType:"application/json;charset=UTF-8",
            success:function(r){
                console.log(r)
            }
        })
        
    })


    



















})