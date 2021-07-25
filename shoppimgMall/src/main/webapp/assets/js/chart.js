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



    //Moth Chart
    $.ajax({
        type: "get",
        url: "/seller/showChartMonth?si_seq=" + si_seq,
        success: function (r) {
            console.log(r.p_name)
            console.log(r.y_prod_cnt)
            yDaychart = new Chart($("#prod_cnt_month"), {
                type: 'bar',
                data: {
                    labels: r.p_name,
                    datasets: [{
                        label: "최근 한달 제품 판매 현황",
                        data: r.prod_cnt,
                        backgroundColor: ["skyblue", "orangered", "#3cba9f", "#e8c3b9", "#c45850", "orange"],
                        borderColor: ["pink", "pink", "pink", "pink", "pink", "pink"]
                    }]
                }
            })
        }
    })



     //Week Chart
     $.ajax({
        type: "get",
        url: "/seller/showChartWeek?si_seq=" + si_seq,
        success: function (r) {
            console.log(r.p_name)
            console.log(r.y_prod_cnt)
            yDaychart = new Chart($("#prod_cnt_week"), {
                type: 'bar',
                data: {
                    labels: r.p_name,
                    datasets: [{
                        label: "최근 일주일 제품 판매 현황",
                        data: r.prod_cnt,
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
            url = "/seller/showChartByDate?si_seq=" + si_seq + "&date=" + today()
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
                            label: "선택날짜별 제품 판매 현황",
                            data: r.prod_cnt,
                            backgroundColor: ["skyblue", "orangered", "#3cba9f", "#e8c3b9", "#c45850", "orange"],
                            borderColor: ["pink", "pink", "pink", "pink", "pink", "pink"]
                        }]
                    }
                })
                
               
               
               
                $(".prod_cnt_date").html('');
                let prod_cnt_date='<span><총<b>'+ r.allCnt+'</b>개 품목 판매></span>'                    
                $(".prod_cnt_date").append(prod_cnt_date)

                
                $(".prod_cnt_today").html('');
                let prod_cnt_today='<span><기본 날짜:'+ today()+'></span>'
                $(".prod_cnt_today").append(prod_cnt_today)


                $(".prod_cnt_chice").html('');
                let choice_date=$("#select_date").val();
                let prod_cnt_chice='<span><선택 날짜:'+ choice_date+'></span>'
                $(".prod_cnt_chice").append(prod_cnt_chice)


                $("#date_prod_cnt_headaer").html('')  
                for(let i = 0;i< r.p_name.length;i++){
                    let headTr=
                     
                    '<td>' + r.p_name[i] + '</td>'
                    
                    $("#date_prod_cnt_headaer").append(headTr)
                }
                $("#date_prod_cnt_body").html('')  
                for(let i = 0;i< r.p_name.length;i++){
                    let bodyTr=                 

                    '<td>' + r.prod_cnt[i] + '</td>'     

                    $("#date_prod_cnt_body").append(bodyTr)
                }                               
            }
        })
    }

    //


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
    function today() {
        var today = new Date();
        var year = today.getFullYear();
        var month = ('0' + (today.getMonth() + 1)).slice(-2);
        var day = ('0' + today.getDate()).slice(-2);

        var dateString = year + '-' + month + '-' + day;
        return dateString;
    }


})