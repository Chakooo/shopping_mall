$(function () {
    let DateChart = null;
    let yDaychart = null;
    selectDateChart();

    $("#yesterDay").html(yesterDay());
    let si_seq = $("#seller_seq").val();

    $(".btn").click(function () {
        let select_date = $("#select_date").val();
        selectDateChart(select_date);
    })
    
    // All Cnt Chart
    $.ajax({
        type: "get",
        url: "/seller/showChart?si_seq=" + si_seq,
        success: function (r) {
            console.log(r.p_name)
            console.log(r.y_prod_cnt)
            yDaychart = new Chart($("#prod_cnt"), {
                type: 'bar',
                data: {
                    labels: r.p_name,
                    datasets: [{
                        label: "총 판매 현황",
                        data: r.y_prod_cnt,
                        backgroundColor: ["skyblue", "orangered", "#3cba9f", "#e8c3b9", "#c45850", "orange"],
                        borderColor: ["pink", "pink", "pink", "pink", "pink", "pink"]
                    }]
                }
            })
        }
    })



    //YesterDay Chart
    $.ajax({
        type: "get",
        url: "/seller/showChartYesterDay?si_seq=" + si_seq,
        success: function (r) {
            console.log(r.p_name)
            console.log(r.y_prod_cnt)
            yDaychart = new Chart($("#yesterDay_cnt"), {
                type: 'bar',
                data: {
                    labels: r.p_name,
                    datasets: [{
                        label: "어제 제품 판매 현황",
                        data: r.y_prod_cnt,
                        backgroundColor: ["skyblue", "orangered", "#3cba9f", "#e8c3b9", "#c45850", "orange"],
                        borderColor: ["pink", "pink", "pink", "pink", "pink", "pink"]
                    }]
                }
            })
        }
    })


    //Date Chart
    function selectDateChart(select_date) {
        let url;
        let si_seq = $("#seller_seq").val();

        if (select_date == undefined || select_date == null || select_date == '') {
            url = "/seller/showChart?si_seq=" + si_seq
        } else {
            url = "/seller/showChartByDate?si_seq=" + si_seq + "&date=" + select_date
        }
        if (DateChart != null) {
            DateChart.destroy()
        }
        $.ajax({
            type: "get",
            url: url,
            success: function (r) {
                console.log(r.p_name)
                console.log(r.y_prod_cnt)
                DateChart = new Chart($("#prod_cnt_search"), {
                    type: 'bar',
                    data: {
                        labels: r.p_name,
                        datasets: [{
                            label: "어제 제품 판매 현황",
                            data: r.y_prod_cnt,
                            backgroundColor: ["skyblue", "orangered", "#3cba9f", "#e8c3b9", "#c45850", "orange"],
                            borderColor: ["pink", "pink", "pink", "pink", "pink", "pink"]
                        }]
                    }
                })
            }
        })
    }




    function yesterDay() {
        let nowDate = new Date();
        let yesterDate = nowDate.getTime() - (1 * 24 * 60 * 60 * 1000);
        nowDate.setTime(yesterDate);

        let yesterYear = nowDate.getFullYear();
        let yesterMonth = nowDate.getMonth() + 1;
        let yester_Day = nowDate.getDate();

        if (yesterMonth < 10) { yesterMonth = "0" + yesterMonth };
        if (yester_Day < 10) { yester_Day = "0" + yester_Day };

        let yesterDayResult = yesterYear + "-" + yesterMonth + "-" + yester_Day;
        return yesterDayResult
    }


})