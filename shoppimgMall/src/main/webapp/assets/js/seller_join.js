// seller_join.js
$(function(){
    let idCheck = false;
    let emailCheck=false;
   
    $("#join").click(function(){
      
        if(idCheck==false){
            alert("판매자 아이디 중복체크를 해주세요")
            return;
        }
       
        const pattern = /\s/g; //공백체크 정규표현식


        let user_id = $("#user_id").val()
        if(user_id==""||user_id==null||user_id==undefined){
            alert("아이디를 입력주세요")
            return;
        }
        if(user_id.match(pattern)){
            alert("아이디에는 공백이 들어갈 수 없습니다.")
            return;
        }
        
        let user_pwd = $("#user_pwd").val()
        if(user_pwd==""||user_pwd==null||user_pwd==undefined){
            alert("비밀번호를 입력주세요")
            return;
        }
        if(user_pwd.match(pattern)){
            alert("비밀번호에는 공백이 들어갈 수 없습니다.")
            return;
        }
        let user_pwd_confirm = $("#user_pwd_confirm").val();
        if(user_pwd!=user_pwd_confirm){
            alert("비밀번호와 비밀번호 확인이 일치하지않습니다.")
            return;
        }

        let user_name = $("#user_name").val()
        if(user_name==""||user_name==null||user_name==undefined){
            alert("판매업체를 입력주세요")
            return;
        }
        if(user_name.match(pattern)){
            alert("판매업체에는 공백이 들어갈 수 없습니다.")
            return;
        }
        

        const patternEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;         
        
        let user_email = $("#user_email").val()
        if(user_email==""||user_email==null||user_email==undefined){
            alert("이메일을 입력주세요")
            return;
        }
        if(user_email.match(pattern)){
            alert("이메일에는 공백이 들어갈 수 없습니다.")
            return;
        }
        if(!user_email.match(patternEmail)){ 
            // not을 붙여서 변수 이메일형식에 맞게 입력이 되지않았을때를 검사한다.
            alert("올바른 이메일형식을 입력하세요\n 예시)aaa@service.com")
            return;
        }
        if(emailCheck==false){
            alert("이메일 중복체크를 해주세요")
            return;        }
    
        let user_address=$("#user_address").val();
        let user_phone=$("#user_phone").val();        
        if(user_phone.length >13 ){
            alert("연락처는 13자리를 넘길수 없습니다.")
        }
        if(!inputValidation(user_address,"주소")){return;}
        if(!inputValidation(user_phone,"전화번호")){return;}
        
        let data={
        si_id:user_id,
        si_pwd:user_pwd,
        si_name:user_name,
        si_email:user_email,
        si_address:user_address,      
        si_phone:user_phone     
             }

             $.ajax({
                type:'post',
                url:'/seller/regist',
                data:JSON.stringify(data),
                contentType:'application/json',
                success:function(r){
                    if(r.result == 'success'){
                        alert(r.message)
                        location.href="/";
                    }else{
                        alert(r.message)
                    }                                    
                },
                error:function(e){
                    console.log(e)
                }
             })
        })


        $("#chk_id").click(function(){
      
        const pattern = /\s/g; //공백체크 정규표현식
        let user_id = $("#user_id").val()       
        if(user_id==""||user_id==null||user_id==undefined){
            alert("아이디를 입력주세요!")
            return;
        }
        if(user_id.match(pattern)){
            alert("아이디에는 공백이 들어갈 수 없습니다.")
            return;
        }

        $.ajax({
            type:"get",
            url:"/seller/isDuplicateId?id="+user_id,
            success:function(r){
                alert(r.message)
                if(r.status==false){
                    idCheck=true;
                }
                else{
                    idCheck=false;
                }
            }

        })
        })
        $("#chk_email").click(function(){          
            const pattern = /\s/g;

            const patternEmail = /^[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_\.]?[0-9a-zA-Z])*\.[a-zA-Z]{2,3}$/i;          
            let user_email = $("#user_email").val()
            if(user_email==""||user_email==null||user_email==undefined){
                alert("이메일을 입력주세요")
                return;
            }
            if(user_email.match(pattern)){
                alert("이메일에는 공백이 들어갈 수 없습니다.")
                return;
            }
            if(!user_email.match(patternEmail)){ 
                alert("올바른 이메일형식을 입력하세요\n 예시)aaa@service.com")
                return;
            }


            $.ajax({
                type:"get",
                url:"/seller/email_check?email="+user_email,
                success:function(r){
                    alert(r.message)
                   emailCheck=r.status;
                    }                   
            })
        })
        $("#user_id").change(function(){
            idCheck=false;
        })
        $("#user_email").change(function(){
            emailCheck=false;
        })
    });
    function inputValidation(input, type){
        if(input =="" || input == null || input ==undefined){
            alert(type+"을/를 입력해주세요");
            return false;
        }
        return true;
    }
  
    
