$(function () {
    $("#seller").addClass("current");



    getSellerList()
    function getSellerList(offset) {
        ($(".seller_tbody").html("")); //안쪽 내용을 괄호안의 내용으로 바꾼다.

        let url = "/seller/api/list";
        if (offset != undefined && offset != null) {
            url += "?offset=" + offset;
        }

        $.ajax({
            type: "get",
            url: url,
            success: function (r) {
                let grade = '';

                for (let i = 0; i < r.data.length; i++) {
                    if (r.data[i].si_grade == 0) {
                        grade = '사업자 등록전(0번)'
                    }
                    if (r.data[i].si_grade == 1) {
                        grade = '정식 판매자(1번)'
                    }
                    if (r.data[i].si_grade == 2) {
                        grade = '사업자 확인중(2번)'
                    }
                    if (r.data[i].si_grade != 99) {
                        let tag =
                            '<tr>' +
                            '<td>' + r.data[i].no + '</td>' +
                            '<td>' + r.data[i].si_id + '</td>' +
                            '<td>' + r.data[i].si_name + '</td>' +
                            '<td>' + r.data[i].si_address + '</td>' +
                            '<td>' + r.data[i].si_email + '</td>' +
                            '<td>' + r.data[i].si_phone + '</td>' +
                            '<td>' + grade + '</td>' +
                            '<td>' + r.data[i].seller_prod_cnt + '</td>' +
                            '<td>' +
                            '<button class="seller_delete" data-seq="' + r.data[i].si_seq + '" ' + (r.data[i].seller_prod_cnt != 0 ? "disabled" : "") + '>삭제</button>' +
                            ' </td>' +
                            '</tr>'

                        $(".seller_tbody").append(tag);
                    }
                }
                var totalData = r.cnt;  // 총 데이터 수
                console.log(totalData)
                var dataPerPage = 6;    // 한 페이지에 나타낼 데이터 수               
                var pageCount = Math.floor(r.cnt/6+1);        // 한 화면에 나타낼 페이지 수
                console.log(pageCount + "페이지카운트")
                paging(totalData, dataPerPage, pageCount, 1)

                function paging(totalData, dataPerPage, pageCount, currentPage) {

                    console.log("currentPage : " + currentPage);

                    var totalPage = Math.ceil(totalData / dataPerPage);    // 총 페이지 수
                    var pageGroup = Math.ceil(currentPage / pageCount);    // 페이지 그룹

                    console.log("totalpage : " + totalPage);
                    console.log("pageGroup : " + pageGroup);

                    var last = pageGroup * pageCount;    // 화면에 보여질 마지막 페이지 번호
                    if (last > totalPage)
                        last = totalPage;
                    var first = last - (pageCount - 1);    // 화면에 보여질 첫번째 페이지 번호
                    var next = last + 1;
                    var prev = first - 1;

                    console.log("last : " + last);
                    console.log("first : " + first);
                    console.log("next : " + next);
                    console.log("prev : " + prev);

                    var $pingingView = $("#paging");


                    var html = "";

                    if (prev > 0)
                        html += '<button id="prev"><</button>';

                    for (var i = first; i <= last; i++) {
                        if (i != 0) {
                            html += '<button class="paging_button">' + i + '</button>';
                        }
                    }

                    // html += "<a href='/product/api/list?keyword=&category=&offset="+15*i+"'   id=" + i + ">" + i + "</a> ";


                    if (last < totalPage)
                        html += '<button id="next">></button>';

                    $("#paging").html(html);    // 페이지 목록 생성
                    // $("#paging button").css({"color":"black",
                    //                         "outline":"0",
                    //                         "border":"0",
                    //                         "background-color":"white",
                    //                         "cursor":"pointer"
                    //                                         });

                    $("#paging a#" + currentPage).css({
                        "text-decoration": "none",
                        "color": "red",
                        "font-weight": "bold"
                    });    // 현재 페이지 표시

                    // $("#paging a").click(function(){                        
                    //     var $item = $(this);
                    //     var $id = $item.attr("id");
                    //     var selectedPage = $item.text();                        
                    //     if($id == "next")    selectedPage = next;
                    //     if($id == "prev")    selectedPage = prev;                        
                    // });

                    $(".paging_button").click(function () {
                        $("#paging button").addClass(".active");
                        let page_num = $(this).html();
                        console.log("페이지값:" + page_num)
                        let result = dataPerPage * (page_num - 1)
                        getSellerList(dataPerPage * (page_num - 1))
                        console.log("offset 번호 : "+result )
                    })

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
    }
    $.ajax({
        type: "get",
        url: "/seller/selectImage",
        success: function (r) {
            console.log(r.data)
            for (let i = 0; i < r.data.length; i++) {
                let data =
                    '<tr>' +
                    '<td>' + r.data[i].si_seq + '</td>' +
                    '<td>' + r.data[i].si_id + '</td>' +
                    '<td>' + r.data[i].si_name + '</td>' +
                    '<td>' + r.data[i].si_address + '</td>' +
                    '<td>' + r.data[i].si_email + '</td>' +
                    '<td>' + r.data[i].si_phone + '</td>' +
                    '<td class="preview"><img src="/image/' + r.data[i].sr_uri + '/' + r.data[i].si_seq + '"></td>' +
                    '<td><button class="seller_grade" si_id="' + r.data[i].si_id + '">판매자 등록</button></td>' +
                    '</tr>'
                $('.img_tbody').append(data);
                console.log(r.data[i].sr_uri)
                console.log(r.data[i].si_seq)
            }
            $(".seller_grade").click(function () {
                let grade = 1;
                let si_id = $(this).attr("si_id")
                if (!confirm("정식 판매자로 등록하시겠습니까? ")) return;
                $.ajax({
                    type: "patch",
                    url: "/seller/grade/update?si_id=" + si_id + "&grade=" + grade,
                    success: function (r) {
                        alert(r.message)
                        location.reload()
                    }

                })
            })
        }
    })




})