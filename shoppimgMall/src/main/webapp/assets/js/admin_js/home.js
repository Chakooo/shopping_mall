$(function () {
    let si_seq = $("#seller_seq").val();
    console.log(si_seq)
    $.ajax({
        type: "get",
        url: "/seller/showChartRank?si_seq=" + si_seq,
        success: function (r) {
            console.log(r.p_name)
            console.log(r.prod_cnt)
            yDaychart = new Chart($("#prod_cnt"), {
                type: 'doughnut',
                data: {
                    labels: r.p_name,
                    datasets: [{
                        label: "최근 한달 제품 판매 현황",
                        data: r.prod_cnt,
                        backgroundColor: ["skyblue", "orangered", "#3cba9f", "#e8c3b9", "#c45850", "orange"],
                        borderColor: ["black"]
                    }]
                }
            })
        }
    })

    $.ajax({
        type: "get",
        url: "/seller/showReiview?si_seq=" + si_seq,
        success: function (r) {
            for (let i = 0; i < r.list.length; i++) {
                let tag =
                    '<tr>' +
                    '<td>' + r.list[i].pi_name + '</td>' +
                    '<td>' + r.list[i].mi_id + '</td>' +                    
                    '<td>' + r.list[i].rev_content + '</td>' +
                    '<td>' + r.list[i].rev_rate + '</td>' +                   
                    '<td>' + r.list[i].rev_reg_dt + '</td>' +
                    '</tr>'
                $('#review_tbody').append(tag);
            }
        }
    })


})