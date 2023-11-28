package home;

import home.library.RoundJTextField;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.text.SimpleDateFormat;
import java.util.Date;

//Body
//홈 화면
class HeadPanel extends JPanel {
    public HeadPanel(){
        setSize(500, 200);
        setBackground(Color.white);
        setLayout(null);
        //상단 바
        TopBarPanel topbar_panel = new TopBarPanel();
        topbar_panel.setBounds(0,0,500, 45);
        add(topbar_panel);
        //로고 패널
        LogoPanel logo_panel = new LogoPanel();
        logo_panel.setBounds(0,45,500,90);
        add(logo_panel);
        //검색 패널
        SearchPanel search_panel = new SearchPanel();
        search_panel.setBounds(0,135,500,70);
        add(search_panel);
    }
}
//모바일 상단바
class TopBarPanel extends JPanel {
    JLabel jtime, battery, wifi;
    Date time;
    SimpleDateFormat formatter;
    Timer timer;
    ImageIcon battery_icon, wifi_icon;
    Image battery_img, wifi_img;
    public TopBarPanel(){
        setLayout(null);
        setSize(500,50);
        setBackground(new Color(241, 241, 241));
        //시간
        time = new Date();
        formatter = new SimpleDateFormat("HH:mm");
        String formatedNow = formatter.format(time);
        jtime = new JLabel(formatedNow);
        jtime.setFont(new Font("마루 부리OTF", Font.BOLD, 18));
        jtime.setBounds(10, 5, 100, 30);
        add(jtime);

        //배터리 이미지
        battery_icon = new ImageIcon("src/home/image/icon/battery.png");
        battery_img = battery_icon.getImage();
        battery_img = battery_img.getScaledInstance(45,28,Image.SCALE_SMOOTH);
        battery_icon = new ImageIcon(battery_img);
        battery = new JLabel(battery_icon);
        battery.setBounds(427,5, 50, 30);
        add(battery);

        //와이파이 이미지
        wifi_icon = new ImageIcon("src/home/image/icon/wifi.png");
        wifi_img = wifi_icon.getImage();
        wifi_img = wifi_img.getScaledInstance(32,28,Image.SCALE_SMOOTH);
        wifi_icon = new ImageIcon(wifi_img);
        wifi = new JLabel(wifi_icon);
        wifi.setBounds(384,5, 40, 30);
        add(wifi);

        //시간 동기화
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                time = new Date();
                String formatedNow = formatter.format(time);
                jtime.setText(formatedNow);
            }
        });
        timer.start();
        setVisible(true);
    }

}
//검색창
//TODO 서버구현
class SearchPanel extends JPanel{
    JLabel search_label, basket_label;
    ImageIcon search_icon, basket_icon;
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
        search_label = new JLabel(search_icon);
        search_label.setBounds(350,10, 45, 50);
        add(search_label);
        //장바구니아이콘
        //TODO 장바구니 페이지로 연결
        basket_icon = new ImageIcon("src/home/image/icon/basket.png");
        basket_img = basket_icon.getImage();
        basket_img = basket_img.getScaledInstance(50, 55, Image.SCALE_SMOOTH);
        basket_icon = new ImageIcon(basket_img);
        basket_label = new JLabel(basket_icon);
        basket_label.setBounds(407, 8, 55, 55);
        add(basket_label);
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
//쇼핑몰 로고
class LogoPanel extends JPanel {
    JLabel logo_label;
    ImageIcon logo_icon;
    Image logo_img;
    public LogoPanel(){
        setLayout(null);
        setBackground(Color.white);
        setSize(500,90);
        //로고
        logo_icon = new ImageIcon("src/home/image/icon/logo.png");
        logo_img = logo_icon.getImage();
        logo_img = logo_img.getScaledInstance(230,60,Image.SCALE_SMOOTH);
        logo_icon = new ImageIcon(logo_img);
        logo_label = new JLabel(logo_icon);
        logo_label.setBounds(120,20, 230, 60);
        add(logo_label);
    }
}