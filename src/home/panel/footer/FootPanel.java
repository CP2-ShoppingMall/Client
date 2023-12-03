package home.panel.footer;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;

public class FootPanel extends JPanel {
    JLabel home_label, mypage_label, setting_label;
    ImageIcon home_icon, mypage_icon, setting_icon;
    Image home_img, mypage_img, setting_img;
    public FootPanel(){
        setSize(500, 120);
        setLayout(null);
        setBackground(Color.white);
        //홈아이콘
        home_icon = new ImageIcon("src/home/image/icon/home.png");
        home_img = home_icon.getImage();
        home_img = home_img.getScaledInstance(60 ,60,Image.SCALE_SMOOTH);
        home_icon = new ImageIcon(home_img);
        home_label = new JLabel(home_icon);
        home_label.setBounds(20,15, 70, 70);
        add(home_label);
        //마이페이지아이콘
        mypage_icon = new ImageIcon("src/home/image/icon/user.png");
        mypage_img = mypage_icon.getImage();
        mypage_img = mypage_img.getScaledInstance(60,60,Image.SCALE_SMOOTH);
        mypage_icon = new ImageIcon(mypage_img);
        mypage_label = new JLabel(mypage_icon);
        mypage_label.setBounds(215,15, 70, 70);
        add(mypage_label);
        //셋팅아이콘
        setting_icon = new ImageIcon("src/home/image/icon/setting.png");
        setting_img = setting_icon.getImage();
        setting_img = setting_img.getScaledInstance(60,60,Image.SCALE_SMOOTH);
        setting_icon = new ImageIcon(setting_img);
        setting_label = new JLabel(setting_icon);
        setting_label.setBounds(395,15, 70, 70);
        add(setting_label);
        setVisible(true);

        //TODO 코드 구현 필요. 홈버튼, 마이페이지버튼, 환경설정 버튼 - 데이터연동

    }

}