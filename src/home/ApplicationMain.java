package home;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.Date;

public class ApplicationMain extends JFrame{
    public ApplicationMain(){
        setLayout(null);
        setTitle("CP2-ShoppingMall");
        setSize(500,1020);

        //헤드
        HeadPanel head_panel = new HeadPanel();
        head_panel.setBounds(0,0,500,200);
        add(head_panel);

        //바디
        ///TODO 해당 코드에서 페이지가 바뀝니다. 상품 페이지 / 회원가입페이지 / 상품 상세페이지 ...
        //1. 상품 리스트 페이지
//        ListPanel list_panel = new ListPanel();
//        list_panel.setBounds(0,200,500,700);
//        add(list_panel);
        //2. 상품 상세 페이지
//        ProductPanel product_panel = new ProductPanel();
//        product_panel.setBounds(0,200,500,700);
//        add(product_panel);
//       //3. 판매자 글 작성 페이지
//        WritePostPanel write_post_panel = new WritePostPanel();
//        write_post_panel.setBounds(0,200,500,700);
//        add(write_post_panel);
        //4. 장바구니 페이지
        BasketPanel basket_panel
                = new BasketPanel();
        basket_panel.setBounds(0,200,500,700);
        add(basket_panel);


        //푸터
        FootPanel foot_panel = new FootPanel();
        foot_panel.setBounds(0,880,500,100);
        add(foot_panel);
        setVisible(true);

//        //4. 메인 페이지
//        //TODO 메인페이지 실행시에 위에 헤드, 바디, 푸터 모두 주석처리하고 실행
//        MainpagePanel mainpage_panel = new MainpagePanel();
//        mainpage_panel.setBounds(0,0,500,1200);
//        add(mainpage_panel);
//        setVisible(true);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ApplicationMain();
    }
}