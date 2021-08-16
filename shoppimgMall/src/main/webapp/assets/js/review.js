// review.js

$(function () {
    $("#save").click(function () {
        if ($(".review_rate_input input:checked").val() == null) {
            alert("평점을 선택하세요.")
            return;
        }
        if ($("#review_detail_content").val() == '') {
            alert("리뷰 내용을 입력하세요.")
            return;
        }

        if (!confirm("리뷰를 등록하시겠습니까?")) {
            return;
        }

        let oi_seq = getParameterByName('oi_seq');

        console.log(oi_seq)

        let pi_seq = $("#product").val();
        let mi_seq = $("#member").val();
        let rate = $(".review_rate_input input:checked").val();
        let content = $("#review_detail_content").val();

        console.log(pi_seq)
        console.log(mi_seq)
        console.log(rate)
        console.log(content)

        let data = {
            rev_pi_seq: pi_seq,
            rev_mi_seq: mi_seq,
            rev_content: content,
            rev_oi_seq: oi_seq,
            rev_rate: rate

        }


        $.ajax({
            type: "post",
            url: "/review/write",
            contentType: "application/json",
            data: JSON.stringify(data),
            success: function (r) {
                alert(r.message);
                location.href="/member/myPage/"+mi_seq

            }
        })
    })
    $("#cancel").click(function () {
        if (!confirm("이전 페이지로 돌아갑니다\n(작성중인 내용은 모두 삭제됩니다.")) {
            return;
        }
        history.back();
        // 이전페이지로 돌려버린다. 
    })



    // 파라미터 값을 가져온다. url에서 oi_seq라는 이름으로 넘어온 파라미터값을 변수로 사용하기위한 함수.
    function getParameterByName(name) {
        name = name.replace(/[\[]/, "\\[").replace(/[\]]/, "\\]");
        var regex = new RegExp("[\\?&]" + name + "=([^&#]*)"),
            results = regex.exec(location.search);
        return results == null ? "" : decodeURIComponent(results[1].replace(/\+/g, " "));
    }
})