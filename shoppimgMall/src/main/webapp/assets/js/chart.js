$(function () {
    let DateChart = null;
    let termChart = null;
    termByChart();
    selectDateChart();

    let term = null;

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
            yDaychart = new Chart($("#prod_cnt"), {
                type: 'bar',
                data: {
                    labels: r.p_name,
                    datasets: [{
                        label: "총 판매 현황",
                        data: r.prod_cnt,
                        backgroundColor: ["skyblue", "orangered", "#3cba9f", "#e8c3b9", "#c45850", "orange"],
                        borderColor: ["pink", "pink", "pink", "pink", "pink", "pink"]
                    }]
                }
            })
        }
    })



    //Moth Chart

    function termByChart(term) {
        let si_seq = $("#seller_seq").val();
        
        let url;
        if (term == null || term == '' || term == undefined) { 
            url= "/seller/showChart?si_seq=" + si_seq
         }
        else{ url= "/seller/showProdCntByTerm?si_seq=" + si_seq + "&term=" + term }
        if (termChart != null) { termChart.destroy() }
        let termName =null;
        if(term==null||term==undefined||term==''){
            termName= ""
        }
        if(term=='week'){
            termName='이번 주'
        }
        
        if(term=='month'){
            termName='이번 달'
        }
        if(term=='year'){
            termName='올해'
        }
        $.ajax({
            type: "get",
            url: url,

            success: function (r) {
                termChart = new Chart($("#prod_cnt_month"), {
                    type: 'bar',
                    data: {
                        labels: r.p_name,
                        datasets: [{
                            label:  termName+ " 제품 판매 현황",
                            data: r.prod_cnt,
                            backgroundColor: ["skyblue", "orangered", "#3cba9f", "#e8c3b9", "#c45850", "orange"],
                            borderColor: ["pink", "pink", "pink", "pink", "pink", "pink"]
                        }]
                    }
                })
            }
        })
    }
    $(".term_select_week").click(function () {
        term = 'week'
        termByChart(term)
    })
    $(".term_select_month").click(function () {
        term = 'month'
        termByChart(term)
    })
    $(".term_select_year").click(function () {
        term = 'year'
        termByChart(term)
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
                let prod_cnt_date = '<span><총<b>' + r.allCnt + '</b>개 품목 판매></span>'
                $(".prod_cnt_date").append(prod_cnt_date)


                $(".prod_cnt_today").html('');
                let prod_cnt_today = '<span><기본 날짜:' + today() + '></span>'
                $(".prod_cnt_today").append(prod_cnt_today)


                $(".prod_cnt_chice").html('');
                let choice_date = $("#select_date").val();
                let prod_cnt_chice = '<span><선택 날짜:' + choice_date + '></span>'
                $(".prod_cnt_chice").append(prod_cnt_chice)


                $("#date_prod_cnt_headaer").html('')
                for (let i = 0; i < r.p_name.length; i++) {
                    let headTr =

                        '<td>' + r.p_name[i] + '</td>'

                    $("#date_prod_cnt_headaer").append(headTr)
                }
                $("#date_prod_cnt_body").html('')
                for (let i = 0; i < r.p_name.length; i++) {
                    let bodyTr =

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