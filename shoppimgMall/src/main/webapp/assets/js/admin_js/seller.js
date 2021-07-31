$(function () {

    $.ajax({
        type: "get",
        url: "/seller/api/list",
        success: function (r) {

            for (let i = 0; i < r.data.length; i++) {
                if (r.data[i].si_grade != 99) {
                    let tag =
                        '<tr>' +
                        '<td>' + r.data[i].si_seq + '</td>' +
                        '<td>' + r.data[i].si_id + '</td>' +
                        '<td>' + r.data[i].si_name + '</td>' +
                        '<td>' + r.data[i].si_address + '</td>' +
                        '<td>' + r.data[i].si_email + '</td>' +
                        '<td>' + r.data[i].si_phone + '</td>' +
                        '<td>' + r.data[i].si_grade + '</td>' +
                        '<td>' + r.data[i].seller_prod_cnt + '</td>' +
                        '<td>' +
                        '<button class="seller_delete" data-seq="' + r.data[i].si_seq + '" ' + (r.data[i].seller_prod_cnt != 0 ? "disabled" : "") + '>삭제</button>' +
                        ' </td>' +
                        '</tr>'

                    $(".seller_tbody").append(tag);
                }
            }
            $(".seller_delete").click(function () {
                let seq = $(this).attr("data-seq"); //data-seq버튼을 눌렀을때의 seq번호 하나만 가져온다.
                if (confirm("삭제하시겠습니까?")) {
                    $.ajax({
                        type: "delete",
                        url: "/seller/api/delete?seq=" + seq,
                        success: function (r) {
                            alert(r.message);
                            location.reload();
                        }
                    })
                }
            })
        }
    })

})