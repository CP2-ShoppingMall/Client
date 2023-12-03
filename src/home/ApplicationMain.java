package home;
import home.panel.body.RegisterPanel;
import home.panel.footer.FootPanel;
import home.panel.head.TopBarPanel;

import javax.swing.*;

public class ApplicationMain extends JFrame{
    public ApplicationMain(){
        setLayout(null);
        setTitle("CP2-ShoppingMall");
        setSize(500,1020);
        setResizable(false);

        //상단 바(고정)
        TopBarPanel topbar_panel = new TopBarPanel();
        topbar_panel.setBounds(0,0,500, 45);
        add(topbar_panel);

        ///TODO 해당 코드에서 페이지가 바뀝니다.
        //바디
        //1. 상품 리스트 페이지 (0)
//        ListPanel list_panel = new ListPanel();
//        list_panel.setBounds(0,45,500,835);
//        add(list_panel);
//        //2. 상품 상세 페이지 (0)
//        ProductPanel product_panel = new ProductPanel();
//        product_panel.setBounds(0,45,500,835);
//        add(product_panel);
//       //3. 판매자 글 작성 페이지 (0)
//        WritePostPanel write_post_panel = new WritePostPanel();
//        write_post_panel.setBounds(0,45,500,835);
//        add(write_post_panel);
//        //4. 장바구니 페이지 (0)
//        BasketPanel basket_panel = new BasketPanel();
//        basket_panel.setBounds(0,45,500,835);
//        add(basket_panel);
//        //5. 마이페이지 (구매목록) (0)
//        MypagePanel mypage_panel = new MypagePanel();
//        mypage_panel.setBounds(0,45,500,835);
//        add(mypage_panel);
//        //6. 메인 페이지
//        MainpagePanel mainpage_panel = new MainpagePanel();
//        mainpage_panel.setBounds(0,0,500,1200);
//        add(mainpage_panel);
//        //7. 회원가입 페이지
        RegisterPanel register_panel = new RegisterPanel();
        register_panel.setBounds(0,0,500,1200);
        add(register_panel);

        //푸터
        FootPanel foot_panel = new FootPanel();
        foot_panel.setBounds(0,880,500,100);
        add(foot_panel);
        setVisible(true);


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ApplicationMain();
    }
}