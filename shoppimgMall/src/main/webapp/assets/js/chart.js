$(function () {
    let termChart = null;
    let term = null;
    let si_seq = $("#seller_seq").val();
    
    termByChart();

    $(".main_date").html("< " + today() + " >");   

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
                        backgroundColor: ["#D3D1FF", "#C7EDD5", "#FFF8DB", "#E9C9C9", "#c45850", "#BDC5FC"],
                        borderColor: ["pink", "pink", "pink", "pink", "pink", "pink"]
                    }]
                }
            })
        }
    })



    //termByChart

    function termByChart(term) {
        let termName = null;
        let si_seq = $("#seller_seq").val();
        let start_date = $("#start_date").val();
        let end_date = $("#end_date").val();
        console.log("term값" + term)
        let url;
        if (term == null || term == '' || term == undefined) {
            url = "/seller/showChart?si_seq=" + si_seq
        }
        if (term == 'dateTerm') {
            url = "/seller/showProdCntByTermDate?si_seq=" + si_seq + "&start_date=" + start_date + "&end_date=" + end_date;
        }
        if (term == 'year' || term == 'month' || term == 'week') { url = "/seller/showProdCntByTerm?si_seq=" + si_seq + "&term=" + term }      

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
            if (start_date == null || start_date == undefined || start_date == '' || end_date == null || end_date == undefined || end_date == '') {
                alert("확인할 날짜를 선택하세요")
                return;
            }
            if (start_date == end_date) {
                termName = start_date;
            }
            else {
                termName = start_date + " ~ " + end_date
            }
        }
        if (termChart != null) { termChart.destroy() }
        $.ajax({
            type: "get",
            url: url,
            success: function (r) {
                termChart = new Chart($("#prod_cnt_term"), {
                    type: 'bar',
                    data: {
                        labels: r.p_name,
                        datasets: [{
                            label: termName + "총 판매 현황",
                            data: r.prod_cnt,
                            backgroundColor: ["#D3D1FF", "#C7EDD5", "#FFF8DB", "#E9C9C9", "#c45850", "#BDC5FC"],
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
    

    $.ajax({
        type: "get",
        url: "/seller/showChartYesterDay?si_seq=" + si_seq ,

        success: function (r) {
            ydate_chart = new Chart($("#prod_cnt_ydate"), {
                type: 'bar',
                data: {
                    labels: r.all_name,
                    datasets: [{
                        label: yesterDay(),
                        data: r.y_prod_cnt,
                        backgroundColor: ["#D3D1FF"
                        ],
                        borderColor: ["pink"
                        ]
                    },
                    {
                        label:today(),
                        data: r.t_prod_cnt,
                        backgroundColor: ["#C7EDD5"],
                        borderColor: ["pink", "pink", "pink", "pink", "pink",
                            "pink"]
                    }
                ]
                }
            })
        }
    })
    function yesterDay(){
  let today = new Date();
  let yesterDay = new Date(today.setDate(today.getDate()-1));
  var year = yesterDay.getFullYear();
var month = ('0' + (yesterDay.getMonth() + 1)).slice(-2);
var day = ('0' + yesterDay.getDate()).slice(-2);

return year + '-' + month  + '-' + day;
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