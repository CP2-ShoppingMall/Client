package home;

import home.panel.body.*;
import home.panel.footer.FootPanel;
import home.panel.head.TopBarPanel;
import kimit.api.ClientException;
import kimit.api.ClientWrapper;

import javax.swing.*;
import java.io.IOException;
import java.util.Arrays;

public class MainFrame extends JFrame
{
    private final JPanel[] Panels;

    public MainFrame()
    {
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
        ListPanel list_panel = new ListPanel(this);
        list_panel.setBounds(0,45,500,835);
        add(list_panel);
        //2. 상품 상세 페이지 (0)
        ProductPanel product_panel = new ProductPanel(this);
        product_panel.setBounds(0,45,500,835);
        add(product_panel);
       //3. 판매자 글 작성 페이지 (0)
        WritePostPanel write_post_panel = new WritePostPanel(this);
        write_post_panel.setBounds(0,45,500,835);
        add(write_post_panel);
        //4. 장바구니 페이지 (0)
        BasketPanel basket_panel = new BasketPanel(this);
        basket_panel.setBounds(0,45,500,835);
        add(basket_panel);
        //5. 마이페이지 (구매목록) (0)
        MypagePanel mypage_panel = new MypagePanel(this);
        mypage_panel.setBounds(0,45,500,835);
        add(mypage_panel);
        //6. 메인 페이지
        MainpagePanel mainpage_panel = new MainpagePanel(this);
        mainpage_panel.setBounds(0,0,500,1200);
        add(mainpage_panel);
        //7. 회원가입 페이지
        RegisterPanel register_panel = new RegisterPanel(this);
        register_panel.setBounds(0,0,500,1200);
        add(register_panel);
        //8. 검색결과 페이지
        SearchListPanel search_list_panel = new SearchListPanel(this);
        search_list_panel.setBounds(0, 45, 500, 835);
        add(search_list_panel);

        Panels = new JPanel[] { mainpage_panel, register_panel, list_panel, product_panel, mypage_panel, basket_panel, write_post_panel, search_list_panel };

        //푸터
        FootPanel foot_panel = new FootPanel(this);
        foot_panel.setBounds(0,880,500,100);
        add(foot_panel);

        setPanelVisible(BodyPanel.MAIN);

        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setPanelVisible(BodyPanel panel)
    {
        for (var loop : Panels)
            loop.setVisible(false);
        Panels[panel.ordinal()].setVisible(true);
    }

    public JPanel[] getPanels()
    {
        return Panels;
    }

    public JPanel getPanel(BodyPanel panel)
    {
        return Panels[panel.ordinal()];
    }
}