// shop.js
$(function(){
    $("#insert_btn").click(function(){       
        let si_seq = $("#seller_seq").val();
        let mi_seq = $("#mi_seq").val();
        if (mi_seq == null || mi_seq == '' || mi_seq == undefined) {
          alert("로그인후 이용하실수있습니다.")
          return;
        }
    
        // console.log(si_seq , mi_seq)
    
        let data = {
          rc_si_seq: si_seq,
          rc_mi_seq: mi_seq
        }
    
        $.ajax({
          type: "post",
          url: "/regular/regist",
          contentType: "application/json",
          data: JSON.stringify(data),
          success: function (r) {
            alert(r.message)
          }
        })

    })
})