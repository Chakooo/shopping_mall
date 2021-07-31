$(function () {




    $("#review_managed").addClass("current")
    let si_seq = $("#seller_seq").val();
    console.log(si_seq)



    $(".raw_btn").click(function () {
        $(".answer_mod_btn").css("display", "none");
        $(".answer_regist").css("display", "block");
        $(".answer").css("display", "none");
        // $(this).parent().parent().next().css("display", "table-row");
        rev_seq = $(this).attr("rev-seq");
        console.log("rev_seq: " + rev_seq)
        let $this = $(this)
        $.ajax({
            type: "get",
            url: "/review/select?si_seq=" + si_seq + "&rev_seq=" + rev_seq,
            success: function (r) {
                console.log(r.data)
                $this.parent().parent().next().css("display", "none");

                if (r.data == null || r.data == undefined || r.data == '') {
                    $(".answer").css("display", "none");
                    $(".answer_check").css("display", "none");
                    $this.parent().parent().next().css("display", "table-row");
                }
                else {
                    $this.parent().parent().next().next().html('');
                    $(".answer_check").css("display", "none");
                    $this.parent().parent().next().next().css("display", "table-row");
                    let tag = 
                    '<td><img src="/assets/images/free-icon-right-arrow-724847.png" alt=""></td>'+
                    '<td class="rejoinder"> 답 변 </td>'+
                    '<td colspan="3">' + r.data.ra_content + '</td>'+
                    '<td><button class="answer_mod">수정</button></td>'+
                    '<td><button class="answer_del">삭제</button></td>'
                    $this.parent().parent().next().next().append(tag)
                    $(".answer_mod").click(function () {
                        $.ajax({
                            type: "get",
                            url: "/review/select?si_seq=" + si_seq + "&rev_seq=" + rev_seq,
                            success: function (r) {
                                $(".answer").css("display", "none");
                                $(".answer_check").css("display", "none");
                                $this.parent().parent().next().css("display", "table-row");
                                $(".answer_mod_btn").css("display", "block");
                                $(".answer_regist").css("display", "none");
                                // let button = $this.parent().parent().next().children().children("button").html("수정");                                
                                $this.parent().parent().next().children().children("textarea").val(r.data.ra_content);

                                $(".answer_mod_btn").click(function () {
                                    if(!confirm("이대로 수정하시겠습니까?"))return;
                                    let content = $(this).parent().children("textarea").val();
                                    let data = {
                                        ra_rev_seq: rev_seq,
                                        ra_content: content,
                                        ra_si_seq: si_seq
                                    }
                                    $.ajax({
                                        type: "patch",
                                        url: "/review/answer/update",
                                        contentType: "application/json",
                                        data: JSON.stringify(data),
                                        success: function (r) {
                                            alert(r.message)
                                            location.reload()
                                        }
                                    })
                                })

                            }
                        })
                    })
                    $(".answer_del").click(function () {
                        if (!confirm("삭제하시겠습니까?")) return;
                        $.ajax({
                            type: "delete",
                            url: "/review/delete?rev_seq=" + rev_seq,
                            success: function (r) {
                                alert(r.message)
                                status = 0;
                                $.ajax({
                                    type: "patch",
                                    url: "/review/status/update?rev_seq=" + rev_seq + "&status=" + status,
                                    success: function (r) {
                                        location.reload()
                                    }
                                })

                            }

                        })

                    })
                }
            }
        }
        )

    })


    $(".answer_regist").click(function () {
        if (!confirm("리뷰 댓글을 등록하시겠습니까?")) return;
        let rev_seq = $(this).attr("rev-seq");
        let content = $(this).parent().children("textarea").val();
        let data = {
            ra_si_seq: si_seq,
            ra_content: content,
            ra_rev_seq: rev_seq
        }
        $.ajax({
            type: "post",
            url: "/review/answer/regist",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (r) {
                alert(r.message)
                status = 1;
                $.ajax({
                    type: "patch",
                    url: "/review/status/update?rev_seq=" + rev_seq + "&status=" + status,
                    success: function (r) {
                        location.reload()
                    }
                })
            }
        })
    })




})










    // $(".answer").css("display", "none");
    // $this.parent().parent().next().next().css("display", "table-row");








