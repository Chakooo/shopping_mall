// registration
$(function () {
    let si_seq = $("#seller_seq").val()*1;
    let si_id = $("#seller_id").val();

    console.log(typeof(si_seq))
 
    $("#img_save").click(function () {
        if (!confirm("등록하시겠습니까?")) return;
        let form = $("#image_form");
        let formData = new FormData(form[0]);

        // for (var key of formData.keys()) {
        //     console.log(key);
        //   }
        //   for (var value of formData.values()) {
        //     console.log(value);
        //   }        

        $.ajax({
            url: "/upload?si_seq=" + si_seq,
            type: "post",
            data: formData,
            contentType: false,
            processData: false,
            success: function (r) {
                console.log(r)
                if (r.status) {
                    let grade = 2;
                    $("#img_save").prop("disabled", true);
                    $("#img_delete").prop("disabled", false);
                    $("#image_form > input").prop("disabled", true);
                    $("#img_preview").append('<img src="/image/' + r.image_uri + '">')
                    $("#img_preview").attr("img-uri", r.image_uri);
                    //프로덕트 데이터베이스에 넣기위해서 uri값을 받아둔다. 
                    console.log(r.image_uri)
                    $.ajax({
                        type:"patch",
                        url:"/seller/grade/update?si_id="+si_id+"&grade="+grade,
                        success:function(r){         
                            console.log(si_seq)                   
                            location.href="/seller/waiting/"+si_seq

                        }    
                    })
                }
                alert(r.message)
            }
        })
    })

})