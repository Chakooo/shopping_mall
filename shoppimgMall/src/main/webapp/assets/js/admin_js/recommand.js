$(function(){
    $("#recommand").addClass("current")
    loadRecommandList();
 
    $(".add").click(function(){
        loadCategory();
        loadSeller();
        $(".add_recommand").show();
        loadNotRecommand();      
    })
    
    $(".close").click(function(){
        $(".add_recommand").hide();
        location.reload()
       
        
    })
    $("#search").click(function(){
        let cate =$("#cate option:selected").val();
        let seller =$("#seller_list option:selected").val();
        let keyword =$("#keyword").val();
        loadNotRecommand(cate,seller,keyword)
    })
    $("#keyword").keyup(function(e){
        console.log(e.keyCode)
        if(e.keyCode==13){
            $("#search").trigger("click")
         
        }
    })


    function loadNotRecommand(cate,seller,keyword){
        if(cate==undefined||cate==null){
            cate =0;
        } 
        if(seller==undefined||seller==null){
            seller=0;
        }
        if(keyword==undefined||keyword==null){
            keyword="";
        }
               $(".product_list").html(""); 
        $.ajax({
            type:"get",
            url:"/admin/api/not_recommand/"+cate+"/"+seller+"?keyword="+keyword,
            success:function(r){
                console.log(r)
                for(let i=0; i<r.list.length; i++){
                    let tag=
                    '<tr>'+
                    '<td>'+r.list[i].pi_seq+'</td>'+
                    '<td>'+r.list[i].pi_name+'</td>'+
                    '<td><img src="/image/'+r.list[i].pi_img_uri+'"></td>'+
                    '<td>'+r.list[i].category_name+'</td>'+
                    '<td>'+r.list[i].seller_name+'</td>'+
                    '<td><button class="reco_add" data-seq="'+r.list[i].pi_seq+'">추천상품에 추가</button></td>'+
                    '<tr>';
                    $(".product_list").append(tag)
                }         
                $(".reco_add").click(function(){
                    let seq= $(this).attr("data-seq")
                    // alert("추가")
                    $.ajax({
                        type:'put',
                        url:'/admin/put/recommand?prod_seq='+seq,
                        success:function(r){
                            alert(r.message)
                            loadNotRecommand(); 
                            loadRecommandList(); 
                        }
                    })
                })                             
            }            
        })
    }
    function loadRecommandList(){
        $("#recommand_tbody").html("");
        $.ajax({
            type:"get",
            url:"/admin/list/recommand",
            success:function(r){
                console.log(r)
                for(let i=0; i<r.list.length; i++){
                    let tag=
                    '<tr>'+
                    '<td>'+r.list[i].pi_seq+'</td>'+
                    '<td>'+r.list[i].pi_name+'</td>'+
                    '<td><img src="/image/'+r.list[i].pi_img_uri+'"></td>'+
                    '<td>'+r.list[i].category_name+'</td>'+
                    '<td>'+r.list[i].seller_name+'</td>'+
                    '<td><button class="delete" data-seq="'+r.list[i].pi_seq+'">삭제</button></td>'+
                    '<tr>';
                    $("#recommand_tbody").append(tag)
                }
                $(".delete").click(function(){        
                    if(!confirm("삭제하시겠습니까?"))return;      
                    let seq=$(this).attr("data-seq");
                    $.ajax({
                        type:"delete",
                        url:"/admin/api/recommand?prod_seq="+ seq,
                        success:function(r){
                            alert(r.message)
                            location.reload()
                        }
                    })
                })
            }
        })    
    }
    function loadCategory(){
        $.ajax({
            type:"get",
            url:"/category/api/list",
            success:function(r){
                $("#cate").html("");
                $("#cate").append('<option value="0">카테고리 전체</option>');
                for(let i=0; i<r.data.length;i++)     {
                    let tag='<option value="'+r.data[i].cate_seq+'">'+r.data[i].cate_name+'</option>'
                    $("#cate").append(tag);
                }           
            }
        })
    }

    function loadSeller(){
        $.ajax({
            type:"get",
            url:"/seller/api/list",
            success:function(r){
                $("#seller_list").html("");
                $("#seller_list").append('<option value="0">판매자 전체</option>');
                for(let i=0; i<r.data.length;i++)     {
                    let tag='<option value="'+r.data[i].si_seq+'">'+r.data[i].si_name+'</option>'
                    $("#seller_list").append(tag);
                }           
            }
        })

    }



})
