$(function () {
   let seq = $("#si_seq").val();
   if(seq==null||seq==undefined||seq==''){
       location.href="/seller/login"
   }
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



})