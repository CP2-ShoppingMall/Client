package home.panel.body;

import home.panel.head.HeadPanel;

import javax.swing.*;
import java.awt.*;

//TODO
//마이 페이지 (구매목록)
public class MypagePanel extends JPanel {
    ImageIcon product_icon;
    Image product_img;
    JLabel product_img_label, product_title_label, product_price_label, product_label;

    JPanel buy_panel;
    JCheckBox buy_cb;
    public MypagePanel(){
        setLayout(null);
        setSize(500,700);
        setBackground(Color.white);
        //헤더
        HeadPanel head_panel = new HeadPanel();
        head_panel.setBounds(0,0,500,160);
        add(head_panel);

        //구매목록 라벨
        product_label = new JLabel("구매 목록");
        product_label.setFont(new Font("맑은고딕", Font.BOLD, 18));
        product_label.setForeground(new Color(153,153,153));
        product_label.setBounds(15,185, 150,30);
        add(product_label);

        //TODO 서버 연결시 수정해야 할 부분
        //While, For문을 사용해서 밑에 상품들을 출력해내야 할 것 같습니다~!
        //구매 패널
        buy_panel = new JPanel();
        buy_panel.setLayout(null);
        buy_panel.setBackground(new Color(157,184,177));
        buy_panel.setBounds(0,220,500,200);
        //상품이미지
        product_icon = new ImageIcon("src/home/image/product/3.png");
        product_img = product_icon.getImage();
        product_img = product_img.getScaledInstance(150,150, Image.SCALE_SMOOTH);
        product_icon = new ImageIcon(product_img);
        product_img_label = new JLabel(product_icon);
        product_img_label.setBounds(40,20,150,150);
        buy_panel.add(product_img_label);
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
    }
}