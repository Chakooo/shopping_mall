// login . js
$(function () {

    $("#login_btn").click(function () {
        const pattern = /\s/g;
        let id = $("#user_id").val();
        if (id == "" || id == null || id == undefined) {
            alert("아이디를 입력해주세요.")
            return;
        }
        if (id.match(pattern)) {
            alert("아이디는 공백을 입력할수 없습니다.")
            return;
        }
        let pwd = $("#user_pwd").val();
        if (pwd == "" || pwd == null || pwd == undefined) {
            alert("비밀번호를 입력해주세요.")
            return;
        }
        if (pwd.match(pattern)) {
            alert("비밀번호는 공백을 입력할수 없습니다.");
            return;
        }
        let data = {
            id: id,
            pwd: pwd
        }

        $.ajax({
            type: "post",
            url: "/seller/login",
            data: JSON.stringify(data),
            contentType: "application/json",
            success: function (r) {
                if (r.status == true) {                    
                    if (r.seller.si_grade == 99) {
                        location.href = "/admin";
                    }
                    else if (r.seller.si_grade != 99 && r.status == true) {
                        location.href = "/seller/home/" + r.si_seq;
                    }
                }
                else {
                    alert(r.message);
                    return;
                }
            }
        })
    })
})