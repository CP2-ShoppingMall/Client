package home.panel.head;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

//모바일 상단바
public class TopBarPanel extends JPanel {
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