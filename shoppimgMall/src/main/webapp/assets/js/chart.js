$(function () {
    let DateChart = null;
    let termChart = null;
    termByChart();
    // selectDateChart();
    
    

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



    //termByChart

    function termByChart(term) {
        let si_seq = $("#seller_seq").val();
        let start_date = $("#start_date").val();
        let end_date = $("#end_date").val();
        console.log("term값"+term)
        let url;
        if (term == null || term == '' || term == undefined ) {
            url = "/seller/showChart?si_seq=" + si_seq
        }
        if (term == 'dateTerm') {
            url = "/seller/showProdCntByTermDate?si_seq=" + si_seq + "&start_date=" + start_date + "&end_date=" + end_date;
        }
        if (term =='year'||term =='month'||term=='week')
         { url = "/seller/showProdCntByTerm?si_seq=" + si_seq + "&term=" + term }
        if (termChart != null) { termChart.destroy() }
        let termName = null;
        if (term == null || term == undefined || term == '') {
            termName = ""
        }
        if (term == 'week') {
            termName = '이번 주'
        }
        if (term == 'month') {
            termName = '이번 달'
        }
        if (term == 'year') {
            termName = '올해'
        }
        if (term == 'dateTerm') {
            if(start_date==null || start_date==undefined || start_date==''||end_date==null || end_date==undefined || end_date ==''){
                alert("확인할 날짜를 선택하세요")
            }
            if (start_date == end_date) {
                termName = start_date;
            }
            else {
                termName = start_date + " ~ " + end_date
            }
        }
        $.ajax({
            type: "get",
            url: url,

            success: function (r) {
                termChart = new Chart($("#prod_cnt_term"), {
                    type: 'bar',
                    data: {
                        labels: r.p_name,
                        datasets: [{
                            label: termName + " 제품 판매 현황",
                            data: r.prod_cnt,
                            backgroundColor: ["skyblue", "orangered", "#3cba9f", "#e8c3b9", "#c45850", "orange"],
                            borderColor: ["pink", "pink", "pink", "pink", "pink", "pink"]
                        }]
                    }
                })

                
                
                $(".prod_cnt_date").html('');
                let prod_cnt_date = '<span><총<b>' + r.allCnt + '</b>개 품목 판매></span>'
                $(".prod_cnt_date").append(prod_cnt_date)

                
                $("#term_prod_cnt_headaer").html('')
                for (let i = 0; i < r.p_name.length; i++) {
                    let headTr =

                        '<td>' + r.p_name[i] + '</td>'

                    $("#term_prod_cnt_headaer").append(headTr)
                }
                $("#term_prod_cnt_body").html('')
                for (let i = 0; i < r.p_name.length; i++) {
                    let bodyTr =

                        '<td>' + r.prod_cnt[i] + '</td>'

                    $("#term_prod_cnt_body").append(bodyTr)
                }




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
    $(".select_date_btn").click(function () {
        term = 'dateTerm'

        termByChart(term)
    })


   

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