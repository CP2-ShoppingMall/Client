package home.panel.head;

import home.library.RoundJTextField;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;

//검색창
//TODO 서버구현
public class SearchPanel extends JPanel {
    public JButton  basket_button;
    public JButton search_button;
    public ImageIcon search_icon, basket_icon;

    Image search_img, basket_img;
    RoundJTextField search_txt;
    public SearchPanel(){
        setBackground(Color.white);
        setSize(500,140);
        setLayout(null);
        //검색아이콘
        //TODO 검색 텍스트 받기
        search_icon = new ImageIcon("src/home/image/icon/search.png");

        search_img = search_icon.getImage();
        search_img = search_img.getScaledInstance(45,50,Image.SCALE_SMOOTH);
        search_icon = new ImageIcon(search_img);
        search_button = new JButton(search_icon);
        search_button.setBounds(350,10, 45, 50);
        add(search_button);
        //장바구니아이콘
        //TODO 장바구니 페이지로 연결
        basket_icon = new ImageIcon("src/home/image/icon/basket.png");
        basket_img = basket_icon.getImage();
        basket_img = basket_img.getScaledInstance(50, 55, Image.SCALE_SMOOTH);
        basket_icon = new ImageIcon(basket_img);
        basket_button = new JButton(basket_icon);
        basket_button.setBounds(407, 8, 55, 55);
        add(basket_button);
        //검색창
        search_txt = new RoundJTextField(30);
        search_txt.setBackground(new Color(157,184,177));
        search_txt.setBounds(15,10,317,50);
        search_txt.setFont(new Font("마루 부리OTF",Font.PLAIN,22));
        search_txt.setText("  ");
        search_txt.setBorder(new LineBorder(new Color(157,184,177)));
        add(search_txt);
        setVisible(true);
    }
}