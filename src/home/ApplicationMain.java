package home;
import home.panel.body.*;
import home.panel.footer.FootPanel;
import home.panel.head.TopBarPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class ApplicationMain extends JFrame{
    public ApplicationMain(){
        setLayout(null);
        setTitle("CP2-ShoppingMall");
        setSize(500,1200);
        setResizable(true);

        //상단 바(고정)
        TopBarPanel topbar_panel = new TopBarPanel();
        topbar_panel.setBounds(0,0,500, 45);
        add(topbar_panel);

        ///TODO 해당 코드에서 페이지가 바뀝니다.
//        바디
//        1. 상품 리스트 페이지 (0)
        ListPanel list_panel = new ListPanel();
        list_panel.setBounds(0,45,500,835);
//        add(list_panel);
        //2. 상품 상세 페이지 (0)
        ProductPanel product_panel = new ProductPanel();
        product_panel.setBounds(0,45,500,835);
//        add(product_panel);
       //3. 판매자 글 작성 페이지 (0)
        WritePostPanel write_post_panel = new WritePostPanel();
        write_post_panel.setBounds(0,45,500,835);
//        add(write_post_panel);
        //4. 장바구니 페이지 (0)
        BasketPanel basket_panel = new BasketPanel();
        basket_panel.setBounds(0,45,500,835);
//        add(basket_panel);
        //5. 마이페이지 (구매목록) (0)
        MypagePanel mypage_panel = new MypagePanel();
        mypage_panel.setBounds(0,45,500,835);
//        add(mypage_panel);
        //6. 메인 페이지
        MainpagePanel mainpage_panel = new MainpagePanel();
        mainpage_panel.setBounds(0,0,500,1200);
//        add(mainpage_panel);
//        //7. 회원가입 페이지
        RegisterPanel register_panel = new RegisterPanel();
        register_panel.setBounds(0,0,500,1200);
//        add(register_panel);

        //푸터
        FootPanel foot_panel = new FootPanel();
        foot_panel.setBounds(0,880,500,100);
        add(foot_panel);
        JPanel[] s=new JPanel[]{list_panel, product_panel,write_post_panel,basket_panel,mypage_panel,mainpage_panel,register_panel};
        add(s[5]);
        //list_panel 0
        //product_panel 1
        //write_post_panel 2
        //basket_panel 3
        //mypage_panel 4
        //mainpage_panel 5
        //register_panel 6


        s[5].setVisible(true);
        mainpage_panel.login_btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭 시 실행될 동작 정의
                s[5].setVisible(false);
                add(s[0]);
                s[0].setVisible(true);

        }});
        mainpage_panel.sign_btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭 시 실행될 동작 정의
                s[5].setVisible(false);
                add(s[6]);
                s[6].setVisible(true);

            }});
        register_panel.sign_btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭 시 실행될 동작 정의
                s[6].setVisible(false);
                add(s[5]);
                s[5].setVisible(true);

            }});

//        이거 좀 고쳐야 될 듯 서치버튼 누루면 검색되게
        list_panel.head_panel.search_panel.search_button.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭 시 실행될 동작 정의
                s[0].setVisible(false);
                add(s[1]);
                s[1].setVisible(true);

            }});
        product_panel.basket_btn.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                // 버튼 클릭 시 실행될 동작 정의
                s[1].setVisible(false);
                add(s[4]);
                s[4].setVisible(true);

            }});


        setVisible(true);



        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        new ApplicationMain();
    }
}