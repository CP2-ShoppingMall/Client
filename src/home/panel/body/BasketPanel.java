package home.panel.body;

import home.panel.head.HeadPanel;

import javax.swing.*;
import java.awt.*;

//TODO
//5. 장바구니 페이지
public class BasketPanel extends JPanel {
    ImageIcon product_icon;
    Image product_img;
    JLabel product_img_label, product_title_label, product_price_label, basket_label;
    public JButton buy_btn;
    JPanel buy_panel;
    JCheckBox buy_cb;
    public BasketPanel(){
        setLayout(null);
        setSize(500,700);
        setBackground(Color.white);

        //헤더
        HeadPanel head_panel = new HeadPanel();
        head_panel.setBounds(0,0,500,160);
        add(head_panel);

        //장바구니 라벨
        basket_label = new JLabel("장바구니 목록");
        basket_label.setFont(new Font("맑은고딕", Font.BOLD, 18));
        basket_label.setForeground(new Color(153,153,153));
        basket_label.setBounds(15,175, 150,30);
        add(basket_label);

        //구매하기 버튼
        buy_btn = new JButton("구매하기");
        buy_btn.setBackground(new Color(33,39,37));
        buy_btn.setForeground(Color.white);
        buy_btn.setFont(new Font("맑은 고딕", Font.BOLD, 37));
        buy_btn.setBounds(16,730,450,90);
        add(buy_btn);

        //TODO 서버 연결시 수정해야 할 부분
        //While, For문을 사용해서 밑에 상품들을 출력해내야 할 것 같습니다~!
        //구매 패널
        buy_panel = new JPanel();
        buy_panel.setLayout(null);
        buy_panel.setBackground(new Color(157,184,177));
        buy_panel.setBounds(0,210,500,200);
        //상품이미지
        product_icon = new ImageIcon("src/home/image/product/3.png");
        product_img = product_icon.getImage();
        product_img = product_img.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        product_icon = new ImageIcon(product_img);
        product_img_label = new JLabel(product_icon);
        product_img_label.setBounds(40,20,150,150);
        buy_panel.add(product_img_label);
        //체크박스
        buy_cb = new JCheckBox();
        buy_cb.setBounds(5,5,20,20);
        buy_panel.add(buy_cb);
        //상품명
        product_title_label = new JLabel("갤럭시탭S9 플러스");
        product_title_label.setFont(new Font("맑은고딕", Font.BOLD, 24));
        product_title_label.setForeground(new Color(72,84,81));
        product_title_label.setBounds(210, 25, 250,30);
        buy_panel.add(product_title_label);
        //상품가격
        product_price_label = new JLabel("950,000");
        product_price_label.setFont(new Font("맑은고딕", Font.BOLD, 34));
        product_price_label.setForeground(new Color(72,84,81));
        product_price_label.setBounds(210,50,250,60);
        buy_panel.add(product_price_label);

        add(buy_panel);

        setVisible(true);

        //TODO 장바구니, 구매하기 버튼에 addActionListener 추가하기
    }

}

