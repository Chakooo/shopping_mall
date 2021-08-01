$(function () {
    $("#member").addClass("current");
    $(".member_del").click(function () {
        // alert("확인")
        let seq = $(this).attr("data-seq");
        // alert(seq);
        if (confirm("삭제하시겠습니까")) {

            $.ajax({
                type: "delete",
                url: "/member/delete?seq=" + seq,
                success: function (r) {
                    alert(r.message)
                    location.reload()
                }
            })
        }
    })
})