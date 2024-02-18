package com.example.testboard2.testboard2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.testboard2.testboard2.dto.MemberDTO;
import com.example.testboard2.testboard2.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
public class MemberController {

    /*
     * DI
     */
    @Autowired
    private MemberService memberService;
   
    /*
     * 회원 등록 Form Page
     */
    @GetMapping("/member/memberWriteForm")
    public String memberWriteForm(
        @RequestParam( value="num", required=false) Integer num,
        Model model){
        // required 옵션은 디폴트가 true이고, 써놓지 않으면 디폴트값으로 true가 적용
        // 기본값 true로 사용을 하는 경우 --> 보통 줄여서 @RequestParam("num")

        //넘어온값이 null인지 체크
        // num이 null인지 비교를 할떄 주의사항!
        // Primitive Type(원시 타입)인 int는 null일 수 없음. null이 필요한 경우 Integer사용. 또는 0을 사용.
        // if (num != 0) {...

        if(num != null)
        {
            System.out.println( num );
            // null이 아니라는 것은 파라미터 값으로 num값이 넘어왔다는 것이므로 " 수정" 처리라고 볼 수 있음.
            // 따라서, 여기에다 수정에 대한 처리 코드를 작성.

            //수정 처리
            // 먼저, 넘어온 num 값에 대한 회원 정보를 데이터베이스에서 가져오고 --> 해당 회원 정보를 Form 페이지로 전달.
            MemberDTO m1 = memberService.getMemberOne( num );    

            //DB에서 가져온 회원 정보가 없을 경우 --> 즉, m1 객체가 null인 경우.
            if( m1 == null){

                // 1번 방식 : 리다이렉트(가장 심플)
                // return "redirect:/";

                // 2번 방식 : PrinterWriter 사용
                // import 필요하고, 추가 처리 필요(아래 코드와 같은)
                // HttpServletResponse response ) throws Exception{ ...}

                // 3번 방식 : 특정 페이지(Error Message Page)로 데이터 값들을(Model을 사용) 보내서 출력
                model.addAttribute( "msg", "회원 정보가 없습니다. 메인 페이지로 이동합니다." );
                model.addAttribute( "url", "/");

                return "/member/messageAlert";  //messageAlert.html

            }

            System.out.println(m1.toString());

            // Form 페이지로 m1 객체를 전달  --> 모델(model)
            model.addAttribute("memberDTO", m1);
            model.addAttribute("formTitle", "Modification");
            model.addAttribute("num", num);
        }
        else{

            System.out.println("null 입니다.");
            //null이라는 것은 파라미터 값으로 num 값이 넘어온게 없다는 것이므로 "입력" 처리라고 볼 수 있음.
            //따라서, 여기에다 등록에 대한 처리코드를 작성.

            //등록 처리(신규회원)
            model.addAttribute("memberDTO", new MemberDTO() );
            model.addAttribute("formTitle", "Registration");
        }

        return "member/memberWriteForm";   //memberWriteForm.html
    }

    /*
     * 회원 등록 Ok
     */
    @PostMapping("/member/memberWriteOk")
    public String registerMember(
            MemberDTO m1,
            Model model){
        
        try{
            //등록처
            System.out.println(m1.toString());
            memberService.insertMember( m1 );

            model.addAttribute("msg", "회원등록이 처리되었습니다. 메인 페이지로 이동합니다.");
            model.addAttribute("url", "/");

            return "/member/messageAlert"; //messageAlert.html
        }catch( Exception e){
            //error
    
        }

        return "redirect:/member/memberWriteForm";
        /**
         * 그냥 리턴처리 하는 것과 redirect 리턴의 차이
         *  1. 별 차이는 없다.
         *  2. 다만, redirect 경우는 다시 한번 해당 url로 http 요청을 넣는 형태.
         */
    }

    /*
     * 회원 수정 Ok
     */
    @PostMapping("/member/memberUpdateOk")
    public String updateMember(
        MemberDTO m1,
        HttpServletRequest request,
        Model model ){

        // 넘어오는 num 값 받아서 정수형으로 형 변환 --> getParameter() 반환이 String이므로.
        String num_ = request.getParameter( "num" );
        int num = Integer.parseInt(num_);

        System.out.println( num );

        try{
            //등록처리
            System.out.println(m1.toString());
            
            memberService.updateMember( m1 );

            //안내 메세지 및 url  정보를 전달 -> messageAlert.html
            // 3번 방식  : 특정페이지로 데이터 값들을 (Model을 사용) 보내서 출력

            model.addAttribute("msg", "회원 정보가 수정되었습니다. 확인 페이지로 이동합니다.");
            model.addAttribute("url", "/member/memberWriteForm?num=" + num );

            return "/member/messageAlert";  //messageAlert.html

        }catch( Exception e){
            //error
        }

        return "redirect:/member/memberWriteForm?num=" + num;
        
    }
}
